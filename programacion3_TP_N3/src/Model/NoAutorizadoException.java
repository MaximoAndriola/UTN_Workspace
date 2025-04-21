package Model;

public class NoAutorizadoException extends RuntimeException {
    public NoAutorizadoException(String message) {
        super(message);
    }
}
