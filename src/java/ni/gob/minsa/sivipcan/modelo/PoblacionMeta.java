/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "POBLACION_META", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoblacionMeta.findAll", query = "SELECT p FROM PoblacionMeta p"),
    @NamedQuery(name = "PoblacionMeta.findByIdPoblacion", query = "SELECT p FROM PoblacionMeta p WHERE p.idPoblacion = :idPoblacion"),
    @NamedQuery(name = "PoblacionMeta.findByCodigoNacional", query = "SELECT p FROM PoblacionMeta p WHERE p.codigoNacional = :codigoNacional"),
    @NamedQuery(name = "PoblacionMeta.findByCantidad", query = "SELECT p FROM PoblacionMeta p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PoblacionMeta.findByAnio", query = "SELECT p FROM PoblacionMeta p WHERE p.anio = :anio")})
public class PoblacionMeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_POBLACION", nullable = false, length = 20)
    private String idPoblacion;
    @Size(max = 4)
    @Column(name = "CODIGO_NACIONAL", length = 4)
    private String codigoNacional;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "ANIO")
    private BigInteger anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poblacionMeta", fetch = FetchType.LAZY)
    private List<PoblacionCategoria> poblacionCategoriaList;

    public PoblacionMeta() {
    }

    public PoblacionMeta(String idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    public String getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(String idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    public String getCodigoNacional() {
        return codigoNacional;
    }

    public void setCodigoNacional(String codigoNacional) {
        this.codigoNacional = codigoNacional;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    @XmlTransient
    public List<PoblacionCategoria> getPoblacionCategoriaList() {
        return poblacionCategoriaList;
    }

    public void setPoblacionCategoriaList(List<PoblacionCategoria> poblacionCategoriaList) {
        this.poblacionCategoriaList = poblacionCategoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoblacion != null ? idPoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoblacionMeta)) {
            return false;
        }
        PoblacionMeta other = (PoblacionMeta) object;
        if ((this.idPoblacion == null && other.idPoblacion != null) || (this.idPoblacion != null && !this.idPoblacion.equals(other.idPoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.PoblacionMeta[ idPoblacion=" + idPoblacion + " ]";
    }
    
}
