package model;

import java.time.LocalDate;
import java.util.Currency;

public class Application extends Payment{
    private AppNames appName;
    private int userId;

    public Application(double value, String currency, AppNames appName, int userId) {
        super(value, currency);
        this.appName = appName;
        this.userId = userId;
    }

    @Override
    public boolean validateFounds(Double payment) {
        return false;
    }

    @Override
    public boolean validatePayment() {
        return false;
    }
}
