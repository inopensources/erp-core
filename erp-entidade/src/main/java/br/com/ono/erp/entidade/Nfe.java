package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade Nfe.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 22:23)
 */
@Entity
@Table(name="nfe")
@DiscriminatorValue("55")
public class Nfe extends DocumentoFiscal {
    
    private String chave;
    private Integer numero;
    private Integer serie;
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Nfe{" + "chave=" + chave + ", numero=" 
                + numero + ", serie=" + serie + ", valor=" + valor + '}';
    }
    
}
