/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.modelo.poblacion.Sector;
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
    private List<Comunidad> listaComunidad = new ArrayList<Comunidad>();
    private List<Sector> ListaSector = new ArrayList<Sector>();

    private DivisionPolitica municipioSelect;

    private SectorMB SectorMB = (SectorMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{sectorMB}", SectorMB.class);

    public ComunidadMB() {
    }

    public List<Comunidad> getListaComunidad() {

//        if (municipioSelect != null) {
//            SectorMB.buscarSectores(municipioSelect.getCodigoNacional());
//            ListaSector = SectorMB.getListaSector();
//        }
//
//        if (ListaSector != null && !ListaSector.isEmpty()) {
//            for (int i = 0; i < ListaSector.size(); i++) {
//                listaComunidad.addAll((Collection<? extends Comunidad>) comunidadEJB.buscarComunidades(ListaSector.get(i).getSectorId()));
//            }
//        }

        //listaComunidad = comunidadEJB.buscarTodo();
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

    public DivisionPolitica getMunicipioSelect() {
       System.out.println("sergio peluche  " + municipioSelect.getNombre());
        return municipioSelect;
    }

    public void setMunicipioSelect(DivisionPolitica municipioSelect) {
        System.out.println("bbdndnsmmasn biennnnnnn  " + municipioSelect.getNombre());
       
            System.out.println("Aki si funciona");
          
          //  ListaSector = SectorMB.getListaSector();
      //  System.out.println("aqui tambien esta bien"+ ListaSector.size());
            SectorMB.buscarSectores(municipioSelect.getCodigoNacional());  
            
      
        this.municipioSelect = municipioSelect;
    }

    public List<Sector> getListaSector() {
        System.out.println("Nulo");
        
     //   cargarSector();
        ListaSector = SectorMB.getListaSectorBusqueda();
        System.out.println("aqui tambien esta bien"+ ListaSector.size());
        if(ListaSector.isEmpty()){
            System.out.println("lista vacia idiota");
        }
        return ListaSector;
    }

    public void setListaSector(List<Sector> ListaSector) 
    {
        this.ListaSector = ListaSector;
    }

    public void cargarSector()
    {
        //  System.out.println("sergio peluche  " + municipioSelect.getNombre());
       
        System.out.println("Nulo numero 2");
    }
}
