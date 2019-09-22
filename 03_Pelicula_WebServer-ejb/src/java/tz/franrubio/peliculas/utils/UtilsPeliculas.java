package tz.franrubio.peliculas.utils;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Clase Java UtilsPeliculas
 * 
 * Una serie de métodos que podemos usar.
 * 
 * @author Francisco J. Rubio
 * @version 1.0
 */

public class UtilsPeliculas {

    //Una enumeración para indicar que tipo de operacion CRUD vamos a usar.
    public static enum TipoOperacion {
        CREAR,
        EDITAR,
        BORRAR
    }

    //Método que nos devuelve si el valor introducido es númerico
    public static boolean isNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    //Método que nos nos devuelve el nombre de un parámetro
    //y nos devuelve su valor.
    public static String getParametro(String parametro) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, String> params = externalContext.getRequestParameterMap();
        String param = params.get(parametro);
        return param;
    }
}
