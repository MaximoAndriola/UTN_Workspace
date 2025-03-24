package exceptions;

public class InvalidCardNumberException extends InvalidPaymentException {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}
