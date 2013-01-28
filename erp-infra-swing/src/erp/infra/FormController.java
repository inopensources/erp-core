package erp.infra;

/**
 * FormController interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 23:39)
 */
public interface FormController<T> {
    
    public T reload() throws Exception;
    public void update(T t) throws Exception;
    public void insert(T t) throws Exception;
    public void delete(T t) throws Exception;
    
}
