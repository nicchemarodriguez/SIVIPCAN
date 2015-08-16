/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VALORES", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valores.findAll", query = "SELECT v FROM Valores v"),
    @NamedQuery(name = "Valores.findByIdValor", query = "SELECT v FROM Valores v WHERE v.idValor = :idValor"),
    @NamedQuery(name = "Valores.findByValor", query = "SELECT v FROM Valores v WHERE v.valor = :valor")})
public class Valores implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VALOR", nullable = false, precision = 38, scale = 0)
    private BigDecimal idValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "VALOR", nullable = false, length = 35)
    private String valor;
    @JoinColumn(name = "ID_SUBCATEGORIA", referencedColumnName = "ID_SUBCATEGORIA")
    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategoria idSubcategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValor", fetch = FetchType.LAZY)
    private List<ResultadoExamen> resultadoExamenList;

    public Valores() {
    }

    public Valores(BigDecimal idValor) {
        this.idValor = idValor;
    }

    public Valores(BigDecimal idValor, String valor) {
        this.idValor = idValor;
        this.valor = valor;
    }

    public BigDecimal getIdValor() {
        return idValor;
    }

    public void setIdValor(BigDecimal idValor) {
        this.idValor = idValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public SubCategoria getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(SubCategoria idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    @XmlTransient
    public List<ResultadoExamen> getResultadoExamenList() {
        return resultadoExamenList;
    }

    public void setResultadoExamenList(List<ResultadoExamen> resultadoExamenList) {
        this.resultadoExamenList = resultadoExamenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValor != null ? idValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valores)) {
            return false;
        }
        Valores other = (Valores) object;
        if ((this.idValor == null && other.idValor != null) || (this.idValor != null && !this.idValor.equals(other.idValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.Valores[ idValor=" + idValor + " ]";
    }
    
}
