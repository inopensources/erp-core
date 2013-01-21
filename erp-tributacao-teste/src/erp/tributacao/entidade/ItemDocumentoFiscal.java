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
    
    private BigDecimal cstIpi;
    private BigDecimal baseCalculoIpi;
    private BigDecimal aliquotaIpi;
    private BigDecimal valorIpi;

    private BigDecimal cstIcms;
    private BigDecimal baseCalculoIcms;
    private BigDecimal aliquotaIcms;
    private BigDecimal valorIcms;

    private BigDecimal cstPis;
    private BigDecimal baseCalculoPis;
    private BigDecimal aliquotaPis;
    private BigDecimal valorPis;

    private BigDecimal cstCofins;
    private BigDecimal baseCalculoCofins;
    private BigDecimal aliquotaCofins;
    private BigDecimal valorCofins;
    
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

    public BigDecimal getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(BigDecimal cstIpi) {
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

    public BigDecimal getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(BigDecimal cstIcms) {
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

    public BigDecimal getCstPis() {
        return cstPis;
    }

    public void setCstPis(BigDecimal cstPis) {
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

    public BigDecimal getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(BigDecimal cstCofins) {
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

    @Override
    public String toString() {
        return "ItemDocumentoFiscal{" + "id=" + id + ", produto=" + produto + ", cstIpi=" + cstIpi + ", baseCalculoIpi=" + baseCalculoIpi + ", aliquotaIpi=" + aliquotaIpi + ", valorIpi=" + valorIpi + ", cstIcms=" + cstIcms + ", baseCalculoIcms=" + baseCalculoIcms + ", aliquotaIcms=" + aliquotaIcms + ", valorIcms=" + valorIcms + ", cstPis=" + cstPis + ", baseCalculoPis=" + baseCalculoPis + ", aliquotaPis=" + aliquotaPis + ", valorPis=" + valorPis + ", cstCofins=" + cstCofins + ", baseCalculoCofins=" + baseCalculoCofins + ", aliquotaCofins=" + aliquotaCofins + ", valorCofins=" + valorCofins + '}';
    }
    
}
