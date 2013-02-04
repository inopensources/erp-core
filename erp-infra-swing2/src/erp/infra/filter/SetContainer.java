package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class SetContainer {

    private List<Container> containers = new ArrayList<Container>();
    private List<Linker> linkers = new ArrayList<Linker>();
    
    public List<Container> getContainers() {
        return containers;
    }

    public List<Linker> getLinkers() {
        return linkers;
    }
    
}
