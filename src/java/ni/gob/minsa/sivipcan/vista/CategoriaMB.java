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
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.modelo.poblacion.Catalogos;
import ni.gob.minsa.sivipcan.controlador.CategoriaEJB;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import org.primefaces.event.SelectEvent;


@ManagedBean
@RequestScoped
public class CategoriaMB implements Serializable {

    
    /**
     * agregar, Actualizar,Buscar,Eliminar categorias
     *
     */
    
    @EJB
    private CategoriaEJB CategoriaEJB;
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
    
    
    
    /**
     *Cargar,Buscar, Asignar categorias para todos los examenes 
     */
    
    
    
      private List<Categoria> Categorias = new ArrayList<Categoria>();
      private Categoria Antecedentes;
         private List<Categoria> listacategoriasObservacion = new ArrayList<Categoria>();
           private Categoria categoriaObservacion;
        private Categoria categoria;
     private Categoria categoriaResultado;
    
 

    public CategoriaMB() {
    }

    public CategoriaMB(CategoriaEJB CategoriaEJB, Categoria catego, SubCategoria subcate, Categoria Seleccion, Catalogos catalogos, Categoria Antecedentes, Categoria categoriaObservacion, Categoria categoria, Categoria categoriaResultado) {
        this.CategoriaEJB = CategoriaEJB;
        this.catego = catego;
        this.subcate = subcate;
        this.Seleccion = Seleccion;
        this.catalogos = catalogos;
        this.Antecedentes = Antecedentes;
        this.categoriaObservacion = categoriaObservacion;
        this.categoria = categoria;
        this.categoriaResultado = categoriaResultado;
        
    }

  
   
    
    
    
    
    /**
     * 
     * get y set 
     * @return 
     */
    
    
    
       public List<Categoria> getCategorias() {
        return Categorias;
    }

    public void setCategorias(List<Categoria> Categorias) {
        this.Categorias = Categorias;
    }

    
    public Categoria getAntecedentes() {
        return Antecedentes;
    }

    public void setAntecedentes(Categoria Antecedentes) {
        this.Antecedentes = Antecedentes;
    }

    
    
    public Categoria getCategoriaObservacion() {
        
      
        return categoriaObservacion;
    }

    public void setCategoriaObservacion(Categoria categoriaObservacion) {
        this.categoriaObservacion = categoriaObservacion;
    }

    
    
    
    
     public List<Categoria> getListacategoriasObservacion() {
      
        return listacategoriasObservacion;
    }

    public void setListacategoriasObservacion(List<Categoria> listacategoriasObservacion) {
        this.listacategoriasObservacion = listacategoriasObservacion;
    }

    
      public Categoria getCategoria() {
        
        if (!CategoriaEJB.buscarSubCategoriaFrotis().isEmpty()) {
            categoria = CategoriaEJB.buscarSubCategoriaFrotis().get(0);
        }
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriaResultado() {
        categoriaResultado = CategoriaEJB.buscarSubCategoriaResultado().get(0);
        return categoriaResultado;
    }
      public void setCategoriaResultado(Categoria categoriaResultado) {
        this.categoriaResultado = categoriaResultado;
    }

    
    
    
    
    
    
    /**
     * Cargar todas las variables
     * 
     */
    public void cargarVariablesCategorias(){
        //categorias
      Categorias = CategoriaEJB.CargarTodasLasCategorias();
    //lista de categorias Observacion
        listacategoriasObservacion = CategoriaEJB.buscarSubCategoriaObservacion();
    // AntGinec
            for (int i = 0; this.getCategorias().size() > i; i++) {

                if (this.getCategorias().get(i).getIdCategoria() == 3) {
                    Antecedentes = this.getCategorias().get(i);
                   
                }
            }
        //categorias observaciones
              for (int i = 0; this.getListacategoriasObservacion().size() > i; i++) {

            if (this.getListacategoriasObservacion().get(i).getIdCategoria() == 8) {
                categoriaObservacion = this.getListacategoriasObservacion().get(i);
            }
        }
            
    
              
    
    
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

    public CategoriaEJB getCategoriaEJB() {
        return CategoriaEJB;
    }

    public void setCategoriaEJB(CategoriaEJB CategoriaEJB) {
        this.CategoriaEJB = CategoriaEJB;
    }

   

    public List<Categoria> getListaCategoria() {
        listaCategoria = CategoriaEJB.buscarTodasLasSubcategorias();
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
                    e = CategoriaEJB.guardar(e);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El Registro ha Sido Guardado Exitosamente.", ""));
                } else if (e != null) {
                    e = CategoriaEJB.actualizar(e);
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
            CategoriaEJB.eliminar(e);
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
