package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    private ProdutoEan13 produtoEan13;
    
    private Integer quantidade;
    private BigDecimal valor;
    
    @OneToOne
    @JoinColumn(name = "id_usuario1")
    private Usuario usuario1;

    @OneToOne
    @JoinColumn(name = "id_usuario2")
    private Usuario usuario2;

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public ProdutoEan13 getProdutoEan13() {
        return produtoEan13;
    }

    public void setProdutoEan13(ProdutoEan13 produtoEan13) {
        this.produtoEan13 = produtoEan13;
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

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    @Override
    public String toString() {
        return "ItemMovimento{" + "id=" + id + ", movimento=" + movimento 
                + ", produtoEan13=" + produtoEan13 + ", quantidade=" 
                + quantidade + ", valor=" + valor + ", usuario1=" 
                + usuario1 + ", usuario2=" + usuario2 + '}';
    }

}
