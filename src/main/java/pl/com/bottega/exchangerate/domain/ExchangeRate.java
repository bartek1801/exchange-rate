package pl.com.bottega.exchangerate.domain;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {

    public static final String MAIN_CURRENCY = "PLN";

    @Id
    @GeneratedValue
    private Long id;

    //@JsonFormat(pattern = "yyyy-MM-dd")
    private String date;

    private String currency;

    private BigDecimal rate;


    public ExchangeRate() {
    }

    public ExchangeRate(String date, String currency, BigDecimal rate) {
        this.date = date;
        this.currency = currency;
        this.rate = rate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
