package br.com.ono.erp.movimento.venda.desktop.impl;

import br.com.ono.erp.entidade.ComandaVenda;
import br.com.ono.erp.entidade.ItemSessaoMovimento;
import br.com.ono.erp.entidade.ProdutoEan13;
import br.com.ono.erp.movimento.model.desktop.impl.Model;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

/**
 * Controller para Balcao de Saida de Venda
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 10:29)
 */
public class Controller {

    private static final EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("entidadePU");
    
    private static final EntityManager em = emf.createEntityManager();
    
    private static final Model model = new Model();
    private static final View view = new View();

    private enum Situacao { COMANDA, MERCADORIA, ERRO_CONTAGEM }
    private static Situacao situacao = Situacao.COMANDA;
    
    public static void main(String[] args) throws Exception {
        model.setIdAplicacao(12345L);
        
        view.getTxt().addActionListener(new TxtAction());
        view.getButtonFechar().addActionListener(new ButtonAction());
        view.getTable().setModel(new TableModel());
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
            }
        });
    }
    
    private static class TableModel extends AbstractTableModel {

        @Override
        public String getColumnName(int i) {
            if (i == 0) {
                return "Cód.";
            }
            if (i == 1) {
                return "Descrição.";
            }
            return "";
        }
        
        @Override
        public int getRowCount() {
            return 5;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int i, int i1) {
            String ret = "";
            if (model.getSessaoMovimento() == null) {
                return ret;
            }
            int qtde = model.getSessaoMovimento().getItensSessaoMovimento().size();
            int indice = qtde - i - 1;
            if (indice < 0) {
                return ret;
            }
            ItemSessaoMovimento itemSessaoMovimento 
                    = model.getSessaoMovimento().getItensSessaoMovimento().get(indice);
            
            if (i1 == 0) {
                ret = itemSessaoMovimento.getProdutoEan13().getCodigoEan13();
            }
            else if (i1 == 1) {
                ret = itemSessaoMovimento.getProdutoEan13().getProduto().getDescricao();
            }
            return ret;
        }
        
    }
    
    private static class ButtonAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Fechar
            try {
                int quantidadeContada = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade contada:"));
                int quantidadeVolumes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de volumes:"));
                model.fecharPassagem(quantidadeContada, quantidadeVolumes);
                situacao = Situacao.COMANDA;
                updateView();
                JOptionPane.showMessageDialog(view, "Comanda fechada com sucesso.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        }
        
    }
    
    private static class TxtAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String valor = ((JTextField) ae.getSource()).getText();
            
            if (situacao == Situacao.COMANDA) {
                // Na verdade tem que carregar do banco
                ComandaVenda comandaVenda = new ComandaVenda();
                comandaVenda.setDataHora(new Date());
                comandaVenda.setEmpresa(null);
                comandaVenda.setEntrega("TRANSPORTADORA TRANSP");
                comandaVenda.setQuantidadeCarrinhos(1);
                comandaVenda.setQuantidadeSacolas(2);
                
                em.getTransaction().begin();
                em.persist(comandaVenda);
                em.getTransaction().commit();
                
                try {
                    model.iniciarPassagem(comandaVenda);
                    situacao = Situacao.MERCADORIA;
                    updateView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
            else if (situacao == Situacao.MERCADORIA) {
                try {
                    Long codigoEan13 = Long.valueOf(valor);
                    ProdutoEan13 produtoEan13 = em.find(ProdutoEan13.class, codigoEan13);
                    if (produtoEan13 == null) {
                        throw new Exception("Mercadoria nao existe !");
                    }
                    model.passarProduto(produtoEan13);
                    System.out.println("Contagem: "+ model.getContagem());
                    updateView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
            
        }
        
    }
    
    private static void updateView() {
        if (situacao == Situacao.COMANDA) {
            view.getLabel().setText("PASSE A COMANDA");
        }
        if (situacao == Situacao.MERCADORIA) {
            view.getLabel().setText("PASSE A MERCADORIA");
        }
        view.getTable().repaint();
        view.getTxt().setText("");
        view.getTxt().requestFocus();
    }
    
}
