package br.com.ono.erp.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade DominioProduto.
 * 
 * Representa o dominio (conjunto) de produtos com os quais
 * uma ou varias empresas trabalham.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 00:23)
 */
@Entity
@Table(name="dominio_produto")
public class DominioProduto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof DominioProduto)) {
            return false;
        }
        DominioProduto other = (DominioProduto) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DominioProduto{" + "id=" + id + ", nome=" + nome + '}';
    }

}
