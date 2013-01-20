package br.com.ono.erp.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade Empresa.
 * 
 * Representa a empresa a ser gerenciada.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 16:00)
 */
@Entity
@Table(name="empresa")
public class Empresa {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "pessoa_juridica_id")
    private PessoaJuridica pessoaJuridica;

    private int situacao;
    
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    /**
     * Para IRPJ e CSLL, a empresa pode optar pelo Simples Nacional, 
     * Lucro Presumido, Lucro Arbitrado ou Lucro Real.
     */
    // TODO a empresa pode alterar o regime de tributacao, portanto
    // o sistema deve possibilitar armazenar varios periodos (data inicial e final)
    // e o tipo de regime utilizado dentro de cada periodo;
    @Column(name="regime_tributacao")
    private String regimeTributacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getRegimeTributacao() {
        return regimeTributacao;
    }

    public void setRegimeTributacao(String regimeTributacao) {
        this.regimeTributacao = regimeTributacao;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", pessoaJuridica=" 
                + pessoaJuridica + ", situacao=" + situacao + ", dataCadastro=" 
                + dataCadastro + ", regimeTributacao=" + regimeTributacao + '}';
    }
    
}
