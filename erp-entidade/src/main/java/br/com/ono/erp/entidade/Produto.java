package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Entidade Produto.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (18/01/2013 14:14)
 */
@Entity
@Table(name="produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    // indica a qual dominio este produto pertence
    @ManyToOne
    @JoinColumn(name="dominio_produto_id")
    private DominioProduto dominioProduto;
    
    @Column(name="codigo_interno")
    private String codigoInterno;
    
    private String descricao;
    
    @Column(name="tipo_item")
    private String tipoItem;
    
    @Column(name="codigo_ncm")
    private String codigoNcm;
    
    @Column(name="codigo_genero")
    private String codigoGenero;
    
    // Consultar: Anexo I da Lei Complementar Federal n. 116/03
    @Column(name="codigo_servico")
    private String codigoServico;
    
    @Column(name="aliquota_icms", precision=10, scale=2)
    private BigDecimal aliquotaIcms;
    
    @Column(name="custo_unitario", precision=10, scale=2)
    private BigDecimal custoUnitario;
    
    @Column(name="valor_venda", precision=10, scale=2)
    private BigDecimal valorVenda;
    
    @Column(name="unidade_estoque")
    private String unidadeEstoque;
    
    @Column(name="peso_unitario")
    private String pesoUnitario;
    
    private String situacao;
    
    @Column(name="data_cadastro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(name="data_ultima_atualizacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;
    
    @OneToMany
    @JoinTable(name = "fornecedor_produto")
    private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DominioProduto getDominioProduto() {
        return dominioProduto;
    }

    public void setDominioProduto(DominioProduto dominioProduto) {
        this.dominioProduto = dominioProduto;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getCodigoNcm() {
        return codigoNcm;
    }

    public void setCodigoNcm(String codigoNcm) {
        this.codigoNcm = codigoNcm;
    }

    public String getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(String codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public BigDecimal getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(BigDecimal custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getUnidadeEstoque() {
        return unidadeEstoque;
    }

    public void setUnidadeEstoque(String unidadeEstoque) {
        this.unidadeEstoque = unidadeEstoque;
    }

    public String getPesoUnitario() {
        return pesoUnitario;
    }

    public void setPesoUnitario(String pesoUnitario) {
        this.pesoUnitario = pesoUnitario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", dominioProduto=" + dominioProduto 
                + ", codigoInterno=" + codigoInterno + ", descricao=" + descricao 
                + ", tipoItem=" + tipoItem + ", codigoNcm=" + codigoNcm 
                + ", codigoGenero=" + codigoGenero + ", codigoServico=" 
                + codigoServico + ", aliquotaIcms=" + aliquotaIcms 
                + ", custoUnitario=" + custoUnitario + ", valorVenda=" 
                + valorVenda + ", unidadeEstoque=" + unidadeEstoque 
                + ", pesoUnitario=" + pesoUnitario + ", situacao=" + situacao 
                + ", dataCadastro=" + dataCadastro + ", dataUltimaAtualizacao=" 
                + dataUltimaAtualizacao + ", fornecedores=" + fornecedores + '}';
    }

}
