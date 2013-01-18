package br.com.ono.erp.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade EnderecoParticipante.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (15/01/2012 12:19)
 */
@Entity
@Table(name="endereco_participante")
public class EnderecoParticipante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo = "";
    private String logradouro = "";
    private String numero = "";
    private String complemento = "";
    private String cep = "";
    private String bairro = "";
    private String municipio = "";
    @Column(name="codigo_ibge_municipio")
    private String codigoIbgeMunicipio = "";
    private String uf = "";
    @Column(name="codigo_ibge_uf")
    private String codigoIbgeUf = "";
    private String pais = "";
    @Column(name="codigo_bc_pais")
    private String codigoBcPais = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigoIbgeMunicipio() {
        return codigoIbgeMunicipio;
    }

    public void setCodigoIbgeMunicipio(String codigoIbgeMunicipio) {
        this.codigoIbgeMunicipio = codigoIbgeMunicipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodigoIbgeUf() {
        return codigoIbgeUf;
    }

    public void setCodigoIbgeUf(String codigoIbgeUf) {
        this.codigoIbgeUf = codigoIbgeUf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoBcPais() {
        return codigoBcPais;
    }

    public void setCodigoBcPais(String codigoBcPais) {
        this.codigoBcPais = codigoBcPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof EnderecoParticipante)) {
            return false;
        }
        EnderecoParticipante other = (EnderecoParticipante) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnderecoParticipante{" + "id=" + id + ", tipo=" + tipo 
                + ", logradouro=" + logradouro + ", numero=" + numero 
                + ", complemento=" + complemento + ", cep=" + cep 
                + ", bairro=" + bairro + ", municipio=" + municipio 
                + ", codigoIbgeMunicipio=" + codigoIbgeMunicipio + ", uf=" 
                + uf + ", codigoIbgeUf=" + codigoIbgeUf + ", pais=" 
                + pais + ", codigoBcPais=" + codigoBcPais + '}';
    }

    
}
