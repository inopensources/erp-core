package erp.infra.annotation;

import erp.infra.validation.DefaultValidator;
import erp.infra.validation.Validator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Field annotation.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (29/01/2013 11:43)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

    /**
     * Id do campo.
     */
    String id();
    
    /**
     * Informa o label de um campo ou nome da coluna de uma gride.
     * Se a propriedade labelText estiver null, sera considerado este valor.
     */
    String label();
    
    /**
     * Ordem da coluna da gride da esquerda para direita.
     */
    int order() default 0;

    /**
     * Ordem da tabulacao (foco) do campo no formulario.
     */
    int tabOrder() default 0;
    
    /**
     * Se a propriedade regex estiver null, sera considerado este valor.
     * Valido somente para TextField.
     */
    String regex() default "";

    /**
     * Permite inserir.
     */
    boolean insertable() default true;

    /**
     * Permite alterar.
     */
    boolean updatable() default true;
    
    /**
     * Classe de validacao.
     */
    Class<? extends Validator> validatorClass() default DefaultValidator.class;
    
}
