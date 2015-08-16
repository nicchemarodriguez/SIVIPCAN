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

import ni.gob.minsa.modelo.estructura.EntidadAdtva;
import ni.gob.minsa.modelo.estructura.Unidad;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.sivipcan.controlador.EntidadAdtvaEJB;
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.modelo.poblacion.Sector;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@RequestScoped
public class EntidadAdtvaMB implements Serializable {

     @EJB
     private EntidadAdtvaEJB entidadAdvEJB;
    
     
     
     
    
    private EntidadAdtva silais = new EntidadAdtva();
    private EntidadAdtva silais_Registra;
    private DivisionPolitica municipio;
    private DivisionPolitica municipio_Registra;
    private Unidad unidad;
    private Unidad unidad_Registra;
    private List<EntidadAdtva> listaEntidadAdtva = new ArrayList<EntidadAdtva>();
    private List<DivisionPolitica> listaMunicipio = new ArrayList<DivisionPolitica>();
    private List<EntidadAdtva> listaEntidadAdtvaRegistra = new ArrayList<EntidadAdtva>();
    private List<DivisionPolitica> listaMunicipioRegistra = new ArrayList<DivisionPolitica>();
    private List<Unidad> listaUnidades = new ArrayList<Unidad>();
    private List<Unidad> listaUnidadesRegistra = new ArrayList<Unidad>();
    private List<DivisionPolitica> listaCSEdeMunicipios = new ArrayList<DivisionPolitica>();

    private EntidadAdtva silaisEntrega = new EntidadAdtva();
    private List<DivisionPolitica> listaMunicipioE = new ArrayList<DivisionPolitica>();
    private List<Unidad> listaUnidadesE = new ArrayList<Unidad>();
     private DivisionPolitica municipioE;
     private Unidad unidadE;
//davis parte
      private Unidad unidadDm = new Unidad();
    private DivisionPolitica municipioRc = new DivisionPolitica();
    private DivisionPolitica municipioDm = new DivisionPolitica();
    private EntidadAdtva silaisDM = new EntidadAdtva();
    private List<DivisionPolitica> listaMunicipioDm = new ArrayList<DivisionPolitica>();
    private List<Unidad> listaUnidadesDm = new ArrayList<Unidad>();
    private Unidad unidadTomaDm = new Unidad();
    private DivisionPolitica municipioTomaRc = new DivisionPolitica();
    private DivisionPolitica municipioTomaDm = new DivisionPolitica();
    private EntidadAdtva silaisTomaDM = new EntidadAdtva();
    private List<DivisionPolitica> listaMunicipioTomaDm = new ArrayList<DivisionPolitica>();
    private List<Unidad> listaUnidadesTomaDm = new ArrayList<Unidad>();
    //fin davis
    
    public List<DivisionPolitica> getListaCSEdeMunicipios(String cod) {
        listaCSEdeMunicipios = entidadAdvEJB.CODIGOCSE(cod);
        return listaCSEdeMunicipios;
    }

    public void setListaCSEdeMunicipios(List<DivisionPolitica> listaCSEdeMunicipios) {
        this.listaCSEdeMunicipios = listaCSEdeMunicipios;
    }

    public List<Unidad> getListaUnidadesRegistra() {
        return listaUnidadesRegistra;
    }

    public void setListaUnidadesRegistra(List<Unidad> listaUnidadesRegistra) {
        this.listaUnidadesRegistra = listaUnidadesRegistra;
    }

    public String getMunicipioRegistraSelect() {
        return MunicipioRegistraSelect;
    }

    public void setMunicipioRegistraSelect(String MunicipioRegistraSelect) {
        this.MunicipioRegistraSelect = MunicipioRegistraSelect;
    }
    private String MunicipioRegistraSelect;

    public List<DivisionPolitica> getListaMunicipioRegistra() {
        return listaMunicipioRegistra;
    }

    public void setListaMunicipioRegistra(List<DivisionPolitica> listaMunicipioRegistra) {
        this.listaMunicipioRegistra = listaMunicipioRegistra;
    }

    //Lista de Silais de registro
    public List<EntidadAdtva> getListaEntidadAdtvaRegistra() {
       // listaEntidadAdtvaRegistra = entidadAdvEJB.buscarTodasLasEntidadesAdtv();
        return listaEntidadAdtvaRegistra;
    }

    public void setListaEntidadAdtvaRegistra(List<EntidadAdtva> listaEntidadAdtvaRegistra) {
        this.listaEntidadAdtvaRegistra = listaEntidadAdtvaRegistra;
    }

    public EntidadAdtvaMB(EntidadAdtvaEJB entidadAdvEJB, EntidadAdtva municipios) {
        this.entidadAdvEJB = entidadAdvEJB;
    }

    public List<Unidad> getListaUnidades() {
        return listaUnidades;
    }

    public void setListaUnidades(List<Unidad> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    public EntidadAdtvaMB(EntidadAdtvaEJB entidadAdvEJB) {
        this.entidadAdvEJB = entidadAdvEJB;
    }

    public List<DivisionPolitica> getListaMunicipio() {
        return listaMunicipio;
    }

    public void setListaMunicipio(List<DivisionPolitica> listaMunicipio) {
        this.listaMunicipio = listaMunicipio;
    }

    public EntidadAdtvaMB() {
    }

    public EntidadAdtvaEJB getEntidadAdvEJB() {
        return entidadAdvEJB;
    }

    public void setEntidadAdvEJB(EntidadAdtvaEJB entidadAdvEJB) {
        this.entidadAdvEJB = entidadAdvEJB;
    }

    public EntidadAdtva getSilais() {
        return silais;
    }

    public void setSilais(EntidadAdtva silais) {
        this.silais = silais;
    }

    public List<EntidadAdtva> getListaEntidadAdtva() {
        listaEntidadAdtva = entidadAdvEJB.buscarTodasLasEntidades();
        return listaEntidadAdtva;
    }

    public void setListaEntidadAdtva(List<EntidadAdtva> listaEntidadAdtva) {
        this.listaEntidadAdtva = listaEntidadAdtva;
    }

    public void relleno() {
       // listaMunicipio = entidadAdvEJB.buscarPorMunicipios(silais.getEntidadAdtvaId());
    }

    public void relleno2() {
      //  listaUnidades = entidadAdvEJB.buscarPorUnidades(municipio.getCodigoNacional());
    }

    //Metodo para completar combo de municipio de silais que registra
    public void relleno3() {
      //  listaMunicipioRegistra = entidadAdvEJB.buscarPorMunicipios(silais_Registra.getEntidadAdtvaId());
    }

    public void relleno4() {
    //   listaUnidadesRegistra = entidadAdvEJB.buscarPorUnidades(municipio_Registra.getCodigoNacional());
    }

    public EntidadAdtva getSilais_Registra() {
        return silais_Registra;
    }

    public void setSilais_Registra(EntidadAdtva silais_Registra) {
        this.silais_Registra = silais_Registra;
    }

    public DivisionPolitica getMunicipio() {
        return municipio;
    }

    public void setMunicipio(DivisionPolitica municipio) {
        this.municipio = municipio;
    }

    public DivisionPolitica getMunicipio_Registra() {
        return municipio_Registra;
    }

    public void setMunicipio_Registra(DivisionPolitica municipio_Registra) {
        this.municipio_Registra = municipio_Registra;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Unidad getUnidad_Registra() {
        return unidad_Registra;
    }

    public void setUnidad_Registra(Unidad unidad_Registra) {
        this.unidad_Registra = unidad_Registra;
    }

    public EntidadAdtva getSilaisEntrega() {
        return silaisEntrega;
    }

    public void setSilaisEntrega(EntidadAdtva silaisEntrega) {
        this.silaisEntrega = silaisEntrega;
    }

    public List<DivisionPolitica> getListaMunicipioE() {
        return listaMunicipioE;
    }

    public void setListaMunicipioE(List<DivisionPolitica> listaMunicipioE) {
        this.listaMunicipioE = listaMunicipioE;
    }

    public List<Unidad> getListaUnidadesE() {
        return listaUnidadesE;
    }

    public void setListaUnidadesE(List<Unidad> listaUnidadesE) {
        this.listaUnidadesE = listaUnidadesE;
    }

    public DivisionPolitica getMunicipioE() {
        return municipioE;
    }

    public void setMunicipioE(DivisionPolitica municipioE) {
        this.municipioE = municipioE;
    }

    public Unidad getUnidadE() {
        return unidadE;
    }

    public void setUnidadE(Unidad unidadE) {
        this.unidadE = unidadE;
    }

    public void rellenoMunicipioEntrega() {
     //   listaMunicipioE = entidadAdvEJB.buscarPorMunicipios(silaisEntrega.getEntidadAdtvaId());
    }
    public void rellenoUnidadEntrega() {
        //listaUnidadesE = entidadAdvEJB.buscarPorUnidades(municipioE.getCodigoNacional());
    }

    public Unidad getUnidadDm() {
        return unidadDm;
    }

    public void setUnidadDm(Unidad unidadDm) {
        this.unidadDm = unidadDm;
    }

    public DivisionPolitica getMunicipioRc() {
        return municipioRc;
    }

    public void setMunicipioRc(DivisionPolitica municipioRc) {
        this.municipioRc = municipioRc;
    }

    public DivisionPolitica getMunicipioDm() {
        return municipioDm;
    }

    public void setMunicipioDm(DivisionPolitica municipioDm) {
        this.municipioDm = municipioDm;
    }

    public EntidadAdtva getSilaisDM() {
        return silaisDM;
    }

    public void setSilaisDM(EntidadAdtva silaisDM) {
        this.silaisDM = silaisDM;
    }

    public List<DivisionPolitica> getListaMunicipioDm() {
        return listaMunicipioDm;
    }

    public void setListaMunicipioDm(List<DivisionPolitica> listaMunicipioDm) {
        this.listaMunicipioDm = listaMunicipioDm;
    }

    public List<Unidad> getListaUnidadesDm() {
        return listaUnidadesDm;
    }

    public void setListaUnidadesDm(List<Unidad> listaUnidadesDm) {
        this.listaUnidadesDm = listaUnidadesDm;
    }

    public Unidad getUnidadTomaDm() {
        return unidadTomaDm;
    }

    public void setUnidadTomaDm(Unidad unidadTomaDm) {
        this.unidadTomaDm = unidadTomaDm;
    }

    public DivisionPolitica getMunicipioTomaRc() {
        return municipioTomaRc;
    }

    public void setMunicipioTomaRc(DivisionPolitica municipioTomaRc) {
        this.municipioTomaRc = municipioTomaRc;
    }

    public DivisionPolitica getMunicipioTomaDm() {
        return municipioTomaDm;
    }

    public void setMunicipioTomaDm(DivisionPolitica municipioTomaDm) {
        this.municipioTomaDm = municipioTomaDm;
    }

    public EntidadAdtva getSilaisTomaDM() {
        return silaisTomaDM;
    }

    public void setSilaisTomaDM(EntidadAdtva silaisTomaDM) {
        this.silaisTomaDM = silaisTomaDM;
    }

    public List<DivisionPolitica> getListaMunicipioTomaDm() {
        return listaMunicipioTomaDm;
    }

    public void setListaMunicipioTomaDm(List<DivisionPolitica> listaMunicipioTomaDm) {
        this.listaMunicipioTomaDm = listaMunicipioTomaDm;
    }

    public List<Unidad> getListaUnidadesTomaDm() {
        return listaUnidadesTomaDm;
    }

    public void setListaUnidadesTomaDm(List<Unidad> listaUnidadesTomaDm) {
        this.listaUnidadesTomaDm = listaUnidadesTomaDm;
    }
    
    
    
    
  
    
    
    
    

    public void rellenoUnidades() {
        listaUnidadesTomaDm = entidadAdvEJB.buscarPorUnidades(silaisTomaDM.getEntidadAdtvaId());
    }
    
    
    
    
   public void rellenoMunicipio() {
        municipioTomaDm = entidadAdvEJB.buscarPorMunicipios(unidadTomaDm.getMunicipio()).get(0);
    }
   
   public void rellenoRUnidades(){
   listaUnidadesDm= entidadAdvEJB.buscarPorUnidades(silaisDM.getEntidadAdtvaId());
   
   }
   
   public void rellenoRMunicipios(){
   
      municipioDm = entidadAdvEJB.buscarPorMunicipios(unidadDm.getMunicipio()).get(0);
   
   
   }
   
   
   
   
   
   
   
   
   
   
   
  
    
    
}
