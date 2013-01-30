package erp.infra.lookup;

import java.util.List;


/**
 * LookupModel interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 23:38)
 */
public interface LookupModel<T> {
    
    public T getEntity();
    public void setEntity(T entity);
    
    public List<T> reload(String code) throws Exception;
    
}
