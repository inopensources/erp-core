package erp.tributacao.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade Tributo
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:33)
 */
public class Tributo {
    
    private String nomeTributo;
    private String cst;
    private BigDecimal baseCalculo;
    private BigDecimal aliquota;
    private BigDecimal valor;
    
    private List<TratamentoDiferenciado> tratamentosDiferenciados 
            = new ArrayList<TratamentoDiferenciado>();

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

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<TratamentoDiferenciado> getTratamentosDiferenciados() {
        return tratamentosDiferenciados;
    }

    public void setTratamentosDiferenciados(List<TratamentoDiferenciado> tratamentosDiferenciados) {
        this.tratamentosDiferenciados = tratamentosDiferenciados;
    }

    @Override
    public String toString() {
        return "Tributo{" + "nomeTributo=" + nomeTributo + ", cst=" 
                + cst + ", baseCalculo=" + baseCalculo + ", aliquota=" 
                + aliquota + ", valor=" + valor + ", tratamentosDiferenciados=" 
                + tratamentosDiferenciados + '}';
    }

}
