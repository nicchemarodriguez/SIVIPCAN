/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ni.gob.minsa.sivipcan.controlador.FechaEJB;
import ni.gob.minsa.sivipcan.modelo.Fecha;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@RequestScoped
public class FechaMB implements Serializable{

    /**
     * Creates a new instance of FechaMB
     */
    @EJB
    private FechaEJB FechaEJB;
    private Fecha Fecha = new Fecha();
    private List<Fecha> fechaList = new ArrayList<Fecha>();
    
    public FechaMB() {
    }

    public FechaEJB getFechaEJB() {
        return FechaEJB;
    }

    public void setFechaEJB(FechaEJB FechaEJB) {
        this.FechaEJB = FechaEJB;
    }

    public Fecha getFecha() {
        return Fecha;
    }

    public void setFecha(Fecha Fecha) {
        this.Fecha = Fecha;
    }

    public List<Fecha> getFechaList() {
        fechaList= FechaEJB.buscarPorValor();
        return fechaList;
    }

    public void setFechaList(List<Fecha> fechaList) {
        this.fechaList = fechaList;
    }
    
    
    
}
