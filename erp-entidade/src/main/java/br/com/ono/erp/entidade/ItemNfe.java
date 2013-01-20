package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade Nfe.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 22:23)
 */
@Entity
@Table(name="item_nfe")
public class ItemNfe extends DocumentoFiscal {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Nfe nfe;
    
    @ManyToOne
    private Produto produto;
    
    private Integer quantidade;
    private BigDecimal valor;

    public Nfe getNfe() {
        return nfe;
    }

    public void setNfe(Nfe nfe) {
        this.nfe = nfe;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ItemNfe{" + "id=" + id + ", nfe=" + nfe + ", produto=" 
                + produto + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }

}
