/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WIN 7
 */
@Stateless
public class DivisionpoliticaEJB {

    @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;
    
    
}
