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
import ni.gob.minsa.sivipcan.modelo.Categoria;

/**
 *
 * @author WIN 7
 */
@Stateless
public class CategoriaEJB {

    @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;

    public List<Categoria> buscarTodasLasSubcategorias() {
        Query query = em.createNamedQuery("Categoria.findAll");
        return query.getResultList();
    }

    public Categoria guardar(Categoria categoria) {
        em.persist(categoria);
        return categoria;
    }

    public Categoria actualizar(Categoria categoria) {
        em.merge(categoria);
        return categoria;
    }

    public void eliminar(Categoria categoria) {
        categoria = em.find(Categoria.class, categoria.getIdCategoria());
        em.remove(categoria);
    }

    public void guardarIntermedia(Categoria cate) {
        em.persist(cate);
    }

   
    public List<Categoria> CargarTodasLasCategorias() {
        Query query = em.createNamedQuery("Categoria.findAll");
        return query.getResultList();

    }

    public List<Categoria> buscarSubCategoriaFrotis() {
        Query query = em.createNamedQuery("Categoria.findByIdCategoria");
        query.setParameter("idCategoria", 5);
        return query.getResultList();
    }

    public List<Categoria> buscarSubCategoriaObservacion() {
        Query query = em.createNamedQuery("Categoria.findAll");
        return query.getResultList();
    }

    public List<Categoria> buscarSubCategoriaResultado() {
        Query query = em.createNamedQuery("Categoria.findByIdCategoria");
        query.setParameter("idCategoria", 6);
        return query.getResultList();
    }

}
