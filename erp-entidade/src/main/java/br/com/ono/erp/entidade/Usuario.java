package br.com.ono.erp.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade Usuario.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 01:39)
 */
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String login;
    private String senha;
    
    @OneToOne(optional=false)
    private PessoaFisica pessoaFisica;

    private int situacao;
    
    @Column(name="data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }


    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha 
                + ", pessoaFisica=" + pessoaFisica + ", situacao=" + situacao 
                + ", dataHoraCadastro=" + dataHoraCadastro + '}';
    }
    
}
