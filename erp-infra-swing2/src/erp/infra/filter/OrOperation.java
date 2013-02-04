package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * OrOperation class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 16:53)
 */
public class OrOperation extends Operation {
    
    private List<Query> conditions = new ArrayList<Query>();

    public OrOperation(Class entityClass) {
        super(entityClass);
        super.setQuery("or");
    }
    
    public void addCondition(Query condition) {
        conditions.add(condition);
    }

    public void removeCondition(Query condition) {
        conditions.remove(condition);
    }

    public String getQuery() {
        String query = "";
        boolean first = true;
        for (Query condition : conditions) {
            query += (first ? "" : " " + super.getQuery() + " ") + "(" + condition.getQuery() + ")";
            first = false;
        }
        return query;
    }
    
    @Override
    public List<String> getParameters() {
        List<String> parameters = new ArrayList<String>();
        for (Query condition : conditions) {
            parameters.addAll(condition.getParameters());
        }
        return parameters;
    }

    @Override
    public Object getParameterValue(String parameter) {
        Object parameterValue = null;
        for (Query condition : conditions) {
            parameterValue = condition.getParameterValue(parameter);
            if (parameterValue != null) {
                return parameterValue;
            }
        }
        return null;
    }
    
}
