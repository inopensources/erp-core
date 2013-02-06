package erp.infra.mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ModeModel class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (06/02/2013 11:06)
 */
public class ModeModel {
    
    public static final String EMPTY = "empty";
    public static final String READY_ONLY = "readyOnly";
    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    
    private String mode = EMPTY;
    
    private List<ModeListener> listeners 
            = new ArrayList<ModeListener>();

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
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
