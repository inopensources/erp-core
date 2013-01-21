package erp.tributacao.entidade;

import java.math.BigDecimal;

/**
 * Entidade Produto
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:22)
 */
public class Produto implements Entidade {
    
    private Long id;
    private String descricao;
    private String ncm;
    private BigDecimal valorUnitario;
    private TributacaoProduto tributacaoProduto;

    public Produto() {
    }

    public Produto(Long id, String descricao, String ncm, BigDecimal valorUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.ncm = ncm;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public TributacaoProduto getTributacaoProduto() {
        return tributacaoProduto;
    }

    public void setTributacaoProduto(TributacaoProduto tributacaoProduto) {
        this.tributacaoProduto = tributacaoProduto;
    }

    @Override
    public String toString() {
        return "\nProduto{" + "id=" + id + ", descricao=" + descricao + ", ncm=" + ncm + ", valorUnitario=" + valorUnitario + ", tributacaoProduto=" + tributacaoProduto + '}';
    }
    
}
