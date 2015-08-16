/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "POBLACION_CATEGORIA", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoblacionCategoria.findAll", query = "SELECT p FROM PoblacionCategoria p"),
    @NamedQuery(name = "PoblacionCategoria.findByIdPoblacion", query = "SELECT p FROM PoblacionCategoria p WHERE p.poblacionCategoriaPK.idPoblacion = :idPoblacion"),
    @NamedQuery(name = "PoblacionCategoria.findByCatalogoId", query = "SELECT p FROM PoblacionCategoria p WHERE p.poblacionCategoriaPK.catalogoId = :catalogoId"),
    @NamedQuery(name = "PoblacionCategoria.findByCantidad", query = "SELECT p FROM PoblacionCategoria p WHERE p.cantidad = :cantidad")})
public class PoblacionCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PoblacionCategoriaPK poblacionCategoriaPK;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_POBLACION", referencedColumnName = "ID_POBLACION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PoblacionMeta poblacionMeta;

    public PoblacionCategoria() {
    }

    public PoblacionCategoria(PoblacionCategoriaPK poblacionCategoriaPK) {
        this.poblacionCategoriaPK = poblacionCategoriaPK;
    }

    public PoblacionCategoria(String idPoblacion, long catalogoId) {
        this.poblacionCategoriaPK = new PoblacionCategoriaPK(idPoblacion, catalogoId);
    }

    public PoblacionCategoriaPK getPoblacionCategoriaPK() {
        return poblacionCategoriaPK;
    }

    public void setPoblacionCategoriaPK(PoblacionCategoriaPK poblacionCategoriaPK) {
        this.poblacionCategoriaPK = poblacionCategoriaPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public PoblacionMeta getPoblacionMeta() {
        return poblacionMeta;
    }

    public void setPoblacionMeta(PoblacionMeta poblacionMeta) {
        this.poblacionMeta = poblacionMeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poblacionCategoriaPK != null ? poblacionCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoblacionCategoria)) {
            return false;
        }
        PoblacionCategoria other = (PoblacionCategoria) object;
        if ((this.poblacionCategoriaPK == null && other.poblacionCategoriaPK != null) || (this.poblacionCategoriaPK != null && !this.poblacionCategoriaPK.equals(other.poblacionCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.PoblacionCategoria[ poblacionCategoriaPK=" + poblacionCategoriaPK + " ]";
    }
    
}
