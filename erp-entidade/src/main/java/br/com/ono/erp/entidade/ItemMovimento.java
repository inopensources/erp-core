package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade ItemMovimento.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 22:26)
 */
@Entity
@Table(name="item_movimento")
public class ItemMovimento extends DocumentoFiscal {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Movimento movimento;
    
    @ManyToOne
    private Produto produto;
    
    private Integer quantidade;
    private BigDecimal valor;

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
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
        return "ItemMovimento{" + "id=" + id + ", movimento=" + movimento 
                + ", produto=" + produto + ", quantidade=" 
                + quantidade + ", valor=" + valor + '}';
    }

}
