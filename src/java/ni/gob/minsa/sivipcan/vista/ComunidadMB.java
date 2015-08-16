/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.sivipcan.controlador.ComunidadEJB;

/**
 *
 * @author WIN 7
 */
@Named(value = "comunidadMB")
@Dependent
public class ComunidadMB {

    @EJB
    private ComunidadEJB comunidadEJB;
    private Comunidad comunidad = new Comunidad();
    private List<Comunidad> listaComunidad = new ArrayList<>();
    

    public ComunidadMB() {
    }

    public List<Comunidad> getListaComunidad() {
        listaComunidad = comunidadEJB.buscarTodo();
        return listaComunidad;
    }

    public void setListaComunidad(List<Comunidad> listaComunidad) {
        this.listaComunidad = listaComunidad;
    }

    public ComunidadMB(ComunidadEJB comunidadEJB) {
        this.comunidadEJB = comunidadEJB;
    }

    public ComunidadEJB getComunidadEJB() {
        return comunidadEJB;
    }

    public void setComunidadEJB(ComunidadEJB comunidadEJB) {
        this.comunidadEJB = comunidadEJB;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

}
