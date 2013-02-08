package erp.infra.validation;

/**
 * ValidationException class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (08/02/2012 12:11)
 */
public class ValidationException extends Exception {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
    
}
