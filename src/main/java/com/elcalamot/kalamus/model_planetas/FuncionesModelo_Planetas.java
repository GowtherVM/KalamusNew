/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.enums.EnumsExceptions;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.exceptions.DemanarDades;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaDB;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaFicheros;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class FuncionesModelo_Planetas {

    public static String crearPlaneta(String[] args, String modo) throws IOException, SQLException, ClassNotFoundException { //Funcion que verifica los datos de entrada y crea un planeta con lo solicitado.
        
        

        PersistenciaDB persistenciadb = new PersistenciaDB();
        Properties eleccion = new Properties();
        eleccion.load(new FileInputStream(new File(System.getProperty("user.home") + "/.kalamus/kalamus.prop")));
        eleccion.getProperty(("eleccio").toLowerCase());
        String mensaje = "";
        
        try { //Prueba la verificacion de datos y el añadir la galaxia y el planeta en caso de que no este repetido.
            DemanarDades.comprobarArgs(args, 8);
            Sistemas sistemas = Sistemas.getInstance();
            Enums.Clima clima = Enums.elegirClima(args[5]);

            if (sistemas.comprobarGalaxia(args[3].toUpperCase()) == null) {
                sistemas.addGalaxia(args[3].toUpperCase());
                System.out.println("Se ha generado una nueva galaxia llamada " + args[3].toUpperCase());
               
            } else {
                System.out.println("La galaxia ya existia.");
                
            }

            if (sistemas.comprobarPlaneta(args[2].toLowerCase()) == null) {
                DemanarDades.demanarEnter(Integer.parseInt(args[4]), 1);
                Planeta nuevoplaneta = new Planeta(args[2].toLowerCase(), Integer.parseInt(args[4]), clima, args[6], args[7]);
                sistemas.addPlaneta(args[3].toUpperCase(), nuevoplaneta);

                if (eleccion.getProperty("eleccio").equalsIgnoreCase("postgres")) { //Dependiendo del properties lo añade a la bbdd o al fichero.
                    persistenciadb.conectar();
                    persistenciadb.insertPlaneta(nuevoplaneta, args[3].toUpperCase());
                    persistenciadb.desconectar();
                } else if (eleccion.getProperty("eleccio").equalsIgnoreCase("fichero")) {
                    PersistenciaFicheros.anadirPlaneta(nuevoplaneta, args[3].toUpperCase());
                }

                System.out.println("Se ha generado el nuevo planeta " + nuevoplaneta.getNomplan() + " en la galaxia " + args[3].toUpperCase());
                mensaje = "Se ha generado correctamente.";
                
            } else {
                System.out.println("El planeta ya existia.");
                mensaje = "El planeta ya existia.";
                
            }

        } catch (EnumsExceptions | DatosExceptions | SQLException exceptions) { //Si algun dato es inorrecto genera una excepcion que coge el catch y muestra el mensaje dependiendo si es por jframe o output.
            if (modo == "jframe") {
                mensaje = exceptions.getMessage();
            } else {
                System.out.println(exceptions.getMessage());
            }
        } catch (NumberFormatException num) {
            if (modo == "jframe") {
                mensaje = "Se espraba un valor numerico en habitantes. \n No se ha generado el planetas.";
            } else {
                System.out.println("Se espraba un valor numerico en habitantes.\n No se ha generado el planetas.");
            }
        }
        
        return mensaje;
    }

    public static boolean elegirOpcion(String opcio, String mensaje) throws PlanetaExceptions { //Hace un cambio dependiendo de la opcion para poner true o false.
        if (opcio.equalsIgnoreCase("si")) {
            return true;
        } else if (opcio.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println(mensaje);
        }

        return false;

    }

    public static void poblacionPlaneta(String planeta) throws PlanetaExceptions { //Metodo que calcula si añades un habitante mas si sobre pasas el limite o no de habitantes.
        Sistemas sis = Sistemas.getInstance();
        Planeta pla = sis.comprobarPlaneta(planeta);
        ArrayList<Essers> array = pla.getLista();
        int habitantes_actualizado = array.size() + 1;
        int habitantes_totales = pla.getPoblacio_max();

        if (habitantes_actualizado > habitantes_totales) {
            throw new PlanetaExceptions(2);
        }

    }

}
