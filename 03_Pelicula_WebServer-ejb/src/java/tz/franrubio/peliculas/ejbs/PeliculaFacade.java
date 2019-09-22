package tz.franrubio.peliculas.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tz.franrubio.peliculas.entities.Pelicula;

/**
 *
 * Clase PeliculaFacade hereda de la clase abstracta Facade e implementa
 * los métodos abstractos de la clase PeliculaFacadeLocal.
 * 
 * @author Francisco J. Rubio
 * @version 1.0
 */

@Stateless
public class PeliculaFacade extends AbstractFacade<Pelicula> implements PeliculaFacadeLocal {

    @PersistenceContext(unitName = "03_Pelicula_WebServer-ejbPU")
    private EntityManager em;

    //Este método devuelve la entidad Manager.
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeliculaFacade() {
        super(Pelicula.class);
    }

    //Este método sobreescribe verificando si una pelicula ya existe en la base 
    //de datos, utilizando para ellos una consulta de la Entidad Pelicula.
    @Override
    public boolean SiExistePelicula(Pelicula pelicula) {
        boolean isExiste = false;
        TypedQuery<Pelicula> qPelicula = em.createNamedQuery("Pelicula.findSiExiste", Pelicula.class);
        qPelicula.setParameter("titulo", pelicula.getTitulo());
        qPelicula.setParameter("director", pelicula.getDirector());
        qPelicula.setParameter("estreno", pelicula.getEstreno());
        List<Pelicula> lista = qPelicula.getResultList();
        if (lista.size() > 0) {
            isExiste = true;
        }
        return isExiste;
    }

    //La sobreescritura de este método busca las películas cuyo director
    //le pasamos por parámetro, y nos devuelve un listado de películas.
    @Override
    public List<Pelicula> findDirector(String director) {
        TypedQuery<Pelicula> qPelicula = em.createNamedQuery("Pelicula.findByDirector", Pelicula.class);
        qPelicula.setParameter("director", director);
        return qPelicula.getResultList();
    }

    //La sobreescritura de este método busca las películas cuyo título 
    //le pasamos por parámetro, y nos devuelve un listado de esas películas.
    @Override
    public List<Pelicula> findTitulo(String titulo) {
        TypedQuery<Pelicula> qPelicula = em.createNamedQuery("Pelicula.findByTitulo", Pelicula.class);
        qPelicula.setParameter("titulo", titulo);
        return qPelicula.getResultList();
    }

    //La sobreescritura de este método busca las películas cuyo año de estreno
    //le pasamos por parárametro, y nos devuelve un listado de esas películas.
    @Override
    public List<Pelicula> findAnyo(Integer anyo) {
        TypedQuery<Pelicula> qPelicula = em.createNamedQuery("Pelicula.findByEstreno", Pelicula.class);
        qPelicula.setParameter("estreno", anyo);
        return qPelicula.getResultList();
    }
}
