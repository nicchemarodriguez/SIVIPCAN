/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.modelo.estructura.EntidadAdtva;
import ni.gob.minsa.modelo.estructura.Unidad;
import ni.gob.minsa.modelo.persona.SisPersonas;
import ni.gob.minsa.modelo.poblacion.Catalogos;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.modelo.poblacion.Sector;
import ni.gob.minsa.sivipcan.controlador.ExamenEJB;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.Examen;
import ni.gob.minsa.sivipcan.modelo.Fxexu;
import ni.gob.minsa.sivipcan.modelo.FxexuPK;
import ni.gob.minsa.sivipcan.modelo.ResultadoExamen;
import ni.gob.minsa.sivipcan.modelo.SisMedicos;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import ni.gob.minsa.sivipcan.modelo.UnidadesXExamen;
import ni.gob.minsa.sivipcan.modelo.Valores;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@ViewScoped
public class ExamenMB implements Serializable {

    @EJB
    private ExamenEJB ExamenEJB;

    private Date fechaNac;
    private boolean skip;

    int n = 0;

    private String Estado;
    private Date Fecha_Toma_Muestra_mostrar;
    private String ResultadoFinal;
    private String NumeroLamina;
    private String TipoExamenMostrar;
    private String Ventana = "DtsGnrals";

    private String numeroCel;
    private String cedula;
    private Examen examen = new Examen();
    private Examen examen2;
    private Catalogos metodoAnticonceptivo;
    private Catalogos catalogos;
    private Catalogos tipoExSegui;
    private Catalogos cat_esc;
    private Catalogos Valor_Etnia;
    private Catalogos valor_Procedencia;
    private Catalogos valor_TipoExamen;
    private List<Catalogos> catlista = new ArrayList<Catalogos>();
    private Examen ExamenSelect = new Examen();

    private List<Examen> listaExamen = new ArrayList<Examen>();
    private List<Examen> listaExamenPendiente = new ArrayList<Examen>();
    private List<Examen> listaExamenCompleto = new ArrayList<Examen>();
    private List<Examen> listaSRExamen = new ArrayList<Examen>();
    private List<Examen> listaPrimerParteExamen = new ArrayList<Examen>();

    private Categoria categoria = new Categoria();

//codigo angelo unidades
    private List<UnidadesXExamen> unidadesExamen = new ArrayList<UnidadesXExamen>();
    private Unidad unidadTomaMuestra;
    private UnidadesXExamen unidadOcurrencia = new UnidadesXExamen();
    private UnidadesXExamen unidadResidencia = new UnidadesXExamen();
    private EntidadAdtva silaisTomaDM;
    private List<EntidadAdtva> listaEntidadAdtva = new ArrayList<EntidadAdtva>();
    private Unidad unidadTomaDm;
    private List<Unidad> listaUnidadesTomaDm = new ArrayList<Unidad>();
    private DivisionPolitica municipioTomaDm;

    //codigo angelo residencia
    //private List<DivisionPolitica> listaDepartamentos = new ArrayList<DivisionPolitica>();
//    private List<DivisionPolitica> listaMunicipios = new ArrayList<DivisionPolitica>();
    private DivisionPolitica departamentoSelect;
    private DivisionPolitica municipioSelect;
    private List<Sector> sectores = new ArrayList<Sector>();
    private List<Comunidad> comunidades = new ArrayList<Comunidad>();
    private Comunidad comunidadSelect;
    private Sector sectorSelect;

    /**
     * Obtener unidades de salud y municipio en la pestaña resultado
     */
    private EntidadAdtva silaisTomaResultado;
    private List<EntidadAdtva> listaEntidadAdtvaResultado = new ArrayList<EntidadAdtva>();
    private Unidad unidadTomaResultado;
    private List<Unidad> listaUnidadesTomaResultado = new ArrayList<Unidad>();
    private DivisionPolitica municipioTomaResultado;

//Codigo Angelo
    private List<ResultadoExamen> resultadoExamen = new ArrayList<ResultadoExamen>();
    private List<ResultadoExamen> listaresultadosExamen = new ArrayList<ResultadoExamen>();

    //--
    private Valores valorFuma = new Valores();
    private Valores valorToma = new Valores();
    private Valores valorEmbarazoActual = new Valores();
    private int Gestasi;
    private int Abortosi;
    private int Cesareasi;
    private int IVSAi = 9;
    private int Menarcai = 9;
    private int semanaDeGestasi;
    private int partosi;
    private Date FUR;
    private Valores valorProcedencia;
    private Valores valorAspecto;
    private Valores valorSecrecion;
    private SubCategoria subCategoriaFrotis = new SubCategoria();
    private Valores valorFrotis;
    private SubCategoria subCategoriaResultado = new SubCategoria();
    private Valores valorResultado;
    private CategoriaMB CategoriaMB = (CategoriaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{categoriaMB}", CategoriaMB.class);
    private SubCategoriaMB SubCategoriaMB = (SubCategoriaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{subCategoriaMB}", SubCategoriaMB.class);
    private ValoresMB ValoresMB = (ValoresMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{valoresMB}", ValoresMB.class);
    ;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //--
    
    private ResultadoExamen[] re;

//--
    private SisMedicos medicoSelect = new SisMedicos();

    private ResultadoExamen resultadExamen1 = new ResultadoExamen();
    private ResultadoExamen resultadExamen2 = new ResultadoExamen();
    private ResultadoExamen resultadExamen3 = new ResultadoExamen();
    private ResultadoExamen resultadExamen4 = new ResultadoExamen();

    private ResultadoExamen re1 = new ResultadoExamen();
    private ResultadoExamen re2 = new ResultadoExamen();
    private ResultadoExamen re3 = new ResultadoExamen();
    private ResultadoExamen re4 = new ResultadoExamen();
    private ResultadoExamen re5 = new ResultadoExamen();
    private ResultadoExamen re6 = new ResultadoExamen();
    private ResultadoExamen re7 = new ResultadoExamen();
    private ResultadoExamen re8 = new ResultadoExamen();
    private ResultadoExamen re9 = new ResultadoExamen();
    private ResultadoExamen re10 = new ResultadoExamen();
    private ResultadoExamen re11 = new ResultadoExamen();
    private ResultadoExamen re12 = new ResultadoExamen();
    private ResultadoExamen re13 = new ResultadoExamen();
    private ResultadoExamen re14 = new ResultadoExamen();
    private ResultadoExamen re15 = new ResultadoExamen();

    private boolean HabilitarDireccion = false;
    private boolean HabilitarSemanasGestacion = false;
    private boolean HabilitarPrimerNombre = false;
    private boolean HabilitarSegundoNombre = false;
    private boolean HabilitarPrimerApellido = false;
    private boolean HabilitarSegundoApellido = false;
    private boolean HabilitarCedula = false;
    private boolean HabilitarFechaNacimiento = false;
    private boolean HabilitarComboEscolaridad = false;
    private boolean HabilitarComboOcupacion = false;
    private boolean HabilitarComboEtnia = false;
    private boolean HabilitarComboProcedencia = false;
    private boolean HabilitarComboComunidad = false;
    private boolean HabilitarComboBarrio = false;
    private boolean HabilitarNumExpediente = false;
    private boolean HabilitarExpedienteTemp = false;
    private boolean HabilitarTelefono1 = false;
    private boolean HabilitarTelefono2 = false;
    private boolean ValordeChecbox;
    private boolean nuevoPaciente = false;
    private boolean continuarPaciente = false;

    //declaraciones para fecha
    private List<Fxexu> fechalista = new ArrayList<Fxexu>();
    private FechaMB FechaMB = (FechaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{fechaMB}", FechaMB.class);

    private CatalogoMB CatalogoMB = (CatalogoMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{catalogoMB}", CatalogoMB.class);

    private DivisionPoliticaMB DivisionPoliticaMB = (DivisionPoliticaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{divisionPoliticaMB}", DivisionPoliticaMB.class);

    private ComunidadMB ComunidadMB = (ComunidadMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{comunidadMB}", ComunidadMB.class);

    //------
    private EntidadAdtvaMB entidadAdtvaMB = (EntidadAdtvaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{entidadAdtvaMB}", EntidadAdtvaMB.class);
    public String nombreCompleto;
    public String[] a;
    private Date fecha;
    private Date Fecha_Metodo_Anticonceptivo;
    private Date Fecha_PAP;
    private Date Fecha_VPH;
    private Date Fecha_Biopsia;
    private Date fecha_Lectura;
    private Date fecha_Entrega_Usuario;
    private Date Fecha_PosTratamiento;
    private Date Fecha_Seguimiento;
    private Date fecha_IVAA;
    private PersonaMB PersonaMB = (PersonaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{personaMB}", PersonaMB.class);
    private SisPersonas Persona;
    private List<SisPersonas> listaPersonas = new ArrayList<SisPersonas>();

    private String datosAbiertos_Recomendaciones;

    private Valores valorObservacion;

    public ExamenMB() {
    }

    public SisMedicos getMedicoSelect() {
        return medicoSelect;
    }

    public void setMedicoSelect(SisMedicos medicoSelect) {
        this.medicoSelect = medicoSelect;
    }

    public ExamenMB(ExamenEJB ExamenEJB, Date fechaNac, boolean skip, String numeroCel, String cedula, Examen examen2, Catalogos catalogos, Catalogos cat_esc, Catalogos Valor_Etnia, Catalogos valor_Procedencia, Categoria categoriaResultado, SubCategoria SubCategoriaFuma, SubCategoria SubCategoriaToma, SubCategoria SubCategoriaEmbarazoActual, Valores valorFuma, Valores valorToma, Valores valorEmbarazoActual, Valores valorFrotis, Valores valorResultado, Categoria Antecedentes, SubCategoria AntecedentesAbiertos, SubCategoria Fuma, SubCategoria Toma, SubCategoria EmbarazoActual, Valores VarFuma, Valores VarToma, Valores VarEmbarazoActual, Valores Gestas, Valores Partos, Valores Cesareaa, Valores IVSA, Valores semanaGestas, Valores menarca, Valores abortos, Valores FURV, int Gestasi, int Abortosi, int Cesareasi, int IVSAi, int Menarcai, int semanaDeGestasi, int partosi, Date FUR, boolean ValordeChecbox, SubCategoria Procedencia, SubCategoria AspectoClinico, SubCategoria Secrecion, Valores valorProcedencia, Valores valorAspecto, Valores valorSecrecion, String nombreCompleto, String[] a, Date fecha, Date Fecha_Metodo_Anticonceptivo, Date Fecha_VPH, Date Fecha_Biopsia, Date fecha_Lectura, Date fecha_Entrega_Usuario, Date Fecha_PosTratamiento, Date Fecha_Seguimiento, Date fecha_IVAA, SisPersonas Persona, SubCategoria observacion, Valores valorObservacion) {
        this.ExamenEJB = ExamenEJB;
        this.fechaNac = fechaNac;
        this.skip = skip;
        this.numeroCel = numeroCel;
        this.cedula = cedula;
        this.examen2 = examen2;
        this.catalogos = catalogos;
        this.cat_esc = cat_esc;
        this.Valor_Etnia = Valor_Etnia;
        this.valor_Procedencia = valor_Procedencia;

        this.Gestasi = Gestasi;
        this.Abortosi = Abortosi;
        this.Cesareasi = Cesareasi;
        this.IVSAi = IVSAi;
        this.Menarcai = Menarcai;
        this.semanaDeGestasi = semanaDeGestasi;
        this.partosi = partosi;
        this.FUR = FUR;
        this.ValordeChecbox = ValordeChecbox;

        this.nombreCompleto = nombreCompleto;
        this.a = a;
        this.fecha = fecha;
        this.Fecha_Metodo_Anticonceptivo = Fecha_Metodo_Anticonceptivo;
        this.Fecha_VPH = Fecha_VPH;
        this.Fecha_Biopsia = Fecha_Biopsia;
        this.fecha_Lectura = fecha_Lectura;
        this.fecha_Entrega_Usuario = fecha_Entrega_Usuario;
        this.Fecha_PosTratamiento = Fecha_PosTratamiento;
        this.Fecha_Seguimiento = Fecha_Seguimiento;
        this.fecha_IVAA = fecha_IVAA;
        this.Persona = Persona;

        this.valorObservacion = valorObservacion;
    }

    //--
    public Valores getValorFuma() {
        return valorFuma;
    }

    public void setValorFuma(Valores valorFuma) {
        this.valorFuma = valorFuma;
    }

    public Valores getValorToma() {
        return valorToma;
    }

    public void setValorToma(Valores valorToma) {
        this.valorToma = valorToma;
    }

    public Valores getValorEmbarazoActual() {
        return valorEmbarazoActual;
    }

    public void setValorEmbarazoActual(Valores valorEmbarazoActual) {
        this.valorEmbarazoActual = valorEmbarazoActual;
    }

    public Valores getValorProcedencia() {
        return valorProcedencia;
    }

    public void setValorProcedencia(Valores valorProcedencia) {
        this.valorProcedencia = valorProcedencia;
    }

    public Valores getValorAspecto() {
        return valorAspecto;
    }

    public void setValorAspecto(Valores valorAspecto) {
        this.valorAspecto = valorAspecto;
    }

    public Valores getValorSecrecion() {
        return valorSecrecion;
    }

    public void setValorSecrecion(Valores valorSecrecion) {
        this.valorSecrecion = valorSecrecion;
    }

    public SubCategoria getSubCategoriaFrotis() {
        return subCategoriaFrotis;
    }

    public void setSubCategoriaFrotis(SubCategoria subCategoriaFrotis) {
        this.subCategoriaFrotis = subCategoriaFrotis;
    }

    public SubCategoria getSubCategoriaResultado() {
        return subCategoriaResultado;
    }

    public void setSubCategoriaResultado(SubCategoria subCategoriaResultado) {
        this.subCategoriaResultado = subCategoriaResultado;
    }

    public Valores getValorFrotis() {
        return valorFrotis;
    }

    public void setValorFrotis(Valores valorFrotis) {
        this.valorFrotis = valorFrotis;
    }

    public Valores getValorResultado() {
        return valorResultado;
    }

    public void setValorResultado(Valores valorResultado) {
        this.valorResultado = valorResultado;
    }

    public CategoriaMB getCategoriaMB() {
        return CategoriaMB;
    }

    public void setCategoriaMB(CategoriaMB CategoriaMB) {
        this.CategoriaMB = CategoriaMB;
    }

    public SubCategoriaMB getSubCategoriaMB() {
        return SubCategoriaMB;
    }

    public void setSubCategoriaMB(SubCategoriaMB SubCategoriaMB) {
        this.SubCategoriaMB = SubCategoriaMB;
    }

    public ValoresMB getValoresMB() {
        return ValoresMB;
    }

    public void setValoresMB(ValoresMB ValoresMB) {
        this.ValoresMB = ValoresMB;
    }

    //--
    public Catalogos getMetodoAnticonceptivo() {
        return metodoAnticonceptivo;
    }

    public void setMetodoAnticonceptivo(Catalogos metodoAnticonceptivo) {
        catlista.add(metodoAnticonceptivo);
        this.metodoAnticonceptivo = metodoAnticonceptivo;
    }

    public void cargarMetodoAnticonceptivo() {
        if (this.ExamenSelect != null) {

            if (this.ExamenSelect.getCatalogoList() != null) {
                for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {

                    if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("METELGANT")) {
                        metodoAnticonceptivo = this.ExamenSelect.getCatalogoList().get(i);
                    }

                }
            }
        }
    }

    //codigo ocurrencia parte 2
    public List<EntidadAdtva> getListaEntidadAdtva() {
        listaEntidadAdtva = entidadAdtvaMB.getEntidadAdvEJB().buscarTodasLasEntidades();
        return listaEntidadAdtva;
    }

    public void setListaEntidadAdtva(List<EntidadAdtva> listaEntidadAdtva) {
        this.listaEntidadAdtva = listaEntidadAdtva;
    }

    public void rellenoUnidades() {
        listaUnidadesTomaDm = entidadAdtvaMB.getEntidadAdvEJB().buscarPorUnidades(silaisTomaDM.getEntidadAdtvaId());
    }

    public UnidadesXExamen getUnidadResidencia() {
        return unidadResidencia;
    }

    public void setUnidadResidencia(UnidadesXExamen unidadResidencia) {
        this.unidadResidencia = unidadResidencia;
    }

    public void rellenoMunicipio() {
        municipioTomaDm = entidadAdtvaMB.getEntidadAdvEJB().buscarPorMunicipios(unidadTomaDm.getMunicipio()).get(0);
    }

    public void AsignarUnidades() {

        if (this.ExamenSelect.getUnidadesXExamenList() != null) {
            for (int i = 0; this.ExamenSelect.getUnidadesXExamenList().size() > i; i++) {

                if (this.ExamenSelect.getUnidadesXExamenList().get(i).getEvento().toString().equals("TOMA DE MUESTRA")) {

                    unidadOcurrencia = this.ExamenSelect.getUnidadesXExamenList().get(i);

                } else if (this.ExamenSelect.getUnidadesXExamenList().get(i).getEvento().toString().equals("UNIDAD RESIDENCIA")) {
                    unidadResidencia = this.ExamenSelect.getUnidadesXExamenList().get(i);

                }

            }

        } else {
            unidadOcurrencia = new UnidadesXExamen();
            unidadResidencia = new UnidadesXExamen();
        }
    }

    public void PasarValoresUnidades() {

        this.unidadOcurrencia.setUnidadId(this.unidadTomaDm);
        this.unidadOcurrencia.setIdExamen(this.ExamenSelect);
        String evento = "o";
        String Evento2 = "TOMA DE MUESTRA";
        this.unidadOcurrencia.setTipoEvento(evento.charAt(0));
        this.unidadOcurrencia.setEvento(Evento2);
        BigInteger big = new BigInteger(this.silaisTomaDM.getEntidadAdtvaId().toString());
        this.unidadOcurrencia.setSilais(big);
        BigInteger big2 = new BigInteger(this.municipioTomaDm.getCodigoNacional());
        this.unidadOcurrencia.setMunicipio(big2);
        BigInteger big3 = new BigInteger(this.municipioTomaDm.getDependencia().getCodigoNacional());
        this.unidadOcurrencia.setDepartamento(big3);
        this.unidadesExamen.add(unidadOcurrencia);

        //guardar unidad de residencia 
        Sector sec = this.ExamenEJB.BuscarSectorPorComunidad(this.ExamenSelect.getIdComunidadResidencia().getSector());
        System.out.println(sec);

        if (sec.getUnidad() != null) {
            System.out.println("adentro del if basura");
            Unidad unidadR = this.ExamenEJB.BuscarUnidadPorSector(sec.getUnidad());
            DivisionPolitica municipioR = this.ExamenEJB.BuscarMunicipioPorSector(sec.getMunicipio());

            unidadResidencia.setIdExamen(this.ExamenSelect);
            unidadResidencia.setUnidadId(unidadR);

            Long silais = unidadR.getEntidadAdtva();
            BigInteger i1 = new BigInteger(silais.toString());
            unidadResidencia.setSilais(i1);

            BigInteger i2 = new BigInteger(municipioR.getCodigoNacional());
            unidadResidencia.setMunicipio(i2);

            BigInteger i3 = new BigInteger(municipioR.getDependencia().getCodigoNacional());
            unidadResidencia.setDepartamento(i3);

            String eve = "R";
            String eve2 = "UNIDAD RESIDENCIA";
            unidadResidencia.setEvento(eve2);
            unidadResidencia.setTipoEvento(eve.charAt(0));

            this.unidadesExamen.add(unidadResidencia);
            this.ExamenSelect.getUnidadesXExamenList().addAll(this.unidadesExamen);
        } else {

            this.ExamenSelect.getUnidadesXExamenList().addAll(this.unidadesExamen);
        }
    }

    public List<UnidadesXExamen> getUnidadesExamen() {
        return unidadesExamen;
    }

    public void setUnidadesExamen(List<UnidadesXExamen> unidadesExamen) {
        this.unidadesExamen = unidadesExamen;
    }

    public Unidad getUnidadTomaMuestra() {
        return unidadTomaMuestra;
    }

    public void setUnidadTomaMuestra(Unidad unidadTomaMuestra) {
        this.unidadTomaMuestra = unidadTomaMuestra;
    }

    public UnidadesXExamen getUnidadOcurrencia() {
        return unidadOcurrencia;
    }

    public void setUnidadOcurrencia(UnidadesXExamen unidadOcurrencia) {
        this.unidadOcurrencia = unidadOcurrencia;
    }

    public EntidadAdtva getSilaisTomaDM() {
        return silaisTomaDM;
    }

    public void setSilaisTomaDM(EntidadAdtva silaisTomaDM) {
        this.silaisTomaDM = silaisTomaDM;
    }

    public void cargarSilaisTomaDM() {
        if (this.unidadOcurrencia.getUnidadId() != null) {

            silaisTomaDM = entidadAdtvaMB.getEntidadAdvEJB().buscarTodasLasEntidadesAdtv(this.unidadOcurrencia.getUnidadId().getEntidadAdtva()).get(0);
            this.rellenoUnidades();
        }
    }

    public Unidad getUnidadTomaDm() {
        return unidadTomaDm;
    }

    public void setUnidadTomaDm(Unidad unidadTomaDm) {
        this.unidadTomaDm = unidadTomaDm;
    }

    public void cargarUnidadTomaDM() {
        if (this.unidadOcurrencia.getUnidadId() != null) {

            unidadTomaDm = this.unidadOcurrencia.getUnidadId();
            this.rellenoMunicipio();
            // System.out.println(unidadTomaDm.getNombre());
        }
    }

    public List<Unidad> getListaUnidadesTomaDm() {
        return listaUnidadesTomaDm;
    }

    public void setListaUnidadesTomaDm(List<Unidad> listaUnidadesTomaDm) {
        this.listaUnidadesTomaDm = listaUnidadesTomaDm;
    }

    public DivisionPolitica getMunicipioTomaDm() {

        return municipioTomaDm;
    }

    public void setMunicipioTomaDm(DivisionPolitica municipioTomaDm) {
        this.municipioTomaDm = municipioTomaDm;
    }

    //codigo angelo residencia parte 2
    public void hola() {
        this.municipioSelect = null;
    }

    public Sector getSectorSelect() {
        if (this.ExamenSelect.getIdComunidadResidencia() != null) {
            sectorSelect = ExamenEJB.BuscarSectorPorComunidad(this.ExamenSelect.getIdComunidadResidencia().getSector());
        }

        return sectorSelect;
    }

    public void setSectorSelect(Sector sectorSelect) {
        this.sectorSelect = sectorSelect;
    }

    public DivisionPolitica getDepartamentoSelect() {

//        if (this.getMunicipioSelect() != null) {
//            departamentoSelect = this.municipioSelect.getDependencia();
//        }
        return departamentoSelect;
    }

    public void setDepartamentoSelect(DivisionPolitica departamentoSelect) {
        DivisionPoliticaMB.setDepartametoSelect(departamentoSelect);
        this.departamentoSelect = departamentoSelect;
    }

    public void cargarDepartamentoSelect() {
        if (this.getMunicipioSelect() != null) {

            departamentoSelect = this.municipioSelect.getDependencia();

        }
    }

    public DivisionPolitica getMunicipioSelect() {

        if (this.getSectorSelect() != null) {
            municipioSelect = ExamenEJB.BuscarMunicipioPorSector(this.sectorSelect.getMunicipio());

        }
        return municipioSelect;
    }

    public void setMunicipioSelect(DivisionPolitica municipioSelect) {

        this.municipioSelect = municipioSelect;
    }

    public void cargarSectores() {
        System.out.println("bgdhd" + municipioSelect.getNombre());
        ComunidadMB.setMunicipioSelect(municipioSelect);
    }

//    public void cargarBarrioComarca() {
//
//        DivisionPolitica m = new DivisionPolitica();
//
//        this.setMunicipioSelect(m);
//
//    }
    public List<Comunidad> getComunidades() {

        if (!this.getSectores().isEmpty()) {
            List<Comunidad> comuni;
            comunidades.clear();
            for (int i = 0; this.sectores.size() > i; i++) {
                comuni = ExamenEJB.buscarLasComunidadesPorSectores(this.sectores.get(i).getCodigo());
                if (!comuni.isEmpty()) {
                    comunidades.add(comuni.get(0));
                }
            }
        }
        return comunidades;
    }

    public void setComunidades(List<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }

    public Comunidad getComunidadSelect() {
        return comunidadSelect;
    }

    public void setComunidadSelect(Comunidad comunidadSelect) {
        this.comunidadSelect = comunidadSelect;
    }

    public List<Sector> getSectores() {
        if (municipioSelect != null) {
            sectores = ExamenEJB.buscarSectoresPormunicipios(municipioSelect.getCodigoNacional());

        }

        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    /**
     *
     * @return
     */
    public EntidadAdtva getSilaisTomaResultado() {
        return silaisTomaResultado;
    }

    public void setSilaisTomaResultado(EntidadAdtva silaisTomaResultado) {
        this.silaisTomaResultado = silaisTomaResultado;
    }

    public void cargarSilaisTomaResultado() {
        if (this.unidadOcurrencia.getUnidadId() != null) {

            silaisTomaResultado = entidadAdtvaMB.getEntidadAdvEJB().buscarTodasLasEntidadesAdtv(this.unidadOcurrencia.getUnidadId().getEntidadAdtva()).get(0);
            this.rellenoUnidadesResultado();
        }
    }

    public List<EntidadAdtva> getListaEntidadAdtvaResultado() {
        listaEntidadAdtvaResultado = entidadAdtvaMB.getEntidadAdvEJB().buscarTodasLasEntidades();
        return listaEntidadAdtvaResultado;
    }

    public void setListaEntidadAdtvaResultado(List<EntidadAdtva> listaEntidadAdtvaResultado) {
        this.listaEntidadAdtvaResultado = listaEntidadAdtvaResultado;
    }

    public void rellenoUnidadesResultado() {
        listaUnidadesTomaResultado = entidadAdtvaMB.getEntidadAdvEJB().buscarPorUnidades(silaisTomaResultado.getEntidadAdtvaId());
    }

    public Unidad getUnidadTomaResultado() {
        return unidadTomaResultado;
    }

    public void setUnidadTomaResultado(Unidad unidadTomaResultado) {
        this.unidadTomaResultado = unidadTomaResultado;
    }

    public void cargarUnidadTomaResultado() {
        if (this.unidadOcurrencia.getUnidadId() != null) {

            unidadTomaResultado = this.unidadOcurrencia.getUnidadId();
            this.rellenoMunicipio();
            // System.out.println(unidadTomaDm.getNombre());
        }
    }

    public List<Unidad> getListaUnidadesTomaResultado() {
        return listaUnidadesTomaResultado;
    }

    public void setListaUnidadesTomaResultado(List<Unidad> listaUnidadesTomaResultado) {
        this.listaUnidadesTomaResultado = listaUnidadesTomaResultado;
    }

    public void rellenoMunicipioResultado() {
        municipioTomaResultado = entidadAdtvaMB.getEntidadAdvEJB().buscarPorMunicipios(unidadTomaResultado.getMunicipio()).get(0);
    }

    public DivisionPolitica getMunicipioTomaResultado() {
        return municipioTomaResultado;
    }

    public void setMunicipioTomaResultado(DivisionPolitica municipioTomaResultado) {
        this.municipioTomaResultado = municipioTomaResultado;
    }

    //Codigo Angelo para Antecedentes Ginecobtetrico
    public void pasarValorResutado() {

        System.out.println(this.ExamenSelect.getIdExamen());

//        this.re1.setDescripcion(String.valueOf(this.Gestasi));
//        this.re2.setDescripcion(String.valueOf(this.partosi));
//        this.re3.setDescripcion(String.valueOf(this.Abortosi));
//        this.re4.setDescripcion(String.valueOf(this.Cesareasi));
//        this.re5.setDescripcion(String.valueOf(this.IVSAi));
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        this.re6.setDescripcion(formatter.format(this.FUR));
//        System.out.println(formatter.format(this.FUR));
//        this.re7.setDescripcion(String.valueOf(this.semanaDeGestasi));
//        this.re8.setDescripcion(String.valueOf(this.Menarcai));
//
//        this.re9.setIdValor(this.valorFuma);
//        System.out.println(this.valorFuma.getValor());
//        //this.re10.getResultadoExamenPK().setIdValor(this.pk10.getIdValor());
//        this.re10.setIdValor(this.valorToma);
//        //this.re11.getResultadoExamenPK().setIdValor(this.pk11.getIdValor());
//        this.re11.setIdValor(this.valorEmbarazoActual);
//        this.re12.setIdValor(this.valorProcedencia);
//        this.re13.setIdValor(this.valorAspecto);
//        this.re14.setIdValor(this.valorSecrecion);
//
//        System.out.println("resset");
//        this.re1.setIdExamen(this.ExamenSelect);
//        this.re2.setIdExamen(this.ExamenSelect);
//        this.re3.setIdExamen(this.ExamenSelect);
//        this.re4.setIdExamen(this.ExamenSelect);
//        this.re5.setIdExamen(this.ExamenSelect);
//        this.re6.setIdExamen(this.ExamenSelect);
//        this.re7.setIdExamen(this.ExamenSelect);
//        this.re8.setIdExamen(this.ExamenSelect);
//        this.re9.setIdExamen(this.ExamenSelect);
//        this.re10.setIdExamen(this.ExamenSelect);
//        this.re11.setIdExamen(this.ExamenSelect);
//        this.re12.setIdExamen(this.ExamenSelect);
//        this.re13.setIdExamen(this.ExamenSelect);
//        this.re14.setIdExamen(this.ExamenSelect);
//
//        this.resultadoExamen.add(this.re1);
//        this.resultadoExamen.add(this.re2);
//        this.resultadoExamen.add(this.re3);
//        this.resultadoExamen.add(this.re4);
//        this.resultadoExamen.add(this.re5);
//        this.resultadoExamen.add(this.re6);
//        this.resultadoExamen.add(this.re7);
//        this.resultadoExamen.add(this.re8);
//        this.resultadoExamen.add(this.re9);
//        this.resultadoExamen.add(this.re10);
//        this.resultadoExamen.add(this.re11);
//        this.resultadoExamen.add(this.re12);
//        this.resultadoExamen.add(this.re13);
//        this.resultadoExamen.add(this.re14);
//        System.out.println("addadd");
//        System.out.println(this.resultadoExamen.size());
//
//        //this.ExamenSelect.setResultadoExamenList(this.resultadoExamen);
//        System.out.println("ya en lista");
        this.re[0].setDescripcion(String.valueOf(this.Gestasi));
        this.re[1].setDescripcion(String.valueOf(this.partosi));
        this.re[2].setDescripcion(String.valueOf(this.Abortosi));
        this.re[3].setDescripcion(String.valueOf(this.Cesareasi));
        this.re[4].setDescripcion(String.valueOf(this.IVSAi));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.re[5].setDescripcion(formatter.format(this.FUR));
        this.re[6].setDescripcion(String.valueOf(this.semanaDeGestasi));
        this.re[7].setDescripcion(String.valueOf(this.Menarcai));

        this.re[8].setIdValor(valorFuma);
        this.re[9].setIdValor(this.valorToma);
        this.re[10].setIdValor(this.valorEmbarazoActual);
        this.re[11].setIdValor(this.valorProcedencia);
        this.re[12].setIdValor(this.valorAspecto);
        this.re[13].setIdValor(this.valorSecrecion);

        System.out.println("resset");

        for (int i = 0; i < 14; i++) {
            this.re[i].setIdExamen(this.ExamenSelect);
            this.resultadoExamen.add(this.re[i]);
            System.out.println("listo");
        }

        System.out.println("addadd");
        System.out.println(this.resultadoExamen.size());

        //this.ExamenSelect.setResultadoExamenList(this.resultadoExamen);
        System.out.println("ya en lista");

    }

    public void asignarResutados() {
        //--tamaño de arreglo solo para antecedentes y descripcion de la muestra

        if (this.ExamenSelect.getResultadoExamenList() != null) {
            //--asignar tamaño de areglo para todos los resultados
            System.out.println("Cantidad de datos en lista resultado antes: " + this.ExamenSelect.getResultadoExamenList().size());
            re = new ResultadoExamen[this.ExamenSelect.getResultadoExamenList().size()];
            //--
            System.out.println("Cantidad de datos en lista resultado: " + this.ExamenSelect.getResultadoExamenList().size());

            System.out.println("Soy el examen #... " + ExamenSelect.getIdExamen());
            System.out.println("existe todos los resultados");

            java.math.BigDecimal v1 = new java.math.BigDecimal(String.valueOf(1));
            java.math.BigDecimal v2 = new java.math.BigDecimal(String.valueOf(2));
            java.math.BigDecimal v3 = new java.math.BigDecimal(String.valueOf(3));
            java.math.BigDecimal v4 = new java.math.BigDecimal(String.valueOf(4));
            java.math.BigDecimal v5 = new java.math.BigDecimal(String.valueOf(5));
            java.math.BigDecimal v6 = new java.math.BigDecimal(String.valueOf(6));
            java.math.BigDecimal v7 = new java.math.BigDecimal(String.valueOf(7));
            java.math.BigDecimal v8 = new java.math.BigDecimal(String.valueOf(8));
            java.math.BigDecimal v9 = new java.math.BigDecimal(String.valueOf(9));
            java.math.BigDecimal v10 = new java.math.BigDecimal(String.valueOf(10));
            java.math.BigDecimal v11 = new java.math.BigDecimal(String.valueOf(11));
            java.math.BigDecimal v12 = new java.math.BigDecimal(String.valueOf(12));
            java.math.BigDecimal v13 = new java.math.BigDecimal(String.valueOf(22));

            for (int i = 0; this.ExamenSelect.getResultadoExamenList().size() > i; i++) {

                if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v1)) {
                    re[0] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v2)) {
                    re[1] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v3)) {
                    re[2] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v4)) {
                    re[3] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v5)) {
                    re[4] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v6)) {
                    re[5] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v7)) {
                    re[6] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getIdValor().equals(v8)) {
                    re[7] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v7)) {
                    re[8] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v8)) {
                    re[9] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v9)) {
                    re[10] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v10)) {
                    re[11] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v11)) {
                    re[12] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v12)) {
                    re[13] = this.ExamenSelect.getResultadoExamenList().get(i);

                } else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria().equals(v13)) {
                    re[14] = this.ExamenSelect.getResultadoExamenList().get(i);

                }

                System.out.println("Termine con antecedentes..." + i);
            }

        } else {
            re = new ResultadoExamen[15];
            //---------------
            /**
             * ciclo para asignar valores por defecto para los resutados de
             * anteGinec y descripcion de la muestra
             */
            for (int i = 0; i < 8; i++) {
                re[i] = new ResultadoExamen();
                re[i].setIdCategoria(this.CategoriaMB.getAntecedentes());
                re[i].setIdSubcategoria(this.SubCategoriaMB.getAntecedentesAbiertos());
            }
            for (int i = 8; i < 11; i++) {
                re[i] = new ResultadoExamen();
                re[i].setIdCategoria(this.CategoriaMB.getAntecedentes());
            }
            for (int i = 11; i < 14; i++) {
                re[i] = new ResultadoExamen();
                re[i].setIdCategoria(this.SubCategoriaMB.getSecrecion().getIdCategoria());
            }
            //---------------       
            //Gestas----------------------
            re[0].setIdValor(this.ValoresMB.getGestas());
            //Partos---------------------------------
            re[1].setIdValor(this.ValoresMB.getPartos());
            //Abortos------------------------------------
            re[2].setIdValor(this.ValoresMB.getAbortos());
            //Cesareas-----------------------------
            re[3].setIdValor(this.ValoresMB.getCesareaa());
            //Ivsa-----------------------------------
            re[4].setIdValor(this.ValoresMB.getIVSA());
            //Fur----------------------------------
            re[5].setIdValor(this.ValoresMB.getFURV());
            //SemanaGestas----------------------------------------
            re[6].setIdValor(this.ValoresMB.getSemanaGestas());
            //menarca-----------------------------
            re[7].setIdValor(this.ValoresMB.getMenarca());
            //fuma--------------------------
            re[8].setIdSubcategoria(this.SubCategoriaMB.getFuma());
            //toma--------------------------
            re[9].setIdSubcategoria(this.SubCategoriaMB.getToma());
            //embarazo actual------------------------------
            re[10].setIdSubcategoria(this.SubCategoriaMB.getEmbarazoActual());
            //------------------------------------------------------------   
            re[11].setIdSubcategoria(this.SubCategoriaMB.getProcedencia());
            re[12].setIdSubcategoria(this.SubCategoriaMB.getAspectoClinico());
            re[13].setIdSubcategoria(this.SubCategoriaMB.getSecrecion());

        }

    }

    public ResultadoExamen[] getRe() {
        return re;
    }

    public void setRe(ResultadoExamen[] re) {
        this.re = re;
    }

    public ResultadoExamen getRe9() {
        return re9;
    }

    public void setRe9(ResultadoExamen re9) {
        this.re9 = re9;
    }

    public ResultadoExamen getRe10() {
        return re10;
    }

    public void setRe10(ResultadoExamen re10) {
        this.re10 = re10;
    }

    public ResultadoExamen getRe11() {
        return re11;
    }

    public void setRe11(ResultadoExamen re11) {
        this.re11 = re11;
    }

    public List<ResultadoExamen> getResultadoExamen() {

        return resultadoExamen;
    }

    public void setResultadoExamen(List<ResultadoExamen> resultadoExamen) {
        this.resultadoExamen = resultadoExamen;
    }

    public ResultadoExamen getRe1() {
        return re1;
    }

    public void setRe1(ResultadoExamen re1) {
        this.re1 = re1;
    }

    public ResultadoExamen getRe2() {
        return re2;
    }

    public void setRe2(ResultadoExamen re2) {
        this.re2 = re2;
    }

    public ResultadoExamen getRe3() {
        return re3;
    }

    public void setRe3(ResultadoExamen re3) {
        this.re3 = re3;
    }

    public ResultadoExamen getRe4() {
        return re4;
    }

    public void setRe4(ResultadoExamen re4) {
        this.re4 = re4;
    }

    public ResultadoExamen getRe5() {
        return re5;
    }

    public void setRe5(ResultadoExamen re5) {
        this.re5 = re5;
    }

    public ResultadoExamen getRe6() {
        return re6;
    }

    public void setRe6(ResultadoExamen re6) {
        this.re6 = re6;
    }

    public ResultadoExamen getRe7() {
        return re7;
    }

    public void setRe7(ResultadoExamen re7) {
        this.re7 = re7;
    }

    public ResultadoExamen getRe8() {
        return re8;
    }

    public void setRe8(ResultadoExamen re8) {
        this.re8 = re8;
    }

    public int getPartosi() {
        return partosi;
    }

    public void setPartosi(int partosi) {
        this.partosi = partosi;
    }

    public void cargarDatosPartos() {
        if (this.re[1].getDescripcion() != null) {
            partosi = Integer.parseInt(this.re[1].getDescripcion());
        }

    }

    public Date getFUR() throws ParseException {
        return FUR;
    }

    public void setFUR(Date FUR) {
        this.FUR = FUR;
    }

    public void cargarFUR() throws ParseException {
        if (this.re[5].getDescripcion() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            FUR = formatter.parse(this.re[5].getDescripcion());
        }
    }

    public int getAbortosi() {
        return Abortosi;
    }

    public void setAbortosi(int Abortosi) {
        this.Abortosi = Abortosi;
    }

    public void cargarDatosAbortos() {
        if (this.re[2].getDescripcion() != null) {
            Abortosi = Integer.parseInt(this.re[2].getDescripcion());
        }
    }

    public int getCesareasi() {
        return Cesareasi;
    }

    public void setCesareasi(int Cesareasi) {
        this.Cesareasi = Cesareasi;
    }

    public void cargarDatosCesarias() {
        if (this.re[3].getDescripcion() != null) {
            Cesareasi = Integer.parseInt(this.re[3].getDescripcion());
        }
    }

    public int getIVSAi() {
        return IVSAi;
    }

    public void setIVSAi(int IVSAi) {
        this.IVSAi = IVSAi;
    }

    public void cargarDatosIVSA() {
        if (this.re[4].getDescripcion() != null) {
            IVSAi = Integer.parseInt(this.re[4].getDescripcion());

        }
    }

    public int getMenarcai() {
        return Menarcai;
    }

    public void setMenarcai(int Menarcai) {
        this.Menarcai = Menarcai;
    }

    public void cargarDatosMenarca() {
        if (this.re[7].getDescripcion() != null) {
            Menarcai = Integer.parseInt(this.re[7].getDescripcion());
        }
    }

    public int getSemanaDeGestasi() {
        return semanaDeGestasi;
    }

    public void setSemanaDeGestasi(int semanaDeGestasi) {
        this.semanaDeGestasi = semanaDeGestasi;
    }

    public void cargarDatosSemanasGestas() {
        if (this.re[6].getDescripcion() != null) {
            semanaDeGestasi = Integer.parseInt(this.re[6].getDescripcion());
        }
    }

    public int getGestasi() {
        return Gestasi;
    }

    public void setGestasi(int Gestasi) {
        this.Gestasi = Gestasi;
    }

    public void cargarDatosGestas() {
        if (this.Gestasi == 0) {
            System.out.println("cargue Gestas...");
            System.out.println(re[0].getIdValor() + " " + re[0].getDescripcion());
            if (this.re[0].getDescripcion() != null) {
                System.out.println("cargue Gestas... " + re[0].getDescripcion());
                Gestasi = Integer.parseInt(this.re[0].getDescripcion());
            }
        }
    }

    //------------------------------------
    public boolean isHabilitarPrimerNombre() {
        return HabilitarPrimerNombre;
    }

    public void setHabilitarPrimerNombre(boolean HabilitarPrimerNombre) {
        this.HabilitarPrimerNombre = HabilitarPrimerNombre;
    }

    public boolean isHabilitarSegundoNombre() {
        return HabilitarSegundoNombre;
    }

    public void setHabilitarSegundoNombre(boolean HabilitarSegundoNombre) {
        this.HabilitarSegundoNombre = HabilitarSegundoNombre;
    }

    public boolean isHabilitarPrimerApellido() {
        return HabilitarPrimerApellido;
    }

    public void setHabilitarPrimerApellido(boolean HabilitarPrimerApellido) {
        this.HabilitarPrimerApellido = HabilitarPrimerApellido;
    }

    public boolean isHabilitarSegundoApellido() {
        return HabilitarSegundoApellido;
    }

    public void setHabilitarSegundoApellido(boolean HabilitarSegundoApellido) {
        this.HabilitarSegundoApellido = HabilitarSegundoApellido;
    }

    public boolean isHabilitarCedula() {
        return HabilitarCedula;
    }

    public void setHabilitarCedula(boolean HabilitarCedula) {
        this.HabilitarCedula = HabilitarCedula;
    }

    public boolean isHabilitarFechaNacimiento() {
        return HabilitarFechaNacimiento;
    }

    public void setHabilitarFechaNacimiento(boolean HabilitarFechaNacimiento) {
        this.HabilitarFechaNacimiento = HabilitarFechaNacimiento;
    }

    public boolean isHabilitarComboEscolaridad() {
        return HabilitarComboEscolaridad;
    }

    public void setHabilitarComboEscolaridad(boolean HabilitarComboEscolaridad) {
        this.HabilitarComboEscolaridad = HabilitarComboEscolaridad;
    }

    public boolean isHabilitarComboOcupacion() {
        return HabilitarComboOcupacion;
    }

    public void setHabilitarComboOcupacion(boolean HabilitarComboOcupacion) {
        this.HabilitarComboOcupacion = HabilitarComboOcupacion;
    }

    public boolean isHabilitarComboEtnia() {
        return HabilitarComboEtnia;
    }

    public void setHabilitarComboEtnia(boolean HabilitarComboEtnia) {
        this.HabilitarComboEtnia = HabilitarComboEtnia;
    }

    public boolean isHabilitarComboProcedencia() {
        return HabilitarComboProcedencia;
    }

    public void setHabilitarComboProcedencia(boolean HabilitarComboProcedencia) {
        this.HabilitarComboProcedencia = HabilitarComboProcedencia;
    }

    public boolean isHabilitarComboComunidad() {
        return HabilitarComboComunidad;
    }

    public void setHabilitarComboComunidad(boolean HabilitarComboComunidad) {
        this.HabilitarComboComunidad = HabilitarComboComunidad;
    }

    public boolean isHabilitarComboBarrio() {
        return HabilitarComboBarrio;
    }

    public void setHabilitarComboBarrio(boolean HabilitarComboBarrio) {
        this.HabilitarComboBarrio = HabilitarComboBarrio;
    }

    public boolean isHabilitarNumExpediente() {
        return HabilitarNumExpediente;
    }

    public void setHabilitarNumExpediente(boolean HabilitarNumExpediente) {
        this.HabilitarNumExpediente = HabilitarNumExpediente;
    }

    public boolean isHabilitarExpedienteTemp() {
        return HabilitarExpedienteTemp;
    }

    public void setHabilitarExpedienteTemp(boolean HabilitarExpedienteTemp) {
        this.HabilitarExpedienteTemp = HabilitarExpedienteTemp;
    }

    public boolean isHabilitarTelefono1() {
        return HabilitarTelefono1;
    }

    public void setHabilitarTelefono1(boolean HabilitarTelefono1) {
        this.HabilitarTelefono1 = HabilitarTelefono1;
    }

    public boolean isHabilitarTelefono2() {
        return HabilitarTelefono2;
    }

    public void setHabilitarTelefono2(boolean HabilitarTelefono2) {
        this.HabilitarTelefono2 = HabilitarTelefono2;
    }

    public boolean isNuevoPaciente() {
        return nuevoPaciente;
    }

    public void setNuevoPaciente(boolean nuevoPaciente) {
        this.nuevoPaciente = nuevoPaciente;
    }

    public boolean isContinuarPaciente() {
        return continuarPaciente;
    }

    public void setContinuarPaciente(boolean continuarPaciente) {
        this.continuarPaciente = continuarPaciente;
    }

    public void HabilitaandoCampos() {

        if (this.valorEmbarazoActual.getValor().equals("Si")) {
            this.HabilitarSemanasGestacion = true;
            Gestasi = this.Gestasi + 1;

//        } else {
//            if (this.valorEmbarazoActual.getValor().equals("No")) {
//                
//                if (Gestasi == 0)
//                {
//                    this.semanaDeGestasi = 0;
//                    this.HabilitarSemanasGestacion = false;
//                    Gestasi = 0;
//                }
//                else if (Gestasi != 0)
//                {
//                    this.semanaDeGestasi = 0;
//                    this.HabilitarSemanasGestacion = false;
//                    Gestasi = this.Gestasi - 1;
//                }
//            }
        }
    }

    public void HabilitaDireccion() {
        if (this.ValordeChecbox == true) {
            this.HabilitarDireccion = true;
        } else if (this.ValordeChecbox == false) {
            this.HabilitarDireccion = false;
        }
    }

    public void IncrementarValorGestas() {
        int incremento;
        incremento = this.Abortosi + this.Cesareasi + this.partosi;
        this.Gestasi = incremento;
    }

    public boolean isValordeChecbox() {
        return ValordeChecbox;
    }

    public void setValordeChecbox(boolean ValordeChecbox) {
        this.ValordeChecbox = ValordeChecbox;
    }

    public boolean isHabilitarDireccion() {
        return HabilitarDireccion;
    }

    public void setHabilitarDireccion(boolean HabilitarDireccion) {
        this.HabilitarDireccion = HabilitarDireccion;
    }

    public boolean isHabilitarSemanasGestacion() {
        return HabilitarSemanasGestacion;
    }

    public void setHabilitarSemanasGestacion(boolean HabilitarSemanasGestacion) {
        this.HabilitarSemanasGestacion = HabilitarSemanasGestacion;
    }

    public EntidadAdtvaMB getEntidadAdtvaMB() {
        return entidadAdtvaMB;
    }

    public void setEntidadAdtvaMB(EntidadAdtvaMB entidadAdtvaMB) {
        this.entidadAdtvaMB = entidadAdtvaMB;
    }

    public String getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(String numeroCel) {
        this.numeroCel = numeroCel;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public List<Catalogos> getListaOcupaciones() {
        return catlista;
    }

    public void setListaOcupaciones(List<Catalogos> catlista) {
        this.catlista = catlista;
    }

    public Catalogos getValor_Procedencia() {

//        if (this.ExamenSelect.getCatalogoList() != null) {
//            for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {
//
//                if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("PROCDNCIA")) {
//                    valor_Procedencia = this.ExamenSelect.getCatalogoList().get(i);
//                }
//
//            }
//        }
        return valor_Procedencia;
    }

    public void setValor_Procedencia(Catalogos valor_Procedencia) {
        catlista.add(valor_Procedencia);
        this.valor_Procedencia = valor_Procedencia;
    }

    public Catalogos getValor_Etnia() {

//        if (this.ExamenSelect.getCatalogoList() != null) {
//            for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {
//
//                if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("ETNIA")) {
//                    Valor_Etnia = this.ExamenSelect.getCatalogoList().get(i);
//                }
//
//            }
//        }
        return Valor_Etnia;
    }

    public void setValor_Etnia(Catalogos Valor_Etnia) {
        catlista.add(Valor_Etnia);
        this.Valor_Etnia = Valor_Etnia;
    }

    public Catalogos getCatalogos() {
//        catlista.add(catalogos);
//        ExamenSelect.setCatalogoList(catlista);

//        if (this.ExamenSelect.getCatalogoList() != null) {
//            for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {
//
//                if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("HSF_OCUPA")) {
//                    catalogos = this.ExamenSelect.getCatalogoList().get(i);
//                }
//
//            }
//        }
        return catalogos;
    }

    public void setCatalogos(Catalogos catalogos) {
        catlista.add(catalogos);

        this.catalogos = catalogos;
    }

    public Catalogos getCat_esc() {
//        if (this.ExamenSelect != null) {
//
//            if (this.ExamenSelect.getCatalogoList() != null) {
//                for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {
//
//                    if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("ESCDA")) {
//                        cat_esc = this.ExamenSelect.getCatalogoList().get(i);
//                    }
//
//                }
//            }
//        }
        return cat_esc;
    }

    public void setCat_esc(Catalogos cat_esc) {
        catlista.add(cat_esc);

        this.cat_esc = cat_esc;
    }

    public Date getFecha_Lectura() {

        return fecha_Lectura;
    }

    public void setFecha_Lectura(Date fecha_Lectura) {
        this.fecha_Lectura = fecha_Lectura;
    }

    public Date getFecha_Entrega_Usuario() {
//        /**
//         * El número 3 representa el id de Fecha referente a la fecha de entrega
//         */
//        if (this.ExamenSelect.getFxexuList() != null) {
//            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 3);
//            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
//                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
//                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
//                        fecha_Entrega_Usuario = this.ExamenSelect.getFxexuList().get(i).getValor();
//                    }
//                }
//            }
//        }
        return fecha_Entrega_Usuario;
    }

    public void setFecha_Entrega_Usuario(Date fecha_Entrega_Usuario) {
        this.fecha_Entrega_Usuario = fecha_Entrega_Usuario;
    }

    public Date getFecha_PosTratamiento() {
        return Fecha_PosTratamiento;
    }

    public void setFecha_PosTratamiento(Date Fecha_PosTratamiento) {
        this.Fecha_PosTratamiento = Fecha_PosTratamiento;
    }

    public Date getFecha_Seguimiento() {
//        /**
//         * El número 4 representa el id de Fecha referente a la fecha de
//         * seguimiento la n es una bandera que permite controlar los cambios en
//         * la fecha calculada
//         */
//
//        if (n == 1) {
//            n = 0;
//            System.out.println(Fecha_Seguimiento);
//            return Fecha_Seguimiento;
//        } else if (this.ExamenSelect.getFxexuList() != null) {
//            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 4);
//            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
//                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
//
//                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
//                        Fecha_Seguimiento = this.ExamenSelect.getFxexuList().get(i).getValor();
//                    }
//                }
//            }
//        }

        return Fecha_Seguimiento;
    }

    public void setFecha_Seguimiento(Date Fecha_Seguimiento) {
        this.Fecha_Seguimiento = Fecha_Seguimiento;
    }

    public Date getFecha_IVAA() {
        return fecha_IVAA;
    }

    public void setFecha_IVAA(Date fecha_IVAA) {
        this.fecha_IVAA = fecha_IVAA;
    }

    public ExamenEJB getExamenEJB() {
        return ExamenEJB;
    }

    public void setExamenEJB(ExamenEJB ExamenEJB) {
        this.ExamenEJB = ExamenEJB;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Examen getExamenSelect() {
        return ExamenSelect;
    }

    public void setExamenSelect(Examen ExamenSelect) {
        this.ExamenSelect = ExamenSelect;
    }

    /**
     * Esta Lista retorna la primer parte del examen realizado.
     *
     * @return
     */
    public List<Examen> getListaPrimerParteExamen() {
        return listaPrimerParteExamen;
    }

    public void setListaPrimerParteExamen(List<Examen> listaPrimerParteExamen) {
        this.listaPrimerParteExamen = listaPrimerParteExamen;
    }

    public List<Examen> getListaExamenPendiente(long Codigo) {

        listaExamenPendiente = ExamenEJB.buscarExamenPendiente(Codigo);
        return listaExamenPendiente;
    }

    public void setListaExamenPendiente(List<Examen> listaExamenPendiente) {
        this.listaExamenPendiente = listaExamenPendiente;
    }

    public List<Examen> getListaExamen() {
        HashSet st = new HashSet();
        st.addAll(listaExamen);
        listaExamen.clear();
        listaExamen.addAll(st);
        return listaExamen;
    }

    public void setListaExamen(List<Examen> listaExamen) {
        this.listaExamen = listaExamen;
    }

    /**
     * Esta lista se encargara de filtrar a las personas que tienen mas de 1
     * examen en la base de datos para que no muestre mas de una vez a la misma
     * persona
     *
     * listaSRExamen = lista Sin Repeticiones de Examen
     *
     * @return
     */
    public List<Examen> getListaSRExamen() {
        Map<String, Examen> limpiarLista = new HashMap<String, Examen>(listaExamen.size());

        for (Examen examen : listaExamen) {
            limpiarLista.put(examen.getCedula(), examen);
        }

        for (Entry<String, Examen> examen1 : limpiarLista.entrySet()) {
            listaSRExamen.add(examen1.getValue());
        }
//        listaSRExamen.addAll(listaExamen);
        HashSet st = new HashSet();
        st.addAll(listaSRExamen);
        listaSRExamen.clear();
        listaSRExamen.addAll(st);
        return listaSRExamen;
    }

    public void setListaSRExamen(List<Examen> listaSRExamen) {
        this.listaSRExamen = listaSRExamen;
    }

    /**
     * Lista que se encarga de mostrar en un datatable cierta información de una
     * persona cuando ya ha finalizado el registro de su examen
     *
     * @return
     */
    public List<Examen> getListaExamenCompleto() {
        return listaExamenCompleto;
    }

    public void mostrarExamenCompleto() {
        listaExamenCompleto = ExamenEJB.buscarExamenCompleto(ExamenSelect.getIdExamen());
    }

    public void setListaExamenCompleto(List<Examen> listaExamenCompleto) {
        this.listaExamenCompleto = listaExamenCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<ResultadoExamen> getListaresultadosExamen() {
        return listaresultadosExamen;
    }

    public void setListaresultadosExamen(List<ResultadoExamen> listaresultadosExamen) {
        this.listaresultadosExamen = listaresultadosExamen;
    }

    public Date getFecha() {
//        /**
//         * El número 1 representa el id de Fecha referente a la Toma de Muestra
//         */
//        if (ExamenSelect.getFxexuList() != null) {
//            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 1);
//            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
//                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
//                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
//                        fecha = this.ExamenSelect.getFxexuList().get(i).getValor();
//                    }
//                }
//            }
//        }
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public SisPersonas getPersona() {
        return Persona;
    }

    public void setPersona(SisPersonas Persona) {
        this.Persona = Persona;
    }

    public List<SisPersonas> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<SisPersonas> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public Date getFecha_Metodo_Anticonceptivo() {
        return Fecha_Metodo_Anticonceptivo;
    }

    public void setFecha_Metodo_Anticonceptivo(Date Fecha_Metodo_Anticonceptivo) {
        this.Fecha_Metodo_Anticonceptivo = Fecha_Metodo_Anticonceptivo;
    }

    public Date getFecha_PAP() {
        return Fecha_PAP;
    }

    public void setFecha_PAP(Date Fecha_PAP) {
        this.Fecha_PAP = Fecha_PAP;
    }

    public Date getFecha_VPH() {
        return Fecha_VPH;
    }

    public void setFecha_VPH(Date Fecha_VPH) {
        this.Fecha_VPH = Fecha_VPH;
    }

    public Date getFecha_Biopsia() {
        return Fecha_Biopsia;
    }

    public void setFecha_Biopsia(Date Fecha_Biopsia) {
        this.Fecha_Biopsia = Fecha_Biopsia;
    }

    public void lista() {
        if (listaExamen.isEmpty()) {

            //System.out.println(nombreCompleto);
            PersonaMB.setNombreCompleto(nombreCompleto);
            PersonaMB.setNombreCompleto(nombreCompleto);
            PersonaMB.setCedula(cedula);
            PersonaMB.setNumeroCel(numeroCel);
            PersonaMB.setFechaNac(fechaNac);
//            System.out.println(PersonaMB.getNombreCompleto() + "NOOOOOOOOOO");
            PersonaMB.porNombreCompleto();
            listaPersonas = PersonaMB.getListaPersonas();

            //listaPersonas.get(1);
            System.out.println(listaPersonas.size());
            for (int i = 0; i < listaPersonas.size(); i++) {

                Integer y = i;
                long x = y.longValue();

                examen2 = new Examen();
                examen2.setIdExamen(x);
                examen2.setIdPersona(listaPersonas.get(i).getPersonaId());
                examen2.setPrimerNombre(listaPersonas.get(i).getPrimerNombre());
                examen2.setPrimerApellido(listaPersonas.get(i).getPrimerApellido());
                examen2.setSegundoNombre(listaPersonas.get(i).getSegundoNombre());
                examen2.setSegundoApellido(listaPersonas.get(i).getSegundoApellido());
                examen2.setCedula(listaPersonas.get(i).getIdentificacion());
                examen2.setFechaNacimiento(listaPersonas.get(i).getFechaNacimiento());
                examen2.setDireccionActual(listaPersonas.get(i).getDireccionResidencia());

                listaExamen.add(examen2);

            }

        }

    }

    public void porNombreCompleto() {

        listaExamen.clear();
        listaSRExamen.clear();

        if (nombreCompleto.isEmpty()) {
            if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {

                listaExamen = ExamenEJB.buscarPorPajas(cedula, numeroCel, fechaNac);
                lista();
            } else {
                if (!cedula.isEmpty() && fechaNac != null) {

                    listaExamen = ExamenEJB.buscarPorPajas(cedula, "", fechaNac);
                    lista();
                } else {
                    if (!numeroCel.isEmpty() && !cedula.isEmpty()) {

                        listaExamen = ExamenEJB.buscarPorPajas(cedula, numeroCel, null);
                        lista();
                    } else {
                        if (fechaNac != null && !numeroCel.isEmpty()) {

                            listaExamen = ExamenEJB.buscarPorPajas("", numeroCel, fechaNac);
                            lista();
                        } else {
                            if (!cedula.isEmpty()) {

                                listaExamen = ExamenEJB.buscarPorPajas(cedula, "", null);
                                lista();
                            } else {
                                if (!numeroCel.isEmpty()) {

                                    listaExamen = ExamenEJB.buscarPorPajas("", numeroCel, null);
                                    lista();
                                } else {
                                    if (fechaNac != null) {

                                        listaExamen = ExamenEJB.buscarPorPajas("", "", fechaNac);

                                        lista();

                                    } else {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El Campo No Puede Estar Vacio", "ingrese algo"));

                                    }

                                }
                            }

                        }
                    }
                }
            }

        } else {
            StringTokenizer st = new StringTokenizer(nombreCompleto);

            int i = 0;
            a = new String[st.countTokens()];
            while (st.hasMoreTokens()) {
                a[i] = st.nextElement().toString();
                i++;

            }

            if (!(nombreCompleto).matches("([a-z]|[A-Z]|\\s|Ñ)+")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "El Campo No Admite Numeros.", ""));
                listaExamen.clear();
            } else {

                if (a.length > 6) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El Nombre No Debe Exceder de 6 Palabras", "mas de 6 token"));
                } else {
                    if (a.length == 6) {
                        String n1;
                        n1 = a[1] + " " + a[2] + " " + a[3];
                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], cedula, numeroCel, fechaNac);
                            lista();

                        } else {
                            if (!cedula.isEmpty() && fechaNac != null) {
                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], cedula, "", fechaNac);

                                lista();
                            } else {
                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], cedula, numeroCel, null);

                                    lista();
                                } else {
                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], "", numeroCel, fechaNac);

                                        lista();
                                    } else {
                                        if (!cedula.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], cedula, "", null);

                                            lista();
                                        } else {
                                            if (!numeroCel.isEmpty()) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], "", numeroCel, null);
                                                lista();
                                            } else {
                                                if (fechaNac != null) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], "", "", fechaNac);

                                                    lista();

                                                } else {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[4], a[5], "", "", null);
                                                    lista();
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }

                    } else {

                        if (a.length == 5) {
                            if ("LOS".equals(a[2]) || "LA".equals(a[2])) {
                                String n3;
                                n3 = a[1] + " " + a[2] + " " + a[3];
                                if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", cedula, numeroCel, fechaNac);
                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], cedula, numeroCel, fechaNac));
                                    lista();

                                } else {
                                    if (!cedula.isEmpty() && fechaNac != null) {
                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", cedula, "", fechaNac);
                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], cedula, "", fechaNac));
                                        lista();

                                    } else {
                                        if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", cedula, numeroCel, null);
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], cedula, numeroCel, null));
                                            lista();

                                        } else {
                                            if (fechaNac != null && !numeroCel.isEmpty()) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", "", numeroCel, fechaNac);
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], "", numeroCel, fechaNac));
                                                lista();

                                            } else {
                                                if (!cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", cedula, "", null);
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], cedula, "", null));
                                                    lista();

                                                } else {
                                                    if (!numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", "", numeroCel, null);
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], "", numeroCel, null));
                                                        lista();

                                                    } else {
                                                        if (fechaNac != null) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", "", "", fechaNac);
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], "", "", fechaNac));
                                                            lista();

                                                        } else {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, a[4], "", "", "", null);
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", a[4], "", "", null));
                                                            lista();
                                                        }

                                                    }
                                                }

                                            }
                                        }
                                    }
                                }
                            } else {

                                String n2;
                                n2 = a[1] + " " + a[2];
                                if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], cedula, numeroCel, fechaNac);
                                    lista();

                                } else {
                                    if (!cedula.isEmpty() && fechaNac != null) {
                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], cedula, "", fechaNac);
                                        lista();

                                    } else {
                                        if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], cedula, numeroCel, null);
                                            lista();

                                        } else {
                                            if (fechaNac != null && !numeroCel.isEmpty()) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], "", numeroCel, fechaNac);
                                                lista();

                                            } else {
                                                if (!cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], cedula, "", null);
                                                    lista();

                                                } else {
                                                    if (!numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], "", numeroCel, null);
                                                        lista();

                                                    } else {
                                                        if (fechaNac != null) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], "", "", fechaNac);
                                                            lista();

                                                        } else {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n2, a[3], a[4], "", "", null);
                                                            lista();
                                                        }

                                                    }
                                                }

                                            }
                                        }
                                    }

                                }
                            }
                        } else {
                            if (a.length == 4) {
                                if ("LOS".equals(a[2]) || "LA".equals(a[2])) {
                                    String n3;
                                    n3 = a[1] + " " + a[2] + " " + a[3];
                                    if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", cedula, numeroCel, fechaNac);
                                        lista();

                                    } else {
                                        if (!cedula.isEmpty() && fechaNac != null) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", cedula, "", fechaNac);
                                            lista();

                                        } else {
                                            if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", cedula, numeroCel, null);
                                                lista();

                                            } else {
                                                if (fechaNac != null && !numeroCel.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", "", numeroCel, fechaNac);
                                                    lista();

                                                } else {
                                                    if (!cedula.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", cedula, "", null);
                                                        lista();

                                                    } else {
                                                        if (!numeroCel.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", "", numeroCel, null);
                                                            lista();

                                                        } else {
                                                            if (fechaNac != null) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", "", "", fechaNac);
                                                                lista();

                                                            } else {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n3, "", "", "", "", null);
                                                                lista();
                                                            }

                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if ("DEL".equals(a[1]) || "DE".equals(a[1])) {
                                        String n1;
                                        n1 = a[1] + " " + a[2];
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", cedula, numeroCel, fechaNac);
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], cedula, numeroCel, fechaNac));
                                            lista();

                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", cedula, "", fechaNac);
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], cedula, "", fechaNac));
                                                lista();

                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", cedula, numeroCel, null);
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], cedula, numeroCel, null));
                                                    lista();

                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", "", numeroCel, fechaNac);
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], "", numeroCel, fechaNac));
                                                        lista();

                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", cedula, "", null);
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], cedula, "", null));
                                                            lista();

                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", "", numeroCel, null);
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], "", numeroCel, null));
                                                                lista();

                                                            } else {
                                                                if (fechaNac != null) {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", "", "", fechaNac);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], "", "", fechaNac));
                                                                    lista();

                                                                } else {

                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, a[3], "", "", "", null);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", a[3], "", "", null));
                                                                    lista();
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], cedula, numeroCel, fechaNac);
                                            lista();

                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], cedula, "", fechaNac);
                                                lista();

                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], cedula, numeroCel, null);
                                                    lista();

                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], "", numeroCel, fechaNac);
                                                        lista();

                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], cedula, "", null);
                                                            lista();

                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], "", numeroCel, null);
                                                                lista();

                                                            } else {
                                                                if (fechaNac != null) {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], "", "", fechaNac);
                                                                    lista();

                                                                } else {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], a[3], "", "", null);
                                                                    lista();
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }

                                        }
                                    }
                                }
                            } else {
                                if (a.length == 3) {

                                    if ("DEL".equals(a[1]) || "DE".equals(a[1])) {
                                        String n1;
                                        n1 = a[1] + " " + a[2];
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", cedula, numeroCel, fechaNac);
                                            lista();

                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", cedula, "", fechaNac);
                                                lista();

                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", cedula, numeroCel, null);
                                                    lista();

                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", "", numeroCel, fechaNac);
                                                        lista();

                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", cedula, "", null);
                                                            lista();

                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", "", numeroCel, null);
                                                                lista();

                                                            } else {
                                                                if (fechaNac != null) {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", "", "", fechaNac);
                                                                    lista();

                                                                } else {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], n1, "", "", "", "", null);
                                                                    lista();
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], cedula, numeroCel, fechaNac);
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], cedula, numeroCel, fechaNac));
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], cedula, numeroCel, fechaNac));
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", cedula, numeroCel, fechaNac));
                                            lista();

                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], cedula, "", fechaNac);
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], cedula, "", fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], cedula, "", fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", cedula, "", fechaNac));
                                                lista();

                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], cedula, numeroCel, null);
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], cedula, numeroCel, null));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], cedula, numeroCel, null));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", cedula, numeroCel, null));
                                                    lista();

                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], "", numeroCel, fechaNac);
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], "", numeroCel, fechaNac));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], "", numeroCel, fechaNac));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", "", numeroCel, fechaNac));
                                                        lista();

                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], cedula, "", null);
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], cedula, "", null));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], cedula, "", null));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", cedula, "", null));
                                                            lista();

                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], "", numeroCel, null);
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], "", numeroCel, null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], "", numeroCel, null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", "", numeroCel, null));
                                                                lista();

                                                            } else {
                                                                if (fechaNac != null) {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], "", "", fechaNac);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], "", "", fechaNac));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], "", "", fechaNac));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", "", "", fechaNac));
                                                                    lista();

                                                                } else {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], a[2], "", "", null);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], a[2], "", "", null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", a[2], "", "", null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], a[2], "", "", "", null));
                                                                    lista();
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }

                                        }
                                    }
                                } else {
                                    if (a.length == 2) {
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", cedula, numeroCel, fechaNac);
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", cedula, numeroCel, fechaNac));
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], cedula, numeroCel, fechaNac));
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", cedula, numeroCel, fechaNac));
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], cedula, numeroCel, fechaNac));
                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], cedula, numeroCel, fechaNac));
                                            lista();

                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", cedula, "", fechaNac);
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", cedula, "", fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], cedula, "", fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", cedula, "", fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], cedula, "", fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], cedula, "", fechaNac));
                                                lista();

                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", cedula, numeroCel, null);
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", cedula, numeroCel, null));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], cedula, numeroCel, null));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", cedula, numeroCel, null));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], cedula, numeroCel, null));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], cedula, numeroCel, null));
                                                    lista();

                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", "", numeroCel, fechaNac);
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", "", numeroCel, fechaNac));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], "", numeroCel, fechaNac));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", "", numeroCel, fechaNac));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], "", numeroCel, fechaNac));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], "", numeroCel, fechaNac));
                                                        lista();

                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", cedula, "", null);
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", cedula, "", null));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], cedula, "", null));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", cedula, "", null));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], cedula, "", null));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], cedula, "", null));
                                                            lista();

                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", "", numeroCel, null);
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", "", numeroCel, null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], "", numeroCel, null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", "", numeroCel, null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], "", numeroCel, null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], "", numeroCel, null));
                                                                lista();

                                                            } else {
                                                                if (fechaNac != null) {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", "", "", fechaNac);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", "", "", fechaNac));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], "", "", fechaNac));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", "", "", fechaNac));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], "", "", fechaNac));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], "", "", fechaNac));

                                                                    lista();

                                                                } else {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], a[1], "", "", "", "", null);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", a[1], "", "", "", null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", a[1], "", "", null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], a[1], "", "", "", null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", a[1], "", "", null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], a[1], "", "", null));
                                                                    lista();
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (a.length == 1) {
                                            if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", cedula, numeroCel, fechaNac);
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", cedula, numeroCel, fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", cedula, numeroCel, fechaNac));
                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], cedula, numeroCel, fechaNac));
                                                lista();

                                            } else {
                                                if (!cedula.isEmpty() && fechaNac != null) {
                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", cedula, "", fechaNac);
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", cedula, "", fechaNac));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", cedula, "", fechaNac));
                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], cedula, "", fechaNac));
                                                    lista();

                                                } else {
                                                    if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", cedula, numeroCel, null);
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", cedula, numeroCel, null));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", cedula, numeroCel, null));
                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], cedula, numeroCel, null));
                                                        lista();

                                                    } else {
                                                        if (fechaNac != null && !numeroCel.isEmpty()) {
                                                            listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", "", numeroCel, fechaNac);
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", "", numeroCel, fechaNac));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", "", numeroCel, fechaNac));
                                                            listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], "", numeroCel, fechaNac));
                                                            lista();

                                                        } else {
                                                            if (!cedula.isEmpty()) {
                                                                listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", cedula, "", null);
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", cedula, "", null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", cedula, "", null));
                                                                listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], cedula, "", null));
                                                                lista();

                                                            } else {
                                                                if (!numeroCel.isEmpty()) {
                                                                    listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", "", numeroCel, null);
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", "", numeroCel, null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", "", numeroCel, null));
                                                                    listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], "", numeroCel, null));
                                                                    lista();

                                                                } else {
                                                                    if (fechaNac != null) {
                                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", "", "", fechaNac);
                                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", "", "", fechaNac));
                                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", "", "", fechaNac));
                                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], "", "", fechaNac));

                                                                        lista();

                                                                    } else {
                                                                        listaExamen = ExamenEJB.buscarExamenPorDosNombreDosApellido(a[0], "", "", "", "", "", null);
                                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", a[0], "", "", "", "", null));
                                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", a[0], "", "", "", null));
                                                                        listaExamen.addAll(ExamenEJB.buscarExamenPorDosNombreDosApellido("", "", "", a[0], "", "", null));
                                                                        lista();
                                                                    }

                                                                }
                                                            }

                                                        }
                                                    }
                                                }

                                            }

                                        }

                                    }

                                }

                            }
                        }

                    }

                }
            }
        }
    }

    public String getDatosAbiertos_Recomendaciones() {
        if (this.ExamenSelect.getResultadoExamenList() != null) {
            for (int i = 0; i < this.ExamenSelect.getResultadoExamenList().size(); i++) {

                if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 8) {
                    datosAbiertos_Recomendaciones = this.ExamenSelect.getResultadoExamenList().get(i).getDescripcion();
                }

            }
        }
        return datosAbiertos_Recomendaciones;
    }

    public void setDatosAbiertos_Recomendaciones(String datosAbiertos_Recomendaciones) {
        this.datosAbiertos_Recomendaciones = datosAbiertos_Recomendaciones;
    }

    public void guardarOactualizar() {
        HashSet st = new HashSet();
        st.addAll(catlista);
        catlista.clear();
        catlista.addAll(st);
        this.ExamenSelect.setCatalogoList(catlista);
        this.ExamenSelect.setIdSectorResidencia(this.getSectorSelect());

        HashSet st1 = new HashSet();
        st1.addAll(resultadoExamen);

        resultadoExamen.clear();
        resultadoExamen.addAll(st1);

        try {
            if (ExamenEJB.buscarID(ExamenSelect.getIdExamen()).isEmpty()) {
                System.out.print(ExamenSelect.getPrimerApellido() + ExamenSelect.getPrimerNombre());
                ExamenSelect.setEstado(BigInteger.valueOf(1));

                this.ExamenSelect = ExamenEJB.crearNuevo(this.ExamenSelect);

                this.pasarValorResutado();
                //this.PasarValoresUnidades();

                System.out.println("resultado es " + resultadoExamen.size());
                this.ExamenSelect.setResultadoExamenList(resultadoExamen);

                System.out.println("resultado es " + ExamenSelect.getResultadoExamenList().size());
                //bloque que agrega la fecha toma
                System.out.println(this.ExamenSelect.getIdExamen() + " " + FechaMB.getFechaList().get(0).getIdFecha() + " " + fecha);
                FxexuPK nfpk = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(0).getIdFecha());
                Fxexu nf = new Fxexu(nfpk, fecha, medicoSelect);
                fechalista.add(nf);
                ExamenSelect.setFxexuList(fechalista);

                ExamenSelect = ExamenEJB.actualizar(ExamenSelect);
                this.ExamenSelect = ExamenEJB.buscarID(ExamenSelect.getIdExamen()).get(0);
                this.asignarResutados();
                // this.AsignarUnidades();
                //finaliza bloque que agrega la fecha
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro Se Guardó Exitosamente", ""));

            } else {

                this.pasarValorResutado();
                //  this.PasarValoresUnidades();
                this.ExamenSelect.setResultadoExamenList(resultadoExamen);

                //bloque que agrega la fecha
                System.out.println(this.ExamenSelect.getIdExamen() + " " + FechaMB.getFechaList().get(0).getIdFecha() + " " + fecha);
                FxexuPK nfpk = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(0).getIdFecha());
                Fxexu nf = new Fxexu(nfpk, fecha, medicoSelect);
                fechalista.add(nf);

//                List<Fxexu> fds = new ArrayList<Fxexu>();
//                fds = ExamenSelect.getFxexuList();
//                
                ExamenSelect.setFxexuList(fechalista);
                //finaliza bloque que agrega la fecha

                ExamenSelect = ExamenEJB.actualizar(ExamenSelect);
                this.ExamenSelect = ExamenEJB.buscarID(ExamenSelect.getIdExamen()).get(0);

                // this.resultadoExamen.clear();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro Se Actualizó Correctamente", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se Guardó", ""));
        }

        fechalista.clear();
//        fecha = null;
//        catlista.clear();
//        cat_esc = null;
//        catalogos = null;
        this.asignarResutados();
        this.AsignarUnidades();
        cargar();
        cargarCatalogos();
        listaPrimerParteExamen = ExamenEJB.buscarPrimerParteExamen(ExamenSelect.getIdExamen());
    }

    public Examen nuevaMiembro() {
        ExamenSelect = null;
        examen = new Examen();

        return examen;
    }

    public void guardarResultadoExamen() {

        List<ResultadoExamen> listaTemporal = new ArrayList<ResultadoExamen>();

        try {
            System.out.println(" Numero de Registros por Examen " + this.ExamenSelect.getResultadoExamenList().size());
            if (this.ExamenSelect.getResultadoExamenList() != null) {
                System.out.println("Valor del Estado " + ExamenSelect.getEstado());

                HashSet st1 = new HashSet();
                st1.addAll(listaresultadosExamen);
                listaresultadosExamen.clear();
                listaresultadosExamen.addAll(st1);

                if (ExamenSelect.getEstado() == BigInteger.valueOf(1)) {
                    resultadExamen1.setIdExamen(ExamenSelect);
                    resultadExamen1.setIdCategoria(categoria);
                    resultadExamen1.setIdSubcategoria(subCategoriaFrotis);
                    resultadExamen1.setIdValor(valorFrotis);

                    this.listaresultadosExamen.add(resultadExamen1);

                    resultadExamen2.setIdExamen(ExamenSelect);
                    resultadExamen2.setIdCategoria(this.CategoriaMB.getCategoriaResultado());
                    resultadExamen2.setIdSubcategoria(subCategoriaResultado);
                    resultadExamen2.setIdValor(valorResultado);

                    this.listaresultadosExamen.add(resultadExamen2);

                    ExamenSelect.setEstado(BigInteger.valueOf(2));

                    listaTemporal.addAll(this.ExamenSelect.getResultadoExamenList());
                    this.ExamenSelect.setResultadoExamenList(listaresultadosExamen);

                    FxexuPK nfpk = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(1).getIdFecha());
                    Fxexu nf = new Fxexu(nfpk, fecha_Lectura, null);

                    FxexuPK nfpk2 = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(3).getIdFecha());
                    Fxexu nf2 = new Fxexu(nfpk2, Fecha_Seguimiento, null);

                    if (tipoExSegui != null) {
                        nf2.setTipoSeguimiento(tipoExSegui.getCatalogoId());
                    } else {
                        nf2.setTipoSeguimiento(null);
                    }

                    if (Fecha_PosTratamiento != null) {
                        FxexuPK nfpk3 = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(4).getIdFecha());
                        Fxexu nf3 = new Fxexu(nfpk3, Fecha_PosTratamiento, null);
                        fechalista.add(nf3);
                    }

                    fechalista.add(nf);
                    fechalista.add(nf2);

                    ExamenSelect.setFxexuList(fechalista);

                    ExamenSelect = ExamenEJB.actualizar(ExamenSelect);
                    ExamenSelect = ExamenEJB.RefrescarObjetoExamen(ExamenSelect);

                    this.ExamenSelect.getResultadoExamenList().addAll(listaTemporal);
                    listaTemporal.clear();

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro Se Guardó Exitosamente", ""));
                    System.out.println("Guardando....");
                } else if (ExamenSelect.getEstado() == BigInteger.valueOf(2)) {
                    System.out.println("Adentro");

                    for (int i = 0; i < ExamenSelect.getResultadoExamenList().size(); i++) {
                        if (ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 5) {
                            System.out.println("Mas Adentro");
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdExamen(ExamenSelect);
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdCategoria(categoria);
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdSubcategoria(subCategoriaFrotis);
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdValor(valorFrotis);
                            this.resultadoExamen.add(this.ExamenSelect.getResultadoExamenList().get(i));
                            System.out.println("Modificando frotis..... ");
                        } else if (ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 6) {
                            System.out.println("Mas Adentro Resultado");
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdExamen(ExamenSelect);
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdCategoria(this.CategoriaMB.getCategoriaResultado());
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdSubcategoria(subCategoriaResultado);
                            this.ExamenSelect.getResultadoExamenList().get(i).setIdValor(valorResultado);
                            this.resultadoExamen.add(this.ExamenSelect.getResultadoExamenList().get(i));
                            System.out.println("Modificando Resultado..... ");
                        }
                    }

                    System.out.println("Vivo " + this.ExamenSelect.getResultadoExamenList().size());

                    listaTemporal.addAll(this.ExamenSelect.getResultadoExamenList());
                    this.ExamenSelect.setResultadoExamenList(listaresultadosExamen);

                    FxexuPK nfpk = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(1).getIdFecha());
                    Fxexu nf = new Fxexu(nfpk, fecha_Lectura, null);

                    FxexuPK nfpk2 = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(3).getIdFecha());
                    Fxexu nf2 = new Fxexu(nfpk2, Fecha_Seguimiento, null);
                    if (tipoExSegui != null) {
                        nf2.setTipoSeguimiento(tipoExSegui.getCatalogoId());
                    } else {
                        nf2.setTipoSeguimiento(null);
                    }

                    if (Fecha_PosTratamiento != null) {
                        FxexuPK nfpk3 = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(4).getIdFecha());
                        Fxexu nf3 = new Fxexu(nfpk3, Fecha_PosTratamiento, null);
                        fechalista.add(nf3);
                    }

                    fechalista.add(nf);
                    fechalista.add(nf2);

                    ExamenSelect.setFxexuList(fechalista);

                    ExamenSelect = ExamenEJB.actualizar(ExamenSelect);
                    ExamenSelect = ExamenEJB.RefrescarObjetoExamen(ExamenSelect);

                    this.ExamenSelect.getResultadoExamenList().addAll(this.ExamenSelect.getResultadoExamenList());
                    this.ExamenSelect.getResultadoExamenList().addAll(listaTemporal);
                    listaTemporal.clear();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro Se Actualizó Exitosamente", ""));
                }
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se Guardó", ""));
        }

        fechalista.clear();

        this.asignarResutados();
        this.AsignarUnidades();
        cargar();
        cargarCatalogos();

//        this.ExamenSelect.getResultadoExamenList().clear();
//        this.valorFrotis = null;
//        this.valorResultado = null;
    }

    public void guardarEtrega() {

        try {
            if (ExamenSelect.getEstado() == BigInteger.valueOf(2)) {
                this.ExamenSelect.getResultadoExamenList().clear();

                resultadExamen3.setIdExamen(ExamenSelect);
                resultadExamen3.setIdCategoria(this.CategoriaMB.getCategoriaObservacion());
                resultadExamen3.setIdSubcategoria(this.SubCategoriaMB.getObservacion());
                resultadExamen3.setIdValor(valorObservacion);
                resultadExamen3.setDescripcion(this.datosAbiertos_Recomendaciones);

                this.listaresultadosExamen.add(resultadExamen3);
                this.ExamenSelect.setResultadoExamenList(listaresultadosExamen);

                FxexuPK nfpk = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(2).getIdFecha());
                Fxexu nf = new Fxexu(nfpk, fecha_Entrega_Usuario, null);
                fechalista.add(nf);

                ExamenSelect.setFxexuList(fechalista);

                ExamenSelect.setEstado(BigInteger.valueOf(3));
                ExamenSelect = ExamenEJB.actualizar(ExamenSelect);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Registro Se Actualizó Exitosamente", ""));
            }

            if (ExamenSelect.getEstado() == BigInteger.valueOf(3)) {
                for (int i = 0; i < ExamenSelect.getResultadoExamenList().size(); i++) {
                    if (ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 8) {
                        System.out.println("Mas Adentro Observacion");
                        this.ExamenSelect.getResultadoExamenList().get(i).setIdExamen(ExamenSelect);
                        this.ExamenSelect.getResultadoExamenList().get(i).setIdCategoria(this.CategoriaMB.getCategoriaObservacion());
                        this.ExamenSelect.getResultadoExamenList().get(i).setIdSubcategoria(this.SubCategoriaMB.getObservacion());
                        this.ExamenSelect.getResultadoExamenList().get(i).setIdValor(valorObservacion);
                        this.ExamenSelect.getResultadoExamenList().get(i).setDescripcion(datosAbiertos_Recomendaciones);
                        this.resultadoExamen.add(this.ExamenSelect.getResultadoExamenList().get(i));
                        System.out.println("Modificando Observaciones..... ");
                    }
                }

                FxexuPK nfpk = new FxexuPK(this.ExamenSelect.getIdExamen(), FechaMB.getFechaList().get(2).getIdFecha());
                Fxexu nf = new Fxexu(nfpk, fecha_Entrega_Usuario, null);
                fechalista.add(nf);

                ExamenSelect.setFxexuList(fechalista);

                this.ExamenSelect.setResultadoExamenList(listaresultadosExamen);
                ExamenSelect = ExamenEJB.actualizar(ExamenSelect);
                ExamenSelect = ExamenEJB.RefrescarObjetoExamen(ExamenSelect);
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se Guardó", ""));
        }

        fechalista.clear();
        cargar();
        cargarCatalogos();
        this.asignarResutados();
        this.AsignarUnidades();
//        cargarValoresFrotis();
//        cargarValoresResultado();
//        cargarSubCategoriaFrotis();
//        cargarSubCategoriaResultado();
//        this.ExamenSelect.getResultadoExamenList().clear();
//        this.valorFrotis = null;
//        this.valorResultado = null;
    }

    public void expedienteNuevo() {

        if (ExamenSelect.getEstado() != null) {
            System.out.println("Examen # " + ExamenSelect.getIdExamen());
            System.out.println("Esty Aqui");

            Examen ex = new Examen();
            ex.setPrimerNombre(ExamenSelect.getPrimerNombre());
            ex.setSegundoNombre(ExamenSelect.getSegundoNombre());
            ex.setPrimerApellido(ExamenSelect.getPrimerApellido());
            ex.setSegundoApellido(ExamenSelect.getSegundoApellido());
            ex.setCedula(ExamenSelect.getCedula());
            ex.setFechaNacimiento(ExamenSelect.getFechaNacimiento());
            ex.setDireccionActual(ExamenSelect.getDireccionActual());
            ex.setNumeroExpediente(ExamenSelect.getNumeroExpediente());
            ex.setIdPersona(ExamenSelect.getIdPersona());
            ex.setTelefono(ExamenSelect.getTelefono());
            ex.setTelefono2(ExamenSelect.getTelefono2());
            ex.setIdComunidadResidencia(ExamenSelect.getIdComunidadResidencia());
            ex.setCatalogoList(ExamenSelect.getCatalogoList());
//            ex.setIdComunidadResidencia(null);

            /**
             * Hacemos al examen seleccionado el cual contiene los registros a
             * guardar nulo
             */
            ExamenSelect = null;

            /**
             * al examen se le asigna un nuevo objeto para guardar otro examen
             * similar
             */
            ExamenSelect = ex;

            this.HabilitarTelefono1 = true;
            this.HabilitarTelefono2 = true;
            this.HabilitarExpedienteTemp = true;

            cargarCatalogos();
            cargarDepartamentoSelect();

            /**
             * Hacemos nulos los campos de Antecedentes Ginecobstetricos
             */
            this.Gestasi = 0;
            this.Abortosi = 0;
            this.Cesareasi = 0;
            this.partosi = 0;
            Menarcai = 0;
            semanaDeGestasi = 0;

            valorEmbarazoActual = null;
            valorFuma = null;
            valorToma = null;

            FUR = null;
            metodoAnticonceptivo = null;
            CatalogoMB.getListaTipoMetodo().clear();

            /**
             * Hacemos nulos los campos de descripcion de la muestra
             */
            silaisTomaDM = null;
            listaEntidadAdtva.clear();
            unidadTomaDm = null;
            listaUnidadesTomaDm.clear();
            municipioTomaDm = null;
            listaUnidadesTomaDm.clear();
            //  Procedencia = null;
            valorProcedencia = null;
            //AspectoClinico = null;
            valorAspecto = null;
            //Secrecion = null;
            valorSecrecion = null;
            fecha = null;

            /**
             * Hacemos Nulos los campos de Resultado
             */
            fecha_Lectura = null;
            subCategoriaFrotis = new SubCategoria();
            valorFrotis = null;
            this.ValoresMB.getListaValoresFrotis().clear();
            subCategoriaResultado = new SubCategoria();
            valorResultado = null;
            this.ValoresMB.getListaValoresResultado().clear();
            valorObservacion = new Valores();
            this.ValoresMB.getListaValoresResultado().clear();
            Fecha_PosTratamiento = null;
            Fecha_Seguimiento = null;

            this.asignarResutados();
            this.AsignarUnidades();

            this.Ventana = "DtsGnrals";

        } /**
         * Aqui el codigo se repite para limpiar los campos cuando se estan
         * ingresando los examenes uno por uno ingresando
         */
        else if (ExamenSelect.getEstado() == null) {
            System.out.println("Examen Nulo " + ExamenSelect.getEstado());

            ExamenSelect.setIdExamen(null);

            this.cat_esc = null;
            this.catalogos = null;
            this.Valor_Etnia = null;
            this.valor_Procedencia = null;
            this.departamentoSelect = null;
            //listaDepartamentos.clear();
            this.municipioSelect = null;
//            listaMunicipios.clear();
            sectores.clear();
            this.sectorSelect = null;

            this.Gestasi = 0;
            this.Abortosi = 0;
            this.Cesareasi = 0;
            this.partosi = 0;
            Menarcai = 0;
            semanaDeGestasi = 0;

            //  Categorias.clear();
            valorEmbarazoActual = null;
            valorFuma = null;
            valorToma = null;

            FUR = null;
            metodoAnticonceptivo = null;

            silaisTomaDM = null;
            listaEntidadAdtva.clear();
            unidadTomaDm = null;
            listaUnidadesTomaDm.clear();
            municipioTomaDm = null;
            listaUnidadesTomaDm.clear();
            //Procedencia = null;
            valorProcedencia = null;
            //AspectoClinico = null;
            valorAspecto = null;
            //Secrecion = null;
            valorSecrecion = null;
            fecha = null;

            fecha_Lectura = null;
            subCategoriaFrotis = new SubCategoria();
            valorFrotis = null;
            //  listaValoresFrotis.clear();
            subCategoriaResultado = new SubCategoria();
            valorResultado = null;
            //listaValoresResultado.clear();
            valorObservacion = new Valores();
            //listaValoresResultado.clear();
            Fecha_PosTratamiento = null;
            Fecha_Seguimiento = null;

            this.asignarResutados();
            this.AsignarUnidades();
            cargarDepartamentoSelect();

//            this.cargarSubCategoriaFuma();
//            this.cargarSubCategoriaToma();
//            this.cargarSubCategoriaEmbarazoActual();
            SisPersonas sis = PersonaMB.ParaExpediente(ExamenSelect.getIdPersona());
            String codigo = null;
            String Nombres = null;
            String codigoGenerado = null;
            String sexo = null;
            String fechaNaci = null;
            int increment;
            boolean listo = false;
            int op = 0;

            /**
             * Habilitando Los Campos de Nombres Y apellidos
             */
            this.HabilitarPrimerNombre = true;
            this.HabilitarSegundoNombre = true;
            this.HabilitarPrimerApellido = true;
            this.HabilitarSegundoApellido = true;
            this.HabilitarCedula = true;
            this.HabilitarFechaNacimiento = true;
            this.HabilitarComboEscolaridad = true;
            this.HabilitarComboOcupacion = true;
            this.HabilitarComboEtnia = true;
            this.HabilitarComboProcedencia = true;
            this.HabilitarTelefono1 = true;
            this.HabilitarTelefono2 = true;
            this.HabilitarExpedienteTemp = true;
            this.HabilitarComboComunidad = true;
            this.HabilitarComboBarrio = true;
            System.out.println("en el metodo 2 de generar expediente");
            while (listo == false) {

                switch (op) {

                    case 0:

                        System.out.println("case 0 del wihe numero 2");
                        if (sis.getSegundoNombre() != null && sis.getSegundoApellido() != null) {

                            if (sis.getSegundoNombre().equals(" ") && sis.getSegundoApellido().equals(" ")) {
                                Nombres = sis.getPrimerNombre().charAt(0) + "9" + sis.getPrimerApellido().charAt(0) + "9";

                            } else if (sis.getSegundoNombre().equals(" ")) {
                                Nombres = sis.getPrimerNombre().charAt(0) + "9" + sis.getPrimerApellido().charAt(0) + "" + sis.getSegundoApellido().charAt(0);

                            } else if (sis.getSegundoApellido().equals(" ")) {
                                StringTokenizer st = new StringTokenizer(sis.getSegundoNombre());
                                String[] b;
                                int i = 0;
                                b = new String[st.countTokens()];
                                while (st.hasMoreTokens()) {
                                    b[i] = st.nextElement().toString();
                                    i++;
                                }

                                if (b.length == 3) {
                                    System.out.println("en el 3");
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[2].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "9";
                                    op = 1;
                                    break;

                                } else if (b.length == 2) {
                                    System.out.println("en el 2");
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[1].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "9";
                                    op = 1;
                                    break;

                                } else {
                                    System.out.println("en el 1");
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[0].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "9";
                                    op = 1;
                                    break;

                                }

                            } else {
                                StringTokenizer st = new StringTokenizer(sis.getSegundoNombre());
                                String[] b;
                                int i = 0;
                                b = new String[st.countTokens()];
                                while (st.hasMoreTokens()) {
                                    b[i] = st.nextElement().toString();
                                    i++;
                                }

                                if (b.length == 3) {
                                    System.out.println("en el 3");
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[2].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "" + sis.getSegundoApellido().charAt(0);
                                    op = 1;
                                    break;

                                } else if (b.length == 2) {
                                    System.out.println("en el 2");
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[1].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "" + sis.getSegundoApellido().charAt(0);
                                    op = 1;
                                    break;

                                } else {
                                    System.out.println("en el 1");
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[0].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "" + sis.getSegundoApellido().charAt(0);
                                    op = 1;
                                    break;

                                }
                            }

                        } else if (sis.getSegundoNombre() != null) {

                            if (sis.getSegundoNombre().equals(" ")) {

                                System.out.println("pura mierda");
                                Nombres = sis.getPrimerNombre().charAt(0) + "9" + sis.getPrimerApellido().charAt(0) + "9";
                            } else {

                                StringTokenizer st = new StringTokenizer(sis.getSegundoNombre());
                                String[] b;
                                int i = 0;
                                b = new String[st.countTokens()];
                                while (st.hasMoreTokens()) {
                                    b[i] = st.nextElement().toString();
                                    i++;
                                }
                                if (b.length == 3) {
                                    System.out.println("en el 3 DE SOLO NOMBRE" + b.length);
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[2].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "9";
                                    op = 1;
                                    break;

                                } else if (b.length == 2) {
                                    System.out.println("en el 2 DE SOLO NOMBRE" + b.length);
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[1].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "9";
                                    op = 1;
                                    break;

                                } else {
                                    System.out.println("en el 1 DE SOLO NOMBRE" + b.length);
                                    Nombres = sis.getPrimerNombre().charAt(0) + "" + b[0].charAt(0) + "" + sis.getPrimerApellido().charAt(0) + "9";
                                    op = 1;
                                    break;

                                }
                            }

                        } else if (sis.getSegundoApellido() != null) {

                            if (sis.getSegundoApellido().equals(" ")) {
                                Nombres = sis.getPrimerNombre().charAt(0) + "9" + sis.getPrimerApellido().charAt(0) + "9";

                            } else {

                                Nombres = sis.getPrimerNombre().charAt(0) + "9" + sis.getPrimerApellido().charAt(0) + "" + sis.getSegundoApellido().charAt(0);
                                op = 1;
                                break;
                            }
                        } else {
                            Nombres = sis.getPrimerNombre().charAt(0) + "9" + sis.getPrimerApellido().charAt(0) + "9";
                            op = 1;
                            break;
                        }

                    case 1:
                        System.out.println("se fue");
                        if (sis.getCodigoMunicipioNacimiento() != null) {
                            if (entidadAdtvaMB.getListaCSEdeMunicipios(sis.getCodigoMunicipioNacimiento()).get(0).getCodigoCse() != null) {

                                codigo = entidadAdtvaMB.getListaCSEdeMunicipios(sis.getCodigoMunicipioNacimiento()).get(0).getCodigoCse().toString();
                                op = 2;
                                break;

                            } else {
                                codigo = "800";
                                op = 2;
                                break;
                            }
                        } else {
                            codigo = "800";
                            op = 2;
                            break;

                        }

                    case 2:
                        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
                        String con = fd.format(sis.getFechaNacimiento());
                        fechaNaci = con.charAt(0) + "" + con.charAt(1) + "" + con.charAt(3)
                                + "" + con.charAt(4) + "" + con.charAt(8) + "" + con.charAt(9);
                        System.out.println(sis.getFechaNacimiento());

                        op = 3;
                        break;
                    case 3:
                        sexo = sis.getCodigoSexo().charAt(5) + "";
                        op = 4;
                        break;
                    case 4:

                        String temCod = codigo + Nombres + sexo + fechaNaci;
                        int tam = ExamenEJB.porCodExpediente(temCod).size();

                        if (tam > 0) {

                            int i;
                            List<Examen> lis = ExamenEJB.porCodExpediente(temCod);
                            for (i = 0; tam > i; i++) {

                                if (lis.get(i).getIdPersona() == sis.getPersonaId()) {
                                    System.out.println("si se encontro coincidencia");
                                    this.ExamenSelect.setNumeroExpediente(lis.get(i).getNumeroExpediente());
                                } else {
                                }
                            }

                            if (this.ExamenSelect.getNumeroExpediente().equals("")) {
                                increment = tam + 1;
                                codigoGenerado = codigo + Nombres + sexo + fechaNaci + "0" + increment;
                                this.ExamenSelect.setNumeroExpediente(codigoGenerado);
                                listo = true;
                                break;
                            } else {
                                System.out.println("no se entro al if");
                                listo = true;
                                break;
                            }

                        } else {

                            increment = 1;
                            codigoGenerado = codigo + Nombres + sexo + fechaNaci + "0" + increment;
                            listo = true;
                            this.ExamenSelect.setNumeroExpediente(codigoGenerado);
                            System.out.println("no se encotro coincidencia");
                            break;
                        }

                }

            }
            this.Ventana = "DtsGnrals";
        }
    }
    public void cargarResultadosXexamenParteUno() throws ParseException {
        // cargar gestas
        Gestasi = Integer.parseInt(this.re[0].getDescripcion());
        //cargar partos
        partosi = Integer.parseInt(this.re[1].getDescripcion());
        //caragarAbortos
        Abortosi = Integer.parseInt(this.re[2].getDescripcion());
        // cargar cesarias
        Cesareasi = Integer.parseInt(this.re[3].getDescripcion());
        //caragar IVSA
        IVSAi = Integer.parseInt(this.re[4].getDescripcion());
        //cargar datos menarcas
           Menarcai = Integer.parseInt(this.re[7].getDescripcion());
           // cargar semanas gestas
             semanaDeGestasi = Integer.parseInt(this.re[6].getDescripcion());
// cargar valor fuma
                valorFuma = this.re[8].getIdValor();
                //cargar valor toma
                  valorToma = this.re[9].getIdValor();
                 //cargar embarazo actual
                   valorEmbarazoActual = this.re[10].getIdValor();
                   //cargar fur
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            FUR = formatter.parse(this.re[5].getDescripcion());
              //cargar valor procedencia
                valorProcedencia = re[11].getIdValor();
                //cargar aspecto clinico
                    valorAspecto = this.re[12].getIdValor();
                    //cargar valor secrecion
                    this.valorSecrecion= this.re[13].getIdValor();
                    
                  
    }
    
    public void cargarResultadosXexamenParteDos(){
        
      //cargar valores frotis
         for (int i = 0; i < this.ExamenSelect.getResultadoExamenList().size(); i++) {

                if (this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria().getIdCategoria().getIdCategoria() == 5) {
                    valorFrotis = this.ExamenSelect.getResultadoExamenList().get(i).getIdValor();
                }else  if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 6) {
                    valorResultado = this.ExamenSelect.getResultadoExamenList().get(i).getIdValor();
                }else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getDescripcion().equals("Frotis")) {
                    subCategoriaFrotis = this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria();
                }else if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 6) {
                    subCategoriaResultado = this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria();
                }
                    
            
         }
         
         
         
        
    }

    public void expediente() throws ParseException {

        /**
         * cargar datos respectivos cuando una persona ya tiene un examen
         */
        System.out.println(ExamenSelect.getPrimerNombre());

        this.asignarResutados();
        this.AsignarUnidades();
        cargarDepartamentoSelect();
        cargar();
        cargarCatalogos();
    
      
   
        this.cargarMetodoAnticonceptivo();
    
        
        cargarSilaisTomaDM();
        cargarUnidadTomaDM();
    

        cargarSilaisTomaResultado();
        cargarUnidadTomaResultado();
        
        cargarResultadosXexamenParteUno();

 
        /**
         * Esta Comparacion compara si el examen de una persona se encuentra en
         * el primer paso, de ser asi la interfaz se mostrara en la 4ta ventana,
         * en caso en que el examen se encuentre en el 2do paso aparecera la
         * ultima interfaz al usuario, de manera que este no tendra que navegar
         * desde la primer pestaña para poder llegar a la que desea.
         */
        if (ExamenSelect.getEstado() == BigInteger.valueOf(1)) {
            this.Ventana = "NumLam";
            
        } else if (ExamenSelect.getEstado() == BigInteger.valueOf(2)) {
            this.Ventana = "Recomendns";
            cargarResultadosXexamenParteDos();
        }

    }


    public void calcularEdad(SelectEvent event) {
        SisPersonas sis = PersonaMB.ParaExpediente(ExamenSelect.getIdPersona());

        Calendar FechaNacimiento = Calendar.getInstance();
        Calendar FechaActual = Calendar.getInstance();

        FechaNacimiento.setTime(sis.getFechaNacimiento());
        FechaActual.setTime(fecha);

        int año = FechaActual.get(Calendar.YEAR) - FechaNacimiento.get(Calendar.YEAR);
        int mes = FechaActual.get(Calendar.MONTH) - FechaNacimiento.get(Calendar.MONTH);
        int dia = FechaActual.get(Calendar.DATE) - FechaNacimiento.get(Calendar.DATE);

        if (mes < 0 || (mes == 0 && dia < 0)) {
            año--;
        }

        BigInteger Edad = new BigInteger(Integer.toString(año));
        this.ExamenSelect.setEdad(Edad);

    }

    public void cargarSubCategoriaFrotis() {
        if (this.ExamenSelect.getResultadoExamenList() != null) {
            for (int i = 0; i < this.ExamenSelect.getResultadoExamenList().size(); i++) {
                if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getDescripcion().equals("Frotis")) {
                    subCategoriaFrotis = this.ExamenSelect.getResultadoExamenList().get(i).getIdSubcategoria();
                }
            }
        }
    }

    public void pacienteExistente() {
        if (ExamenSelect.getEstado() == null) {
            nuevoPaciente = true;
        }
    }

    /**
     * Este metodo verifica atraves de estas variables si una persona ya tiene
     * un examen si lo tiene el boton de continuar examen se habilita, si no
     * este se deshabilitara
     */
    public void verificarPaciente(SelectEvent event) {
        Examen examenPaciente;
        examenPaciente = (Examen) event.getObject();
        if (examenPaciente.getEstado() == BigInteger.valueOf(1) || examenPaciente.getEstado() == BigInteger.valueOf(2)) {
            nuevoPaciente = true;
            continuarPaciente = true;
        } else {
            nuevoPaciente = true;
            continuarPaciente = false;
        }
    }

    public Catalogos getTipoExSegui() {
        return tipoExSegui;
    }

    public void setTipoExSegui(Catalogos tipoExSegui) {
        this.tipoExSegui = tipoExSegui;
    }

  

   

    public void setValorObservacion(Valores valorObservacion) {
        this.valorObservacion = valorObservacion;
    }

   


   
  
   

    public Catalogos getValor_TipoExamen() {
        return valor_TipoExamen;
    }

    public void setValor_TipoExamen(Catalogos valor_TipoExamen) {
        catlista.add(valor_TipoExamen);
        this.valor_TipoExamen = valor_TipoExamen;
    }

    /**
     * En este método se calcula la fecha en base a la observación. cuando se
     * compara con el cod. 64 es repetir en un año. cuando se compara con el
     * cod. 65 es PAP urgente. cuando se compara con el cod. 66 es Pap
     * seguimiento 3 años. cuando se compara con el cod. 67 es Pap control 4 a 6
     * meses. cuando se compara con el cod. 83 es VPH seguimiento1 año.
     *
     */
    public void calcularFechaSeguiniento() {

        Fecha_Seguimiento = new Date();
        Fecha_Seguimiento.setDate(fecha.getDate());
        Fecha_Seguimiento.setMonth(fecha.getMonth());
        Fecha_Seguimiento.setYear(fecha.getYear());
//        n = 1;
//        System.out.println(Fecha_Seguimiento + " " + valorObservacion.getIdValor());
        if (valorObservacion.getIdValor().equals(BigDecimal.valueOf(64))) {
//            Fecha_Seguimiento.setDate(fecha.getDate());
//            Fecha_Seguimiento.setMonth(fecha.getMonth());
            Fecha_Seguimiento.setYear(Fecha_Seguimiento.getYear() + 1);
            setTipoExSegui(null);
        } else if (valorObservacion.getIdValor().equals(BigDecimal.valueOf(65))) {
            Fecha_Seguimiento.setMonth(Fecha_Seguimiento.getMonth() + 1);
//            Fecha_Seguimiento.setYear(fecha.getYear());
//            Fecha_Seguimiento.setDate(fecha.getDate());
            setTipoExSegui(null);
        } else if (valorObservacion.getIdValor().equals(BigDecimal.valueOf(66))) {
//            Fecha_Seguimiento.setMonth(fecha.getMonth());
            Fecha_Seguimiento.setYear(Fecha_Seguimiento.getYear() + 3);
//            Fecha_Seguimiento.setDate(fecha.getDate());
            setTipoExSegui(null);
        } else if (valorObservacion.getIdValor().equals(BigDecimal.valueOf(67))) {
            Fecha_Seguimiento.setMonth(Fecha_Seguimiento.getMonth() + 4);
//            Fecha_Seguimiento.setYear(fecha.getYear());
//            Fecha_Seguimiento.setDate(fecha.getDate());
            setTipoExSegui(null);
        }
        if (valorObservacion.getIdValor().equals(BigDecimal.valueOf(83))) {
//            Fecha_Seguimiento.setDate(fecha.getDate());
//            Fecha_Seguimiento.setMonth(fecha.getMonth());
            Fecha_Seguimiento.setYear(Fecha_Seguimiento.getYear() + 1);

            setTipoExSegui(CatalogoMB.getListaTipoExamen("Exasivipca|VPH").get(0));
        }

    }

    public void cargarCatalogos() {
        //carga cat. escolaridad
        if (this.ExamenSelect != null) {

            if (this.ExamenSelect.getCatalogoList() != null) {
                for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {

                    if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("ESCDA")) {
                        cat_esc = this.ExamenSelect.getCatalogoList().get(i);
                    }

                }
            }
        }

//carga ocupaciones
        if (this.ExamenSelect.getCatalogoList() != null) {
            for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {

                if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("HSF_OCUPA")) {
                    catalogos = this.ExamenSelect.getCatalogoList().get(i);
                }

            }
        }

//carga valor etnia
        if (this.ExamenSelect.getCatalogoList() != null) {
            for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {

                if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("ETNIA")) {
                    Valor_Etnia = this.ExamenSelect.getCatalogoList().get(i);
                }

            }
        }

//carga procedencia
        if (this.ExamenSelect.getCatalogoList() != null) {
            for (int i = 0; i < this.ExamenSelect.getCatalogoList().size(); i++) {

                if (this.ExamenSelect.getCatalogoList().get(i).getDependencia().equals("PROCDNCIA")) {
                    valor_Procedencia = this.ExamenSelect.getCatalogoList().get(i);
                }
            }
        }
    }

    public void cargar() {
//carga fecha de toma
        if (ExamenSelect.getFxexuList() != null) {
            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 1);
            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
                        fecha = this.ExamenSelect.getFxexuList().get(i).getValor();
                    }
                }
            }
        }

        // carga fecha de lectura
        if (this.ExamenSelect.getFxexuList() != null) {
            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 2);
            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
                        System.out.println("Cargando Fecha......");
                        fecha_Lectura = this.ExamenSelect.getFxexuList().get(i).getValor();
                    }
                }
            }
        }

        //carga valores de observacion
        if (this.ExamenSelect.getResultadoExamenList() != null) {
            for (int i = 0; i < this.ExamenSelect.getResultadoExamenList().size(); i++) {

                if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 8) {
                    valorObservacion = this.ExamenSelect.getResultadoExamenList().get(i).getIdValor();
                }

            }
        }

        //carga fecha seguimiento
//        if (n == 1) {
//            n = 0;
//            System.out.println(Fecha_Seguimiento);
//            return Fecha_Seguimiento;
//        } else 
        if (this.ExamenSelect.getFxexuList() != null) {
            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 4);
            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {

                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
                        Fecha_Seguimiento = this.ExamenSelect.getFxexuList().get(i).getValor();
                    }
                }
            }
        }

        // 3 representa el id de Fecha referente a la fecha de entrega
        if (this.ExamenSelect.getFxexuList() != null) {
            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 3);
            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
                        fecha_Entrega_Usuario = this.ExamenSelect.getFxexuList().get(i).getValor();
                    }
                }
            }
        }

        // 5 representa el id de Fecha referente a la fecha de POST_TRATAMIENTO
        if (this.ExamenSelect.getFxexuList() != null) {
            FxexuPK nfxexuPk = new FxexuPK(ExamenSelect.getIdExamen(), 5);
            if (!this.ExamenSelect.getFxexuList().isEmpty()) {
                for (int i = 0; i < this.ExamenSelect.getFxexuList().size(); i++) {
                    if (ExamenSelect.getFxexuList().get(i).getFxexuPK().getIdFecha() == nfxexuPk.getIdFecha()) {
                        Fecha_PosTratamiento = this.ExamenSelect.getFxexuList().get(i).getValor();
                    }
                }
            }
        }
    }

    public void limpiarObjetoExamen() {

        ExamenSelect = null;
        System.out.println(ExamenSelect);

        nombreCompleto = null;
        listaExamen.clear();
        listaSRExamen.clear();

    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public String getEstado() {
        for (int i = 0; i < listaExamenPendiente.size(); i++) {
            if (listaExamenPendiente.get(i).getEstado() == BigInteger.valueOf(1) || listaExamenPendiente.get(i).getEstado() == BigInteger.valueOf(2)) {
                Estado = listaExamenPendiente.get(i).getEstado() + " /3";
            }
        }
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * Metodo para mostrar la fecha en que se realizo el examen para mostarlo en
     * la interfaz 2do datatable
     */
    public Date getFecha_Toma_Muestra_mostrar() {
        for (int j = 0; j < listaExamenPendiente.size(); j++) {
            if (this.listaExamenPendiente.get(j).getFxexuList() != null) {
                for (int i = 0; i < this.listaExamenPendiente.get(j).getFxexuList().size(); i++) {
                    if (listaExamenPendiente.get(j).getFxexuList().get(i).getFxexuPK().getIdFecha() == 1) {
                        Fecha_Toma_Muestra_mostrar = this.listaExamenPendiente.get(j).getFxexuList().get(i).getValor();
                    }
                }
            }
        }

        return Fecha_Toma_Muestra_mostrar;
    }

    public void setFecha_Toma_Muestra_mostrar(Date Fecha_Toma_Muestra_mostrar) {
        this.Fecha_Toma_Muestra_mostrar = Fecha_Toma_Muestra_mostrar;
    }

    public String getResultadoFinal() {
        if (this.ExamenSelect.getResultadoExamenList() != null) {
            for (int i = 0; i < this.ExamenSelect.getResultadoExamenList().size(); i++) {

                if (this.ExamenSelect.getResultadoExamenList().get(i).getIdCategoria().getIdCategoria() == 6) {
                    ResultadoFinal = this.ExamenSelect.getResultadoExamenList().get(i).getIdValor().getValor();
                }

            }
        }
        return ResultadoFinal;
    }

    public void setResultadoFinal(String ResultadoFinal) {
        this.ResultadoFinal = ResultadoFinal;
    }

    public String getNumeroLamina() {
        return NumeroLamina;
    }

    public void setNumeroLamina(String NumeroLamina) {
        this.NumeroLamina = NumeroLamina;
    }

    public void generarNumeroLamina() {
        String codigoIsoDepto;
        String codigoExamen;
        String digitosAnio;
        Date FechaActual = new Date();

        codigoIsoDepto = departamentoSelect.getCodigoIso();
        codigoExamen = String.valueOf(ExamenSelect.getIdExamen());

        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        String con = fd.format(FechaActual);
        digitosAnio = con.charAt(8) + "" + con.charAt(9);

        this.NumeroLamina = codigoIsoDepto + codigoExamen + digitosAnio;
    }

    public String getVentana() {
        return Ventana;
    }

    public void setVentana(String Ventana) {
        this.Ventana = Ventana;
    }

    public void verTipoExamen() {
        valor_TipoExamen = CatalogoMB.getListaExamenPAP().get(0);
        System.out.println("Soy el Examen " + valor_TipoExamen.getCatalogoId() + " " + valor_TipoExamen.getValor());
    }

    public String getTipoExamenMostrar() {
        for (int i = 0; i < listaExamenPendiente.size(); i++) {
            if (!listaExamenPendiente.get(i).getCatalogoList().isEmpty()) {
                for (int j = 0; j < listaExamenPendiente.get(i).getCatalogoList().size(); j++) {
                    if (listaExamenPendiente.get(i).getCatalogoList().get(j).getDependencia().equals("Exasivipca")) {
                        TipoExamenMostrar = listaExamenPendiente.get(i).getCatalogoList().get(j).getValor();
                    }
                }
            }
        }

        return TipoExamenMostrar;
    }

    public void setTipoExamenMostrar(String TipoExamenMostrar) {
        this.TipoExamenMostrar = TipoExamenMostrar;
    }

    public void resetearVentana() {
        this.Ventana = "DtsGnrals";
    }
}
