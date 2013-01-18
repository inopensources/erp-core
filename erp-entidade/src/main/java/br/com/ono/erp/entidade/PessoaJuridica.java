package br.com.ono.erp.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade Pessoa Juridica.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (15/01/2012 12:02)
 */
@Entity
@Table(name="pessoa_juridica")
@DiscriminatorValue("J")
public class PessoaJuridica extends Participante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cnpj;
    
    @Column(name="razao_social")
    private String razaoSocial;
    
    @Column(name="nome_fantasia")
    private String nomeFantasia;
    
    @Column(name="inscricao_estadual")
    private String inscricaoEstadual;
    
    @Column(name="inscricao_suframa")
    private String inscricaoSuframa;
    
    // Consulte: http://www.anvisa.gov.br/servicos/arrecadacao/porte.htm
    private String porte;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getInscricaoSuframa() {
        return inscricaoSuframa;
    }

    public void setInscricaoSuframa(String inscricaoSuframa) {
        this.inscricaoSuframa = inscricaoSuframa;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "cnpj=" + cnpj + ", razaoSocial=" 
                + razaoSocial + ", nomeFantasia=" + nomeFantasia 
                + ", inscricaoEstadual=" + inscricaoEstadual 
                + ", inscricaoSuframa=" + inscricaoSuframa 
                + ", porte=" + porte + '}';
    }
    
}
