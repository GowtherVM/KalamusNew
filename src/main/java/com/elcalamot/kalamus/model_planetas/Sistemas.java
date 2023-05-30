/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.controller.ControllerARGS;
import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.model_essers.EssersExceptions;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class Sistemas {

    private static Sistemas sistemas = null;
    private HashMap<String, ArrayList<Planeta>> galaxiaplanetas = new HashMap(); //La estructura de sistemas se gestiona con un nombre de galaxia y una arraylist de planetas.

    private Sistemas() {
    }

    public static Sistemas getInstance() { //Genera la intancia unica o la devulve si ya existe.
        if (sistemas == null) {
            sistemas = new Sistemas();
        }

        return sistemas;
    }

    public void addGalaxia(String newgalaxia) { //Añade una galaxia al hashmap.

        ArrayList<Planeta> planetas = new ArrayList();
        galaxiaplanetas.put(newgalaxia, planetas);

    }

    public void addPlaneta(String galaxiaexist, Planeta newplaneta) { //Añade un planeta a la arraylist de una galaxia.

        ArrayList<Planeta> planetas = galaxiaplanetas.get(galaxiaexist);
        if (planetas != null) {
            planetas.add(newplaneta);
        }

    }

    public String comprobarGalaxia(String galaxia){ //Comprueba si una galaxia existe.
        boolean keyexist = galaxiaplanetas.containsKey(galaxia.toUpperCase());

        if (keyexist == false) {
            return null;
        }

        return galaxia;
    }
    
    public void comprobarEsserP(String nomesser, String nomplaneta)throws NullPointerException, EssersExceptions{ //Compueba si un esser existe en un planeta.
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                    ArrayList <Essers> arrayessers = planeta.getLista();
                    if(!arrayessers.isEmpty()){
                        for(Essers esser: arrayessers){
                            
                            if (esser instanceof Humans) { Humans huma = (Humans) esser; if(nomesser.equalsIgnoreCase(huma.getNom())){throw new EssersExceptions(3);}}
                            else if (esser instanceof Andorians) { Andorians andor = (Andorians) esser; if(nomesser.equalsIgnoreCase(andor.getNom())){throw new EssersExceptions(3);}}
                            else if (esser instanceof Ferengi) { Ferengi fer = (Ferengi) esser; if(nomesser.equalsIgnoreCase(fer.getNom())){throw new EssersExceptions(3);}}
                            else if (esser instanceof Klingon) { Klingon kin = (Klingon) esser; if(nomesser.equalsIgnoreCase(kin.getNom())){throw new EssersExceptions(3);}}
                            else if (esser instanceof Nibirians) { Nibirians nib = (Nibirians) esser; if(nomesser.equalsIgnoreCase(nib.getNom())){throw new EssersExceptions(3);}}
                            else if (esser instanceof Vulcanians) { Vulcanians vul = (Vulcanians) esser; if(nomesser.equalsIgnoreCase(vul.getNom())){throw new EssersExceptions(3);}}
                    
                        }                    
                    }
                
            }
        }

    }

    public String devolverGalaxiaP(String nomplaneta) { //Devulve el nombre de la galaxia a raiz del planeta.
        String galaxia = "";
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                if (planeta.getNomplan().equalsIgnoreCase(nomplaneta)) {
                    galaxia = key;
                }
            }
        }
        return galaxia;
    }

    public Planeta comprobarPlaneta(String nomplaneta){ //Comprueba si un planeta existe.
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            if(!planetas.isEmpty()){
                for (Planeta planeta : planetas) {
                    if (planeta.getNomplan().equalsIgnoreCase(nomplaneta)) {
                    
                        return planeta;
                    }
                }
            }
        }
        return null;
    }

    public void listPlanetas() { //Metodo que envia todos los planetas para extraer sus datos.
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                ControllerARGS.generarCadenasPlanetas(planeta);
            }
        }
        
    }

    public boolean existeGalaxia(String galaxia) { //Comprueba si la galaxia existe.
        return galaxiaplanetas.containsKey(galaxia);
    }

    public boolean existePlaneta(Planeta planeta) {

        return galaxiaplanetas.containsValue(planeta);
    }

    public void listEssers() { //Devulve todos los seres de todos los planetas.

        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            System.out.println("Galaxia:" + key);
            for (Planeta planeta : planetas) {
                ControllerARGS.generarCadenasEssers(planeta);

            }
        }
    }
    
    public ArrayList <String> nombresPlanetas(){ //Devuelve los nombres de los planetas para una lista del modo visual.
        ArrayList <String> nombres = new ArrayList();
        String nombre;
        
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                nombre = planeta.getNomplan();
                nombres.add(nombre);
            }
        }

        return nombres;
    }
    
    public ArrayList <String> datosPlanetas(){ //Devuelve los datos de los planetas para el list visual.
        ArrayList <String> datos = new ArrayList();
        String dato;
        
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
 
                dato = "Nombre: " + planeta.getNomplan()+" | "+ "Galaxia: " + key +" | "+ "Clima: " + planeta.getClima() +" | "+ "Habitantes (maximos): " + planeta.getPoblacio_max() +" | "+ "Flora Vermella: "+ planeta.getFlora_vermella() +" | "+ "Essers aquatics: " + planeta.getEssers_aquatics()+"\n";
                datos.add(dato);
            }
        }
        
        return datos;
    }
    
    public ArrayList <String> datosBeing(){ //Devuelve los datos de los essers para el list visual.
        ArrayList <String> datosbeing = new ArrayList();
        
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                    datosbeing.add("Planeta: "+planeta.getNomplan() + "\n");
                    ArrayList <Essers> arrayessers = planeta.getLista();
                    if(!arrayessers.isEmpty()){
                        for(Essers esser: arrayessers){
                            String datos = "Nombre: " + esser.getNom() + "|" + "Raza: " + esser.getEsser()+"|";
                            
                            if (esser instanceof Humans) { Humans huma = (Humans) esser; datos = datos + "Edad:" + huma.getEdad() + "|" +"Genero: "+ huma.getGenere()+ "\n";}
                            else if (esser instanceof Andorians) { Andorians andor = (Andorians) esser;datos = datos + "Rango: " + andor.getRango()+ "\n" ;}
                            else if (esser instanceof Ferengi) { Ferengi fer = (Ferengi) esser;datos = datos + "Latinum: " + fer.getLatinum()+ "\n";}
                            else if (esser instanceof Klingon) { Klingon kin = (Klingon) esser;datos = datos + "Fuerza: " + kin.getFuerza() + "\n";}
                            else if (esser instanceof Nibirians) { Nibirians nib = (Nibirians) esser;datos = datos + "Come flora roja: " + nib.isFlora() + "|"+ "Come pezes: " + nib.isPeix()+ "\n";}
                            else if (esser instanceof Vulcanians) { Vulcanians vul = (Vulcanians) esser;datos = datos + "Meditacion: "+ vul.getMeditacio()+ "\n" ;}
                    
                            datosbeing.add(datos);
                       }                    
                    }
                    else{datosbeing.add("Desabitado. \n");}
                
            }
        }
        return datosbeing;

    }
    
    public ArrayList <String> nombresEssers(){ //Devuelve los nombres de los essers.
        ArrayList <String> datosbeing = new ArrayList();
        
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                    ArrayList <Essers> arrayessers = planeta.getLista();
                    if(!arrayessers.isEmpty()){
                        for(Essers esser: arrayessers){
                            datosbeing.add(esser.getNom());
                       }                    
                    }
            }
        }
        return datosbeing;
    }

}
