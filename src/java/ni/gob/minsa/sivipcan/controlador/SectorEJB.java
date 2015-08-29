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
import ni.gob.minsa.modelo.poblacion.Sector;


/**
 *
 * @author WIN 7
 */
@Stateless
public class SectorEJB {

    @PersistenceContext(unitName = "PerDa")
    private EntityManager em;

    public List<Sector> buscarTodosLosSectores( ) {
        Query query = em.createNamedQuery("Sector.findAll");
        return query.getResultList();
        
       
    }
    
    public List<Sector> buscarSectoresXmunicipio(String municipioSelect) {
        System.out.println(municipioSelect + "caro");
        Query query = em.createNamedQuery("Sector.findByMunicipio");
        query.setParameter("municipio", municipioSelect);
         System.out.println( query.getResultList().size() + "si funciona");  
        return query.getResultList();
    }
}
