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
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;

/**
 *
 * @author WIN 7
 */
@Stateless
public class DivisionpoliticaEJB {

    @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;
    
    public List<DivisionPolitica>buscardepartamentos() {
        Query query = em.createNamedQuery("DivisionPolitica.findAll");       
        return query.getResultList();
    
    }
    
    public List<DivisionPolitica>buscarMunicipios(String codigoMunicipio) {
        Query query = em.createNamedQuery("DivisionPolitica.findByCodigoNacional"); 
        query.setParameter("codigoNacional", codigoMunicipio);
        return query.getResultList();
    
    }
    
}
