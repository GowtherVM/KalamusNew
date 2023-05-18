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
public class Nibirians extends Essers {
    private boolean flora;
    private boolean peix;

    public Nibirians(String nom,String esser, boolean peix, boolean flora ) throws EnumsExceptions {
        super(nom,esser);
        this.flora = flora;
        this.peix = peix;
    }

    public String isPeix() {
        return FuncionesModelo_Essers.getPeixFlora(peix);
    }
    
    public String isFlora() {
        return FuncionesModelo_Essers.getPeixFlora(peix);
    }
    
    public void setFlora(boolean peix) {
        this.flora = flora;
    }

    public void setPeix(boolean peix) {
        this.peix = peix;
    }
    
    
}
