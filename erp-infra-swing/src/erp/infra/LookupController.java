package erp.infra;

import java.util.List;


/**
 * LookupController interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 23:38)
 */
public interface LookupController<T> {
    
    public T getEntity();
    public void setEntity(T entity);
    
    public List<T> reload(String code) throws Exception;
    
}
