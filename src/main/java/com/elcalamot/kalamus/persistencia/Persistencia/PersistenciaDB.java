/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.persistencia.Persistencia;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.enums.EnumsExceptions;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.FuncionesModelo_Essers;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import com.elcalamot.kalamus.model_planetas.Planeta;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class PersistenciaDB {

    private Connection conexio;

    public void selectAllPlanetas() throws SQLException {
        Sistemas db = Sistemas.getInstance();
        try {
            String query = "select * from planeta;";
            Statement st = conexio.createStatement();
            // Executem la consulta i recollim el resultat
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ArrayList<Planeta> planetas = new ArrayList();
                String galaxia = rs.getString("galaxia");
                String nom_planeta = rs.getString("nom_planeta");
                int poblacio_max = rs.getInt("poblacio_max");
                String clima = rs.getString("clima");
                String flora_vermella = rs.getString("flora_vermella");
                String essers_aquatics = rs.getString("essers_aquatics");

                Planeta plan = new Planeta(nom_planeta, poblacio_max, Enums.elegirClima(clima), flora_vermella, essers_aquatics);
                if (db.comprobarGalaxia(galaxia) == null) {
                    db.addGalaxia(galaxia);
                }

                db.addPlaneta(galaxia, plan);
            }

            rs.close();
            st.close();
        } catch (EnumsExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAllEssers() throws SQLException, DatosExceptions {
        Sistemas db = Sistemas.getInstance();
        try {
            String query = "select * from esser;";
            Statement st = conexio.createStatement();

            String query2;
            // Executem la consulta i recollim el resultat
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                String nom = rs.getString("nom");
                String esser = rs.getString("esser");
                String planeta = rs.getString("planeta");
                Planeta añadir = db.comprobarPlaneta(planeta);

                if (esser.equalsIgnoreCase("humans")) {
                    query2 = "select * from huma;";
                    ResultSet hm = st.executeQuery(query2);
                    while (hm.next()) {
                        if (hm.getString("nom").equalsIgnoreCase(nom)) {
                            int edad = hm.getInt("edad");
                            String genero = hm.getString("genero");
                            Humans huma = new Humans(nom, "huma", edad, genero);
                            añadir.addEsser(huma);
                            hm.close();
                        }
                    }

                } else if (esser.equalsIgnoreCase("andorians")) {

                    query2 = "select * from andoria;";
                    ResultSet an = st.executeQuery(query2);
                    while (an.next()) {
                        if (an.getString("nom").equalsIgnoreCase(nom)) {
                            String rango = an.getString("rango");
                            Andorians andor = new Andorians(nom, "andoria", rango);
                            añadir.addEsser(andor);
                            an.close();
                        }
                    }

                } else if (esser.equalsIgnoreCase("ferengi")) {

                    query2 = "select * from ferengi;";
                    ResultSet fr = st.executeQuery(query2);
                    while (fr.next()) {
                        if (fr.getString("nom").equalsIgnoreCase(nom)) {
                            double latinum = fr.getDouble("latinum");
                            Ferengi fer = new Ferengi(nom, "ferengi", latinum);
                            añadir.addEsser(fer);
                            fr.close();
                        }
                    }

                } else if (esser.equalsIgnoreCase("klingon")) {

                    query2 = "select * from klingon;";
                    ResultSet kl = st.executeQuery(query2);
                    while (kl.next()) {
                        if (kl.getString("nom").equalsIgnoreCase(nom)) {
                            int fuerza = kl.getInt("fuerza");
                            Klingon klin = new Klingon(nom, "klingon", fuerza);
                            añadir.addEsser(klin);
                            kl.close();
                        }
                    }

                } else if (esser.equalsIgnoreCase("nibirians")) {

                    query2 = "select * from nibirian;";
                    ResultSet nib = st.executeQuery(query2);
                    while (nib.next()) {
                        if (nib.getString("nom").equalsIgnoreCase(nom)) {
                            String vegano = nib.getString("vegano");
                            String peix = nib.getString("pescado");
                            Nibirians nibs = new Nibirians(nom, "nibiria", FuncionesModelo_Essers.getPeixFlora(vegano), FuncionesModelo_Essers.getPeixFlora(peix));
                            añadir.addEsser(nibs);
                            nib.close();
                        }
                    }

                } else if (esser.equalsIgnoreCase("vulcanians")) {

                    query2 = "select * from vulcania;";
                    ResultSet vul = st.executeQuery(query2);
                    while (vul.next()) {
                        if (vul.getString("nom").equalsIgnoreCase(nom)) {
                            int meditacio = vul.getInt("meditacio");
                            Vulcanians vulc = new Vulcanians(nom, "vulcania", meditacio);
                            añadir.addEsser(vulc);
                            vul.close();
                        }
                    }

                }
            }

            rs.close();
            st.close();
        } catch (EnumsExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertPlaneta(Planeta planeta, String galaxia) throws SQLException {
        // Pendiente verificar primero que existe
        String insert = "insert into planeta (nom_planeta, galaxia, poblacio_max, clima, flora_vermella, essers_aquatics) "
                + "values (?, ?, ?,?,?,?);";
        PreparedStatement ps = conexio.prepareStatement(insert);
        ps.setString(1, planeta.getNomplan());
        ps.setString(2, galaxia);
        ps.setInt(3, planeta.getPoblacio_max());
        ps.setString(4, planeta.getClima().toString());
        ps.setString(5, planeta.getFlora_vermella());
        ps.setString(6, planeta.getEssers_aquatics());
        ps.executeUpdate();
        ps.close();
    }

    public void insertEssers(Essers esser, String planeta) throws SQLException {
        // Pendiente verificar primero que existe
        String insert = "insert into esser(nom, esser, planeta) " + "values (?, ?, ?);";
        PreparedStatement ps = conexio.prepareStatement(insert);

        ps.setString(1, esser.getNom());
        ps.setString(2, esser.getEsser().toString());
        ps.setString(3, planeta);
        ps.executeUpdate();
        ps.close();

        String insert2 = "ERROR";
        PreparedStatement pe = conexio.prepareStatement(insert2);

        if (esser instanceof Humans) {
            Humans huma = (Humans) esser;
            insert2 = "insert into huma (nom, edad, genero) " + "values (?, ?, ?);";
            pe = conexio.prepareStatement(insert2);
            pe.setString(1, esser.getNom());
            pe.setInt(2, huma.getEdad());
            pe.setString(3, huma.getGenere());
            ;
        } else if (esser instanceof Andorians) {
            Andorians andor = (Andorians) esser;
            insert2 = "insert into andoria (nom, rango) " + "values (?, ?);";
            pe = conexio.prepareStatement(insert2);
            pe.setString(1, esser.getNom());
            pe.setString(2, andor.getRango().toString());
            ;
        } else if (esser instanceof Ferengi) {
            Ferengi fer = (Ferengi) esser;
            insert2 = "insert into ferengi (nom, latinum) " + "values (?, ?);";
            pe = conexio.prepareStatement(insert2);
            pe.setString(1, esser.getNom());
            pe.setDouble(2, fer.getLatinum());
            ;
        } else if (esser instanceof Klingon) {
            Klingon kin = (Klingon) esser;
            insert2 = "insert into klingon (nom, fuerza) " + "values (?, ?);";
            pe = conexio.prepareStatement(insert2);
            pe.setString(1, esser.getNom());
            pe.setInt(2, kin.getFuerza());
            ;
        } else if (esser instanceof Nibirians) {
            Nibirians nib = (Nibirians) esser;
            insert2 = "insert into nibirian (nom, vegano, pescado) " + "values (?, ?, ?);";
            pe = conexio.prepareStatement(insert2);
            pe.setString(1, esser.getNom());
            pe.setString(2, nib.isFlora());
            pe.setString(3, nib.isPeix());
            ;
        } else if (esser instanceof Vulcanians) {
            Vulcanians vul = (Vulcanians) esser;
            insert2 = "insert into vulcania (nom, meditacio) " + "values (?, ?);";
            pe = conexio.prepareStatement(insert2);
            pe.setString(1, esser.getNom());
            pe.setInt(2, vul.getMeditacio());
            ;
        }

        pe.executeUpdate();
        pe.close();

    }


    public void conectar() throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:postgresql://localhost:5432/sistemasdb";
        String user = "postgres";
        String pass = "1234";
        conexio = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexio != null) {
            conexio.close();
        }
    }

}
