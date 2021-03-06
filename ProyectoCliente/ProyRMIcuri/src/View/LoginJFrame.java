/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Vongola
 */
public class LoginJFrame extends javax.swing.JFrame {

    private int logCount = 0;

    /**
     * Creates new form LoginJFrame
     */
    public LoginJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearUsuarioJTextField = new javax.swing.JTextField();
        crearContraJTextField = new javax.swing.JTextField();
        iniciarContraJTextField = new javax.swing.JTextField();
        iniciarUsuarioJTextField = new javax.swing.JTextField();
        crearButtonjLabel = new javax.swing.JLabel();
        iniciarButtonjLabel = new javax.swing.JLabel();
        logojLabel = new javax.swing.JLabel();
        LoginBGjLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 472));
        setMaximumSize(new java.awt.Dimension(800, 472));
        setMinimumSize(new java.awt.Dimension(800, 472));
        setPreferredSize(new java.awt.Dimension(800, 472));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 472));
        getContentPane().setLayout(null);
        getContentPane().add(crearUsuarioJTextField);
        crearUsuarioJTextField.setBounds(390, 320, 120, 30);
        getContentPane().add(crearContraJTextField);
        crearContraJTextField.setBounds(390, 360, 120, 30);
        getContentPane().add(iniciarContraJTextField);
        iniciarContraJTextField.setBounds(390, 230, 120, 30);
        getContentPane().add(iniciarUsuarioJTextField);
        iniciarUsuarioJTextField.setBounds(390, 195, 120, 30);

        crearButtonjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/crear.png"))); // NOI18N
        crearButtonjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                crearButtonjLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                crearButtonjLabelMouseReleased(evt);
            }
        });
        getContentPane().add(crearButtonjLabel);
        crearButtonjLabel.setBounds(430, 390, 77, 31);

        iniciarButtonjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/iniciar.png"))); // NOI18N
        iniciarButtonjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iniciarButtonjLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                iniciarButtonjLabelMouseReleased(evt);
            }
        });
        getContentPane().add(iniciarButtonjLabel);
        iniciarButtonjLabel.setBounds(430, 260, 77, 31);

        logojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/gude.png"))); // NOI18N
        logojLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logojLabelMouseClicked(evt);
            }
        });
        getContentPane().add(logojLabel);
        logojLabel.setBounds(435, 46, 90, 90);

        LoginBGjLabel.setBackground(new java.awt.Color(255, 255, 255));
        LoginBGjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/LoginBG.png"))); // NOI18N
        getContentPane().add(LoginBGjLabel);
        LoginBGjLabel.setBounds(0, 0, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarButtonjLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarButtonjLabelMousePressed
        // TODO add your handling code here:
        iniciarButtonjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/iniciar" + "Presionado.png")));
    }//GEN-LAST:event_iniciarButtonjLabelMousePressed

    private void iniciarButtonjLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarButtonjLabelMouseReleased
        // TODO add your handling code here:
        iniciarButtonjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/iniciar" + ".png")));
    }//GEN-LAST:event_iniciarButtonjLabelMouseReleased

    private void crearButtonjLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearButtonjLabelMousePressed
        // TODO add your handling code here:
        crearButtonjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/crear" + "Presionado.png")));
    }//GEN-LAST:event_crearButtonjLabelMousePressed

    private void crearButtonjLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearButtonjLabelMouseReleased
        // TODO add your handling code here:
        crearButtonjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/crear" + ".png")));
    }//GEN-LAST:event_crearButtonjLabelMouseReleased

    private void logojLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logojLabelMouseClicked
        // TODO add your handling code here:
        switch (logCount) {
            case 0:
                logojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/foca" + ".png")));
                logCount = 1;
                break;
            case 1:
                logojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/drag" + ".png")));
                logCount = 2;
                break;
            case 2:
                logojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/gude" + ".png")));
                logCount = 0;
                break;
        }

    }//GEN-LAST:event_logojLabelMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginBGjLabel;
    public javax.swing.JLabel crearButtonjLabel;
    public javax.swing.JTextField crearContraJTextField;
    public javax.swing.JTextField crearUsuarioJTextField;
    public javax.swing.JLabel iniciarButtonjLabel;
    public javax.swing.JTextField iniciarContraJTextField;
    public javax.swing.JTextField iniciarUsuarioJTextField;
    private javax.swing.JLabel logojLabel;
    // End of variables declaration//GEN-END:variables
}
