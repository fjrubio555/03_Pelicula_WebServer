package tz.franrubio.peliculas.ejbs;

import java.util.List;
import javax.ejb.Local;
import tz.franrubio.peliculas.entities.Pelicula;

/**
 * Interfaz PelículaFacadeLocal.
 * 
 * @author Francisco J. Rubio.
 * @version 1.0
 */

@Local
public interface PeliculaFacadeLocal {

    void create(Pelicula pelicula);

    void edit(Pelicula pelicula);

    void remove(Pelicula pelicula);

    Pelicula find(Object id);

    List<Pelicula> findAll();

    List<Pelicula> findRange(int[] range);

    int count();
    
    boolean SiExistePelicula(Pelicula pelicula);
    
    List<Pelicula> findDirector(String director);
    
    List<Pelicula> findAnyo (Integer anyo);
    
    List<Pelicula> findTitulo (String titulo);
    
}
