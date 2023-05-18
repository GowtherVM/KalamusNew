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
public class Ferengi extends Essers {
    private double latinum;

    public Ferengi(String nom,String esser,double latinum ) throws EnumsExceptions {
        super(nom,esser);
        this.latinum = latinum;
    }

    public double getLatinum() {
        return latinum;
    }

    public void setLatinum(double latinum) {
        this.latinum = latinum;
    }
    
    
}
