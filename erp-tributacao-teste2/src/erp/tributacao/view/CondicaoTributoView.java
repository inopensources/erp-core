/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.tributacao.view;

import erp.tributacao.entidade.CondicaoTributo;
import erp.tributacao.entidade.NaturezaOperacao;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

/**
 *
 * @author leonardo
 */
public class CondicaoTributoView extends javax.swing.JPanel implements DropTargetListener, DragSourceListener, DragGestureListener {
    
    private CondicaoTributo condicaoTributo;
    private DragSource dragSource;
    private DropTarget dropTarget;
    /**
     * Creates new form CondicaoTributoView
     */
    public CondicaoTributoView() {
        initComponents();
        dragSource = new DragSource();
        dropTarget = new DropTarget(this, this);
        dragSource.addDragSourceListener(this);
        
        TransferHandler transfer = new TransferHandler("text") {
            
            @Override
            public Transferable createTransferable(JComponent c) {
                return new Transferable() {

                    @Override
                    public DataFlavor[] getTransferDataFlavors() {
                        return new DataFlavor[] { new DataFlavor(CondicaoTributo.class, "condicao tributo")};
                    }

                    @Override
                    public boolean isDataFlavorSupported(DataFlavor flavor) {
                        return true;
                    }

                    @Override
                    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                        return condicaoTributo;
                    }
                };
            }
            
        };
        buttonLinkar.setTransferHandler(transfer);
    }

    public CondicaoTributo getCondicaoTributo() {
        return condicaoTributo;
    }

    public JButton getButtonAdicionarCondicao() {
        return buttonAdicionarCondicao;
    }

    public JButton getButtonEditarScript() {
        return buttonAdicionarCondicao;
    }

    public JButton getButtonLinkar() {
        return buttonLinkar;
    }

    public JLabel getLabel() {
        return label;
    }

    public CondicaoTributoView(CondicaoTributo condicaoTributo) {
        this();
        this.condicaoTributo = condicaoTributo;
        if (condicaoTributo instanceof NaturezaOperacao) {
            this.label.setText(((NaturezaOperacao) condicaoTributo).getDescricao());
            setBackground(Color.ORANGE);
        }
        else {
            this.label.setText(condicaoTributo.getScriptCondicaoTributo().getDescricao());
        }
        setBounds(condicaoTributo.getBounds());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        buttonAdicionarCondicao = new javax.swing.JButton();
        buttonLinkar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        label.setText("Descricao da condicao");
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMousePressed(evt);
            }
        });
        label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelMouseDragged(evt);
            }
        });

        buttonAdicionarCondicao.setText("+");
        buttonAdicionarCondicao.setBorder(null);
        buttonAdicionarCondicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonAdicionarCondicaoMousePressed(evt);
            }
        });
        buttonAdicionarCondicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarCondicaoActionPerformed(evt);
            }
        });

        buttonLinkar.setText("L");
        buttonLinkar.setBorder(null);
        buttonLinkar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonLinkarMousePressed(evt);
            }
        });
        buttonLinkar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                buttonLinkarMouseDragged(evt);
            }
        });
        buttonLinkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLinkarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAdicionarCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLinkar, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonAdicionarCondicao)
                .addComponent(buttonLinkar)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseDragged
        // TODO add your handling code here:
        setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
        condicaoTributo.setBounds(getBounds());
        updateParent();
    }//GEN-LAST:event_labelMouseDragged

    private void updateParent() {
        Panel parentPanel = (Panel) getParent();
        parentPanel.reajustarTamanhoMaximo();
        parentPanel.repaint();
        parentPanel.updateUI();
    }
    
    int x = 0;
    int y = 0;
    private void labelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMousePressed
        x = evt.getXOnScreen() - getLocation().x;
        y = evt.getYOnScreen() - getLocation().y;
    }//GEN-LAST:event_labelMousePressed

    private void buttonAdicionarCondicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarCondicaoActionPerformed
        AdicaoCondicaoView acView = new AdicaoCondicaoView();
        acView.setCondicaoTributo(condicaoTributo);
        acView.setVisible(true);
    }//GEN-LAST:event_buttonAdicionarCondicaoActionPerformed

    private void buttonAdicionarCondicaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAdicionarCondicaoMousePressed
    }//GEN-LAST:event_buttonAdicionarCondicaoMousePressed

    private void buttonLinkarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLinkarMousePressed
        JButton button = (JButton)evt.getSource();
        TransferHandler handle = button.getTransferHandler();
        handle.exportAsDrag(button, evt, TransferHandler.COPY);
        dragSource.createDefaultDragGestureRecognizer(buttonLinkar, DnDConstants.ACTION_COPY, this);
    }//GEN-LAST:event_buttonLinkarMousePressed

    private void buttonLinkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLinkarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLinkarActionPerformed

    private void buttonLinkarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLinkarMouseDragged
        // TODO add your handling code here:
        System.out.println("buttonLinkarMouseDragged " + evt);
    }//GEN-LAST:event_buttonLinkarMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarCondicao;
    private javax.swing.JButton buttonLinkar;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        //System.out.println("dragEnter " + dtde);
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        //System.out.println("dragOver " + dtde);
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        //System.out.println("dropActionChanged " + dtde);
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        //System.out.println("dragExit " + dte);
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable t = dtde.getTransferable();
            CondicaoTributo condicaoTributoPai = (CondicaoTributo) t.getTransferData(t.getTransferDataFlavors()[0]);
            condicaoTributoPai.getProximasCondicoes().add(condicaoTributo);
            updateParent();
            System.out.println("drop " + condicaoTributoPai);
        } catch (Exception ex) {
            Logger.getLogger(CondicaoTributoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void dragEnter(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragOver(DragSourceDragEvent dsde) {
    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragExit(DragSourceEvent dse) {
    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
        System.out.println("dragDropEnd " + dsde);
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        System.out.println("dragGestureRecognized " + dge);
    }

}
