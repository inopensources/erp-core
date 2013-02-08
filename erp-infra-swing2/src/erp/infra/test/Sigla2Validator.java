package erp.infra.test;

import erp.infra.validation.*;

/**
 * Sigla2Validator class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (08/02/2012 12:44)
 */

public class Sigla2Validator implements Validator {
    
    @Override
    public void validate(Object value) throws ValidationException {
        if (value == null || value.toString().trim().isEmpty()) {
            throw new ValidationException("Sigla 2 nao pode estar vazia !");
        }
        if (value.toString().trim().length() != 2) {
            throw new ValidationException("Sigla 2 precisa ter 2 letras !");
        }
    }
    
}
