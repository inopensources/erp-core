package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class SetContainer extends Container {

    private List<Container> containers = new ArrayList<Container>();

    public List<Container> getAll() {
        return containers;
    }
    
    public void add(Container container) {
        container.setEntityClass(getEntityClass());
        containers.add(container);
    }

    public void remove(Container container) {
        containers.remove(container);
    }

    @Override
    public String getQuery() {
        Container startContainer = null;
        for (Container container : containers) {
            if (container.getLeftLinker() == null) {
                startContainer = container;
                break;
            }
        }
        
        String query = "( ";
        
        while (startContainer != null) {
            query += startContainer.getQuery() + " ";
            Linker linker = startContainer.getRightLinker();
            startContainer = null;
            if (linker != null) {
                query += linker.getOperation().getQuery() + " ";
                startContainer = linker.getRightContainer();
            }
        }
        
        query += ")";
        return query;
    }

    @Override
    public void getParameters(List<String> parameters) {
        for (Container container : containers) {
            container.getParameters(parameters);
        }
    }

    @Override
    public Object getParameterValue(String parameter) {
        Object parameterValue = null;
        for (Container container : containers) {
            parameterValue = container.getParameterValue(parameter);
            if (parameterValue != null) {
                return parameterValue;
            }
        }
        return parameterValue;
    }
    
}
