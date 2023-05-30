/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.enums;


/**
 *
 * @author Admin
 */
public class Enums {

    public static enum Clima {
        FRED, CALID, TEMPERAT
    };

    public static enum Esser {
        HUMANS,VULCANIANS,ANDORIANS,NIBIRIANS,KLINGON,FERENGI
    };
    
    public static enum Categoria {
        I,II,III,O
    };
    
    public static enum Rango {
        DEFENSOR,ENTRENADOR,LLUITADOR,CAVALLER
    };

    public static Clima elegirClima(String clima) throws EnumsExceptions{ //Combierte la string en Climas.

        switch (clima.toLowerCase()) {
            case "fred":
                return Clima.FRED;
            case "calid":
                return Clima.CALID;
            case "temperat":
                return Clima.TEMPERAT;
        }
            
        throw new EnumsExceptions(0);
    }
    
    public static Esser elegirEsser(String nombre) throws EnumsExceptions{ //Combierte las string en essers.
        
        switch (nombre.toLowerCase()) {
            case "huma":
                return Esser.HUMANS;
            case "vulcania":
                return Esser.VULCANIANS;
            case "andoria":
                return Esser.ANDORIANS;
            case "nibiria":
                return Esser.NIBIRIANS;
            case "klingon":
                return Esser.KLINGON;
            case "ferengi":
                return Esser.FERENGI;

        }
        
        throw new EnumsExceptions(1);
        
    }
    
    public static Categoria elegirCategoria(Esser especie){ //Combierte el Esser en categorias.
        Categoria sucategoria = Categoria.O;
        
        switch (especie) {
            case HUMANS,FERENGI:
                sucategoria = Categoria.I;
                break;
            case VULCANIANS,KLINGON:
                sucategoria = Categoria.III;
                break;
            case ANDORIANS,NIBIRIANS:
                sucategoria = Categoria.II;
                break;
            default:
                System.out.println("El esser no li correspon cap catgoria. Es quedara amb O.");
        }
        
        return sucategoria;
    }

    public static Rango elegirRango(String rango) throws EnumsExceptions{ //Combierte el string en rangos.
        switch (rango.toLowerCase()){
            case "defensor":
                return Rango.DEFENSOR;
            case "lluitador":
                return Rango.LLUITADOR;
            case "cavaller":
                return Rango.CAVALLER;
            case "entrenador":
                return Rango.ENTRENADOR;    
        }
          
        throw new EnumsExceptions(2);
    }

}
