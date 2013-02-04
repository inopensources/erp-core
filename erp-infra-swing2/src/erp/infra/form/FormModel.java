package erp.infra.form;

import erp.infra.entity.EntityModel;
import erp.infra.entity.EntityModelListener;
import java.util.ArrayList;
import java.util.List;

/**
 * FormModel class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (03/02/2013 20:26)
 */
public abstract class FormModel<T> {

    public enum Mode { EMPTY, READ_ONLY, INSERT, UPDATE }
    private EntityModel<T> entityModel = new EntityModel<T>();
    private String property = "";
    private Mode mode = Mode.EMPTY;
    private List<FormModelListener> listeners 
            = new ArrayList<FormModelListener>();

    public EntityModel<T> getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(EntityModel<T> entityModel) {
        if (entityModel == null) {
            return;
        }
        this.entityModel = entityModel;
        fireEntityModelChanged();
    }
        
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        if (property == null) {
            property = "";
        }
        this.property = property;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        if (mode == null) {
            mode = Mode.EMPTY;
        }
        this.mode = mode;
        fireModeChanged();
    }

    // -- Private wrapper methods ---
    
    void initReload() throws Exception {
        System.out.println("reload");
        entityModel.setEntity(reload());
    }

    void initUpdate() throws Exception {
        if (mode == Mode.READ_ONLY) {
            setMode(Mode.UPDATE);
        }
        throw new RuntimeException("Can't update in actual mode !");
    }

    public void initInsert() throws Exception {
        if (mode == Mode.READ_ONLY) {
            entityModel.setEntity(newInstance());
            setMode(Mode.INSERT);
        }
        throw new RuntimeException("Can't insert in actual mode !");
    }

    public void initDelete() throws Exception {
        if (mode == Mode.READ_ONLY && entityModel.getEntity() != null) {
            System.out.println("delete");
            delete(entityModel.getEntity());
        }
        else {
            throw new RuntimeException("Can't delete in actual mode !");
        }
    }
    
    public void initCancel() throws Exception {
        if (mode == Mode.UPDATE || mode == Mode.INSERT) {
            System.out.println("cancel");
            setMode(Mode.READ_ONLY);
        }
        else {
            throw new RuntimeException("Can't cancel in actual mode !");
        }
    }    
 
    void save() throws Exception {
        if (mode == Mode.UPDATE) {
            System.out.println("update");
            fireUpdateModel();
            update(entityModel.getEntity());
            setMode(Mode.READ_ONLY);
        }
        else if (mode == Mode.INSERT) {
            System.out.println("insert");
            fireUpdateModel();
            insert(entityModel.getEntity());
            setMode(Mode.READ_ONLY);
        }
        else {
            throw new RuntimeException("Can't save in actual mode !");
        }
    }
    
    // --- Listener ---
    
    public void addListener(FormModelListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
    }

    public void removeListener(FormModelListener listener) {
        listeners.remove(listener);
    }

    protected void fireEntityModelChanged() {
        for (FormModelListener listener : listeners) {
            listener.entityModelChanged();
        }
    }

    protected void fireUpdateModel() {
        for (FormModelListener listener : listeners) {
            listener.updateModel();
        }
    }
    
    protected void fireModeChanged() {
        for (FormModelListener listener : listeners) {
            listener.modeChanged();
        }
    }

    // --- Must be implemented by client ---
    
    public abstract T reload() throws Exception;
    public abstract void update(T entity) throws Exception;
    public abstract void insert(T entity) throws Exception;
    public abstract void delete(T entity) throws Exception;
    public abstract T newInstance() throws Exception;
    
}
