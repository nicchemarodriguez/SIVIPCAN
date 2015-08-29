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
import ni.gob.minsa.sivipcan.modelo.Fecha;

/**
 *
 * @author WIN 7
 */
@Stateless
public class FechaEJB {

    @PersistenceContext(unitName = "PerDa")
    private EntityManager em;
     
   
  public List<Fecha> buscarPorValor() {
        Query query = em.createNamedQuery("Fecha.findAll");
//        query.setParameter("valor", valor);
        return query.getResultList();
    }
}
