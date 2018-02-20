package pl.com.bottega.exchangerate.api;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.SaveExchangeRateCommand;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class CreateExchangeRateHandler {

    private ExchangeRateRepository exchangeRateRepository;

    public CreateExchangeRateHandler(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }


    @Transactional
    public void handle(SaveExchangeRateCommand command){
        ExchangeRate exchangeRate;
        List<ExchangeRate> exchangeRates = exchangeRateRepository.find(command.getDate(), command.getCurrency());
        if (exchangeRates.isEmpty()) {
            exchangeRate = new ExchangeRate(command.getDate(), command.getCurrency(), BigDecimal.valueOf(command.getRate()));
        }
        else {
            exchangeRate = exchangeRates.get(0);
            exchangeRate.setRate(BigDecimal.valueOf(command.getRate()));
        }
        exchangeRateRepository.save(exchangeRate);
    }


}
