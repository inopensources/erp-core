package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade ItemSessaoMovimento.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 22:26)
 */
@Entity
@Table(name="item_sessao_movimento")
public class ItemSessaoMovimento {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_sessao_movimento")
    private SessaoMovimento sessaoMovimento;
    
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
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Date dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public SessaoMovimento getSessaoMovimento() {
        return sessaoMovimento;
    }

    public void setSessaoMovimento(SessaoMovimento sessaoMovimento) {
        this.sessaoMovimento = sessaoMovimento;
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
        return "ItemSessaoMovimento{" + "id=" + id + ", sessaoMovimento=" 
                + sessaoMovimento + ", produtoEan13=" + produtoEan13 
                + ", quantidade=" + quantidade + ", valor=" + valor 
                + ", usuario1=" + usuario1 + ", usuario2=" 
                + usuario2 + ", dataHora=" + dataHora + '}';
    }

}
