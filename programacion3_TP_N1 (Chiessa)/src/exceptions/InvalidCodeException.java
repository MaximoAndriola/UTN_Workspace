package exceptions;

public class InvalidCodeException extends InvalidPaymentException {
    public InvalidCodeException(String message) {
        super(message);
    }
}
