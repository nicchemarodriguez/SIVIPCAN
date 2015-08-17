/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.sivipcan.controlador.SubCategoriaEJB;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import ni.gob.minsa.sivipcan.modelo.Valores;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class SubCategoriaMB implements Serializable {

    @EJB
    private SubCategoriaEJB subcategEJB;
    private List<SubCategoria> listaSubcategoria = new ArrayList<SubCategoria>();
    private List<Categoria> listaCategoria = new ArrayList<Categoria>();
    private SubCategoria e = new SubCategoria();
    private SubCategoriaEJB subCategEJB;
    private SubCategoria Seleccion;
    private Valores valor;
    private Categoria categoria;

    /**
     * Cargar,Buscar, Asignar Subcategorias para todos los examenes
     */
  
  
    private List<SubCategoria> listaSubCategoria = new ArrayList<SubCategoria>();
    private SubCategoria AntecedentesAbiertos;
    private SubCategoria Fuma;
    private SubCategoria Toma;
    private SubCategoria EmbarazoActual;
    private SubCategoria Procedencia;
    private SubCategoria AspectoClinico;
    private SubCategoria Secrecion;
    private SubCategoria observacion;
    private CategoriaMB CategoriaMB = (CategoriaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{categoriaMB}", CategoriaMB.class);

    public SubCategoriaMB() {
    }

    public SubCategoriaMB(SubCategoriaEJB subcategEJB, SubCategoriaEJB subCategEJB, SubCategoria Seleccion, Valores valor, Categoria categoria, SubCategoria AntecedentesAbiertos, SubCategoria Fuma, SubCategoria Toma, SubCategoria EmbarazoActual, SubCategoria Procedencia, SubCategoria AspectoClinico, SubCategoria Secrecion, SubCategoria observacion) {
        this.subcategEJB = subcategEJB;
        this.subCategEJB = subCategEJB;
        this.Seleccion = Seleccion;
        this.valor = valor;
        this.categoria = categoria;
        this.AntecedentesAbiertos = AntecedentesAbiertos;
        this.Fuma = Fuma;
        this.Toma = Toma;
        this.EmbarazoActual = EmbarazoActual;
        this.Procedencia = Procedencia;
        this.AspectoClinico = AspectoClinico;
        this.Secrecion = Secrecion;
        this.observacion = observacion;
    }

 

    /**
     * get y set
     *
     * @return
     */
    public CategoriaMB getCategoriaMB() {
        return CategoriaMB;
    }

    public void setCategoriaMB(CategoriaMB CategoriaMB) {
        this.CategoriaMB = CategoriaMB;
    }

    public SubCategoria getAntecedentesAbiertos() {

        return AntecedentesAbiertos;
    }

    public void setAntecedentesAbiertos(SubCategoria AntecedentesAbiertos) {
        this.AntecedentesAbiertos = AntecedentesAbiertos;
    }

    public SubCategoria getFuma() {

        return Fuma;
    }

    public void setFuma(SubCategoria Fuma) {
        this.Fuma = Fuma;
    }

    public SubCategoria getToma() {

        return Toma;
    }

    public void setToma(SubCategoria Toma) {
        this.Toma = Toma;
    }

    public SubCategoria getEmbarazoActual() {

        return EmbarazoActual;
    }

    public void setEmbarazoActual(SubCategoria EmbarazoActual) {
        this.EmbarazoActual = EmbarazoActual;
    }

   
    public List<SubCategoria> getListaSubCategoria() {
        return listaSubCategoria;
    }

    public void setListaSubCategoria(List<SubCategoria> listaSubCategoria) {
        this.listaSubCategoria = listaSubCategoria;
    }

    public SubCategoria getObservacion() {

        return observacion;
    }

    public void setObservacion(SubCategoria observacion) {
        this.observacion = observacion;
    }

    public SubCategoria getProcedencia() {

        return Procedencia;
    }

    public void setProcedencia(SubCategoria Procedencia) {
        this.Procedencia = Procedencia;
    }

    public SubCategoria getAspectoClinico() {

        return AspectoClinico;
    }

    public void setAspectoClinico(SubCategoria AspectoClinico) {
        this.AspectoClinico = AspectoClinico;
    }

    public SubCategoria getSecrecion() {

        return Secrecion;
    }

    public void setSecrecion(SubCategoria Secrecion) {
        this.Secrecion = Secrecion;
    }

  

    //cargar variables de subcategorias con los datos de las categorias
    public void cargarVariablesSubCategorias() {

        this.CategoriaMB.cargarVariablesCategorias();

        java.math.BigDecimal idAnteAbiertos = new java.math.BigDecimal(String.valueOf(6));

        for (int i = 0; this.CategoriaMB.getAntecedentes().getSubCategoriaList().size() > i; i++) {
            if (this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i).getIdSubcategoria().equals(idAnteAbiertos)) {
                AntecedentesAbiertos = this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i);
                System.out.println("anteabiertos");
            }
        }

        //--
        java.math.BigDecimal idFuma = new java.math.BigDecimal(String.valueOf(7));

        for (int i = 0; this.CategoriaMB.getAntecedentes().getSubCategoriaList().size() > i; i++) {

            if (this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i).getIdSubcategoria().equals(idFuma)) {

                Fuma = this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i);
            }
        }
        //--

        java.math.BigDecimal idToma = new java.math.BigDecimal(String.valueOf(8));
        for (int i = 0; this.CategoriaMB.getAntecedentes().getSubCategoriaList().size() > i; i++) {
            if (this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i).getIdSubcategoria().equals(idToma)) {

                Toma = this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i);

            }
        }
        //--

        java.math.BigDecimal idEmbarazo = new java.math.BigDecimal(String.valueOf(9));
        for (int i = 0; this.CategoriaMB.getAntecedentes().getSubCategoriaList().size() > i; i++) {
            if (this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i).getIdSubcategoria().equals(idEmbarazo)) {
                EmbarazoActual = this.CategoriaMB.getAntecedentes().getSubCategoriaList().get(i);

            }
        }
    //--

        BigDecimal idObservaciones = new BigDecimal(23);
        for (int i = 0; this.CategoriaMB.getCategoriaObservacion().getSubCategoriaList().size() > i; i++) {
            if (this.CategoriaMB.getCategoriaObservacion().getSubCategoriaList().get(i).getIdSubcategoria().equals(idObservaciones)) {
                observacion = this.CategoriaMB.getCategoriaObservacion().getSubCategoriaList().get(i);
            }
        }
        //--

        Procedencia = subcategEJB.buscarProcedencia().get(0);
        //--
        AspectoClinico = subcategEJB.buscarAspectoClinico().get(0);
        //--
        Secrecion = subcategEJB.buscarSecrecion().get(0);
    }

    public SubCategoriaEJB getSubcategEJB() {
        return subcategEJB;
    }

    public void setSubcategEJB(SubCategoriaEJB subcategEJB) {
        this.subcategEJB = subcategEJB;
    }

    public List<SubCategoria> getListaSubcategoria() {
        listaSubcategoria = subcategEJB.buscarTodasLasSubcategorias();
        return listaSubcategoria;
    }

    public void setListaSubcategoria(List<SubCategoria> listaSubcategoria) {
        this.listaSubcategoria = listaSubcategoria;
    }

    public SubCategoria getE() {
        return e;
    }

    public void setE(SubCategoria e) {
        this.e = e;
    }

    public SubCategoriaEJB getSubCategEJB() {
        return subCategEJB;
    }

    public void setSubCategEJB(SubCategoriaEJB subCategEJB) {
        this.subCategEJB = subCategEJB;
    }

    public SubCategoria getSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(SubCategoria Seleccion) {
        this.Seleccion = Seleccion;
    }

    public void onRowSelect(SelectEvent event) {
        this.e = (SubCategoria) event.getObject();
    }

    public void onClickSalir() {
        Seleccion = null;
    }

    public void guardarOactualizar() {

        this.listaCategoria.clear();
        this.categoria = null;

        if (!(e.getValor()).matches("([a-z]|[A-Z]|[0-9]|\\s|Ñ|ñ)+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "El Campo No Admite Numeros o Carcteres Especiales.", ""));
        } else {

            try {
                if (e == null) {
                    e = subcategEJB.guardar(e);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El registro ha sido guardado exitosamente.", ""));
                } else if (e != null) {
                    e = subcategEJB.actualizar(e);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El registro ha sido guardado exitosamente.", ""));
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "El Registro no puede ser guardado.", e.getMessage()));
            }
        }
    }

    public void Elminiar() {
        try {
            subcategEJB.eliminar(e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "El registro ha sido eliminado exitosamente.", ""));
            Seleccion = null;
            e = new SubCategoria();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El Registro no ha sido eliminado.", ex.getMessage()));
        }
    }

    public SubCategoria nueva() {
        Seleccion = null;
        e = new SubCategoria();
        return e;
    }

    public Valores getValor() {
        return valor;
    }

    public void setValor(Valores valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        categoria = e.getIdCategoria();
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        e.setIdCategoria(categoria);
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

}
