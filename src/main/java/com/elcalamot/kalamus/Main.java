/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.elcalamot.kalamus;

import com.elcalamot.kalamus.controller.ControllerKalamus;
import com.elcalamot.kalamus.enums.EnumsExceptions;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaFicheros;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, DatosExceptions{
        
        Sistemas sistemas = Sistemas.getInstance();
        PersistenciaFicheros pers = new PersistenciaFicheros();
        ControllerKalamus controller = new ControllerKalamus(sistemas, pers);
        pers.comprobarRuta("/planets",".csv");
        pers.comprobarRuta("/beings",".csv");

        // FuncionesModelo_Planetas.testsPlanetas();
        // FuncionesModelo_Essers.testEssers();
        
        try{
        pers.generarDBP();
        pers.generarDBE();
        controller.iniciarKalamus(args);
        
        }catch(DatosExceptions | EnumsExceptions excep){
            System.out.println(excep.getMessage());
        }
        
        
        
       
        

        
    }
}

