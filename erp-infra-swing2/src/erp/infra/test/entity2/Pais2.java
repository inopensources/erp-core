package erp.infra.test.entity2;

import erp.infra.annotation.Field;
import erp.infra.annotation.Form;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PAIS")
@Form(id = "pais", verticalPadding=3, layout = "\n\n"
        + "              [id__]                                  \n"
        + "              [codbc_]                                \n"
        + "              [nome_________________________]         \n"
        + "              [s2__   ]                               \n"
)
public class Pais2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODIGO_BACEN")
    private String codigoBacen;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SIGLA_2")
    private String sigla2;

    public Pais2() {
    }

    public Pais2(Long id) {
        this.id = id;
    }

    @Field(id="id", label="Id", insertable=false, updatable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Field(id="codbc", label="Cód. BACEN")
    public String getCodigoBacen() {
        return codigoBacen;
    }

    public void setCodigoBacen(String codigoBacen) {
        this.codigoBacen = codigoBacen;
    }

    @Field(id="nome", label="Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Field(id="s2", label="Sigla 2")
    public String getSigla2() {
        return sigla2;
    }

    public void setSigla2(String sigla2) {
        this.sigla2 = sigla2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais2)) {
            return false;
        }
        Pais2 other = (Pais2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "erp.infra.test.entity2.Pais[ id=" + id + " ]";
    }
    
}
