/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.controlador;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;

/**
 *
 * @author WIN 7
 */
@Stateless
public class SubCategoriaEJB {

    @PersistenceContext(unitName = "PerDa")
    private EntityManager em;
    
     public List<SubCategoria> buscarTodasLasSubcategorias() {
        Query query = em.createNamedQuery("SubCategoria.findAll");
        
        return query.getResultList();
    }
     
     public SubCategoria guardar(SubCategoria subCategoria) {
        em.persist(subCategoria);
        return subCategoria;
    }

    public SubCategoria actualizar(SubCategoria subCategoria) {
        em.merge(subCategoria);
        return subCategoria;
    }

    public void eliminar(SubCategoria subCategoria) {
        subCategoria = em.find(SubCategoria.class, subCategoria.getIdSubcategoria());
        em.remove(subCategoria);
    }
    
    
    
    /**
     * metodos para cargar listas y objetos de subcategoria para examen pap
     * @param codigo
     * @return 
     */
    
    
    
    
 
   public List<SubCategoria> buscarValoresFrotis( BigDecimal codigo )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", codigo);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValoresResultado( BigDecimal codigo )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", codigo);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValorFuma( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 7);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValorToma( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 8);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValorEmbarazoActual( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 9);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarObservaciones( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 23);
        return query.getResultList();
    }

   public List<SubCategoria> buscarProcedencia( )
    {
        
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 10);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarAspectoClinico( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 11);
        return query.getResultList();
    }
    
     public List<SubCategoria> buscarSecrecion( )
    {
        
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 12);
        return query.getResultList();
    }
   
    
    
    
 
}
