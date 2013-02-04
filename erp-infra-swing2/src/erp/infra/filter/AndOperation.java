package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * AndOperation class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 16:49)
 */
public class AndOperation extends Operation {
    
    private List<Query> conditions = new ArrayList<Query>();

    public AndOperation(Class entityClass) {
        super(entityClass);
        super.setQuery("and");
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
