package erp.infra.grid;

import erp.infra.form.FormModel;
import java.util.List;


/**
 * GridModel interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 09:33)
 */
public interface GridModel<T> extends FormModel<T> {
    
    public List<T> reloadGrid() throws Exception;
    public void update(List<T> t) throws Exception;
    public void insert(List<T> t) throws Exception;
    public void delete(List<T> t) throws Exception;
    
}
