/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author espin
 */
public class EssersExceptions extends Exception{
    public static final int REGLA_AV = 0;
    public static final int REGLA_KLINGON = 1;
    public static final int REGLA_FERENGI = 2;
    public static final int ESSER_EXIST = 3;
    public static final int REGLA_NIB_FLORA = 4;
    public static final int REGLA_NIB_PEIX = 5;

    
    private final List<String> missatges = Arrays.asList(
            "ERROR: Un Andoria no pot conviura amb un Vulcania y viceversa. ",
            "ERROR: Los Klingon no pueden vivir en un clima CALID. ",
            "ERROR: Los Ferengi no pueden vivir en un clima FRIO",
            "ERROR: Ya existe un esser con ese nombre en algun planeta. No se pueden repetir nombres.",
            "ERROR: Este Niberia necesita flora en el planeta.",
            "ERROR: Este Niberia necesita pezes en el planeta.");
    
    private final int code;

    public EssersExceptions(int code) {
        this.code = code;
    }
    

    @Override
    public String getMessage() {
        return missatges.get(code);
    }
}
