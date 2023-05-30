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
import com.elcalamot.kalamus.vistas.Principal;


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

    public static void main(String[] args) throws IOException, FileNotFoundException, DatosExceptions, SQLException, ClassNotFoundException {
        
        
        //Genero intancias que en principio se tienen que pasar. De clase en clase que se necesite.
        
        Sistemas sistemas = Sistemas.getInstance(); // Esta es para absolutamente solo tener una instancia del sistema planetario
        PersistenciaFicheros pers = new PersistenciaFicheros();
        PersistenciaDB persdb = new PersistenciaDB();
        ControllerARGS controller = new ControllerARGS(sistemas, pers, persdb);
        

        
        generarBDs(crearProperties(),persdb,pers); 
        
        if(args.length == 0){ // Si no hay argumeto se inicia la pantalla grafica
            Principal vista = new Principal();
            vista.setVisible(true);
            
            
        }else{ //Si detecta argumento ejecuta el controllador de argumentos.
           controller.iniciarKalamusArgs(args);
        }
        
        

    }
    
    public static Properties crearProperties() throws FileNotFoundException, IOException { //Genera el properties para la base de datos postgres.
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
    
    public static void generarBDs(Properties eleccion, PersistenciaDB persdb, PersistenciaFicheros persistencia) throws FileNotFoundException, IOException{ //Genera las bases de datos dependiendo del properties y las carga en memoria.
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
                persistencia.comprobarRuta("/planets", ".csv"); 
                persistencia.comprobarRuta("/beings", ".csv");
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


