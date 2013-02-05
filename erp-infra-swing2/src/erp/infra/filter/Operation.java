package erp.infra.filter;

/**
 * Operation class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 16:40)
 */
public class Operation {
    
    private String name = "";
    private String query = "";

    private String field;
    private String value;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReplacedQuery() {
        String replacedQuery = getQuery();
        replacedQuery = replacedQuery.replace("{field}", field);
        replacedQuery = replacedQuery.replace("{value}", value);
        return replacedQuery;
    }
    
}
