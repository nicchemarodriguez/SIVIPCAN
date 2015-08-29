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
import ni.gob.minsa.sivipcan.modelo.Valores;

/**
 *
 * @author WIN 7
 */
@Stateless
public class ValoresEJB {

    @PersistenceContext(unitName = "PerDa")
    private EntityManager em;
     
     public List<Valores> buscarTodasLasSubcategorias() {
        Query query = em.createNamedQuery("Valores.findAll");
        
        return query.getResultList();
    }
     
     public Valores guardar(Valores valor) {
        em.persist(valor);
        return valor;
    }

    public Valores actualizar(Valores valores) {
        em.merge(valores);
        return valores;
    }

    public void eliminar(Valores valor) {
        valor = em.find(Valores.class, valor.getIdValor());
        em.remove(valor);
    }
}
