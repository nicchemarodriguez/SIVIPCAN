/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.modelo.poblacion.Sector;
import ni.gob.minsa.sivipcan.controlador.ComunidadEJB;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@RequestScoped
public class ComunidadMB {

    /**
     * Creates a new instance of ComunidadMB
     */
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
    
    private DivisionPoliticaMB DivisionPoliticaMB = (DivisionPoliticaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{divisionPoliticaMB}", DivisionPoliticaMB.class);

    public ComunidadMB() {
    }

    public List<Comunidad> getListaComunidad() {

//        if (municipioSelect != null) {
//            SectorMB.buscarSectores(municipioSelect.getCodigoNacional());
//            ListaSector = SectorMB.getListaSector();
//        }
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
        return municipioSelect;
    }

    public void setMunicipioSelect(DivisionPolitica municipioSelect) {
        System.out.println("estoy recibiendo el municipio");
        this.municipioSelect = municipioSelect;
    }

    public List<Sector> getListaSector() {
        System.out.println("la estoy pidiendo");
        System.out.println(ListaSector);
        return ListaSector;
    }

    public void setListaSector(List<Sector> ListaSector) {

        this.ListaSector = ListaSector;
    }

    public List<Comunidad> cargarListaComunidad() {
        if (this.getMunicipioSelect() != null) {
            System.out.println("si entre al metodo");
            List<Comunidad> listComunidadTemp;
            ListaSector = SectorMB.buscarSectores(municipioSelect.getCodigoNacional());
            if (ListaSector != null && !ListaSector.isEmpty()) {
                for (int i = 0; i < ListaSector.size(); i++) {
                    listComunidadTemp = comunidadEJB.buscarComunidades(ListaSector.get(i).getCodigo());
                    listaComunidad.addAll(listComunidadTemp);
                }
            }           
        }        
        return listaComunidad;
    }
    
    public List<Comunidad> cargarListaComunidadSelected(long IdComunidadResidencia) {
        Comunidad comunidadTemp;
        Sector sectorTemp;
        DivisionPolitica municipioSelectTemp;
        
        comunidadTemp = comunidadEJB.buscarComunidadesPorId(IdComunidadResidencia).get(0);  
        sectorTemp = SectorMB.buscarSector(comunidadTemp.getSector()).get(0);
        municipioSelectTemp = DivisionPoliticaMB.obtenerMunicipioSelect(sectorTemp.getMunicipio()).get(0);
        
        if (municipioSelectTemp != null) {
            System.out.println("si entre al metodo");
            List<Comunidad> listComunidadTemp;
            ListaSector = SectorMB.buscarSectores(municipioSelectTemp.getCodigoNacional());
            if (ListaSector != null && !ListaSector.isEmpty()) {
                for (int i = 0; i < ListaSector.size(); i++) {
                    listComunidadTemp = comunidadEJB.buscarComunidades(ListaSector.get(i).getCodigo());
                    listaComunidad.addAll(listComunidadTemp);
                }
            }           
        } 


        return listaComunidad;
    }

    public void prueba() {

        System.out.println(ListaSector);

    }

}
