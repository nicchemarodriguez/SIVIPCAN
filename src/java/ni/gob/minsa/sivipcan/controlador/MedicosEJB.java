/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ni.gob.minsa.modelo.poblacion.Catalogos;
import ni.gob.minsa.sivipcan.modelo.SisMedicos;

/**
 *
 * @author WIN 7
 */
@Stateless
public class MedicosEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
  @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;
  
  
  
  
  
   public List<SisMedicos> buscarMedicos( Long Codigo,String NombreCompleto) {
       
       System.out.println("hola"+Codigo+NombreCompleto);
       
       if(Codigo!=null && !NombreCompleto.equals("")){
           
           
         Query query3 = em.createNamedQuery("SisMedicos.findByCodigosanitarioNombreCOmpleto");
           query3.setParameter("codigosanitario", Codigo);
              query3.setParameter("nombreCompleto", '%'+NombreCompleto+'%');
         
            System.out.println("hola1");
        return query3.getResultList();
       
        
        
       }else if(!NombreCompleto.equals("")){
            System.out.println("sin nombre");
           
             Query query2 = em.createNamedQuery("SisMedicos.findByNombreCompleto");
            query2.setParameter("nombreCompleto", '%'+NombreCompleto+'%');
       
            return query2.getResultList();
            
       
        
       }else{
              System.out.println("hola3"+Codigo);
            Query query = em.createNamedQuery("SisMedicos.findByCodigosanitario");
             query.setParameter("codigosanitario", Codigo);
             return query.getResultList();
           
           
           
           
       }
    
       
       
       
       
       
      
        
        
       
       
    }
   
  
  
  
  
  


}
