package erp.tributacao.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade ValoresTributo
 * 
 * Indica os valores configurados para cada NaturezaOperacao.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:33)
 */
public class ValoresTributo implements Entidade {
    
    private Long id;
    private String nomeTributo = "";
    
    private String origemDaMercadoria;
    private String cst = "";

    private BigDecimal valorTotal = BigDecimal.ZERO;
    
    private BigDecimal aliquota = BigDecimal.ZERO;
    private BigDecimal valorBaseCalculo = BigDecimal.ZERO;
    private BigDecimal valorTributo = BigDecimal.ZERO;

    private BigDecimal aliquotaST = BigDecimal.ZERO;
    private BigDecimal valorBaseCalculoST = BigDecimal.ZERO;
    private BigDecimal valorTributoST = BigDecimal.ZERO;
    
    private List<ApuracaoTributo> apuracoesTributo = new ArrayList<ApuracaoTributo>();
    
    public ValoresTributo() {
    }

    public ValoresTributo(Long id, String nomeTributo, String cst, BigDecimal aliquota) {
        this.id = id;
        this.nomeTributo = nomeTributo;
        this.cst = cst;
        this.aliquota = aliquota;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNomeTributo() {
        return nomeTributo;
    }

    public void setNomeTributo(String nomeTributo) {
        this.nomeTributo = nomeTributo;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public BigDecimal getValorTributo() {
        return valorTributo;
    }

    public void setValorTributo(BigDecimal valorTributo) {
        this.valorTributo = valorTributo;
    }

    public List<ApuracaoTributo> getApuracoesTributo() {
        return apuracoesTributo;
    }

    public void setApuracoesTributo(List<ApuracaoTributo> apuracoesTributo) {
        this.apuracoesTributo = apuracoesTributo;
    }

    public String getOrigemDaMercadoria() {
        return origemDaMercadoria;
    }

    public void setOrigemDaMercadoria(String origemDaMercadoria) {
        this.origemDaMercadoria = origemDaMercadoria;
    }

    public BigDecimal getAliquotaST() {
        return aliquotaST;
    }

    public void setAliquotaST(BigDecimal aliquotaST) {
        this.aliquotaST = aliquotaST;
    }

    public BigDecimal getValorBaseCalculoST() {
        return valorBaseCalculoST;
    }

    public void setValorBaseCalculoST(BigDecimal valorBaseCalculoST) {
        this.valorBaseCalculoST = valorBaseCalculoST;
    }

    public BigDecimal getValorTributoST() {
        return valorTributoST;
    }

    public void setValorTributoST(BigDecimal valorTributoST) {
        this.valorTributoST = valorTributoST;
    }

    public void executarTodasApuracoesTributo(ContextoTributacao contexto) throws Exception {
        for (ApuracaoTributo apuracaoTributo : apuracoesTributo) {
            apuracaoTributo.executar(contexto);
        }
    }

    @Override
    public String toString() {
        return "ValoresTributo{" + "id=" + id + ", nomeTributo=" + nomeTributo + ", origemDaMercadoria=" + origemDaMercadoria + ", cst=" + cst + ", valorTotal=" + valorTotal + ", aliquota=" + aliquota + ", valorBaseCalculo=" + valorBaseCalculo + ", valorTributo=" + valorTributo + ", aliquotaST=" + aliquotaST + ", valorBaseCalculoST=" + valorBaseCalculoST + ", valorTributoST=" + valorTributoST + ", apuracoesTributo=" + apuracoesTributo + '}';
    }

}
