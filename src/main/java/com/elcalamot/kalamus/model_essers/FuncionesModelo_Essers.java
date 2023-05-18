/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import static com.elcalamot.kalamus.enums.Enums.Clima.CALID;
import static com.elcalamot.kalamus.enums.Enums.Clima.FRED;
import static com.elcalamot.kalamus.enums.Enums.Esser.ANDORIANS;
import static com.elcalamot.kalamus.enums.Enums.Esser.VULCANIANS;
import com.elcalamot.kalamus.enums.EnumsExceptions;
import com.elcalamot.kalamus.exceptions.DatosExceptions;
import com.elcalamot.kalamus.exceptions.DemanarDades;
import com.elcalamot.kalamus.model_planetas.FuncionesModelo_Planetas;
import com.elcalamot.kalamus.model_planetas.PlanetaExceptions;
import com.elcalamot.kalamus.model_planetas.Planeta;
import com.elcalamot.kalamus.model_planetas.Sistemas;
import com.elcalamot.kalamus.persistencia.Persistencia.PersistenciaFicheros;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author A200238614
 */
public class FuncionesModelo_Essers {

    public static void crearEsser(String[] args) throws IOException {
        try {
            Sistemas sis = Sistemas.getInstance();
            Planeta planeta = sis.comprobarPlaneta(args[4].toLowerCase());
            
            
            switch (args[3].toLowerCase()) {

                case "huma":
                    DemanarDades.comprobarArgs(args, 7);
                    sis.comprobarEsserP(args[2].toLowerCase(), planeta.getNomplan());
                    DemanarDades.demanarEnter(Integer.parseInt(args[5]), 0, 130, "huma");
                    Humans huma = new Humans(args[2], "huma", Integer.parseInt(args[5]), args[6]);
                    FuncionesModelo_Planetas.poblacionPlaneta(planeta.getNomplan());
                    planeta.addEsser(huma);
                    PersistenciaFicheros.anadirEsser(huma, planeta);
                    System.out.println("Añadido correctamente.");

                    break;
                case "andoria":
                    DemanarDades.comprobarArgs(args, 6);
                    sis.comprobarEsserP(args[2].toLowerCase(), planeta.getNomplan());
                    Andorians andor = new Andorians(args[2], "andoria", args[5]);
                    reglasVA(andor, planeta);
                    FuncionesModelo_Planetas.poblacionPlaneta(planeta.getNomplan());
                    planeta.addEsser(andor);
                    PersistenciaFicheros.anadirEsser(andor, planeta);
                    System.out.println("Añadido correctamente.");

                    break;
                case "ferengi":
                    DemanarDades.comprobarArgs(args, 6);
                    sis.comprobarEsserP(args[2].toLowerCase(), planeta.getNomplan());
                    reglasFerengi(planeta);
                    DemanarDades.demanarEnter(Integer.parseInt(args[5]), 1, "ferengi");
                    Ferengi fer = new Ferengi(args[2], "ferengi", Double.parseDouble(args[5]));
                    FuncionesModelo_Planetas.poblacionPlaneta(planeta.getNomplan());
                    planeta.addEsser(fer);
                    PersistenciaFicheros.anadirEsser(fer, planeta);
                    System.out.println("Añadido correctamente.");

                    break;
                case "vulcania":
                    DemanarDades.comprobarArgs(args, 6);
                    sis.comprobarEsserP(args[2].toLowerCase(), planeta.getNomplan());
                    DemanarDades.demanarEnter(Integer.parseInt(args[5]), 0, 10, "vulcania");
                    Vulcanians vulc = new Vulcanians(args[2], "vulcania", Integer.parseInt(args[5]));
                    reglasVA(vulc, planeta);
                    FuncionesModelo_Planetas.poblacionPlaneta(planeta.getNomplan());
                    planeta.addEsser(vulc);
                    PersistenciaFicheros.anadirEsser(vulc, planeta);
                    System.out.println("Añadido correctamente.");

                    break;
                case "nibirian":
                    DemanarDades.comprobarArgs(args, 6);
                    sis.comprobarEsserP(args[2].toLowerCase(), planeta.getNomplan());
                    Nibirians nib = new Nibirians(args[2], "nibiria", FuncionesModelo_Essers.getPeixFlora(args[6]), FuncionesModelo_Essers.getPeixFlora(args[5]));
                    reglasNibirians(nib, planeta);
                    FuncionesModelo_Planetas.poblacionPlaneta(planeta.getNomplan());
                    planeta.addEsser(nib);
                    PersistenciaFicheros.anadirEsser(nib, planeta);
                    System.out.println("Añadido correctamente.");
                    

                    break;

                case "klingon":
                    DemanarDades.comprobarArgs(args, 6);
                    sis.comprobarEsserP(args[2].toLowerCase(), planeta.getNomplan());
                    reglasKlingon(planeta);
                    DemanarDades.demanarEnter(Integer.parseInt(args[5]), 50, 350, "klingon");
                    Klingon kling = new Klingon(args[2], "klingon", Integer.parseInt(args[5]));
                    FuncionesModelo_Planetas.poblacionPlaneta(planeta.getNomplan());
                    planeta.addEsser(kling);
                    PersistenciaFicheros.anadirEsser(kling, planeta);
                    System.out.println("Añadido correctamente.");

                    break;

            }

        } catch (NullPointerException | DatosExceptions | EssersExceptions | EnumsExceptions | PlanetaExceptions exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String getGenere(boolean opcio) {
        if (opcio == true) {
            return "masculi";
        } else if (opcio == false) {
            return "femeni";
        }

        return "femenino";

    }

    public static boolean getPeixFlora(String opcio) throws DatosExceptions {
        if (opcio.equalsIgnoreCase("yes")) {
            return true;
        } else if (opcio.equalsIgnoreCase("no")) {
            return false;
        }
        throw new DatosExceptions(4);
    }

    public static String getPeixFlora(boolean opcio) {
        if (opcio == true) {
            return "Yes";
        } else if (opcio == false) {
            return "No";
        }

        return "No";

    }

    public static boolean elegirGenere(String opcio, String mensaje) throws DatosExceptions {
        if (opcio.equalsIgnoreCase("masculi")) {
            return true;
        } else if (opcio.equalsIgnoreCase("femeni")) {
            return false;
        }

        throw new DatosExceptions(5);

    }

    public static void reglasVA(Essers va, Planeta destino) throws EssersExceptions {
        ArrayList<Essers> poblacion_planeta = destino.getLista();
        switch (va.getEsser()) {
            case VULCANIANS:
                for (Essers esser : poblacion_planeta) {
                    if (esser.getEsser() == ANDORIANS) {
                        throw new EssersExceptions(0);
                    }
                }
                break;
            case ANDORIANS:
                for (Essers esser : poblacion_planeta) {
                    if (esser.getEsser() == VULCANIANS) {
                        throw new EssersExceptions(0);

                    }
                }
                break;
        }

    }

    public static void reglasKlingon(Planeta destino) throws EssersExceptions {
        if (destino.getClima() == CALID) {
            throw new EssersExceptions(1);
        }

    }

    public static void reglasFerengi(Planeta destino) throws EssersExceptions {
        if (destino.getClima() == FRED) {
            throw new EssersExceptions(2);
        }

    }

    public static void reglasNibirians(Nibirians nib, Planeta destino) throws EssersExceptions {
        if (nib.isFlora().equalsIgnoreCase("yes")) {
            if (destino.getFlora_vermella().equalsIgnoreCase("No")) {
                throw new EssersExceptions(4);
                
            }
        }

        if (nib.isPeix().equalsIgnoreCase("Si") && destino.getEssers_aquatics().equalsIgnoreCase("No")) {
            throw new EssersExceptions(5);
        }

    }

    public static void testEssers() throws IOException, PlanetaExceptions, DatosExceptions, EnumsExceptions {
        Sistemas sis = Sistemas.getInstance();
        Planeta tierra = sis.comprobarPlaneta("tierra");
        Planeta marte = sis.comprobarPlaneta("marte");

        Humans nuevo = new Humans("Sarah", "humans", 21, "femeni");
        Humans nuevo1 = new Humans("Pau", "humans", 23, "masculi");
        Klingon kling = new Klingon("Eric", "klingon", 5);
        Nibirians nib = new Nibirians("Nibpez", "nibirians", true, false);
        Andorians andor = new Andorians("Andor1", "andorians", "defensor");
        Vulcanians vulc = new Vulcanians("Vulc1", "vulcanians", 5);
        tierra.addEsser(vulc);

        tierra.addEsser(andor);
        marte.addEsser(nib);
        tierra.addEsser(nuevo);
        tierra.addEsser(nuevo1);
        marte.addEsser(kling);

    }
}
