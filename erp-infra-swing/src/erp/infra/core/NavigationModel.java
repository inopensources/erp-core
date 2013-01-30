package erp.infra.core;


/**
 * NavigationModel interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 15:30)
 */
public interface NavigationModel {
    
    public abstract void first() throws Exception;
    public abstract void next() throws Exception;
    public abstract void previous() throws Exception;
    public abstract void last() throws Exception;
    
}
