/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.elcalamot.kalamus;

import com.elcalamot.kalamus.controller.ControllerARGS;
import com.elcalamot.kalamus.enums.EnumsExceptions;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaDB;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaFicheros;

import com.elcalamot.kalamus.vistas.DashBoard;
import java.io.File;
import java.io.FileInputStream;
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
        
        
        
        
        Sistemas sistemas = Sistemas.getInstance();
        PersistenciaFicheros pers = new PersistenciaFicheros();
        PersistenciaDB persdb = new PersistenciaDB();
        ControllerARGS controller = new ControllerARGS(sistemas, pers, persdb);
        DashBoard vista = new DashBoard();
        pers.comprobarRuta("/planets", ".csv");
        pers.comprobarRuta("/beings", ".csv");

        // FuncionesModelo_Planetas.testsPlanetas();
        // FuncionesModelo_Essers.testEssers();
        generarBDs(crearProperties(),persdb,pers);
        
        if(args.length == 0){
            vista.main(args);
        }else{
           controller.iniciarKalamusArgs(args);
        }
        
        

    }
    
    public static Properties crearProperties() throws FileNotFoundException, IOException {
        Properties p = new Properties();
        File ficheroProperties = new File(System.getProperty("user.home")+"/.kalamus/kalamus.prop");
        if(!ficheroProperties.exists()){
            ficheroProperties.createNewFile();
            p.put("eleccio", "fichero");
            p.put("bd", "postgres");
            p.save(new FileOutputStream(System.getProperty("user.home")+"/.kalamus/kalamus.prop"),"");
            
        }
        
        return p;
    }
    
    public static void generarBDs(Properties eleccion, PersistenciaDB persdb, PersistenciaFicheros persistencia) throws FileNotFoundException, IOException{
        eleccion.load(new FileInputStream(new File(System.getProperty("user.home")+"/.kalamus/kalamus.prop")));
        eleccion.getProperty(("eleccio").toLowerCase());
        
        //FuncionesModelo_Planetas.testsPlanetas();
        //FuncionesModelo_Essers.testEssers();
        
        try {
            if(eleccion.getProperty("eleccio").equalsIgnoreCase("postgres")){
                persdb.conectar();
                persdb.selectAllPlanetas();
                persdb.selectAllEssers();
                
            }else if(eleccion.getProperty("eleccio").equalsIgnoreCase("fichero")){
                persistencia.generarDBP();
                persistencia.generarDBE();
            }else{
                throw new DatosExceptions(8);
            }
            
        } catch (DatosExceptions | EnumsExceptions | SQLException | ClassNotFoundException excep) {
            System.out.println(excep.getMessage());
        }
    }

    
}


