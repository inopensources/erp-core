package erp.infra.test.entity;

import erp.infra.annotation.Field;
import erp.infra.annotation.Form;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade Pessoa Fisica.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (15/01/2012 12:02)
 */
@Entity
@Table(name="pessoa_fisica")
@DiscriminatorValue("F")
@Form(id="pf", layout="\n"
        + "           [id ]                                           \n"
        + "           [nome_____________________]                     \n"
        + "           [rg____________]      [cpf___________]          \n"
        + "           [enderecos        ]                             \n"
        + "           [telefones        ]                             \n"
        + "           [emails           ]                             \n"
)
public class PessoaFisica extends Participante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String rg;
    private String cpf;

    @Field(id="nome", label="Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Field(id="rg", label="RG")
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Field(id="cpf", label="CPF")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "nome=" + nome 
                + ", rg=" + rg + ", cpf=" + cpf + '}';
    }
    
}
