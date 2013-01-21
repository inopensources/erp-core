package erp.tributacao.entidade;

import java.math.BigDecimal;

/**
 * Entidade ItemDocumentoFiscal
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 14:10)
 */
public class ItemDocumentoFiscal implements Entidade {

    private Long id;
    private Produto produto;
    private int quantidade;
    
    private String cfop = "";
    
    private BigDecimal valorUnitario = BigDecimal.ZERO;
    private BigDecimal valorTotal = BigDecimal.ZERO;
    
    private String cstIpi = "";
    private BigDecimal baseCalculoIpi = BigDecimal.ZERO;
    private BigDecimal aliquotaIpi = BigDecimal.ZERO;
    private BigDecimal valorIpi = BigDecimal.ZERO;

    private String cstIcms = "";
    private BigDecimal baseCalculoIcms = BigDecimal.ZERO;
    private BigDecimal aliquotaIcms = BigDecimal.ZERO;
    private BigDecimal valorIcms = BigDecimal.ZERO;

    private String cstPis = "";
    private BigDecimal baseCalculoPis = BigDecimal.ZERO;
    private BigDecimal aliquotaPis = BigDecimal.ZERO;
    private BigDecimal valorPis = BigDecimal.ZERO;

    private String cstCofins = "";
    private BigDecimal baseCalculoCofins = BigDecimal.ZERO;
    private BigDecimal aliquotaCofins = BigDecimal.ZERO;
    private BigDecimal valorCofins = BigDecimal.ZERO;

    public ItemDocumentoFiscal(Long id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = produto.getValorUnitario();
        this.valorTotal = produto.getValorUnitario().multiply(new BigDecimal(quantidade));
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(String cstIpi) {
        this.cstIpi = cstIpi;
    }

    public BigDecimal getBaseCalculoIpi() {
        return baseCalculoIpi;
    }

    public void setBaseCalculoIpi(BigDecimal baseCalculoIpi) {
        this.baseCalculoIpi = baseCalculoIpi;
    }

    public BigDecimal getAliquotaIpi() {
        return aliquotaIpi;
    }

    public void setAliquotaIpi(BigDecimal aliquotaIpi) {
        this.aliquotaIpi = aliquotaIpi;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public String getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(String cstIcms) {
        this.cstIcms = cstIcms;
    }

    public BigDecimal getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(BigDecimal baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
    }

    public BigDecimal getBaseCalculoPis() {
        return baseCalculoPis;
    }

    public void setBaseCalculoPis(BigDecimal baseCalculoPis) {
        this.baseCalculoPis = baseCalculoPis;
    }

    public BigDecimal getAliquotaPis() {
        return aliquotaPis;
    }

    public void setAliquotaPis(BigDecimal aliquotaPis) {
        this.aliquotaPis = aliquotaPis;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
    }

    public BigDecimal getBaseCalculoCofins() {
        return baseCalculoCofins;
    }

    public void setBaseCalculoCofins(BigDecimal baseCalculoCofins) {
        this.baseCalculoCofins = baseCalculoCofins;
    }

    public BigDecimal getAliquotaCofins() {
        return aliquotaCofins;
    }

    public void setAliquotaCofins(BigDecimal aliquotaCofins) {
        this.aliquotaCofins = aliquotaCofins;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public void preencherImpostos(ContextoTributacao contexto) {
        cfop = contexto.getCfop();
        for (ValoresTributo valoresTributo : contexto.getValoresTributos()) {
            if (valoresTributo.getNomeTributo().equals("ICMS")) {
                cstIcms = valoresTributo.getCst();
                baseCalculoIcms = valoresTributo.getValorBaseCalculo();
                aliquotaIcms = valoresTributo.getAliquota();
                valorIcms = valoresTributo.getValorTributo();
            }
            if (valoresTributo.getNomeTributo().equals("IPI")) {
                cstIpi = valoresTributo.getCst();
                baseCalculoIpi = valoresTributo.getValorBaseCalculo();
                aliquotaIpi = valoresTributo.getAliquota();
                valorIpi = valoresTributo.getValorTributo();
            }
            if (valoresTributo.getNomeTributo().equals("PIS")) {
                cstPis = valoresTributo.getCst();
                baseCalculoPis = valoresTributo.getValorBaseCalculo();
                aliquotaPis = valoresTributo.getAliquota();
                valorPis = valoresTributo.getValorTributo();
            }
            if (valoresTributo.getNomeTributo().equals("COFINS")) {
                cstCofins = valoresTributo.getCst();
                baseCalculoCofins = valoresTributo.getValorBaseCalculo();
                aliquotaCofins = valoresTributo.getAliquota();
                valorCofins = valoresTributo.getValorTributo();
            }
        }
    }

    @Override
    public String toString() {
        return "\nItemDocumentoFiscal{" + "id=" + id + ", produto.descricao=" + produto.getDescricao() + ", quantidade=" + quantidade + ", cfop=" + cfop + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", cstIpi=" + cstIpi + ", baseCalculoIpi=" + baseCalculoIpi + ", aliquotaIpi=" + aliquotaIpi + ", valorIpi=" + valorIpi + ", cstIcms=" + cstIcms + ", baseCalculoIcms=" + baseCalculoIcms + ", aliquotaIcms=" + aliquotaIcms + ", valorIcms=" + valorIcms + ", cstPis=" + cstPis + ", baseCalculoPis=" + baseCalculoPis + ", aliquotaPis=" + aliquotaPis + ", valorPis=" + valorPis + ", cstCofins=" + cstCofins + ", baseCalculoCofins=" + baseCalculoCofins + ", aliquotaCofins=" + aliquotaCofins + ", valorCofins=" + valorCofins + '}';
    }
    


}
