package exception;

/**
 * Created on 30/06/2020.
 */
public class InvalidInputParameterException extends RuntimeException{
    public InvalidInputParameterException(String message) {
        super(message);
    }
}
