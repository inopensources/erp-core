package erp.infra.test;

import erp.infra.Form;
import erp.infra.FormController;
import erp.infra.GridController;
import erp.infra.LookupController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * View class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 00:06)
 */
public class View extends javax.swing.JFrame {

    private FormController<Pais> formController = new FormController<Pais>() {
        private Pais entity;

        @Override
        public Pais getEntity() {
            return entity;
        }

        @Override
        public void setEntity(Pais entity) {
            this.entity = entity;
        }

        @Override
        public void reload() throws Exception {
            /*
             Pais pais = new Pais();
             pais.setId(1L);
             pais.setCodigoBacen("1058");
             pais.setNome("BRASIL");
             pais.setSigla2("BR");
             entity = pais;
             */
        }

        @Override
        public void update() throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void insert() throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void delete() throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
    
    private GridController<Pais> gridController = new GridController<Pais>() {
        @Override
        public List<Pais> reload() throws Exception {
            List<Pais> list = new ArrayList<Pais>();
            for (int i = 0; i < 30; i++) {
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
                list.add(new Pais(1L, "1058", "BRASIL", "BR"));
                list.add(new Pais(2L, "1034", "ESTADOS UNIDOS", "EU"));
                list.add(new Pais(3L, "1098", "JAPAO", "JP"));
            }
            return list;
        }

        @Override
        public void update(List<Pais> t) throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void insert(List<Pais> t) throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void delete(List<Pais> t) throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    };
    
    private LookupController<Pais> lookupController = new LookupController<Pais>() {
        private Pais pais;

        @Override
        public Pais getEntity() {
            return pais;
        }

        @Override
        public void setEntity(Pais entity) {
            this.pais = entity;
        }

        @Override
        public List<Pais> reload(String code) throws Exception {
            Pais pais = new Pais(999L, "1058", "TESTESEL", "TESTE");
            List<Pais> paises = new ArrayList<Pais>();
            paises.add(pais);
            return paises;
        }
        
    };

    public View() {
        initComponents();
        form.setController(formController);
        grid.setController(gridController);
        lookup.setController(lookupController);
        grid.reload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new erp.infra.Form();
        field1 = new erp.infra.Field();
        field2 = new erp.infra.Field();
        field3 = new erp.infra.Field();
        field4 = new erp.infra.Field();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new erp.infra.Grid();
        field5 = new erp.infra.Field();
        lookup = new erp.infra.Lookup();
        jToolBar2 = new javax.swing.JToolBar();
        buttonAtualizarGrid = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        buttonAtualizar = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonExibirEntity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        form.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        field1.setEditableOnInsert(false);
        field1.setEditableOnUpdate(false);
        field1.setLabelText("Id");
        field1.setProperty("id");

        field2.setLabelText("Cód. BACEN");
        field2.setProperty("codigoBacen");
        field2.setRequired(true);

        field3.setLabelText("Nome");
        field3.setProperty("nome");
        field3.setRequired(true);

        field4.setLabelText("Sigla 2");
        field4.setProperty("sigla2");
        field4.setRequired(true);

        grid.setFormModel(form);
        jScrollPane1.setViewportView(grid);

        field5.setExpression("entity.id + ' - ' + entity.codigoBacen + ' - ' + entity.nome + ' - ' + entity.sigla2");
        field5.setLabelText("Campo");
        field5.setRequired(true);

        lookup.setDescriptionExpression("'<html><body><strong> ' + entity.id + ' </strong> - ' + entity.nome + '</body></html>'");
        lookup.setExpression("");
        lookup.setProperty("objeto");

        jToolBar2.setRollover(true);

        buttonAtualizarGrid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh16x16.png"))); // NOI18N
        buttonAtualizarGrid.setText("Atualizar");
        buttonAtualizarGrid.setFocusable(false);
        buttonAtualizarGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarGridActionPerformed(evt);
            }
        });
        jToolBar2.add(buttonAtualizarGrid);

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lookup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lookup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setRollover(true);

        buttonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh16x16.png"))); // NOI18N
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonAtualizar);

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete16x16.gif"))); // NOI18N
        jToolBar1.add(buttonDelete);

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit16x16.gif"))); // NOI18N
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonEditar);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save2_16x16.png"))); // NOI18N
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonSalvar);

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel16x16.gif"))); // NOI18N
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonCancelar);

        buttonExibirEntity.setText("Exibir Entity");
        buttonExibirEntity.setFocusable(false);
        buttonExibirEntity.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonExibirEntity.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonExibirEntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExibirEntityActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonExibirEntity);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        form.reload();
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        form.insert();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonAtualizarGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarGridActionPerformed
        grid.reload();
    }//GEN-LAST:event_buttonAtualizarGridActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        form.setMode(Form.Mode.UPDATE);
        grid.setEnabled(false);
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        form.setMode(Form.Mode.READ_ONLY);
        form.reload();
        grid.setEnabled(true);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonExibirEntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExibirEntityActionPerformed
        JOptionPane.showMessageDialog(this, form.getEntity());
    }//GEN-LAST:event_buttonExibirEntityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonAtualizarGrid;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExibirEntity;
    private javax.swing.JButton buttonSalvar;
    private erp.infra.Field field1;
    private erp.infra.Field field2;
    private erp.infra.Field field3;
    private erp.infra.Field field4;
    private erp.infra.Field field5;
    private erp.infra.Form form;
    private erp.infra.Grid grid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private erp.infra.Lookup lookup;
    // End of variables declaration//GEN-END:variables

}

