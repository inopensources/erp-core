package erp.tributacao.entidade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
    
    private Map<String, String> propriedades = new HashMap<String, String>();
    
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

    public Map<String, String> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(Map<String, String> propriedades) {
        this.propriedades = propriedades;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", ncm=" + ncm + ", valorUnitario=" + valorUnitario + ", propriedades=" + propriedades + '}';
    }
    
}
