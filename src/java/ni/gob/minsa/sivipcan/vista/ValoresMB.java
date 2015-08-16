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
import ni.gob.minsa.sivipcan.controlador.ValoresEJB;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import ni.gob.minsa.sivipcan.modelo.Valores;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class ValoresMB implements Serializable {

    @EJB

    private ValoresEJB valoresEJB;
    private List<Valores> listaValores = new ArrayList<Valores>();
    private Valores e = new Valores();
    private ValoresEJB valorEJB2;
    private Valores Seleccion;
    private ValoresEJB valorEJB;
    private SubCategoria subCategoria;
    private List<SubCategoria> listaSubCategoria = new ArrayList<SubCategoria>();

    public ValoresMB() {
    }

    public ValoresMB(ValoresEJB valoresEJB, ValoresEJB valorEJB2, Valores Seleccion, ValoresEJB valorEJB) {
        this.valoresEJB = valoresEJB;
        this.valorEJB2 = valorEJB2;
        this.Seleccion = Seleccion;
        this.valorEJB = valorEJB;
    }

    public ValoresEJB getValoresEJB() {
        return valoresEJB;
    }

    public void setValoresEJB(ValoresEJB valoresEJB) {
        this.valoresEJB = valoresEJB;
    }

    public List<Valores> getListaValores() {
        listaValores = valoresEJB.buscarTodasLasSubcategorias();
        return listaValores;
    }

    public void setListaValores(List<Valores> listaValores) {
        this.listaValores = listaValores;
    }

    public Valores getE() {
        return e;
    }

    public void setE(Valores e) {
        this.e = e;
    }

    public ValoresEJB getValorEJB2() {
        return valorEJB2;
    }

    public void setValorEJB2(ValoresEJB valorEJB2) {
        this.valorEJB2 = valorEJB2;
    }

    public Valores getSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(Valores Seleccion) {
        this.Seleccion = Seleccion;
    }

    public ValoresEJB getValorEJB() {
        return valorEJB;
    }

    public void setValorEJB(ValoresEJB valorEJB) {
        this.valorEJB = valorEJB;
    }

    public void onRowSelect(SelectEvent event) {
        this.e = (Valores) event.getObject();
    }

    public void onClickSalir() {
        Seleccion = null;
    }

    public void guardarOactualizar() {

     this.listaSubCategoria.clear();
        this.subCategoria = null;

        if (!(e.getValor()).matches("([a-z]|[A-Z]|[0-9]|\\s|Ñ|ñ)+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "El Campo No Admite Carcteres Especiales.", ""));
        } else {
            try {
                if (e == null) {
                    e = valoresEJB.guardar(e);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El registro ha sido guardado exitosamente.", ""));
                } else if (e != null) {
                    e = valoresEJB.actualizar(e);
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
            valoresEJB.eliminar(e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "El registro ha sido eliminado exitosamente.", ""));
            Seleccion = null;
            e = new Valores();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El Registro no ha sido eliminado.", ex.getMessage()));
        }
    }

    public Valores nueva() {
        Seleccion = null;
        e = new Valores();
        return e;
    }

    public SubCategoria getSubCategoria() {
        subCategoria = e.getIdSubcategoria();
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        e.setIdSubcategoria(subCategoria);
        this.subCategoria = subCategoria;
    }

    public List<SubCategoria> getListaSubCategoria() {
        return listaSubCategoria;
    }

    public void setListaSubCategoria(List<SubCategoria> listaSubCategoria) {
        this.listaSubCategoria = listaSubCategoria;
    }

}
