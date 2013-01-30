package erp.infra.form;

import erp.infra.form.Form.Mode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class WrapperFormModel<T> implements FormModel<T> {

    private FormModel<T> formModel;
    
    private Mode mode = Mode.EMPTY;
    private List<FormModelListener> listeners = new ArrayList<FormModelListener>();

    public WrapperFormModel(FormModel<T> formModel) {
        this.formModel = formModel;
    }
    
    public void addListener(FormModelListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
    }

    public void removeListener(FormModelListener listener) {
        listeners.remove(listener);
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        boolean changed = (this.mode != mode);
        this.mode = mode;
        fireModeChanged();
    }

    @Override
    public void setEntity(T entity) {
        System.out.println("setEntity");
        T before = formModel.getEntity();
        formModel.setEntity(entity);
        if (before != formModel.getEntity()) {
            fireEntityChanged();
        }
    }

    @Override
    public T getEntity() {
        return formModel.getEntity();
    }

    @Override
    public void reload() throws Exception {
        System.out.println("reload");
        formModel.reload();
        fireReloaded();
    }

    @Override
    public void update() throws Exception {
        if (mode == Mode.READ_ONLY) {
            setMode(Mode.UPDATE);
        }
        else if (mode == Mode.UPDATE) {
            System.out.println("update");
            formModel.update();
            fireUpdated();
        }
    }

    @Override
    public void insert() throws Exception {
        if (mode == Mode.READ_ONLY) {
            setMode(Mode.INSERT);
        }
        else if (mode == Mode.INSERT) {
            System.out.println("insert");
            formModel.insert();
            fireInserted();
        }
    }

    @Override
    public void delete() throws Exception {
        System.out.println("delete");
        formModel.delete();
        fireDeleted();
    }
    
    @Override
    public void cancel() throws Exception {
        System.out.println("cancel");
        formModel.cancel();
        fireCanceled();
    }
    
    protected void fireModeChanged() {
        for (FormModelListener listener : listeners) {
            listener.modeChanged();
        }
    }

    protected void fireEntityChanged() {
        for (FormModelListener listener : listeners) {
            listener.entityChanged();
        }
    }

    protected void fireReloaded() {
        for (FormModelListener listener : listeners) {
            listener.reloaded();
        }
    }
    
    protected void fireUpdated() {
        for (FormModelListener listener : listeners) {
            listener.updated();
        }
    }

    protected void fireInserted() {
        for (FormModelListener listener : listeners) {
            listener.inserted();
        }
    }

    protected void fireCanceled() {
        for (FormModelListener listener : listeners) {
            listener.canceled();
        }
    }

    protected void fireDeleted() {
        for (FormModelListener listener : listeners) {
            listener.deleted();
        }
    }
    
}
