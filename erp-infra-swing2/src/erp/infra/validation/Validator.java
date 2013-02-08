package erp.infra.validation;

/**
 * Validator interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (08/02/2012 12:11)
 */

public interface Validator<T> {
    
    public void validate(T value) throws ValidationException;
    
}
