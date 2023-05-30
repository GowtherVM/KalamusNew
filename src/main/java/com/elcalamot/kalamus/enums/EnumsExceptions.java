/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.enums;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author A200238614
 */
public class EnumsExceptions extends Exception { //Excepciones que estan relacionados con los enums.
    public static final int ELEGIR_CLIMA = 0;
    public static final int ELEGIR_ESSER = 1;
    public static final int ELEGIR_RANGO = 2;

    
    private final List<String> missatges = Arrays.asList(
            "ERROR: Clima incorrecto.\n Opciones validas: TEMPERAT,FRED,CALID.",
            "ERROR: Esser incorrecto.\n Opciones validas: HUMANS,VULCANIANS,ANDORIANS,NIBIRIANS,KLINGON,FERENGI.",
            "ERROR: Rango incorrecto.\n Opciones validas: DEFENSOR,ENTRENADOR,LLUITADOR,CAVALLER.");
    
    private final int code;

    public EnumsExceptions(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return missatges.get(code);
    }
}
