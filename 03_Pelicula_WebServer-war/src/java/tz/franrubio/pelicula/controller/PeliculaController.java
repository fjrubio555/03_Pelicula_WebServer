package tz.franrubio.pelicula.controller;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import net.bootsfaces.utils.FacesMessages;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import tz.franrubio.peliculas.ejbs.PeliculaFacadeLocal;
import tz.franrubio.peliculas.entities.Pelicula;
import tz.franrubio.peliculas.utils.UtilsPeliculas;
import tz.franrubio.peliculas.utils.UtilsPeliculas.TipoOperacion;

/**
 * Clase Java PeliculaController.
 *
 * Es el controlador de la entidad de Pelicula de la base de datos básicamente
 * es el interactuador entre la parte visual y la parte lógica.
 *
 * @author Francisco J. Rubio
 * @version 1.0
 */

@Named(value = "peliculaController")
@SessionScoped
public class PeliculaController implements Serializable {

    @EJB
    private PeliculaFacadeLocal peliculaFacade;
    private Pelicula p = new Pelicula();
    private Pelicula selecPeli = new Pelicula();
    private List<Pelicula> listapelis;
    private String paramBusq;

    public PeliculaController() {
    }

    public Pelicula getP() {
        return p;
    }

    public void setP(Pelicula p) {
        this.p = p;
    }

    public List<Pelicula> getListapelis() {

        if ((listapelis == null)) {
            listapelis = new ArrayList<Pelicula>();
        }

        return listapelis;
    }

    public void setListapelis(List<Pelicula> listapelis) {
        this.listapelis = listapelis;
    }

    public String getParamBusq() {
        return paramBusq;
    }

    public void setParamBusq(String paramBusq) {
        this.paramBusq = paramBusq;
    }

    public Pelicula getSelecPeli() {
        return selecPeli;
    }

    public void setSelecPeli(Pelicula selecPeli) {
        this.selecPeli = selecPeli;
    }

    //Nos indicia la pelicula que hemos seleccionamos.
    //@param: peli: Pelicula selecionada en la tabla de datos.
    //        indexes: Indice de la pelicula seleccionada en la tabla de datos  
    public void seleccionar(Pelicula peli, String indexes) {
        if (null != peli) {
            this.selecPeli = peli;
        } else if (null != indexes) {
            int i = Integer.parseInt(indexes);
            this.selecPeli = listapelis.get(i);

        }
    }

    //Este método nos sirve para que nos devuelve la cabecera según el tipo
    //de busqueda que hemos realizado. Le pasamos el parámetro de la
    //busqueda a realizar.
    public String modalCabecera() {
        String titulocab = " ";
        String param = UtilsPeliculas.getParametro("busqueda");
        switch (param) {

            case "BusqDirector":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("NavPeliculaD");
                break;
            case "BusqPelicula":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("NavPeliculaT");
                break;
            case "BusqAnyo":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("NavPeliculaA");
                break;
            default:
                titulocab = " ";
                break;
        }
        return titulocab;
    }

    //Este método coger el parametro de la pagina Web "busqueda" y según su
    //valor nos devuelve la etiqueta del título que corresponda.
    public String modalTituloLabel() {
        String titulocab = " ";
        String param = UtilsPeliculas.getParametro("busqueda");
        switch (param) {

            case "BusqDirector":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("EtiquetaDirector");
                break;
            case "BusqPelicula":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("EtiquetaTitulo");
                break;
            case "BusqAnyo":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("EtiquetaAnoEstreno");
                break;
            default:
                titulocab = " ";
                break;
        }
        return titulocab;
    }

    //Este método coger el parametro de la pagina Web "busqueda" y según su
    //valor nos devuelve el texto que es requerido en los campos que corresponda.
    public String modalTituloLabelReq() {
        String titulocab = " ";
        String param = UtilsPeliculas.getParametro("busqueda");
        switch (param) {

            case "BusqDirector":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("MensajeroDirectorReq");
                break;
            case "BusqPelicula":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("MensajeroTituloReq");
                break;
            case "BusqAnyo":
                titulocab = ResourceBundle.getBundle("/Mensajero").getString("MensajeroAnyoReq");
                break;
            default:
                titulocab = " ";
                break;
        }
        return titulocab;
    }

    //Este método devuelve una lista de peliculas según si deseamos
    //hacer una busqueda o no, en ese caso muestra todo el conjunto 
    //de peliculas.
    public List<Pelicula> Busqueda() {
        String param = UtilsPeliculas.getParametro("busqueda");
        String msg = null;
        String summ = null;

        if (listapelis == null) {
            listapelis = new ArrayList<Pelicula>();
        }
        try {
            if (paramBusq != null && listapelis != null) {
                
                switch (param) {
                    case "BusqTodas":
                        listapelis = peliculaFacade.findAll();
                        break;
                    case "BusqDirector":

                        listapelis = peliculaFacade.findDirector(paramBusq.toLowerCase().trim());
                        msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorBusqDirector");
                        break;
                    case "BusqPelicula":
                        listapelis = peliculaFacade.findTitulo(paramBusq.toLowerCase().trim());
                        msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorBusqTituto");
                        break;
                    case "BusqAnyo":
                        int paramAnyo = Integer.parseInt(paramBusq.toLowerCase().trim());
                        listapelis = peliculaFacade.findAnyo(paramAnyo);
                        msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorBusqAnyo");

                        break;
                    default:
                        listapelis = new ArrayList<Pelicula>();
                        break;

                }
            } else {
                if ("BusqTodas".equals(param)) {
                    listapelis = peliculaFacade.findAll();
                }
            }

//        } catch (EJBException ex) {
//            CausaError(ex);
        } catch (Exception ex) {
            msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorPersitencia");
            summ = ResourceBundle.getBundle("/Mensajero").getString("Error");
            FacesMessages.error(summ, msg);
        }
        if (!(listapelis.size() > 0) && (paramBusq != null)) {
            listapelis = new ArrayList<Pelicula>();
            summ = ResourceBundle.getBundle("/Mensajero").getString("Info");
            FacesMessages.info(summ, msg);

        }
        paramBusq = null;
        return listapelis;
    }

    public List<Pelicula> findAll() {
        return peliculaFacade.findAll();
    }

    public void add() {
        String msg;
        String itemRef = "formanyadir:btnAnyadir"; //Componente EL de la vista
        String summ;
        try {
            if (peliculaFacade.SiExistePelicula(p) == false) {
                peliculaFacade.create(p);
                msg = ResourceBundle.getBundle("/Mensajero").getString("MensajeCreacion");
            } else {
                msg = ResourceBundle.getBundle("/Mensajero").getString("MensajeYaExiste");
            }
            summ = ResourceBundle.getBundle("/Mensajero").getString("Info");
            FacesMessages.info(itemRef, summ, msg);

//        } catch (EJBException ex) {
//            CausaError(ex);
        } catch (Exception ex) {
            summ = ResourceBundle.getBundle("/Mensajero").getString("Error");
            msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorPersitencia");
            FacesMessages.error(itemRef, summ, msg);
        }
        p = new Pelicula();
    }

    public void editar() {
        
        if (peliculaFacade.SiExistePelicula(selecPeli) == false) {
            String msg = ResourceBundle.getBundle("/Mensajero").getString("MensajeModificacion");
            p = selecPeli;
            peliPersistencia(TipoOperacion.EDITAR, msg, p);
        }
    }

    public void borrar() {
        Pelicula peli = selecPeli;
        String msg = ResourceBundle.getBundle("/Mensajero").getString("MensajeBorrar");
        peliPersistencia(TipoOperacion.BORRAR, msg, peli);
    }

    //Método de Persistencia si la operación no es borrar edita/actualiza la pelicula
    //sino la borra.
    private void peliPersistencia(TipoOperacion tipoOpe, String msgEntrada, Pelicula peli) {
        String summ = ResourceBundle.getBundle("/Mensajero").getString("Info");
        if (peli != null) {

            try {
                if (tipoOpe != TipoOperacion.BORRAR) {

                    peliculaFacade.edit(peli);
                    
                } else {

                    listapelis.remove(peli);
                    peliculaFacade.remove(peli);
                }
                p = new Pelicula();

                FacesMessages.info(summ, msgEntrada);
//            } catch (EJBException ex) {
//                CausaError(ex);
            } catch (Exception ex) {

                summ = ResourceBundle.getBundle("/Mensajero").getString("Error");
                String msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorPersitencia");
                FacesMessages.error(summ, msg);
            }
        }
    }

    private void CausaError(EJBException ex) {
        String msg = "";
        String summ = ResourceBundle.getBundle("/Mensajero").getString("Error");
        Throwable cause = ex.getCause();
        if (cause != null) {
            msg = cause.getLocalizedMessage();
        }
        if (msg.length() > 0) {
            msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorControlador") + "Tipo: " + msg;
            FacesMessages.error(summ, msg);
        } else {
            msg = ResourceBundle.getBundle("/Mensajero").getString("ErrorPersitencia");
            FacesMessages.error(summ, msg);
        }
    }

    //Método que indica que la celda es o no editable
    public String editAction(Pelicula peli) {

        p.setEditable(true);
        return null;
    }

}
