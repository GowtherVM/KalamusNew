/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.elcalamot.kalamus;

import com.elcalamot.kalamus.controller.ControllerKalamus;
import com.elcalamot.kalamus.enums.EnumsExceptions;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaFicheros;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, DatosExceptions, SQLException {
        
        crearProperties();
        
        
        Sistemas sistemas = Sistemas.getInstance();
        PersistenciaFicheros pers = new PersistenciaFicheros();
        ControllerKalamus controller = new ControllerKalamus(sistemas, pers);
        pers.comprobarRuta("/planets", ".csv");
        pers.comprobarRuta("/beings", ".csv");

        // FuncionesModelo_Planetas.testsPlanetas();
        // FuncionesModelo_Essers.testEssers();
        
        controller.iniciarKalamus(args);

    }

    public static void crearProperties() throws FileNotFoundException, IOException {
        Properties p = new Properties();
        File ficheroProperties = new File(System.getProperty("user.home")+"/.kalamus/kalamus.prop");
        if(!ficheroProperties.exists()){
            ficheroProperties.createNewFile();
            p.put("eleccio", "fichero");
            p.put("bd", "postgres");
            p.save(new FileOutputStream(System.getProperty("user.home")+"/.kalamus/kalamus.prop"),"");
        }
    }
}
