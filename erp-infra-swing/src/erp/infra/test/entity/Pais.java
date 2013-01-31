package erp.infra.test.entity;

import erp.infra.annotation.Field;
import erp.infra.annotation.Form;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidade Pais.
 * 
 * Os registros podem ser encontrados em: 
 * http://www.bcb.gov.br/rex/ftp/paises.txt
 * 
 * A sigla de 2 letras pode ser encontrada em:
 * http://www.inf.ufrgs.br/~cabral/Paises.html
 * segundo norma ISO3166
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (18/01/2013 23:05)
 */
@Entity
@Table(name = "pais")
@Form(id = "pais", verticalPadding=3, layout = "\n\n\n"
        + "              [id__]           [objeto_________]      \n"
        + "              [codbc_]                                \n"
        + "              [nome_________________________]         \n"
        + "              [s2__   ]                               \n"
        + "              [quente ]                               \n"
        + "              [datacad]                               \n"
        + "              [c]                                     \n"
)
public class Pais implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_bacen")
    private String codigoBacen;
    
    private String nome;
    
    private String sigla2;

    @Transient
    private Object objeto;
    
    @Transient
    private Boolean quente;
    
    @Transient
    private Date dataCadastro;
    
    @Transient
    private Character caracter;
    
    public Pais() {
    }

    public Pais(Long id, String codigoBacen, String nome, String sigla2) {
        this.id = id;
        this.codigoBacen = codigoBacen;
        this.nome = nome;
        this.sigla2 = sigla2;
    }

    @Field(id="objeto", label="Objeto")
    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
    @Field(id="id", label="Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Field(id="codbc", label="Cód. BACEN")
    public String getCodigoBacen() {
        return codigoBacen;
    }

    public void setCodigoBacen(String codigoBacen) {
        this.codigoBacen = codigoBacen;
    }

    @Field(id="nome", label="Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Field(id="s2", label="Sigla 2")
    public String getSigla2() {
        return sigla2;
    }

    public void setSigla2(String sigla2) {
        this.sigla2 = sigla2;
    }

    @Field(id="quente", label="Quente")
    public Boolean getQuente() {
        return quente;
    }

    public void setQuente(Boolean quente) {
        this.quente = quente;
    }

    @Field(id="datacad", label="Data de cadastro")
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Field(id="c", label="Caracter")
    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", codigoBacen=" + codigoBacen + ", nome=" + nome + ", sigla2=" + sigla2 + ", objeto=" + objeto + ", quente=" + quente + ", dataCadastro=" + dataCadastro + ", caracter=" + caracter + '}';
    }

}
