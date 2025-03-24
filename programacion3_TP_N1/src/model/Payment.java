package model;

import interfaces.iPayment;

import java.time.LocalDate;
import java.util.Currency;

public abstract class Payment implements iPayment {
    protected double value;
    protected LocalDate date;
    protected static int count = 0;
    protected int id = count ++;
    protected Currency currency;

    public Payment(double value, String currency) {
        this.value = value;
        this.date = LocalDate.now();
        this.currency = Currency.getInstance(currency);
    }
}
