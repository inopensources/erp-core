package br.com.ono.erp.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade Fornecedor.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (18/01/2013 13:21)
 */
@Entity
@Table(name="fornecedor")
public class Fornecedor {
    
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
    
    @Column(name="data_ultima_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;
    
    @OneToMany
    @JoinTable(name="representante_fornecedor")
    private List<PessoaFisica> representantes;

    @Column(name="aceita_devolucao")
    private Boolean aceitaDevolucao;
    
    @Column(name="prazo_pagamento_dias")
    private int prazoPagamentoDias;
    
    @Column(name="prazo_entrega_dias")
    private int prazoEntregaDias;
    
    @ManyToMany(mappedBy="fornecedores")
    private List<Produto> produtos = new ArrayList<Produto>();
    
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

    public List<PessoaFisica> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(List<PessoaFisica> representantes) {
        this.representantes = representantes;
    }

    public Boolean getAceitaDevolucao() {
        return aceitaDevolucao;
    }

    public void setAceitaDevolucao(Boolean aceitaDevolucao) {
        this.aceitaDevolucao = aceitaDevolucao;
    }

    public int getPrazoPagamentoDias() {
        return prazoPagamentoDias;
    }

    public void setPrazoPagamentoDias(int prazoPagamentoDias) {
        this.prazoPagamentoDias = prazoPagamentoDias;
    }

    public int getPrazoEntregaDias() {
        return prazoEntregaDias;
    }

    public void setPrazoEntregaDias(int prazoEntregaDias) {
        this.prazoEntregaDias = prazoEntregaDias;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", codigo=" + codigo 
                + ", participante=" + participante + ", situacao=" 
                + situacao + ", dataCadastro=" + dataCadastro 
                + ", dataUltimaAtualizacao=" + dataUltimaAtualizacao 
                + ", representantes=" + representantes 
                + ", aceitaDevolucao=" + aceitaDevolucao 
                + ", prazoPagamentoDias=" + prazoPagamentoDias 
                + ", prazoEntregaDias=" + prazoEntregaDias 
                + ", produtos=" + produtos + '}';
    }
    
}
