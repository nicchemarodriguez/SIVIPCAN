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
import ni.gob.minsa.modelo.estructura.EntidadAdtva;
import ni.gob.minsa.modelo.estructura.Unidad;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.modelo.poblacion.Sector;


@Stateless
public class EntidadAdtvaEJB {

    @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;
    
    public List<EntidadAdtva> buscarTodasLasEntidades( ) {
        Query query = em.createNamedQuery("EntidadAdtva.findAll");
        return query.getResultList();
    }
    
    public List<EntidadAdtva> buscarTodasLasEntidadesAdtv(Long id) {
        Query query = em.createNamedQuery("EntidadAdtva.findByEntidadAdtvaId");
        query.setParameter("entidadAdtvaId", id);
        return query.getResultList();
    }
    
    public List<DivisionPolitica> buscarPorMunicipios(String codigo) {
        Query query = em.createNamedQuery("DivisionPolitica.findByCodigoNacional");
        query.setParameter("codigoNacional",codigo);
        return query.getResultList();
    }
     public List<DivisionPolitica> CODIGOCSE(String codigo) {
        Query query = em.createNamedQuery("DivisionPolitica.findByCodigoNacional");
        query.setParameter("codigoNacional",codigo);
        return query.getResultList();
    }
    public List<Unidad> buscarPorUnidades(Long codigo_enADT) {
        Query query = em.createNamedQuery("Unidad.findByEntidadAdtva");
        query.setParameter("entidadAdtva",codigo_enADT);
        return query.getResultList();
    }
    
    
    
    
    
    
    
}
