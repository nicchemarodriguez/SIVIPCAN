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
import ni.gob.minsa.modelo.poblacion.Comunidad;

/**
 *
 * @author WIN 7
 */
@Stateless
public class ComunidadEJB {

    @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;

    public List<Comunidad> buscarTodo() {
        Query query = em.createNamedQuery("Comunidad.findAll");
        return query.getResultList();

    }
    
    public List<Comunidad> buscarComunidades(long codSector) {
        Query query = em.createNamedQuery("Comunidad.findBySector");
        query.setParameter("sector", codSector);
        return query.getResultList();

    }

}
