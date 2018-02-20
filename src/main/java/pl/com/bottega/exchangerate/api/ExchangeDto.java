package pl.com.bottega.exchangerate.api;

import java.math.BigDecimal;

public class ExchangeDto {

//
////    {
////        "from": "USD",
////            "to": "GPB",
////            "amount": 100.00,
////            "calculatedAmount": 87.44,
////            "date": "YYYY-MM-DD"
////    }

    private String from;
    private String to;
    private BigDecimal amount;
    private BigDecimal calculatedAmount;
    private String date;


    public ExchangeDto() {
    }

    public ExchangeDto(String from, String to, BigDecimal amount, BigDecimal calculatedAmount, String date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.calculatedAmount = calculatedAmount;
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
