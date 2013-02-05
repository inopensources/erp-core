package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public abstract class Container {

    private Linker leftLinker;
    private Linker rightLinker;
    private Class entityClass;
    
    public String getClassAlias() {
        String classAlias = entityClass.getSimpleName();
        classAlias = classAlias.substring(0, 1).toLowerCase() + classAlias.substring(1);
        return classAlias;
    }
    
    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public Linker getLeftLinker() {
        return leftLinker;
    }

    public void setLeftLinker(Linker leftLinker) {
        this.leftLinker = leftLinker;
        if (leftLinker.getRightContainer() != this) {
            leftLinker.setRightContainer(this);
        }
    }

    public Linker getRightLinker() {
        return rightLinker;
    }

    public void setRightLinker(Linker rightLinker) {
        this.rightLinker = rightLinker;
        if (rightLinker.getLeftContainer() != this) {
            rightLinker.setLeftContainer(this);
        }
    }
    
    public abstract String getQuery();
    public abstract void getParameters(List<String> parameters);
    public abstract Object getParameterValue(String parameter);
    
}
