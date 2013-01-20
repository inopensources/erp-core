package br.com.ono.erp.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidade SessaoMovimento.
 * 
 * O mesmo movimento pode ser utilizado para registrar os itens de entrada/saida
 * por diversos programas ao mesmo tempo. Para isso, cada aplicativo deve
 * criar uma sessao (SessaoMovimento) que contem campos que identificam 
 * a aplicacao que esta utilizando o movimento, se a passagem foi validada 
 * com sucesso, etc.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 12:48)
 */
@Entity
@Table(name="sessao_movimento")
public class SessaoMovimento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid_sessao")
    private String uuidSessao;

    @Column(name = "id_aplicacao")
    private String idAplicacao;
    
    // "A" aberta
    // "S" salva com sucesso
    // "F" fechada com sucesso
    private String situacao;
    
    @Column(name = "contagem_informada")
    private Integer contagemInformada;

    @Column(name = "numero_passagem")
    private Integer numeroPassagem;
    
    @ManyToOne
    @JoinColumn(name = "id_movimento")
    private Movimento movimento;
    
    @OneToMany(mappedBy = "sessaoMovimento", cascade = CascadeType.ALL)
    private List<ItemSessaoMovimento> itensSessaoMovimento = new ArrayList<ItemSessaoMovimento>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuidSessao() {
        return uuidSessao;
    }

    public void setUuidSessao(String uuidSessao) {
        this.uuidSessao = uuidSessao;
    }

    public String getIdAplicacao() {
        return idAplicacao;
    }

    public void setIdAplicacao(String idAplicacao) {
        this.idAplicacao = idAplicacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getContagemInformada() {
        return contagemInformada;
    }

    public void setContagemInformada(Integer contagemInformada) {
        this.contagemInformada = contagemInformada;
    }

    public Integer getNumeroPassagem() {
        return numeroPassagem;
    }

    public void setNumeroPassagem(Integer numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public List<ItemSessaoMovimento> getItensSessaoMovimento() {
        return itensSessaoMovimento;
    }

    public void setItensSessaoMovimento(List<ItemSessaoMovimento> itensSessaoMovimento) {
        this.itensSessaoMovimento = itensSessaoMovimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof SessaoMovimento)) {
            return false;
        }
        SessaoMovimento other = (SessaoMovimento) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessaoMovimento{" + "id=" + id + ", uuidSessao=" + uuidSessao 
                + ", idAplicacao=" + idAplicacao + ", situacao=" + situacao 
                + ", contagemInformada=" + contagemInformada 
                + ", numeroPassagem=" + numeroPassagem 
                + ", movimento=" + movimento + ", itensSessaoMovimento=" 
                + itensSessaoMovimento + '}';
    }

}
