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
import javax.faces.bean.ViewScoped;
import ni.gob.minsa.modelo.poblacion.Catalogos;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.sivipcan.controlador.CatalogoEJB;
import ni.gob.minsa.sivipcan.controlador.ComunidadEJB;

@ManagedBean
@RequestScoped
public class CatalogoMB implements Serializable {

    @EJB
    private CatalogoEJB CatalogoEJB;
    private Catalogos persona = new Catalogos();
    private List<Catalogos> listaEtnias = new ArrayList<Catalogos>();
    private List<Catalogos> listaOcupaciones = new ArrayList<Catalogos>();
    private List<Catalogos> listaEscolaridad = new ArrayList<Catalogos>();
    private List<Catalogos> listaProcedencia = new ArrayList<Catalogos>();
    private List<Catalogos> listaTipoExamen = new ArrayList<Catalogos>();
    private List<Catalogos> listaTiposExamen = new ArrayList<Catalogos>();
    private List<Catalogos> listaExamenPAP = new ArrayList<Catalogos>();

    private String Codigo_Etnia = "ETNIA";
    private String Codigo_Ocupacion = "HSF_OCUPA";
    private String Codigo_Escolaridad = "ESCDA";
    private String Codigo_Procedencia = "PROCDNCIA";
    private String Codigo_TipoExamen = "Exasivipca";
    private String Codigo_ExamenPAP = "Exasivipca|PAP";
    private String Valor_Etnia;
    private String Valor_Ocupacion;
    private String Valor_Escolaridad;
    private String Valor_Procedencia;
    private Long Codigo_Comunidad;
    private ComunidadEJB comunidadEJB;

    //Valores de Respuesta para Metodos Anticonceptivos y sus tipos de metodos
    private String Codigo_Respuesta_Metodo_Antc = "RESP|S";
    private String Codigo_Respuesta_Metodo_Antc2 = "RESP|N";
    private String Codigo_Tipo_Metodos_Antc = "METELGANT";
    private List<Catalogos> listaRespuestaMetodo = new ArrayList<Catalogos>();
    private List<Catalogos> listaTipoMetodo = new ArrayList<Catalogos>();
    private Catalogos RespuestaMetodo;
    private Catalogos TipoMetodo;
    private boolean habilitado = false;
    private boolean habilitarFechaMetodo = false;

    
    
    

    public ComunidadEJB getComunidadEJB() {
        return comunidadEJB;
    }
    public void setComunidadEJB(ComunidadEJB comunidadEJB) {
        this.comunidadEJB = comunidadEJB;
    }
    public Long getCodigo_Comunidad() {
        return Codigo_Comunidad;
    }

    public void setCodigo_Comunidad(Long Codigo_Comunidad) {
        this.Codigo_Comunidad = Codigo_Comunidad;
    }

    public CatalogoMB(CatalogoEJB CatalogoEJB) {
        this.CatalogoEJB = CatalogoEJB;
    }

    public String getValor_Escolaridad() {
        return Valor_Escolaridad;
    }

    public void setValor_Escolaridad(String Valor_Escolaridad) {
        this.Valor_Escolaridad = Valor_Escolaridad;
    }

    public String getValor_Ocupacion() {
        return Valor_Ocupacion;
    }

    public void setValor_Ocupacion(String Valor_Ocupacion) {
        this.Valor_Ocupacion = Valor_Ocupacion;
    }

    public CatalogoMB() {
    }

    public CatalogoEJB getCatalogoEJB() {
        return CatalogoEJB;
    }

    public void setCatalogoEJB(CatalogoEJB CatalogoEJB) {
        this.CatalogoEJB = CatalogoEJB;
    }

    public Catalogos getPersona() {
        return persona;
    }

    public void setPersona(Catalogos persona) {
        this.persona = persona;
    }

    public List<Catalogos> getListaEtnias() {
        if (listaEtnias.isEmpty()) {
            listaEtnias = CatalogoEJB.buscarTodasLasEtnias(Codigo_Etnia);
        }

        return listaEtnias;
    }

    public void setListaEtnias(List<Catalogos> listaEtnias) {
        this.listaEtnias = listaEtnias;
    }

    public String getCodigo_Etnia() {
        return Codigo_Etnia;
    }

    public void setCodigo_Etnia(String Codigo_Etnia) {
        this.Codigo_Etnia = Codigo_Etnia;
    }

    public String getValor_Etnia() {
        return Valor_Etnia;

    }

    public void setValor_Etnia(String Valor_Etnia) {
        this.Valor_Etnia = Valor_Etnia;
    }

    public String getCodigo_Ocupacion() {
        return Codigo_Ocupacion;
    }

    public void setCodigo_Ocupacion(String Codigo_Ocupacion) {
        this.Codigo_Ocupacion = Codigo_Ocupacion;
    }

    public String getCodigo_Escolaridad() {
        return Codigo_Escolaridad;
    }

    public void setCodigo_Escolaridad(String Codigo_Escolaridad) {
        this.Codigo_Escolaridad = Codigo_Escolaridad;
    }

    public List<Catalogos> getListaOcupaciones() {
        if (listaOcupaciones.isEmpty()) {
            listaOcupaciones = CatalogoEJB.buscarTodasLasOcupaciones(Codigo_Ocupacion);
        }

        return listaOcupaciones;
    }

    public void setListaOcupaciones(List<Catalogos> listaOcupaciones) {
        this.listaOcupaciones = listaOcupaciones;
    }

    public List<Catalogos> getListaEscolaridad() {

        if (listaEscolaridad.isEmpty()) {
            listaEscolaridad = CatalogoEJB.buscarTodasLasEscolaridades(Codigo_Escolaridad);
        }
        return listaEscolaridad;
    }

    public void setListaEscolaridad(List<Catalogos> listaEscolaridad) {
        this.listaEscolaridad = listaEscolaridad;
    }

    public List<Catalogos> getListaProcedencia() {
        if (listaProcedencia.isEmpty()) {
            listaProcedencia = CatalogoEJB.buscarTodasLasProcedencias(Codigo_Procedencia);
        }

        return listaProcedencia;
    }

    public void setListaProcedencia(List<Catalogos> listaProcedencia) {
        this.listaProcedencia = listaProcedencia;
    }

    public String getCodigo_Procedencia() {
        return Codigo_Procedencia;
    }

    public void setCodigo_Procedencia(String Codigo_Procedencia) {
        this.Codigo_Procedencia = Codigo_Procedencia;
    }

    public String getValor_Procedencia() {
        return Valor_Procedencia;
    }

    public void setValor_Procedencia(String Valor_Procedencia) {
        this.Valor_Procedencia = Valor_Procedencia;
    }

    public void prueba() {
        System.out.println(Valor_Etnia + " mi valor");
    }

    public String getCodigo_Respuesta_Metodo_Antc() {
        return Codigo_Respuesta_Metodo_Antc;
    }

    public void setCodigo_Respuesta_Metodo_Antc(String Codigo_Respuesta_Metodo_Antc) {
        this.Codigo_Respuesta_Metodo_Antc = Codigo_Respuesta_Metodo_Antc;
    }

    public String getCodigo_Tipo_Metodos_Antc() {
        return Codigo_Tipo_Metodos_Antc;
    }

    public void setCodigo_Tipo_Metodos_Antc(String Codigo_Tipo_Metodos_Antc) {
        this.Codigo_Tipo_Metodos_Antc = Codigo_Tipo_Metodos_Antc;
    }

    public List<Catalogos> getListaRespuestaMetodo() {
        if ( listaRespuestaMetodo.isEmpty() ) 
        {
            listaRespuestaMetodo = CatalogoEJB.buscarRespuestasMetodoAntc( Codigo_Respuesta_Metodo_Antc, Codigo_Respuesta_Metodo_Antc2 );
        }
        return listaRespuestaMetodo;
    }

    public void setListaRespuestaMetodo(List<Catalogos> listaRespuestaMetodo) {
        this.listaRespuestaMetodo = listaRespuestaMetodo;
    }

    public List<Catalogos> getListaTipoMetodo() {
         listaTipoMetodo = CatalogoEJB.buscarTipoMetodosAntc( Codigo_Tipo_Metodos_Antc );
        return listaTipoMetodo;
    }

    public void RellenoTipoMetodoAntc() {
        if (RespuestaMetodo.getValor().equals( "Si" ) ) 
        {
           
            habilitado = true;
            habilitarFechaMetodo = true;
        } 
        else {
            if (RespuestaMetodo.getValor().equals( "No" ) ) 
            {
                listaTipoMetodo.clear();
                habilitado = false;
                habilitarFechaMetodo = false;
            }
        }
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isHabilitarFechaMetodo() {
        return habilitarFechaMetodo;
    }

    public void setHabilitarFechaMetodo(boolean habilitarFechaMetodo) {
        this.habilitarFechaMetodo = habilitarFechaMetodo;
    }
 
    public void setListaTipoMetodo(List<Catalogos> listaTipoMetodo) {
        this.listaTipoMetodo = listaTipoMetodo;
    }

    public Catalogos getRespuestaMetodo() {
        return RespuestaMetodo;
    }

    public void setRespuestaMetodo(Catalogos RespuestaMetodo) {
        this.RespuestaMetodo = RespuestaMetodo;
    }

    public Catalogos getTipoMetodo() {
        return TipoMetodo;
    }

    public void setTipoMetodo(Catalogos TipoMetodo) {
        this.TipoMetodo = TipoMetodo;
    }

    public List<Catalogos> getListaTipoExamen(String codigo) {     
        listaTipoExamen = CatalogoEJB.buscarTiposExamen(codigo);
        return listaTipoExamen;
    }

    public void setListaTipoExamenVPH(List<Catalogos> listaTipoExamen) {
        this.listaTipoExamen = listaTipoExamen;
    }

    public List<Catalogos> getListaTiposExamen() {
        listaTipoExamen = CatalogoEJB.buscarTipoExamen(Codigo_TipoExamen);
        return listaTiposExamen;
    }

    public void setListaTiposExamen(List<Catalogos> listaTiposExamen) {
        this.listaTiposExamen = listaTiposExamen;
    }

    public String getCodigo_TipoExamen() {
        return Codigo_TipoExamen;
    }

    public void setCodigo_TipoExamen(String Codigo_TipoExamen) {
        this.Codigo_TipoExamen = Codigo_TipoExamen;
    }
    
    public List<Catalogos> getListaExamenPAP() {
        listaExamenPAP = CatalogoEJB.buscarExamenPAP(Codigo_ExamenPAP);
        return listaExamenPAP;
    }

    public void setListaExamenPAP(List<Catalogos> listaExamenPAP) {
        this.listaExamenPAP = listaExamenPAP;
    }

}
