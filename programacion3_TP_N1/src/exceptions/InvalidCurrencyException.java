package exceptions;

public class InvalidCurrencyException extends InvalidPaymentException{
    public InvalidCurrencyException(String message) {
        super(message);
    }
}
