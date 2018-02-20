package pl.com.bottega.exchangerate.domain.repositories;

import pl.com.bottega.exchangerate.domain.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateRepository {

     void save(ExchangeRate exchangeRate);

     List<ExchangeRate> find(String date, String currency);





}
