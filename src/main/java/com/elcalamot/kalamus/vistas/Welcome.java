/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.elcalamot.kalamus.vistas;

/**
 *
 * @author A200238614
 */
public class Welcome extends javax.swing.JPanel {

    /**
     * Creates new form Welcome
     */
    public Welcome() {
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

        welcome1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.GridLayout());

        welcome1.setBackground(new java.awt.Color(51, 51, 51));
        welcome1.setForeground(new java.awt.Color(51, 51, 51));
        welcome1.setPreferredSize(new java.awt.Dimension(820, 540));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Multivers Kalamus!");

        javax.swing.GroupLayout welcome1Layout = new javax.swing.GroupLayout(welcome1);
        welcome1.setLayout(welcome1Layout);
        welcome1Layout.setHorizontalGroup(
            welcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
        );
        welcome1Layout.setVerticalGroup(
            welcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        add(welcome1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel welcome1;
    // End of variables declaration//GEN-END:variables
}
