package br.com.ono.erp.entidade;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade Pessoa Estrangeira.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (15/01/2012 12:02)
 */
@Entity
@Table(name="pessoa_estrangeira")
@DiscriminatorValue("E")
public class PessoaEstrangeira extends Participante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "PessoaEstrangeira{" + "nome=" + nome 
                + ", documento=" + documento + '}';
    }
    
}
