
package View_01;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminMenu_01 extends javax.swing.JFrame {
   
    public AdminMenu_01() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnlogin = new javax.swing.JButton();
        btnmember = new javax.swing.JButton();
        btnbook = new javax.swing.JButton();
        btnauthor = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("LIBRARY MANAGEMENT SYSTEM ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogin.setBackground(new java.awt.Color(0, 255, 255));
        btnlogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(0, 0, 102));
        btnlogin.setText("LOGIN");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel2.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, -1));

        btnmember.setBackground(new java.awt.Color(0, 255, 255));
        btnmember.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnmember.setForeground(new java.awt.Color(0, 0, 102));
        btnmember.setText("MEMBER");
        btnmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmemberActionPerformed(evt);
            }
        });
        jPanel2.add(btnmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, -1));

        btnbook.setBackground(new java.awt.Color(0, 255, 255));
        btnbook.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnbook.setForeground(new java.awt.Color(0, 0, 102));
        btnbook.setText("BOOK");
        btnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbookActionPerformed(evt);
            }
        });
        jPanel2.add(btnbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, -1));

        btnauthor.setBackground(new java.awt.Color(0, 255, 255));
        btnauthor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnauthor.setForeground(new java.awt.Color(0, 0, 102));
        btnauthor.setText("AUTHOR");
        btnauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnauthorActionPerformed(evt);
            }
        });
        jPanel2.add(btnauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 180, -1));

        btnlogout.setBackground(new java.awt.Color(0, 255, 255));
        btnlogout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(0, 0, 102));
        btnlogout.setText("LOGOUT");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 270, 620));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("WELCOME TO E-LIBRARY");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 1140, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 810));

        setSize(new java.awt.Dimension(1534, 816));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        Login_01 login = new Login_01();
        login.setVisible(true);
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmemberActionPerformed
     Member_01 mem= new Member_01();
     mem.setVisible(true);
    }//GEN-LAST:event_btnmemberActionPerformed

    private void btnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbookActionPerformed
       Book_01 book=new Book_01();
       book.setVisible(true);
    }//GEN-LAST:event_btnbookActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
      this.hide();
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnauthorActionPerformed
        Author_01 a1= new Author_01();
        a1.setVisible(true);
    }//GEN-LAST:event_btnauthorActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMenu_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu_01().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnauthor;
    private javax.swing.JButton btnbook;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnmember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
