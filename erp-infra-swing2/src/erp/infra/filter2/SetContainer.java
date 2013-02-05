package erp.infra.filter2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class SetContainer extends Container {

    private List<Container> containers = new ArrayList<Container>();
    
    public List<Container> getContainers() {
        return containers;
    }

    @Override
    public String getQuery() {
        String query = "";
        for (Container container : containers) {
            query = query + container.getQuery() + " ";
        }
        return query;
    }
    
}
