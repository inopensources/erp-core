package br.com.ono.erp.entidade;

import br.com.ono.erp.entidade.NaturezaOperacao.IndicadorTipoOperacao;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade abstrata DocumentoFiscal.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 20:58)
 */
@Entity
@Table(name="documento_fiscal")
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="codigo_modelo", discriminatorType= DiscriminatorType.STRING, length=2)
public abstract class DocumentoFiscal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Empresa empresa;
    
    @Enumerated
    @Column(name = "indicador_tipo_operacao")
    private IndicadorTipoOperacao indicadorTipoOperacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public IndicadorTipoOperacao getIndicadorTipoOperacao() {
        return indicadorTipoOperacao;
    }

    public void setIndicadorTipoOperacao(IndicadorTipoOperacao indicadorTipoOperacao) {
        this.indicadorTipoOperacao = indicadorTipoOperacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof DocumentoFiscal)) {
            return false;
        }
        DocumentoFiscal other = (DocumentoFiscal) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentoFiscal{" + "id=" + id + ", empresa=" 
                + empresa + ", indicadorTipoOperacao=" + indicadorTipoOperacao + '}';
    }

}
