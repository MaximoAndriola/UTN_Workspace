package model;

import interfaces.iPaymentManage;

public class PaymentManager implements iPaymentManage {
    @Override
    public boolean processPayment() {
        return false;
    }

    @Override
    public void cancelPayment() {

    }
}
