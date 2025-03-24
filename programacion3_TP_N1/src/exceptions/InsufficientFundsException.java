package exceptions;

public class InsufficientFundsException extends InvalidPaymentException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
