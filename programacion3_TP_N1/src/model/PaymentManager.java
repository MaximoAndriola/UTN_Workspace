package model;

import exceptions.InsufficientFundsException;

import java.util.ArrayList;

public abstract class PaymentManager <T extends Payment> {
    ArrayList<T> payments = new ArrayList<>();

    public static <T extends Payment> boolean processPayment(T t ) throws InsufficientFundsException {
        boolean successfulPayment = false;

        if (t.getValue() < 0){
            throw new InsufficientFundsException("el valor de la transferencia debe ser mayor a 0");
        }else
            successfulPayment = true;

        return successfulPayment;
    }

    public void cancelPayment() {

    }
}