package erp.infra.form;

/**
 * FormController interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 23:39)
 */
public interface FormController<T> {

    public T getEntity();
    public void setEntity(T entity);
    
    public void reload() throws Exception;
    public void update() throws Exception;
    public void insert() throws Exception;
    public void delete() throws Exception;
    
}
