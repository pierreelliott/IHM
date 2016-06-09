/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.applet.AudioClip;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author p1402690
 */
public class GestionProduit extends javax.swing.JFrame {

    private DefaultTableModel modele;
    private AudioClip son1, son2;
    
    /**
     * Creates new form GestionProduit
     */
    public GestionProduit() {
        initComponents();
        
        modele = (DefaultTableModel) tabProduits.getModel();
        
        java.net.URL url1 = GestionProduit.class.getResource("/sons/son1.wav");
        java.net.URL url2 = GestionProduit.class.getResource("/sons/son2.wav");
        
        son1 = java.applet.Applet.newAudioClip(url1);
        son2 = java.applet.Applet.newAudioClip(url2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caracteristiquesPanel = new javax.swing.JPanel();
        jtfPrixUnitaire = new javax.swing.JTextField();
        jlLibelle = new javax.swing.JLabel();
        jlCategorie = new javax.swing.JLabel();
        jcbComboBox = new javax.swing.JComboBox();
        jlPrixUnitaire = new javax.swing.JLabel();
        jtfLibelle = new javax.swing.JTextField();
        jbAjouter = new javax.swing.JButton();
        jbSupprimer = new javax.swing.JButton();
        jbModifier = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tabProduits = new javax.swing.JTable();
        jlMessagedErreur = new javax.swing.JLabel();
        jbTestSon1 = new javax.swing.JButton();
        jbTestSon2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Gestion Produit"); // NOI18N
        setResizable(false);

        caracteristiquesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caractéristiques du produit", 0, 0, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jlLibelle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlLibelle.setText("Libellé");

        jlCategorie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCategorie.setText("Catégorie");

        jcbComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Appareil Photo", "Casque Audio", "Clavier", "Disque Dur Externe", "Lecteur Audio", "Souris" }));
        jcbComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComboBoxActionPerformed(evt);
            }
        });

        jlPrixUnitaire.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlPrixUnitaire.setText("Prix unitaire");
        jlPrixUnitaire.setToolTipText("");

        jbAjouter.setText("Ajouter");
        jbAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAjouterActionPerformed(evt);
            }
        });

        jbSupprimer.setText("Supprimer");
        jbSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSupprimerActionPerformed(evt);
            }
        });

        jbModifier.setText("Modifier");
        jbModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout caracteristiquesPanelLayout = new javax.swing.GroupLayout(caracteristiquesPanel);
        caracteristiquesPanel.setLayout(caracteristiquesPanelLayout);
        caracteristiquesPanelLayout.setHorizontalGroup(
            caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caracteristiquesPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(caracteristiquesPanelLayout.createSequentialGroup()
                        .addComponent(jbAjouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jbModifier)
                        .addGap(33, 33, 33)
                        .addComponent(jbSupprimer)
                        .addGap(39, 39, 39))
                    .addGroup(caracteristiquesPanelLayout.createSequentialGroup()
                        .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLibelle)
                            .addComponent(jlCategorie)
                            .addComponent(jlPrixUnitaire))
                        .addGap(54, 54, 54)
                        .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPrixUnitaire)
                            .addComponent(jcbComboBox, 0, 128, Short.MAX_VALUE)
                            .addComponent(jtfLibelle))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        caracteristiquesPanelLayout.setVerticalGroup(
            caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caracteristiquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlLibelle)
                    .addComponent(jtfLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCategorie)
                    .addComponent(jcbComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrixUnitaire)
                    .addComponent(jtfPrixUnitaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(caracteristiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAjouter)
                    .addComponent(jbSupprimer)
                    .addComponent(jbModifier))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabProduits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libellé", "Catégorie", "Prix"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProduitsMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(tabProduits);

        jlMessagedErreur.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlMessagedErreur.setForeground(new java.awt.Color(255, 0, 0));
        jlMessagedErreur.setText("(Message d'erreur)");

        jbTestSon1.setText("test son 1");
        jbTestSon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTestSon1ActionPerformed(evt);
            }
        });

        jbTestSon2.setText("test son 2");
        jbTestSon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTestSon2ActionPerformed(evt);
            }
        });

        jMenu1.setText("Fichier");

        jMenuItem1.setText("Charger");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sauvegarder");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caracteristiquesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jlMessagedErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jbTestSon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbTestSon2)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(caracteristiquesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlMessagedErreur)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTestSon1)
                    .addComponent(jbTestSon2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbComboBoxActionPerformed

    private void jbAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjouterActionPerformed
        if(jtfLibelle.getText().equals(""))
            jlMessagedErreur.setText("Libellé manquant");
        else
        {
            try
            {
                modele.addRow(new Object[] {jtfLibelle.getText().trim(), jcbComboBox.getSelectedItem().toString(), Double.parseDouble(jtfPrixUnitaire.getText())}) ;
            }
            catch(NumberFormatException e)
            {
                showMessageDialog(this, e, "Erreur", ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbAjouterActionPerformed

    private void jbModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModifierActionPerformed
        if(tabProduits.getRowCount() == 0)
            jlMessagedErreur.setText("La table est vide");
        else
        {
        try
            {
                modele.setValueAt(jtfLibelle.getText(), tabProduits.getSelectedRow(), 0);
                modele.setValueAt(jcbComboBox.getSelectedItem().toString(), tabProduits.getSelectedRow(), 1);
                modele.setValueAt(Double.parseDouble(jtfPrixUnitaire.getText()), tabProduits.getSelectedRow(), 2);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                jlMessagedErreur.setText("Aucune ligne sélectionnée");
            }
        }
    }//GEN-LAST:event_jbModifierActionPerformed

    private void tabProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProduitsMouseClicked
        jtfLibelle.setText(modele.getValueAt(tabProduits.getSelectedRow(), 0).toString());
        jcbComboBox.setSelectedItem(modele.getValueAt(tabProduits.getSelectedRow(), 1).toString());
        jtfPrixUnitaire.setText(modele.getValueAt(tabProduits.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tabProduitsMouseClicked

    private void jbSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSupprimerActionPerformed
        modele.removeRow(tabProduits.getSelectedRow());
    }//GEN-LAST:event_jbSupprimerActionPerformed

    private void jbTestSon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTestSon1ActionPerformed
        son1.play();
    }//GEN-LAST:event_jbTestSon1ActionPerformed

    private void jbTestSon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTestSon2ActionPerformed
        son2.play();
    }//GEN-LAST:event_jbTestSon2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser jfc = new JFileChooser(new File("."));
        jfc.showSaveDialog(this);
        try{
            File f1 = new File(nomFic);
            FileOutputStream fs = new FileOutputStream(f1);
            ObjectOutputStream fsObj = new ObjectOutputStream(fs);
            fsObj.writeObject(tM);
            fsObj.close();
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        cont.sauvegarder(jfc.getName(jfc.getSelectedFile()));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionProduit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel caracteristiquesPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton jbAjouter;
    private javax.swing.JButton jbModifier;
    private javax.swing.JButton jbSupprimer;
    private javax.swing.JButton jbTestSon1;
    private javax.swing.JButton jbTestSon2;
    private javax.swing.JComboBox jcbComboBox;
    private javax.swing.JLabel jlCategorie;
    private javax.swing.JLabel jlLibelle;
    private javax.swing.JLabel jlMessagedErreur;
    private javax.swing.JLabel jlPrixUnitaire;
    private javax.swing.JTextField jtfLibelle;
    private javax.swing.JTextField jtfPrixUnitaire;
    private javax.swing.JTable tabProduits;
    // End of variables declaration//GEN-END:variables
}
