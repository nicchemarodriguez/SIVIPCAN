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

/**
 *
 * @author WIN 7
 */
@Embeddable
public class FxexuPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXAMEN", nullable = false)
    private long idExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FECHA", nullable = false)
    private long idFecha;

    public FxexuPK() {
    }

    public FxexuPK(long idExamen, long idFecha) {
        this.idExamen = idExamen;
        this.idFecha = idFecha;
    }

    public long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(long idExamen) {
        this.idExamen = idExamen;
    }

    public long getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(long idFecha) {
        this.idFecha = idFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idExamen;
        hash += (int) idFecha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FxexuPK)) {
            return false;
        }
        FxexuPK other = (FxexuPK) object;
        if (this.idExamen != other.idExamen) {
            return false;
        }
        if (this.idFecha != other.idFecha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.FxexuPK[ idExamen=" + idExamen + ", idFecha=" + idFecha + " ]";
    }
    
}
