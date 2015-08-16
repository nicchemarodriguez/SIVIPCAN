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
import ni.gob.minsa.sivipcan.modelo.SubCategoria;

/**
 *
 * @author WIN 7
 */
@Stateless
public class SubCategoriaEJB {

    @PersistenceContext(unitName = "PerLocal")
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
 
}
