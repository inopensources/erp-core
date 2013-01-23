/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.tributacao.view;

import erp.tributacao.entidade.CondicaoTributo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author leonardo
 */
public class Panel extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
    }

    @Override
    public Component add(Component comp) {
        Component c = super.add(comp);
        reajustarTamanhoMaximo();
        return c;
    }

    public void reajustarTamanhoMaximo() {
        int widthMax = 0;
        int heightMax = 0;
        for (Component c : getComponents()) {
            int w = c.getX() + c.getWidth();
            int h = c.getY() + c.getHeight();
            if (w > widthMax) widthMax = w;
            if (h > heightMax) heightMax = h;
        }
        widthMax += 50;
        heightMax += 50;
        setPreferredSize(new Dimension(widthMax, heightMax));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        for (int x=0; x<=getWidth(); x+=10) {
            for (int y=0; y<=getHeight(); y+=10) {
                g.drawLine(x, y, x, y);
            }
        }
        g.setColor(Color.WHITE);
        for (Component c : getComponents()) {
            CondicaoTributoView ctv = (CondicaoTributoView) c;
            int xini = ctv.getX() + ctv.getWidth();
            int yini = ctv.getY() + (ctv.getHeight()/2);
            CondicaoTributo ct = ctv.getCondicaoTributo();
            for (CondicaoTributo ctl : ct.getProximasCondicoes()) {
                int xfin = ctl.getBounds().x;
                int yfin = ctl.getBounds().y + (ctl.getBounds().height/2);
                g.drawLine(xini, yini-1, xfin, yfin-1);
                g.drawLine(xini, yini+0, xfin, yfin+0);
                g.drawLine(xini, yini+1, xfin, yfin+1);
            }
        }
    }
    
}
