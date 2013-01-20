package br.com.ono.erp.entidade;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade DuplicataNfe.
 * 
 * Representa o titulo de credito da fatura.
 * Referencia: http://http://pt.wikipedia.org/wiki/Fatura
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 16:08)
 */
@Entity
@Table(name="duplicata_nfe")
public class DuplicataNfe extends DocumentoFiscal {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Nfe nfe;
    
    private String numero;;
    private BigDecimal valor;
    
    @Temporal(value = TemporalType.DATE)
    private Date dataVencimento;

    public Nfe getNfe() {
        return nfe;
    }

    public void setNfe(Nfe nfe) {
        this.nfe = nfe;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "DuplicataNfe{" + "id=" + id + ", nfe=" + nfe + ", numero=" 
                + numero + ", valor=" + valor + ", dataVencimento=" + dataVencimento + '}';
    }

}
