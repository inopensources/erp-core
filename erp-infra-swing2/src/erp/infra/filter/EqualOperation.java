package erp.infra.filter;

/**
 * EqualOperation class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 17:10)
 */
public class EqualOperation extends Operation {
    
    public EqualOperation(Class entityClass) {
        super(entityClass);
        setQuery("=");
        setName("igual");
    }
    
}
