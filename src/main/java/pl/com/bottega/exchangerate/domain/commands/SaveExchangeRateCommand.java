package pl.com.bottega.exchangerate.domain.commands;

public class SaveExchangeRateCommand implements Validatable {


    private String date;

    private String currency;

    private Double rate;

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void validate(ValidationErrors errors) {
        if (isEmpty(date))
            errors.add("date", "is required");
        if (isEmpty(currency))
            errors.add("currency", "is required");
        if(currency != null && currency.length() != 3)
            errors.add("currency", "has invalid format");
        if (rate == 0)
            errors.add("rate", "is required");
        if (rate < 0)
            errors.add("rate", "must be > than 0.0" );
    }
}
