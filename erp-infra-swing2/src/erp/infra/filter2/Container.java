package erp.infra.filter2;

import erp.infra.filter.Linker;

/**
 *
 * @author leonardo
 */
public abstract class Container {

    private Linker leftLinker;
    private Linker rightLinker;

    public Linker getLeftLinker() {
        return leftLinker;
    }

    public void setLeftLinker(Linker leftLinker) {
        this.leftLinker = leftLinker;
    }

    public Linker getRightLinker() {
        return rightLinker;
    }

    public void setRightLinker(Linker rightLinker) {
        this.rightLinker = rightLinker;
    }
    
    public abstract String getQuery();
    
}
