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
import javax.faces.bean.ViewScoped;
import ni.gob.minsa.modelo.poblacion.Sector;
import ni.gob.minsa.sivipcan.controlador.SectorEJB;


@ManagedBean
@ViewScoped
public class SectorMB implements Serializable {

    @EJB
    private SectorEJB sectorEJB;
    private Sector sector = new Sector();
    private List<Sector> listaSector = new ArrayList<Sector>();
    
    public SectorMB() {
    }

    public SectorMB(SectorEJB sectorEJB) {
        this.sectorEJB = sectorEJB;
    }

    public SectorEJB getSectorEJB() {
        return sectorEJB;
    }

    public void setSectorEJB(SectorEJB sectorEJB) {
        this.sectorEJB = sectorEJB;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Sector> getListaSector() {
        listaSector = sectorEJB.buscarTodosLosSectores();
        return listaSector;
    }

    public void setListaSector(List<Sector> listaSector) {
        this.listaSector = listaSector;
    }
    
}
