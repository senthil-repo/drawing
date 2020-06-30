package exception;

/**
 * Created on 30/06/2020.
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message) {
        super(message);
    }
}
