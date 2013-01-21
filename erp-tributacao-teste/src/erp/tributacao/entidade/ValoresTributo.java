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
    private String nomeTributo;
    private String cst;
    private BigDecimal aliquota;

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

    @Override
    public String toString() {
        return "\nValoresTributo{" + "id=" + id + ", nomeTributo=" + nomeTributo + ", cst=" + cst + ", aliquota=" + aliquota + '}';
    }

}
