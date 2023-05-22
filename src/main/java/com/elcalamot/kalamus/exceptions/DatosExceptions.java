/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.exceptions;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author espin
 */
public class DatosExceptions extends Exception {
    public static final int EDAD_HUMA = 0;
    public static final int MEDITACIO_VULC = 1;
    public static final int FUERZA_KLING = 2;
    public static final int RIQUEZA_FERENGI = 3;
    public static final int ALIMENTACIO_NIB = 4;
    public static final int GENERE_HUMA = 5;
    public static final int ARGS = 6;
    public static final int POBLACIO = 7;
    public static final int ELECCION = 8;
 

    
    private final List<String> missatges = Arrays.asList(
            "ERROR: La edad tiene que ser ente 0 y 130. ",
            "ERROR: La meditacion tiene que ser entre 0 y 10.",
            "ERROR: La fuerza tiene que ser entre 50 y 350.",
            "ERROR: La cantidad de Latinum no puede ser menos a 1.",
            "ERROR: La especie en caso de que coma flora o peces se tiene que indicar con: yes/no.",
            "ERROR: El genero tiene que ser masculi/femeni.",
            "ERROR: Numero de argumentos incorrecto. Compruebe su comando.",
            "ERROR: Poblacion del planeta tiene que ser mayor a 0.",
            "ERROR: El properties tiene que ser postgres/fichero.");
    
    private final int code;

    public DatosExceptions(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return missatges.get(code);
    }
}
