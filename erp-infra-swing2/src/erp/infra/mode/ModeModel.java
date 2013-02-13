package erp.infra.mode;

import java.util.ArrayList;
import java.util.List;

/**
 * ModeModel class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (06/02/2013 11:06)
 */
public class ModeModel {
    
    public static enum CrudMode { EMPTY, READY_ONLY, INSERT, UPDATE }
    
    private Object mode = CrudMode.EMPTY;
    
    private List<ModeListener> listeners 
            = new ArrayList<ModeListener>();

    public Object getMode() {
        return mode;
    }

    public void setMode(Object mode) {
        this.mode = mode;
        fireModeChanged();
    }
    
    // --- Listener ---
    
    public void addListener(ModeListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
    }

    public void removeListener(ModeListener listener) {
        listeners.remove(listener);
    }

    protected void fireModeChanged() {
        for (ModeListener listener : listeners) {
            listener.modeChanged();
        }
    }
    
}
