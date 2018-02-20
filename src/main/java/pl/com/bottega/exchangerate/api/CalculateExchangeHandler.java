package pl.com.bottega.exchangerate.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.NoRateException;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CalculateExchangeHandler {

    private ExchangeRateRepository exchangeRateRepository;


    public CalculateExchangeHandler(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeDto handle(CalculateQuery query){
        Optional<ExchangeRate> exTo = exchangeRateRepository.find(query.getDate(), query.getTo()).stream().findFirst();
        Optional<ExchangeRate> exFrom = exchangeRateRepository.find(query.getDate(), query.getFrom()).stream().findFirst();

        BigDecimal calculatedAmount = BigDecimal.ZERO;
        ExchangeDto exchangeDto = new ExchangeDto(query.getFrom(), query.getTo(),query.getAmount(), calculatedAmount, query.getDate());

        if (isEqualToMainCurrency(query.getFrom())){
            checkRatePresence(exTo);
            calculatedAmount = query.getAmount().divide(exTo.get().getRate(), 2, BigDecimal.ROUND_HALF_UP);
            exchangeDto.setCalculatedAmount(calculatedAmount);
        }
        else if (isEqualToMainCurrency(query.getTo())){
            checkRatePresence(exFrom);
            calculatedAmount = query.getAmount().multiply(exFrom.get().getRate());
            exchangeDto.setCalculatedAmount(calculatedAmount);
        }
        else if (!isEqualToMainCurrency(query.getFrom()) && !isEqualToMainCurrency(query.getTo())){
            checkRatePresence(exTo);
            checkRatePresence(exFrom);
            calculatedAmount = query.getAmount().multiply(exFrom.get().getRate()).divide(exTo.get().getRate());
            exchangeDto.setCalculatedAmount(calculatedAmount);
        }
        return exchangeDto;
    }

    private void checkRatePresence(Optional<ExchangeRate> exTo) {
        if (!exTo.isPresent())
            throw new NoRateException();
    }

    private boolean isEqualToMainCurrency(String currency){
        return currency.equals(ExchangeRate.MAIN_CURRENCY);
    }
}
