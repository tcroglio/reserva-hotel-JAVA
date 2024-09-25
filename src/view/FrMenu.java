package view;

import javax.swing.JOptionPane;

/**
 * @author tiago
 */
public class FrMenu extends javax.swing.JFrame {

    public FrMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menCadastrar = new javax.swing.JMenu();
        imCadUsuario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        imCadSair = new javax.swing.JMenuItem();
        menConsultar = new javax.swing.JMenu();
        imConsUsuario = new javax.swing.JMenuItem();
        menSobre = new javax.swing.JMenu();
        imSobreSobre = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-div.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        menCadastrar.setText("Cadastrar");

        imCadUsuario.setText("Usuário");
        imCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadUsuarioActionPerformed(evt);
            }
        });
        menCadastrar.add(imCadUsuario);

        jMenuItem1.setText("???");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menCadastrar.add(jMenuItem1);

        imCadSair.setText("Sair");
        imCadSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imCadSairMouseClicked(evt);
            }
        });
        imCadSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadSairActionPerformed(evt);
            }
        });
        menCadastrar.add(imCadSair);

        jMenuBar1.add(menCadastrar);

        menConsultar.setText("Consultar");

        imConsUsuario.setText("Usuário");
        imConsUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsUsuarioActionPerformed(evt);
            }
        });
        menConsultar.add(imConsUsuario);

        jMenuBar1.add(menConsultar);

        menSobre.setText("Sobre");

        imSobreSobre.setText("Sobre");
        imSobreSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSobreSobreActionPerformed(evt);
            }
        });
        menSobre.add(imSobreSobre);

        jMenuBar1.add(menSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadUsuarioActionPerformed
        FrCadastrarUser cad = new FrCadastrarUser();

        cad.setVisible(true);
    }//GEN-LAST:event_imCadUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void imCadSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imCadSairMouseClicked
    }//GEN-LAST:event_imCadSairMouseClicked

    private void imCadSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadSairActionPerformed

        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_imCadSairActionPerformed

    private void imConsUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsUsuarioActionPerformed
        FrListaUser frList = new FrListaUser();

        frList.setVisible(true);
    }//GEN-LAST:event_imConsUsuarioActionPerformed

    private void imSobreSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSobreSobreActionPerformed
        FrSobre frsobre = new FrSobre();
        frsobre.setVisible(true);

    }//GEN-LAST:event_imSobreSobreActionPerformed

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
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imCadSair;
    private javax.swing.JMenuItem imCadUsuario;
    private javax.swing.JMenuItem imConsUsuario;
    private javax.swing.JMenuItem imSobreSobre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menCadastrar;
    private javax.swing.JMenu menConsultar;
    private javax.swing.JMenu menSobre;
    // End of variables declaration//GEN-END:variables
}
