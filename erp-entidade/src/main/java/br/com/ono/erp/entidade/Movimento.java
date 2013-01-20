package br.com.ono.erp.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade Movimento.
 * 
 * Representa as movimentacoes fisicas dos produtos 
 * de uma Empresa de acordo com uma NaturezaOperacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (19/01/2013 21:50)
 */
@Entity
@Table(name="movimento")
public class Movimento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Empresa empresa;
    
    // Se o indicador do tipo de operacao for ENTRADA, considera-se como participante_origem (ex.: fornecedor)
    // Se o indicador do tipo de operacao for SAIDA, considera-se como participante_destino (ex.: cliente)
    @ManyToOne
    @JoinColumn(name = "participante_origem_destino_id")
    private Participante participanteOrigemDestino;
    
    @ManyToOne
    @JoinColumn(name = "natureza_operacao_id")
    private NaturezaOperacao naturezaOperacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Date dataHora;
    
    @Column(name = "quantidade_volumes")
    private Integer quantidadeVolumes;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Participante getParticipanteOrigemDestino() {
        return participanteOrigemDestino;
    }

    public void setParticipanteOrigemDestino(Participante participanteOrigemDestino) {
        this.participanteOrigemDestino = participanteOrigemDestino;
    }

    public NaturezaOperacao getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(NaturezaOperacao naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getQuantidadeVolumes() {
        return quantidadeVolumes;
    }

    public void setQuantidadeVolumes(Integer quantidadeVolumes) {
        this.quantidadeVolumes = quantidadeVolumes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimento{" + "id=" + id + ", empresa=" + empresa 
                + ", participanteOrigemDestino=" + participanteOrigemDestino 
                + ", naturezaOperacao=" + naturezaOperacao + ", dataHora=" 
                + dataHora + ", quantidadeVolumes=" + quantidadeVolumes + '}';
    }

}
