package erp.tributacao.entidade;

/**
 * Entidade Destinatario do documento fiscal
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:22)
 */
public class Destinatario {
    
    private String cnpj;
    private String razao;
    private String porte;
    private String uf;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Emitente{" + "cnpj=" + cnpj + ", razao=" + razao + ", porte=" + porte + ", uf=" + uf + '}';
    }
    
}
