package model;

import java.time.LocalDate;
import java.util.Currency;

public class Cash extends Payment{

    public Cash(double value, String currency) {
        super(value, currency);
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
