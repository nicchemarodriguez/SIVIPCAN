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
import ni.gob.minsa.sivipcan.controlador.MedicosEJB;
import ni.gob.minsa.sivipcan.modelo.SisMedicos;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@ViewScoped
public class MedicosMB implements Serializable {

    /**
     * Creates a new instance of MedicosMB
     */
    
    @EJB
    private MedicosEJB MedicosEJB;
    
    private List<SisMedicos> listaMedicos=new ArrayList<>();
    
    private SisMedicos medicoSelect;
    
    
    private String nombreCompleto;
    
    private Long codigo;
    
    
    
    
    
    
    
    public MedicosMB() {
    }
    
    
    
    
    
    
   

    public MedicosMB(MedicosEJB MedicosEJB, SisMedicos medicoSelect, String nombreCompleto, Long codigo) {
        this.MedicosEJB = MedicosEJB;
        this.medicoSelect = medicoSelect;
        this.nombreCompleto = nombreCompleto;
        this.codigo = codigo;
    }

  

    public MedicosEJB getMedicosEJB() {
        return MedicosEJB;
    }

    public void setMedicosEJB(MedicosEJB MedicosEJB) {
        this.MedicosEJB = MedicosEJB;
    }

    public List<SisMedicos> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(List<SisMedicos> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public SisMedicos getMedicoSelect() {
        return medicoSelect;
    }

    public void setMedicoSelect(SisMedicos medicoSelect) {
        this.medicoSelect = medicoSelect;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
   
     public void buscar(){
        
        System.out.println(codigo);
        
    
        listaMedicos=MedicosEJB.buscarMedicos(codigo,nombreCompleto);
    
    
    
    
    }
    
    
}
