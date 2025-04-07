package model;

import interfaces.iValidateCard;

import java.time.LocalDate;

public class Card extends Payment implements iValidateCard {
    private LocalDate expirationDate;
    private String cardNumber;
    private String securityCode;

    public Card(double value, String currency, String expirationDate, String cardNumber, String securityCode) {
        super(value, currency);
        this.expirationDate = LocalDate.parse(expirationDate);
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
    }

    @Override
    public boolean validateFounds(Double payment) {
        return false;
    }

    @Override
    public boolean validatePayment() {
        return false;
    }

    @Override
    public boolean validateCardNumber() {
        return false;
    }

    @Override
    public boolean validateExpirationDate() {
        return false;
    }

    @Override
    public boolean validateSecurityCode() {
        return false;
    }
}
