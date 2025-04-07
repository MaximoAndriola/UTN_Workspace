package model;

import interfaces.iPayment;

import java.text.NumberFormat;
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

    public Payment(){
        this.date = LocalDate.now();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = Currency.getInstance(currency);
    }
}
