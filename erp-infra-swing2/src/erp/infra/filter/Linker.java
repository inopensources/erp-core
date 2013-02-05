package erp.infra.filter;

import erp.infra.filter2.Container;

/**
 *
 * @author leonardo
 */
public class Linker {
    
    private String name;
    private Operation operation;
    
    private Container leftContainer;
    private Container rightContainer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Container getLeftContainer() {
        return leftContainer;
    }

    public void setLeftContainer(Container leftContainer) {
        this.leftContainer = leftContainer;
    }

    public Container getRightContainer() {
        return rightContainer;
    }

    public void setRightContainer(Container rightContainer) {
        this.rightContainer = rightContainer;
    }
    
}
