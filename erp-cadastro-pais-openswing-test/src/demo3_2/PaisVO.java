package demo3_2;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 * Entidade PaisVO.
 * 
 * Adaptado para OpenSwing.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (25/01/2013 21:23)
 */
public class PaisVO extends ValueObjectImpl {
    
    private Long id;
    private String codigoBacen;
    private String nome;
    private String sigla2;

    public PaisVO() {
    }

    public PaisVO(Long id, String codigoBacen, String nome, String sigla2) {
        this.id = id;
        this.codigoBacen = codigoBacen;
        this.nome = nome;
        this.sigla2 = sigla2;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBacen() {
        return codigoBacen;
    }

    public void setCodigoBacen(String codigoBacen) {
        this.codigoBacen = codigoBacen;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla2() {
        return sigla2;
    }

    public void setSigla2(String sigla2) {
        this.sigla2 = sigla2;
    }

    @Override
    public String toString() {
        return "PaisVO{" + "id=" + id + ", codigoBacen=" + codigoBacen + ", nome=" + nome + ", sigla2=" + sigla2 + '}';
    }

    
}
