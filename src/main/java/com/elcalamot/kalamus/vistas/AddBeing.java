/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.elcalamot.kalamus.vistas;

import com.elcalamot.kalamus.model_essers.FuncionesModelo_Essers;

import com.elcalamot.kalamus.model_planetas.Sistemas;
import static java.awt.event.MouseEvent.BUTTON1;

import java.io.IOException;


import java.util.ArrayList;

/**
 *
 * @author A200238614
 */
public class AddBeing extends javax.swing.JFrame {

    /**
     * Creates new form AddPlanet
     */
    public AddBeing() {
        initComponents();
        Sistemas sis = Sistemas.getInstance();
        
        this.setLocationRelativeTo(null);
        this.añadirbeing.setVisible(false);
        this.añadirbeing.setEnabled(false);
        this.latinum1.setVisible(false);
        this.latinum.setVisible(false);
        this.genere.setVisible(true);
        this.genere1.setVisible(true);
        this.edad.setVisible(true);
        this.edad1.setVisible(true);
        this.flora.setVisible(false);
        this.pez.setVisible(false);
        this.fuerza.setVisible(false);
        this.fuerza1.setVisible(false);
        this.meditacion.setVisible(false);
        this.meditacion1.setVisible(false);
        this.rango.setVisible(false);
        this.rango1.setVisible(false);

        ArrayList<String> listb = sis.nombresEssers();
        planetexist.append("No disponibles: \n");
        for (String linea : listb) {
            planetexist.append(linea + "\n");

        }

    }

    public void habilitarBoton() {
        if (!this.nombre1.getText().isEmpty() && !this.planeta1.getText().isEmpty()) {
            this.añadirbeing.setVisible(true);
            this.añadirbeing.setEnabled(true);

        } else {
            this.añadirbeing.setVisible(false);
            this.añadirbeing.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensaje = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajepanel = new javax.swing.JTextArea();
        base = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        planetexist = new javax.swing.JTextArea();
        nombre = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        planeta1 = new javax.swing.JTextField();
        nombre2 = new javax.swing.JLabel();
        planeta = new javax.swing.JLabel();
        esser1 = new javax.swing.JComboBox<>();
        esser = new javax.swing.JLabel();
        linea = new javax.swing.JLabel();
        datosgenerales = new javax.swing.JPanel();
        genere = new javax.swing.JComboBox<>();
        latinum1 = new javax.swing.JLabel();
        latinum = new javax.swing.JSpinner();
        genere1 = new javax.swing.JLabel();
        edad1 = new javax.swing.JLabel();
        edad = new javax.swing.JSpinner();
        meditacion1 = new javax.swing.JLabel();
        meditacion = new javax.swing.JSpinner();
        fuerza1 = new javax.swing.JLabel();
        fuerza = new javax.swing.JSpinner();
        flora = new javax.swing.JRadioButton();
        pez = new javax.swing.JRadioButton();
        rango = new javax.swing.JComboBox<>();
        rango1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        añadirbeing = new javax.swing.JButton();

        this.setLocationRelativeTo(null);
        mensaje.setMinimumSize(new java.awt.Dimension(400, 300));
        mensaje.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        mensajepanel.setEditable(false);
        mensajepanel.setBackground(new java.awt.Color(102, 102, 102));
        mensajepanel.setColumns(20);
        mensajepanel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        mensajepanel.setLineWrap(true);
        mensajepanel.setRows(5);
        jScrollPane2.setViewportView(mensajepanel);

        mensaje.getContentPane().add(jScrollPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Planetas");
        setMinimumSize(new java.awt.Dimension(820, 500));
        setSize(new java.awt.Dimension(820, 500));

        base.setBackground(new java.awt.Color(51, 51, 51));
        base.setMinimumSize(new java.awt.Dimension(820, 500));
        base.setPreferredSize(new java.awt.Dimension(820, 500));

        planetexist.setEditable(false);
        planetexist.setBackground(new java.awt.Color(204, 204, 204));
        planetexist.setColumns(20);
        planetexist.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        planetexist.setForeground(new java.awt.Color(51, 51, 51));
        planetexist.setRows(5);
        planetexist.setAutoscrolls(false);
        planetexist.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        planetexist.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(planetexist);

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(204, 204, 204));
        nombre.setText("DATOS");

        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombre1KeyReleased(evt);
            }
        });

        planeta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                planeta1KeyReleased(evt);
            }
        });

        nombre2.setBackground(new java.awt.Color(204, 204, 204));
        nombre2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nombre2.setForeground(new java.awt.Color(204, 204, 204));
        nombre2.setText("Nombre:");

        planeta.setBackground(new java.awt.Color(204, 204, 204));
        planeta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        planeta.setForeground(new java.awt.Color(204, 204, 204));
        planeta.setText("Planeta:");

        esser1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HUMA", "ANDORIA", "FERENGI", "VULCANIA", "KLINGON", "NIBIRIA" }));
        esser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esser1ActionPerformed(evt);
            }
        });

        esser.setBackground(new java.awt.Color(204, 204, 204));
        esser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        esser.setForeground(new java.awt.Color(204, 204, 204));
        esser.setText("Esser:");

        linea.setBackground(new java.awt.Color(204, 204, 204));
        linea.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        linea.setForeground(new java.awt.Color(204, 204, 204));
        linea.setText("---------------------------------------------------------------------------------------------------------");

        datosgenerales.setBackground(new java.awt.Color(51, 51, 51));

        genere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULI", "FEMENI" }));
        genere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genereActionPerformed(evt);
            }
        });

        latinum1.setBackground(new java.awt.Color(204, 204, 204));
        latinum1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        latinum1.setForeground(new java.awt.Color(204, 204, 204));
        latinum1.setText("Latimum:");

        latinum.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        genere1.setBackground(new java.awt.Color(204, 204, 204));
        genere1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        genere1.setForeground(new java.awt.Color(204, 204, 204));
        genere1.setText("Genere:");

        edad1.setBackground(new java.awt.Color(204, 204, 204));
        edad1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edad1.setForeground(new java.awt.Color(204, 204, 204));
        edad1.setText("Edad:");

        edad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 130, 1));

        meditacion1.setBackground(new java.awt.Color(204, 204, 204));
        meditacion1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        meditacion1.setForeground(new java.awt.Color(204, 204, 204));
        meditacion1.setText("Meditacion:");

        meditacion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        fuerza1.setBackground(new java.awt.Color(204, 204, 204));
        fuerza1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fuerza1.setForeground(new java.awt.Color(204, 204, 204));
        fuerza1.setText("Fuerza:");

        fuerza.setModel(new javax.swing.SpinnerNumberModel(50, 50, 350, 1));

        flora.setBackground(new java.awt.Color(51, 51, 51));
        flora.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        flora.setForeground(new java.awt.Color(204, 204, 204));
        flora.setText("Come flora roja");
        flora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floraActionPerformed(evt);
            }
        });

        pez.setBackground(new java.awt.Color(51, 51, 51));
        pez.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pez.setForeground(new java.awt.Color(204, 204, 204));
        pez.setText("Come pez");

        rango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEFENSOR", "ENTRENADOR", "LLUITADOR", "CAVALLER" }));
        rango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoActionPerformed(evt);
            }
        });

        rango1.setBackground(new java.awt.Color(204, 204, 204));
        rango1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        rango1.setForeground(new java.awt.Color(204, 204, 204));
        rango1.setText("Rango:");

        javax.swing.GroupLayout datosgeneralesLayout = new javax.swing.GroupLayout(datosgenerales);
        datosgenerales.setLayout(datosgeneralesLayout);
        datosgeneralesLayout.setHorizontalGroup(
            datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosgeneralesLayout.createSequentialGroup()
                        .addComponent(genere1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosgeneralesLayout.createSequentialGroup()
                        .addComponent(edad1)
                        .addGap(18, 18, 18)
                        .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosgeneralesLayout.createSequentialGroup()
                        .addComponent(latinum1)
                        .addGap(15, 15, 15)
                        .addComponent(latinum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosgeneralesLayout.createSequentialGroup()
                        .addComponent(meditacion1)
                        .addGap(18, 18, 18)
                        .addComponent(meditacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(flora)
                    .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(datosgeneralesLayout.createSequentialGroup()
                            .addComponent(rango1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, datosgeneralesLayout.createSequentialGroup()
                            .addComponent(fuerza1)
                            .addGap(18, 18, 18)
                            .addComponent(fuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pez))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosgeneralesLayout.setVerticalGroup(
            datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosgeneralesLayout.createSequentialGroup()
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genere1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(latinum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(latinum1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(meditacion)
                    .addComponent(meditacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fuerza1)
                    .addComponent(fuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rango1)
                    .addComponent(rango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pez)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addComponent(nombre2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombre)
                            .addComponent(linea)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(planeta)
                                    .addComponent(esser))
                                .addGap(18, 18, 18)
                                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(esser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(planeta1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(datosgenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(nombre)
                        .addGap(18, 18, 18)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre2)
                            .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(planeta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(planeta))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(esser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(esser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datosgenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(base, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(820, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 35));

        añadirbeing.setText("Añadir");
        añadirbeing.setEnabled(false);
        añadirbeing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                añadirbeingMouseClicked(evt);
            }
        });
        jPanel1.add(añadirbeing);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirbeingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirbeingMouseClicked
        String out = "";
        try {
            
            if (evt.getButton() == BUTTON1) {
                
                String nom = this.nombre1.getText();
                String planeta = this.planeta1.getText();

                if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("huma")) {
                    String genere = this.genere.getSelectedItem().toString();
                    String edad = this.edad.getValue().toString();
                    String[] huma = {"", "", nom, "huma", planeta, edad, genere};
                    out = FuncionesModelo_Essers.crearEsser(huma, "vista");
                } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("andoria")) {
                    String rango = this.rango.getSelectedItem().toString();
                    String[] andor = {"", "", nom, "andoria", planeta, rango};
                    out = FuncionesModelo_Essers.crearEsser(andor, "vista");
                } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("klingon")) {
                    String fuerza = this.fuerza.getValue().toString();
                    String[] klingon = {"", "", nom, "klingon", planeta, fuerza};
                    out = FuncionesModelo_Essers.crearEsser(klingon, "vista");
                } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("ferengi")) {

                    String latinum = this.latinum.getValue().toString();
                    String[] fer = {"", "", nom, "ferengi", planeta, latinum};
                    out = FuncionesModelo_Essers.crearEsser(fer, "vista");
                } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("nibiria")) {
                    boolean flora = this.flora.isSelected();
                    boolean pez = this.pez.isSelected();
                    String dato1 = "no";
                    String dato2 = "no";
                    if (flora == true) {
                        dato1 = "yes";
                    } else if (flora == false) {
                        dato1 = "no";
                    }
                    if (pez == true) {
                        dato2 = "yes";
                    } else if (pez == false) {
                        dato2 = "no";
                    }

                    String[] nib = {"", "", nom, "nibiria", planeta, dato1, dato2};
                    out = FuncionesModelo_Essers.crearEsser(nib, "vista");
                } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("vulcania")) {
                    String meditacio = this.meditacion.getValue().toString();
                    String[] val = {"", "", nom, "vulcania", planeta, meditacio};
                    out = FuncionesModelo_Essers.crearEsser(val, "vista");
                }
            }
        } catch (IOException e) {
            out = e.getMessage().toString();
        }
        this.mensajepanel.append(out);
        this.mensaje.setVisible(true);

    }//GEN-LAST:event_añadirbeingMouseClicked

    private void nombre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyReleased
        // TODO add your handling code here:
        habilitarBoton();

    }//GEN-LAST:event_nombre1KeyReleased

    private void planeta1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_planeta1KeyReleased
        habilitarBoton();
    }//GEN-LAST:event_planeta1KeyReleased

    private void esser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esser1ActionPerformed
        if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("huma")) {
            this.latinum1.setVisible(false);
            this.latinum.setVisible(false);
            this.genere.setVisible(true);
            this.genere1.setVisible(true);
            this.edad.setVisible(true);
            this.edad1.setVisible(true);
            this.flora.setVisible(false);
            this.pez.setVisible(false);
            this.fuerza.setVisible(false);
            this.fuerza1.setVisible(false);
            this.meditacion.setVisible(false);
            this.meditacion1.setVisible(false);
            this.rango.setVisible(false);
            this.rango1.setVisible(false);

        } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("andoria")) {
            this.latinum1.setVisible(false);
            this.latinum.setVisible(false);
            this.genere.setVisible(false);
            this.genere1.setVisible(false);
            this.edad.setVisible(false);
            this.edad1.setVisible(false);
            this.flora.setVisible(false);
            this.pez.setVisible(false);
            this.fuerza.setVisible(false);
            this.fuerza1.setVisible(false);
            this.meditacion.setVisible(false);
            this.meditacion1.setVisible(false);
            this.rango.setVisible(true);
            this.rango1.setVisible(true);

        } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("klingon")) {
            this.latinum1.setVisible(false);
            this.latinum.setVisible(false);
            this.genere.setVisible(false);
            this.genere1.setVisible(false);
            this.edad.setVisible(false);
            this.edad1.setVisible(false);
            this.flora.setVisible(false);
            this.pez.setVisible(false);
            this.fuerza.setVisible(true);
            this.fuerza1.setVisible(true);
            this.meditacion.setVisible(false);
            this.meditacion1.setVisible(false);
            this.rango.setVisible(false);
            this.rango1.setVisible(false);
        } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("ferengi")) {
            this.latinum1.setVisible(true);
            this.latinum.setVisible(true);
            this.genere.setVisible(false);
            this.genere1.setVisible(false);
            this.edad.setVisible(false);
            this.edad1.setVisible(false);
            this.flora.setVisible(false);
            this.pez.setVisible(false);
            this.fuerza.setVisible(false);
            this.fuerza1.setVisible(false);
            this.meditacion.setVisible(false);
            this.meditacion1.setVisible(false);
            this.rango.setVisible(false);
            this.rango1.setVisible(false);

        } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("nibiria")) {
            this.latinum1.setVisible(false);
            this.latinum.setVisible(false);
            this.genere.setVisible(false);
            this.genere1.setVisible(false);
            this.edad.setVisible(false);
            this.edad1.setVisible(false);
            this.flora.setVisible(true);
            this.pez.setVisible(true);
            this.fuerza.setVisible(false);
            this.fuerza1.setVisible(false);
            this.meditacion.setVisible(false);
            this.meditacion1.setVisible(false);
            this.rango.setVisible(false);
            this.rango1.setVisible(false);
        } else if (this.esser1.getSelectedItem().toString().equalsIgnoreCase("vulcania")) {
            this.latinum1.setVisible(false);
            this.latinum.setVisible(false);
            this.genere.setVisible(false);
            this.genere1.setVisible(false);
            this.edad.setVisible(false);
            this.edad1.setVisible(false);
            this.flora.setVisible(false);
            this.pez.setVisible(false);
            this.fuerza.setVisible(false);
            this.fuerza1.setVisible(false);
            this.meditacion.setVisible(true);
            this.meditacion1.setVisible(true);
            this.rango.setVisible(false);
            this.rango1.setVisible(false);
        }
    }//GEN-LAST:event_esser1ActionPerformed

    private void genereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genereActionPerformed

    private void floraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_floraActionPerformed

    private void rangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoActionPerformed

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
            java.util.logging.Logger.getLogger(AddBeing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBeing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBeing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBeing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBeing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirbeing;
    private javax.swing.JPanel base;
    private javax.swing.JPanel datosgenerales;
    private javax.swing.JSpinner edad;
    private javax.swing.JLabel edad1;
    private javax.swing.JLabel esser;
    private javax.swing.JComboBox<String> esser1;
    private javax.swing.JRadioButton flora;
    private javax.swing.JSpinner fuerza;
    private javax.swing.JLabel fuerza1;
    private javax.swing.JComboBox<String> genere;
    private javax.swing.JLabel genere1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner latinum;
    private javax.swing.JLabel latinum1;
    private javax.swing.JLabel linea;
    private javax.swing.JSpinner meditacion;
    private javax.swing.JLabel meditacion1;
    private javax.swing.JDialog mensaje;
    private javax.swing.JTextArea mensajepanel;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombre1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JRadioButton pez;
    private javax.swing.JLabel planeta;
    private javax.swing.JTextField planeta1;
    private javax.swing.JTextArea planetexist;
    private javax.swing.JComboBox<String> rango;
    private javax.swing.JLabel rango1;
    // End of variables declaration//GEN-END:variables
}
