package erp.infra.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Form annotation.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (29/01/2013 11:43)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Form {

    /**
     * Id do formulario.
     */
    String id();
    
    /**
     * Layout do formulario
     */
    String layout() default "";

    /**
     * Escala quanto cada caracter representa em pixels.
     */
    int layoutScale() default 10;

    /**
     * Espaco vertical entre um componente e outro;
     */
    int verticalPadding() default 3;
    
}
