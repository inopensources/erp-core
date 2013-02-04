package erp.infra.form;

/**
 * FormModelListener interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 23:39)
 */
public interface FormModelListener {
    
    public abstract void entityModelChanged();
    public abstract void updateModel();
    public abstract void modeChanged();
    
}
