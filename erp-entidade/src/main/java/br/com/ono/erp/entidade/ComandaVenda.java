package br.com.ono.erp.entidade;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade ComandaVenda.
 * 
 * O cliente, ao efetuar uma compra, dirige-se ao balcao 
 * onde recebe uma comanda e aguarda a passagem das mercadorias.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 03:58)
 */
@Entity
@Table(name="comanda_venda")
@DiscriminatorValue("VENDA")
public class ComandaVenda extends Movimento {
    
    @Column(name = "quantidade_carrinhos")
    private int quantidadeCarrinhos;
    
    @Column(name = "quantidade_sacolas")
    private int quantidadeSacolas;
    
    private String entrega;

    public int getQuantidadeCarrinhos() {
        return quantidadeCarrinhos;
    }

    public void setQuantidadeCarrinhos(int quantidadeCarrinhos) {
        this.quantidadeCarrinhos = quantidadeCarrinhos;
    }

    public int getQuantidadeSacolas() {
        return quantidadeSacolas;
    }

    public void setQuantidadeSacolas(int quantidadeSacolas) {
        this.quantidadeSacolas = quantidadeSacolas;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    @Override
    public String toString() {
        return "ComandaVenda{" + "quantidadeCarrinhos=" 
                + quantidadeCarrinhos + ", quantidadeSacolas=" 
                + quantidadeSacolas + ", entrega=" + entrega + '}';
    }
    
}
