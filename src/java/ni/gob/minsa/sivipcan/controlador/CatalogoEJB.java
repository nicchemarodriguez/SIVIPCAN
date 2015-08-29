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
import ni.gob.minsa.modelo.poblacion.Comunidad;


/**
 *
 * @author WIN 7
 */
@Stateless
public class CatalogoEJB {

     @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;
    
     public List<Catalogos> buscarTodasLasEtnias( String Codigo) {
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo",'%'+Codigo+'%');
        return query.getResultList();
    }
     
     public List<Catalogos> buscarTodasLasOcupaciones( String Codigo) {
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo",'%'+Codigo+'%');
        return query.getResultList();
    }
     
     public List<Catalogos> buscarTodasLasEscolaridades( String Codigo) {
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo",'%'+Codigo+'%');
        return query.getResultList();
    }
     
     public List<Catalogos> buscarTodasLasProcedencias( String Codigo) {
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo",'%'+Codigo+'%');
        return query.getResultList();
    }
     
     public List<Catalogos> buscarRespuestasMetodoAntc( String Codigo1, String Codigo2) {
        Query query = em.createNamedQuery("Catalogos.buscarRespuestaMetodo");
        query.setParameter("codigo", Codigo1);
        query.setParameter("codigo1", Codigo2);
        return query.getResultList();
    }
     
     public List<Catalogos> buscarTipoMetodosAntc( String Codigo) {
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo",'%'+Codigo+'%');
        return query.getResultList();
    }
     
    public List<Catalogos> buscarTiposExamen(String Codigo) {           
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo", Codigo);
        return query.getResultList();
    }
    
     public List<Catalogos> buscarTipoExamen(String Codigo) {           
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo", Codigo);
        return query.getResultList();
    }
     
     public List<Catalogos> buscarExamenPAP(String Codigo) {           
        Query query = em.createNamedQuery("Catalogos.findByCodigo");
        query.setParameter("codigo", Codigo);
        return query.getResultList();
    }
}
