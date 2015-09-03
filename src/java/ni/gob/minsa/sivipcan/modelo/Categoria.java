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
import ni.gob.minsa.modelo.poblacion.Catalogos;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "CATEGORIA", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "Categoria.findByDescripcion", query = "SELECT c FROM Categoria c WHERE c.descripcion = :descripcion")})
public class Categoria implements Serializable {

   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Long idCategoria;
    @Size(max = 35)
    @Column(name = "DESCRIPCION", length = 35)
    private String descripcion;
    @OneToMany(mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<Fecha> fechaList;
    @OneToMany(mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<SubCategoria> subCategoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<ResultadoExamen> resultadoExamenList;
    
    @JoinColumn(name = "CATALOGO_ID", referencedColumnName = "CATALOGO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Catalogos Catalogos;

    public Categoria() {
    }

    public Categoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Catalogos getCatalogos() {
        return Catalogos;
    }

    public void setCatalogos(Catalogos Catalogos) {
        this.Catalogos = Catalogos;
    }
    
    @XmlTransient
    public List<Fecha> getFechaList() {
        return fechaList;
    }

    public void setFechaList(List<Fecha> fechaList) {
        this.fechaList = fechaList;
    }

    @XmlTransient
    public List<SubCategoria> getSubCategoriaList() {
        return subCategoriaList;
    }

    public void setSubCategoriaList(List<SubCategoria> subCategoriaList) {
        this.subCategoriaList = subCategoriaList;
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.Categoria[ idCategoria=" + idCategoria + " ]";
    }

  

  
    
}
