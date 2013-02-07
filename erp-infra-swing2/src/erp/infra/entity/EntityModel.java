package erp.infra.entity;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * EntityModel class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (03/02/2013 21:36)
 */
public class EntityModel<T> {
    
    private T entity;
    private List<EntityModelListener> listeners 
            = new ArrayList<EntityModelListener>();

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
        fireEntityChanged();
    }

    // --- Listener ---
    
    public void addListener(EntityModelListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EntityModelListener listener) {
        listeners.remove(listener);
    }
    
    private void fireEntityChanged() {
        for (EntityModelListener listener : listeners) {
            listener.entityChanged();
        }
    }
    
}
