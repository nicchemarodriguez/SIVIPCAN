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
@Table(name = "SUB_CATEGORIA", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategoria.findAll", query = "SELECT s FROM SubCategoria s"),
    @NamedQuery(name = "SubCategoria.findByIdSubcategoria", query = "SELECT s FROM SubCategoria s WHERE s.idSubcategoria = :idSubcategoria"),
    @NamedQuery(name = "SubCategoria.findByValor", query = "SELECT s FROM SubCategoria s WHERE s.valor = :valor")})
public class SubCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBCATEGORIA", nullable = false, precision = 38, scale = 0)
    private BigDecimal idSubcategoria;
    @Size(max = 35)
    @Column(name = "VALOR", length = 35)
    private String valor;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria idCategoria;
    @OneToMany(mappedBy = "idSubcategoria", fetch = FetchType.LAZY)
    private List<Valores> valoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubcategoria", fetch = FetchType.LAZY)
    private List<ResultadoExamen> resultadoExamenList;

    public SubCategoria() {
    }

    public SubCategoria(BigDecimal idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public BigDecimal getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(BigDecimal idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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
    public List<Valores> getValoresList() {
        return valoresList;
    }

    public void setValoresList(List<Valores> valoresList) {
        this.valoresList = valoresList;
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
        hash += (idSubcategoria != null ? idSubcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategoria)) {
            return false;
        }
        SubCategoria other = (SubCategoria) object;
        if ((this.idSubcategoria == null && other.idSubcategoria != null) || (this.idSubcategoria != null && !this.idSubcategoria.equals(other.idSubcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.SubCategoria[ idSubcategoria=" + idSubcategoria + " ]";
    }
    
}
