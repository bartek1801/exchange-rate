package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.commands.Validatable;

import java.math.BigDecimal;

public class CalculateQuery  implements Validatable {

    //?date=YYYY-MM-DD&from=USD&to=GBP&amount=100.00

    private String date;

    private String from;

    private String to;

    private BigDecimal amount;

    public CalculateQuery() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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


    @Override
    public void validate(ValidationErrors errors) {
        if (isEmpty(date))
            errors.add("date", "is required");
        if (amount == null)
            errors.add("amount", "is required");
        if (isEmpty(from))
            errors.add("from", "is required");
        if (isEmpty(to))
            errors.add("to", "is required");

        if (from != null && from.equals(to))
            errors.add("from", "must be different than to");
        if (to != null && to.equals(from))
            errors.add("to", "must be different than from");
    }
}
