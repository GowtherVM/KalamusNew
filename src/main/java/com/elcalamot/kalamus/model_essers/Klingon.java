/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import com.elcalamot.kalamus.enums.EnumsExceptions;

/**
 *
 * @author A200238614
 */
public class Klingon extends Essers {
    private int fuerza;

    public Klingon(String nom, String esser,int fuerza) throws EnumsExceptions {
        super(nom,esser);
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    
    
}
