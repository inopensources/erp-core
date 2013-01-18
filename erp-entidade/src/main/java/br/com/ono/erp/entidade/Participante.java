package br.com.ono.erp.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidade abstrata Participante.
 * 
 * Pai de PessoaFisica, PessoaJuridica e PessoaEstrangeira.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (15/01/2012 12:34)
 */
@Entity
@Table(name="participante")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING, length=1)
public abstract class Participante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_participante", referencedColumnName="id")
    private List<EnderecoParticipante> enderecos = new ArrayList<EnderecoParticipante>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_participante", referencedColumnName="id")
    private List<TelefoneParticipante> telefones = new ArrayList<TelefoneParticipante>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_participante", referencedColumnName="id")
    private List<EmailParticipante> emails = new ArrayList<EmailParticipante>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EnderecoParticipante> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoParticipante> enderecos) {
        this.enderecos = enderecos;
    }

    public List<TelefoneParticipante> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneParticipante> telefones) {
        this.telefones = telefones;
    }

    public List<EmailParticipante> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailParticipante> emails) {
        this.emails = emails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", enderecos=" 
                + enderecos + ", telefones=" + telefones
                + ", emails=" + emails + '}';
    }
    
}
