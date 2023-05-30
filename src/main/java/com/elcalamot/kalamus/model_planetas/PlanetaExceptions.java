
package com.elcalamot.kalamus.model_planetas;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pau
 */
public class PlanetaExceptions extends Exception { //Excepciones propias de los planetas.
    

    public static final int GALAXIA_EXIST = 0;
    public static final int MUNDO_EXIST = 1;
    public static final int SOBRE_POBLACION = 2;
    public static final int DB_ESSERS_ERROR_PLAN = 3;

    
    private final List<String> missatges = Arrays.asList(
            "ERROR: Galaxia existe.",
            "ERROR: Mundo existe. ",
            "ERROR: Este individuo genera sobrepoblacion en el planeta.\n No puede ser asignado.",
            "ERROR: La base de datos esta intentando añadir un esser a un planeta que ha sido eliminado.");
    
    private final int code;

    public PlanetaExceptions(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return missatges.get(code);
    }
    
}
