/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.elcalamot.kalamus;

import com.elcalamot.kalamus.controller.ControllerARGS;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaFicheros;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, DatosExceptions, SQLException {
        
        
        
        
        Sistemas sistemas = Sistemas.getInstance();
        PersistenciaFicheros pers = new PersistenciaFicheros();
        ControllerARGS controller = new ControllerARGS(sistemas, pers);
        pers.comprobarRuta("/planets", ".csv");
        pers.comprobarRuta("/beings", ".csv");

        // FuncionesModelo_Planetas.testsPlanetas();
        // FuncionesModelo_Essers.testEssers();
        
        
        if(args.length == 0){
            
        }else{
           controller.iniciarKalamusArgs(args);
        }
        
        

    }

    
}
