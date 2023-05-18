/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.persistencia.Persistencia;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.enums.EnumsExceptions;
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
            String query = "select * from planetas;";
            HashMap<String, ArrayList<Planeta>> galaxias = new HashMap();
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
                galaxias.put(galaxia, planetas);
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

    public void insertPlaneta(Planeta planeta, String galaxia) throws SQLException {
        // Pendiente verificar primero que existe
        String insert = "insert into planetas (nom_planeta, galaxia, poblacio_max, clima, flora_vermella, essers_aquatics) "
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

    private boolean existePokedom(Planeta planeta) {
        // código que verifica si existe
        return false;
    }

    public void conectar() throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:postgresql://localhost:5432/bd";
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
