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
import ni.gob.minsa.sivipcan.controlador.ValoresEJB;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import ni.gob.minsa.sivipcan.modelo.Valores;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class ValoresMB implements Serializable {

    @EJB

    private ValoresEJB valoresEJB;
    private List<Valores> listaValores2 = new ArrayList<Valores>();
    private Valores e = new Valores();
    private ValoresEJB valorEJB2;
    private Valores Seleccion;
    private ValoresEJB valorEJB;
    private SubCategoria subCategoria;
    private List<SubCategoria> listaSubCategoria = new ArrayList<SubCategoria>();
    private boolean estado = false;

      /**
     * Cargar,Buscar, Asignar valores para todos los examenes 
     */
    
      private Valores valor = new Valores();
    private List<Valores> listaValores = new ArrayList<Valores>();
 
   
    private List<Valores> listaValoresFrotis = new ArrayList<Valores>();
    private List<Valores> listaValoresResultado = new ArrayList<Valores>();
 
  
      private Valores VarFuma;
    private Valores VarToma;
    private Valores VarEmbarazoActual;
    private Valores Gestas;
    private Valores Partos;
    private Valores Cesareaa;
    private Valores IVSA;
    private Valores semanaGestas;
    private Valores menarca;
    private Valores abortos;
    private Valores FURV;
   
    
    private SubCategoriaMB SubCategoriaMB= (SubCategoriaMB) FacesContext.getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                    "#{subCategoriaMB}", SubCategoriaMB.class);
    

    public ValoresMB() {
    }

    public ValoresMB(ValoresEJB valoresEJB, ValoresEJB valorEJB2, Valores Seleccion, ValoresEJB valorEJB, SubCategoria subCategoria, Valores VarFuma, Valores VarToma, Valores VarEmbarazoActual, Valores Gestas, Valores Partos, Valores Cesareaa, Valores IVSA, Valores semanaGestas, Valores menarca, Valores abortos, Valores FURV) {
        this.valoresEJB = valoresEJB;
        this.valorEJB2 = valorEJB2;
        this.Seleccion = Seleccion;
        this.valorEJB = valorEJB;
        this.subCategoria = subCategoria;
        this.VarFuma = VarFuma;
        this.VarToma = VarToma;
        this.VarEmbarazoActual = VarEmbarazoActual;
        this.Gestas = Gestas;
        this.Partos = Partos;
        this.Cesareaa = Cesareaa;
        this.IVSA = IVSA;
        this.semanaGestas = semanaGestas;
        this.menarca = menarca;
        this.abortos = abortos;
        this.FURV = FURV;
    }


    
    
    
    
    
    /**
     * get y set
     * @return 
     */
    
    
    
       public SubCategoriaMB getSubCategoriaMB() {

        return SubCategoriaMB;
    }

    public void setSubCategoriaMB(SubCategoriaMB SubCategoriaMB) {
        this.SubCategoriaMB = SubCategoriaMB;
    }

    
    
    
       public Valores getGestas() {

      
        return Gestas;
    }

    public void setGestas(Valores Gestas) {
        this.Gestas = Gestas;
    }

      public Valores getFURV() {

       
        return FURV;
    }

    public void setFURV(Valores FURV) {
        this.FURV = FURV;
    }
       public Valores getPartos() {

       
        return Partos;
    }

    public void setPartos(Valores Partos) {
        this.Partos = Partos;
    }

    public Valores getCesareaa() {

      
        return Cesareaa;
    }

    public void setCesareaa(Valores Cesareaa) {
        this.Cesareaa = Cesareaa;
    }

    public Valores getIVSA() {

      
        return IVSA;
    }

    public void setIVSA(Valores IVSA) {
        this.IVSA = IVSA;
    }

    public Valores getSemanaGestas() {
       
        return semanaGestas;
    }

    public void setSemanaGestas(Valores semanaGestas) {
        this.semanaGestas = semanaGestas;
    }

    public Valores getMenarca() {
       
        return menarca;
    }

    public void setMenarca(Valores menarca) {
        this.menarca = menarca;
    }

    public Valores getAbortos() {
        
        return abortos;
    }

    public void setAbortos(Valores abortos) {
        this.abortos = abortos;
    }

    
    
       public Valores getVarFuma() {

        return VarFuma;
    }

    public void setVarFuma(Valores VarFuma) {
        this.VarFuma = VarFuma;
    }

    public Valores getVarToma() {
        return VarToma;
    }

    public void setVarToma(Valores VarToma) {
        this.VarToma = VarToma;
    }

    public Valores getVarEmbarazoActual() {
        return VarEmbarazoActual;
    }

    public void setVarEmbarazoActual(Valores VarEmbarazoActual) {
        this.VarEmbarazoActual = VarEmbarazoActual;
    }
      public Valores getValor() {
        return valor;
    }

    public void setValor(Valores valor) {
        this.valor = valor;
    }
  public List<Valores> getListaValores() {
        return listaValores;
    }

    public void setListaValores(List<Valores> listaValores) {
        this.listaValores = listaValores;
    }
    
     public List<Valores> getListaValoresFrotis() {
      
          
       
        return listaValoresFrotis;
    }

    public void setListaValoresFrotis(List<Valores> listaValoresFrotis) {
        this.listaValoresFrotis = listaValoresFrotis;
    }
      public List<Valores> getListaValoresResultado() {
      
          
        
        return listaValoresResultado;
    }

    public void setListaValoresResultado(List<Valores> listaValoresResultado) {
        this.listaValoresResultado = listaValoresResultado;
    }
 
    
    
    
    /**
     * Cargar variables de valores
     * 
     */
    
    public void cargarVariablesValores(){
        if(estado==false){
        estado=true;
        
       
        System.out.println("en el metodo cargar valores");
    //--
    this.SubCategoriaMB.cargarVariablesSubCategorias();
    //--
      for (int i = 0; this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().size() > i; i++) {
          
            if(this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("1")) {
                Gestas = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);
              
            }else   if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("2")) {
                Partos = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            }else   if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("3")) {
                abortos = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            }  else  if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("4")) {
                Cesareaa = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            }else   if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("5")) {
                IVSA = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            } else  if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("6")) {
                FURV = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            }else  if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("7")) {
                semanaGestas = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            }else  if (this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i).getIdValor().toString().equals("8")) {
                menarca = this.SubCategoriaMB.getAntecedentesAbiertos().getValoresList().get(i);

            }
        }      
      //--
           } 
      
      //--
           

    }
    public void cargarlistaValoresFrotis(SubCategoria frotis){
       listaValoresFrotis = frotis.getValoresList();
    
    }
    public void cargarListaValoresResultados(SubCategoria resultados){
         listaValoresResultado = resultados.getValoresList();
    
    }
    

    public ValoresEJB getValoresEJB() {
        return valoresEJB;
    }

    public void setValoresEJB(ValoresEJB valoresEJB) {
        this.valoresEJB = valoresEJB;
    }

    
    

    public List<Valores> getListaValores2() {
          listaValores = valoresEJB.buscarTodasLasSubcategorias();
        return listaValores2;
    }

    public void setListaValores2(List<Valores> listaValores2) {
        this.listaValores2 = listaValores2;
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
