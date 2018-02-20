package pl.com.bottega.exchangerate.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.api.CalculateExchangeHandler;
import pl.com.bottega.exchangerate.api.CalculateQuery;
import pl.com.bottega.exchangerate.api.CreateExchangeRateHandler;
import pl.com.bottega.exchangerate.api.ExchangeDto;
import pl.com.bottega.exchangerate.domain.commands.SaveExchangeRateCommand;

@RestController
public class ExchangeController {

    private CreateExchangeRateHandler createExchangeRateHandler;

    private CalculateExchangeHandler calculateExchangeHandler;

    public ExchangeController(CreateExchangeRateHandler createExchangeRateHandler, CalculateExchangeHandler calculateExchangeHandler) {
        this.createExchangeRateHandler = createExchangeRateHandler;
        this.calculateExchangeHandler = calculateExchangeHandler;
    }

    @PutMapping("/exchange-rate")
    public void saveExchangeRate(@RequestBody SaveExchangeRateCommand command){
        createExchangeRateHandler.handle(command);
    }

    @GetMapping("/calculation")
    public ExchangeDto calculate(CalculateQuery query){
        return calculateExchangeHandler.handle(query);
    }

}
