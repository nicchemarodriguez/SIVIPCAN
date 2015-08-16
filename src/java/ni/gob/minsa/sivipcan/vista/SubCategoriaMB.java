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
import ni.gob.minsa.sivipcan.controlador.CatalogoEJB;
import ni.gob.minsa.sivipcan.controlador.SubCategoriaEJB;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import ni.gob.minsa.sivipcan.modelo.Valores;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
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

  
    

    public SubCategoriaMB() {
    }

    public SubCategoriaMB(SubCategoriaEJB subcategEJB, SubCategoria Seleccion) {
        this.subcategEJB = subcategEJB;
        this.Seleccion = Seleccion;
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
