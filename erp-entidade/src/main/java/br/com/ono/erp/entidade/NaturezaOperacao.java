package br.com.ono.erp.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade NaturezaOperacao.
 * 
 * Equivale ao registro 0400 do efd-contribuicoes e  efd-sped.
 * 
 * Referencia: www.spedbrasil.net/forum/topics/2159846:Topic:10695?commentId=2159846%3AComment%3A97066
 * 
 * Conforme art. 19 do Convenio SINIEF S/N de 1970:
 * "Art. 19. A nota fiscal conterá, nos quadros e campos próprios, 
 *  observada a disposição gráfica dos modelos 1 e 1-A, as seguintes indicações:
 * 
 *  I - no quadro “EMITENTE”:
 *  ...
 *  i) a natureza da operação de que decorrer a saída ou a entrada, 
 *   tais como: venda, compra, transferência, devolução, importação, 
 *   consignação, remessa (para fins de demonstração, 
 *   de industrialização ou outra);"
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 15:31)
 */
@Entity
@Table(name="natureza_operacao")
public class NaturezaOperacao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Empresa empresa;

    private String descricao;
    
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof NaturezaOperacao)) {
            return false;
        }
        NaturezaOperacao other = (NaturezaOperacao) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NaturezaOperacao{" + "id=" + id + ", empresa=" 
                + empresa + ", descricao=" + descricao + '}';
    }

}
