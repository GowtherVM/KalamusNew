/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elcalamot.kalamus.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author usuari
 */
public class DemanarDades { //Funciones generales de validacion de datos o pedir datos.

    public static String demanarCadenaNoBuida(String missatge) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String cadena;
        do {
            System.out.println(missatge);
            cadena = entrada.readLine();
            if (cadena.isBlank()) {
                System.out.println("Error, no es pot deixar el camp en blanc.");

            }
        } while (cadena.isBlank());
        return cadena;
    }

    public static int demanarEnter(String missatge) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error = false;
        do {
            try {
                System.out.println(missatge);
                numero = Integer.parseInt(entrada.readLine());
                error = false;
            } catch (NumberFormatException ex) {
                System.out.println("Has d'introduir un número");
                error = true;
            }
        } while (error);
        return numero;
    }

    public static int demanarEnter(String missatge, int minim) throws IOException {
        int numero = 0;
        do {
            numero = demanarEnter(missatge);
            if (numero <= minim) {
                System.out.println("El número ha de ser més gran que " + minim);
            }
        } while (numero <= minim);
        return numero;
    }

    public static void demanarEnter(int enter, int minim, int max, String esser) throws DatosExceptions {

        if (enter <= minim || enter >= max) {
            if (esser.equalsIgnoreCase("huma")) {
                throw new DatosExceptions(0);
            }
        }

        if (enter <= minim || enter >= max) {
            if (esser.equalsIgnoreCase("vulcania")) {
                throw new DatosExceptions(1);
            }
        }

        if (enter <= minim || enter >= max) {
            if (esser.equalsIgnoreCase("klingon")) {
                throw new DatosExceptions(2);
            }

        }

    }

    public static void comprobarArgs(String[] args, int max) throws DatosExceptions {
        if (args.length != max) {
            throw new DatosExceptions(6);
        }

    }

    public static void demanarEnter(int enter, int minim, String miss) throws DatosExceptions {
        if (miss.equalsIgnoreCase("ferengi")) {
            if (enter >= minim) {
                throw new DatosExceptions(3);
            }
        }
    }

    public static void demanarEnter(int enter, int minim) throws DatosExceptions {
        
            if (enter <= minim) {
                throw new DatosExceptions(3);
            }
        
    }
    

    public static boolean demanarBoolean(String missatge, String opcioTrue, String opcioFalse) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean opcio = false;
        String resposta = "";
        do {
            System.out.println(missatge);
            resposta = entrada.readLine();
            if (!resposta.equalsIgnoreCase(opcioTrue) && !resposta.equalsIgnoreCase(opcioFalse)) {
                System.out.println("Resposta incorrecta.");
            } else if (resposta.equalsIgnoreCase(opcioTrue)) {
                opcio = true;
            } else {
                opcio = false;
            }
        } while (!resposta.equalsIgnoreCase(opcioTrue) && !resposta.equalsIgnoreCase(opcioFalse));
        return opcio;
    }

    public static double demanarDoble(String missatge) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        double numero = 0;
        boolean error = false;
        do {
            try {
                System.out.println(missatge);
                numero = Double.parseDouble(entrada.readLine());
            } catch (NumberFormatException ex) {
                System.out.println("Has d'introduir un número");
                error = true;
            }
        } while (error);
        return numero;
    }

    public static double demanarDoble(String missatge, double minim) throws IOException {
        double numero = 0;
        do {
            numero = demanarDoble(missatge);
            if (numero <= minim) {
                System.out.println("El número ha de ser més gran que " + minim);
            }
        } while (numero <= minim);
        return numero;
    }

}
