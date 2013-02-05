package erp.infra.filter;

/**
 * EqualOperation class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 21:50)
 */
public class EqualOperation extends Operation {

    public EqualOperation() {
        setName("igual");
        setQuery("{field} = {value}");
    }

}
