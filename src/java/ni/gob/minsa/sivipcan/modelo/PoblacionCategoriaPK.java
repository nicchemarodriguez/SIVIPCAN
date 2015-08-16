/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author WIN 7
 */
@Embeddable
public class PoblacionCategoriaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_POBLACION", nullable = false, length = 20)
    private String idPoblacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATALOGO_ID", nullable = false)
    private long catalogoId;

    public PoblacionCategoriaPK() {
    }

    public PoblacionCategoriaPK(String idPoblacion, long catalogoId) {
        this.idPoblacion = idPoblacion;
        this.catalogoId = catalogoId;
    }

    public String getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(String idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    public long getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(long catalogoId) {
        this.catalogoId = catalogoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoblacion != null ? idPoblacion.hashCode() : 0);
        hash += (int) catalogoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoblacionCategoriaPK)) {
            return false;
        }
        PoblacionCategoriaPK other = (PoblacionCategoriaPK) object;
        if ((this.idPoblacion == null && other.idPoblacion != null) || (this.idPoblacion != null && !this.idPoblacion.equals(other.idPoblacion))) {
            return false;
        }
        if (this.catalogoId != other.catalogoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.PoblacionCategoriaPK[ idPoblacion=" + idPoblacion + ", catalogoId=" + catalogoId + " ]";
    }
    
}
