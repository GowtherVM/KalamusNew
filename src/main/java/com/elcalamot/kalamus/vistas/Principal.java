/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.elcalamot.kalamus.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.MouseEvent.BUTTON1;

/**
 *
 * @author A200238614
 */
public class Principal extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addplanet = new javax.swing.JButton();
        listplanet = new javax.swing.JButton();
        listbeing = new javax.swing.JButton();
        addbeing = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome!");
        setSize(new java.awt.Dimension(850, 500));

        contenedor.setBackground(new java.awt.Color(51, 51, 51));
        contenedor.setForeground(new java.awt.Color(51, 51, 51));
        contenedor.setMinimumSize(new java.awt.Dimension(820, 500));
        contenedor.setPreferredSize(new java.awt.Dimension(850, 500));
        contenedor.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 35));
        jPanel1.setRequestFocusEnabled(false);

        addplanet.setText("AddPlanet");
        addplanet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addplanetMouseClicked(evt);
            }
        });
        jPanel1.add(addplanet);

        listplanet.setText("ListPlanet");
        listplanet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listplanetMouseClicked(evt);
            }
        });
        jPanel1.add(listplanet);

        listbeing.setText("ListBeing");
        listbeing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listbeingMouseClicked(evt);
            }
        });
        jPanel1.add(listbeing);

        addbeing.setText("AddBeing");
        addbeing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbeingMouseClicked(evt);
            }
        });
        jPanel1.add(addbeing);

        contenedor.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Multivers Kalamus!");
        jPanel2.add(jLabel1);

        contenedor.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(contenedor, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addplanetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addplanetMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == BUTTON1) {
            AddPlanet addp = new AddPlanet();
            addp.setVisible(true);
        }
    }//GEN-LAST:event_addplanetMouseClicked

    private void listplanetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listplanetMouseClicked
        if (evt.getButton() == BUTTON1) {
            ListPlanet listp = new ListPlanet();
            listp.setVisible(true);
        }
    }//GEN-LAST:event_listplanetMouseClicked

    private void listbeingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listbeingMouseClicked
        if (evt.getButton() == BUTTON1) {
            ListBeing listb = new ListBeing();
            listb.setVisible(true);
        }
    }//GEN-LAST:event_listbeingMouseClicked

    private void addbeingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbeingMouseClicked
        if (evt.getButton() == BUTTON1) {
            AddBeing addb = new AddBeing();
            addb.setVisible(true);
        }
    }//GEN-LAST:event_addbeingMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbeing;
    private javax.swing.JButton addplanet;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton listbeing;
    private javax.swing.JButton listplanet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
