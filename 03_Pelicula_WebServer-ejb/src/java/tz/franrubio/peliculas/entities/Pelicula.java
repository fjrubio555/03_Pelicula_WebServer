package tz.franrubio.peliculas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Java Pelicula. 
 * 
 * @author Francisco J. Rubio
 * @version 1.0
 */

@Entity
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findById", query = "SELECT p FROM Pelicula p WHERE p.id = :id")
    , @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE LOWER(p.titulo) LIKE LOWER(CONCAT(CONCAT('%',:titulo),'%'))")
    , @NamedQuery(name = "Pelicula.findByDirector", query = "SELECT p FROM Pelicula p WHERE LOWER(p.director) LIKE LOWER(CONCAT(CONCAT('%',:director),'%'))")
    , @NamedQuery(name = "Pelicula.findByEstreno", query = "SELECT p FROM Pelicula p WHERE p.estreno = :estreno")
    , @NamedQuery(name = "Pelicula.findSiExiste", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo AND p.director = :director AND p.estreno = :estreno")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
  
    @Column(name = "director")
    private String director;
    @Basic(optional = false)

    @Column(name = "estreno")
    private Integer estreno;

    //Esta maquetación permite añadir una variable incando que no es propia
    //de la tabla.
    @Transient 
    private boolean editable;

    public Pelicula() {
    }

    public Pelicula(Integer id) {
        this.id = id;
    }

    public Pelicula(Integer id, String titulo, String director, Integer estreno) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director.trim();
    }

    public Integer getEstreno() {
        return estreno;
    }

    public void setEstreno(Integer estreno) {
        this.estreno = estreno;
    }

    public void edit() {
        editable = !editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tz.franrubio.peliculas.entities.Pelicula[ Id=" + id + " Título=" + titulo + " ]";
    }

}
