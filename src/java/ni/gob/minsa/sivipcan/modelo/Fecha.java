/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FECHA", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fecha.findAll", query = "SELECT f FROM Fecha f ORDER BY f.idFecha"),
    @NamedQuery(name = "Fecha.findByIdFecha", query = "SELECT f FROM Fecha f WHERE f.idFecha = :idFecha"),
    @NamedQuery(name = "Fecha.findByValor", query = "SELECT f FROM Fecha f WHERE f.valor = :valor")})
public class Fecha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FECHA", nullable = false)
    private Long idFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VALOR", nullable = false, length = 30)
    private String valor;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fecha", fetch = FetchType.LAZY)
    private List<Fxexu> fxexuList;

    public Fecha() {
    }

    public Fecha(Long idFecha) {
        this.idFecha = idFecha;
    }

    public Fecha(Long idFecha, String valor) {
        this.idFecha = idFecha;
        this.valor = valor;
    }

    public Long getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Long idFecha) {
        this.idFecha = idFecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public List<Fxexu> getFxexuList() {
        return fxexuList;
    }

    public void setFxexuList(List<Fxexu> fxexuList) {
        this.fxexuList = fxexuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFecha != null ? idFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fecha)) {
            return false;
        }
        Fecha other = (Fecha) object;
        if ((this.idFecha == null && other.idFecha != null) || (this.idFecha != null && !this.idFecha.equals(other.idFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.Fecha[ idFecha=" + idFecha + " ]";
    }
    
}
