package erp.infra;

import java.util.List;


/**
 * GridController interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 09:33)
 */
public interface GridController<T> {
    
    public List<T> reload() throws Exception;
    public void update(List<T> t) throws Exception;
    public void insert(List<T> t) throws Exception;
    public void delete(List<T> t) throws Exception;
    
}
