/*+
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
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import com.elcalamot.kalamus.model_planetas.Planeta;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static com.elcalamot.kalamus.model_essers.FuncionesModelo_Essers.getPeixFlora;


/**
 *
 * @author Admin
 */
public class PersistenciaFicheros {

    public void comprobarRuta(String nombre, String extension) throws IOException { //Compruba si la ruta existe. Si no existe la genera.

        File directorio = new File(System.getProperty("user.home") + "/.kalamus");
        if (!directorio.exists()) {
            directorio.mkdir();

        }

        File file = new File(System.getProperty("user.home") + "/.kalamus/" + nombre + extension);

        if (!file.exists()) {

            file.createNewFile();
            FileWriter archivo = new FileWriter(file, true);
            PrintWriter write = new PrintWriter(archivo);
            if (nombre.equalsIgnoreCase("/planets")) {
                write.println("nom_planeta,galaxia,poblacio_max,clima,flora_vermella,essets_aquatics");
            }

            write.close();

        }

    }

    public static void anadirEsser(Essers esser, Planeta planeta) throws IOException { //Añade un esser al fichero being.csv
        Sistemas sis = Sistemas.getInstance();
        String galaxia = sis.devolverGalaxiaP(planeta.getNomplan());
        File file = new File(System.getProperty("user.home") + "/.kalamus/beings.csv");
        String contenido = "ERROR";

        if (esser instanceof Humans) {
            Humans huma = (Humans) esser;
            contenido = huma.getNom() + "," + "huma" + "," + huma.getEdad() + "," + huma.getGenere() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Andorians) {
            Andorians andor = (Andorians) esser;
            contenido = andor.getNom() + "," + "andoria" + "," + andor.getRango() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Ferengi) {
            Ferengi fer = (Ferengi) esser;
            contenido = fer.getNom() + "," + "ferengi" + "," + fer.getLatinum() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Klingon) {
            Klingon kin = (Klingon) esser;
            contenido = kin.getNom() + "," + "klingon" + "," + kin.getFuerza() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Nibirians) {
            Nibirians nib = (Nibirians) esser;
            contenido = nib.getNom() + "," + "nibiria" + "," + "," + nib.isFlora() + "," + nib.isPeix() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Vulcanians) {
            Vulcanians vul = (Vulcanians) esser;
            contenido = vul.getNom() + "," + "vulcania" + "," + vul.getMeditacio() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        }

        FileWriter archivo = new FileWriter(file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(contenido);
        write.close();
    }

    public static void anadirPlaneta(Planeta planeta, String galaxia) throws IOException { //Añade un planeta al fichero planetas.csv
        String contenido = planeta.getNomplan() + "," + galaxia + "," + String.valueOf(planeta.getPoblacio_max()) + "," + planeta.getClima() + "," + planeta.getFlora_vermella() + "," + planeta.getEssers_aquatics();
        File file = new File(System.getProperty("user.home") + "/.kalamus/planets.csv");
        FileWriter archivo = new FileWriter(file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(contenido);
        write.close();
    }

    public void buscarAlgo(String buscar, File fil) throws FileNotFoundException, IOException {

        BufferedReader archivo = new BufferedReader(new FileReader(fil));
        String linea;

        while ((linea = archivo.readLine()) != null) {
            if (linea.contains(buscar.toUpperCase())) {

                System.out.println(linea);

            }
        }

    }


    public static void generarDBP() throws FileNotFoundException, IOException { //Carga los planetas del fichero en la memoria.
        try {
            System.out.println(".");
            Sistemas db = Sistemas.getInstance();
            String galaxia;
            File file = new File(System.getProperty("user.home") + "/.kalamus/planets.csv");
            BufferedReader archivo = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = archivo.readLine()) != null) {
                if (!linea.contains("nom_planeta,")) {
                    String[] split = linea.split(",");
                    galaxia = split[1];
                    Planeta añadir = new Planeta(split[0], Integer.parseInt(split[2]), Enums.elegirClima(split[3]), split[4], split[5]);
                    if (db.comprobarGalaxia(galaxia) == null) {
                        db.addGalaxia(galaxia);
                    }

                    db.addPlaneta(galaxia, añadir);
                }
            }
        } catch (EnumsExceptions ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void generarDBE() throws FileNotFoundException, IOException, DatosExceptions, EnumsExceptions{ //Carga los essers del fichero en la memoria.

        System.out.println(".");
        Sistemas db = Sistemas.getInstance();
        Planeta planeta;
        File file = new File(System.getProperty("user.home") + "/.kalamus/beings.csv");
        BufferedReader archivo = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = archivo.readLine()) != null) {

            String[] split = linea.split(",");
            

            
            switch (split[1].toLowerCase()) {
                case "huma":

                    planeta = db.comprobarPlaneta(split[4].toLowerCase());
                    Humans huma = new Humans(split[0].toLowerCase(), "huma", Integer.parseInt(split[2]), split[3]);
                    planeta.addEsser(huma);

                    break;
                case "andoria":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Andorians andor = new Andorians(split[0].toLowerCase(), "andoria", split[2]);

                    planeta.addEsser(andor);

                    break;
                case "ferengi":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Ferengi fer = new Ferengi(split[0].toLowerCase(), "ferengi", Double.parseDouble(split[2]));
                    planeta.addEsser(fer);

                    break;
                case "vulcania":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Vulcanians vulc = new Vulcanians(split[0].toLowerCase(), "vulcania", Integer.parseInt(split[2]));
                    planeta.addEsser(vulc);
                    break;
                case "nibirian":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Nibirians nib = new Nibirians(split[0].toLowerCase(), "nibiria", getPeixFlora(split[2]), getPeixFlora(split[3]));
                    planeta.addEsser(nib);

                    break;

                case "klingon":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Klingon kling = new Klingon(split[0].toLowerCase(), "klingon", Integer.parseInt(split[2]));
                    planeta.addEsser(kling);

                    break;

            }

        }

    }
}
