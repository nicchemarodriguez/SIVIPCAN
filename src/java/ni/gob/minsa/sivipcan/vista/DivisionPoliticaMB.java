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
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.sivipcan.controlador.DivisionpoliticaEJB;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@ViewScoped
public class DivisionPoliticaMB implements Serializable{

    @EJB
    private DivisionpoliticaEJB DivisionpoliticaEJB;
    private List<DivisionPolitica> ListaDivisionpolitica = new ArrayList<DivisionPolitica>();
    private List<DivisionPolitica> ListaMunicipios= new ArrayList<DivisionPolitica>();
    
    private DivisionPolitica departametoSelect;
    
    
    public DivisionPoliticaMB() {
    }
    

    public DivisionPoliticaMB(DivisionpoliticaEJB DivisionpoliticaEJB) {
        this.DivisionpoliticaEJB = DivisionpoliticaEJB;
    }
    
    public List<DivisionPolitica> getListaDivisionpolitica() {
        ListaDivisionpolitica = DivisionpoliticaEJB.buscardepartamentos();
        return ListaDivisionpolitica;
    }

    public void setListaDivisionpolitica(List<DivisionPolitica> ListaDivisionpolitica) {
        this.ListaDivisionpolitica = ListaDivisionpolitica;
    }

    public List<DivisionPolitica> getListaMunicipios() { 
        if(departametoSelect != null){
        ListaMunicipios = this.departametoSelect.getDivisionPoliticaList(); 
        }
        return ListaMunicipios;
    }

    public void setListaMunicipios(List<DivisionPolitica> ListaMunicipios) {
        this.ListaMunicipios = ListaMunicipios;
    }

    public DivisionPolitica getDepartametoSelect() {
        return departametoSelect;
    }

    public void setDepartametoSelect(DivisionPolitica departametoSelect) {
        this.departametoSelect = departametoSelect;
    }

    public List<DivisionPolitica> obtenerMunicipioSelect(String codigoMunicipio){
        
        DivisionpoliticaEJB.buscarMunicipios(codigoMunicipio);
        return null;
    }
    
}
