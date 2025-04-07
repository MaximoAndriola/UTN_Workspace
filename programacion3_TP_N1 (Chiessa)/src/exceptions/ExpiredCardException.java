package exceptions;

public class ExpiredCardException extends InvalidPaymentException {
    public ExpiredCardException(String message) {
        super(message);
    }
}
