package br.com.ono.erp.entidade;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade Cliente.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (18/01/2013 12:22)
 */
@Entity
@Table(name="cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;
    
    @OneToOne(optional=false)
    private Participante participante;

    private int situacao;
    
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(name="data_ultima_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaCompra;

    @Column(name="data_ultima_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;
    
    @OneToMany
    @JoinTable(name="autorizados_cliente")
    private List<PessoaFisica> autorizados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
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

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Date getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(Date dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    public List<PessoaFisica> getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(List<PessoaFisica> autorizados) {
        this.autorizados = autorizados;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", codigo=" + codigo 
                + ", participante=" + participante 
                + ", situacao=" + situacao + ", dataCadastro=" + dataCadastro 
                + ", dataUltimaAtualizacao=" + dataUltimaAtualizacao 
                + ", dataUltimaCompra=" + dataUltimaCompra 
                + ", autorizados=" + autorizados + '}';
    }
    
}
