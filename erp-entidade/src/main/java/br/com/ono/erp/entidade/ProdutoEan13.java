package br.com.ono.erp.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade Pessoa Estrangeira.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (15/01/2012 12:02)
 */
@Entity
@Table(name="produto_ean13")
public class ProdutoEan13 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Produto produto;
    
    @Column(name = "codigo_ean13")
    private String codigoEan13;
    
    private String cor;
    private String tamanho;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getCodigoEan13() {
        return codigoEan13;
    }

    public void setCodigoEan13(String codigoEan13) {
        this.codigoEan13 = codigoEan13;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "ProdutoEan13{" + "id=" + id + ", produto=" + produto 
                + ", codigoEan13=" + codigoEan13 + ", cor=" 
                + cor + ", tamanho=" + tamanho + '}';
    }
    
}
