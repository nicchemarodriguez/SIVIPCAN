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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.modelo.poblacion.Catalogos;
import ni.gob.minsa.sivipcan.controlador.CategoriaEJB;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

@ManagedBean
@ViewScoped
public class CategoriaMB implements Serializable {

    @EJB
    private CategoriaEJB categEJB;
    private List<Categoria> listaCategoria = new ArrayList<Categoria>();
    private Categoria e = new Categoria();
    private Categoria catego;
    private SubCategoria subcate;
    List<SubCategoria> listacmbSubcatego = new ArrayList<SubCategoria>();
    List<SubCategoria> listaSubCategoria = new ArrayList<SubCategoria>();
    private Categoria Seleccion;
    private SubCategoriaMB SuBcategoriaMB = (SubCategoriaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{suBcategoriaMB}", SubCategoriaMB.class);

    private Catalogos catalogos;
    private DualListModel<SubCategoria> modeloLista;

    public CategoriaMB() {
    }

    public CategoriaMB(CategoriaEJB categEJB, Categoria Seleccion) {
        this.categEJB = categEJB;
        this.Seleccion = Seleccion;

    }

    public void setModeloLista(DualListModel<SubCategoria> modeloLista) {
        this.modeloLista = modeloLista;
    }

    public Categoria getCatego() {
        return catego;
    }

    public void setCatego(Categoria catego) {
        this.catego = catego;
    }

    public SubCategoria getSubcate() {
        return subcate;
    }

    public void setSubcate(SubCategoria subcate) {
        this.listaSubCategoria.add(subcate);
        this.e.setSubCategoriaList(this.listaSubCategoria);
        this.subcate = subcate;
    }

    public List<SubCategoria> getListacmbSubcatego() {
        return listacmbSubcatego;
    }

    public void setListacmbSubcatego(List<SubCategoria> listacmbSubcatego) {
        this.listacmbSubcatego = listacmbSubcatego;
    }

    public CategoriaEJB getSubcategEJB() {
        return categEJB;
    }

    public void setCategEJB(CategoriaEJB subcategEJB) {
        this.categEJB = subcategEJB;
    }

    public List<Categoria> getListaCategoria() {
        listaCategoria = categEJB.buscarTodasLasSubcategorias();
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public Categoria getE() {
        return e;
    }

    public void setE(Categoria e) {
        this.e = e;
    }

    public Categoria getSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(Categoria Seleccion) {
        this.Seleccion = Seleccion;
    }

    public void onRowSelect(SelectEvent event) {
        this.e = (Categoria) event.getObject();
    }

    public void onClickSalir() {
        Seleccion = null;
    }

    public void guardarOactualizar() {
        //e = new Categoria();
        // e= null;
        if (!(e.getDescripcion()).matches("([a-z]|[A-Z]|[0-9]|\\s|Ñ|ñ)+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "El Campo No Admite Numeros o Carcteres Especiales.", ""));
        } else {

            try {
                if (e == null) {
                    e = categEJB.guardar(e);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El Registro ha Sido Guardado Exitosamente.", ""));
                } else if (e != null) {
                    e = categEJB.actualizar(e);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El Registro ha Sido Actualizado Exitosamente.", ""));
                }

                this.listacmbSubcatego.clear();
                this.subcate = null;
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "El Registro No Puede Ser Guardado.", e.getMessage()));
            }
        }
    }

    public void Elminiar() {
        try {
            categEJB.eliminar(e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "El registro ha sido eliminado exitosamente.", ""));
            Seleccion = null;
            e = new Categoria();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El Registro no ha sido eliminado.", ex.getMessage()));
        }
    }

    public Categoria nueva() {
        Seleccion = null;
        e = new Categoria();
        return e;
    }

    public List<SubCategoria> getListaSubCategoria() {
        return listaSubCategoria;
    }

    public void setListaSubCategoria(List<SubCategoria> listaSubCategoria) {
        this.listaSubCategoria = listaSubCategoria;
    }

    public SubCategoriaMB getSuBcategoriaMB() {
        return SuBcategoriaMB;
    }

    public void setSuBcategoriaMB(SubCategoriaMB SuBcategoriaMB) {
        this.SuBcategoriaMB = SuBcategoriaMB;
    }

    public Catalogos getCatalogos() {
        catalogos = e.getCatalogos();
        return catalogos;
    }

    public void setCatalogos(Catalogos catalogos) {
        e.setCatalogos(catalogos);
        this.catalogos = catalogos;
    }
    
}
