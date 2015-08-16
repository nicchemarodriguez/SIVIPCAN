/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "RESULTADO_EXAMEN", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoExamen.findAll", query = "SELECT r FROM ResultadoExamen r"),
    @NamedQuery(name = "ResultadoExamen.findByDescripcion", query = "SELECT r FROM ResultadoExamen r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "ResultadoExamen.findByIdResultadoExamen", query = "SELECT r FROM ResultadoExamen r WHERE r.idResultadoExamen = :idResultadoExamen")})
public class ResultadoExamen implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "DESCRIPCION", length = 25)
    private String descripcion;
    @Id 
    @SequenceGenerator(name = "SEQ_GENR", sequenceName = "SECUENCIA_RESULTADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENR")
    @Column(name = "ID_RESULTADO_EXAMEN", nullable = false)
    private Long idResultadoExamen;
    @JoinColumn(name = "ID_VALOR", referencedColumnName = "ID_VALOR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Valores idValor;
    @JoinColumn(name = "ID_SUBCATEGORIA", referencedColumnName = "ID_SUBCATEGORIA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubCategoria idSubcategoria;
    @JoinColumn(name = "ID_EXAMEN", referencedColumnName = "ID_EXAMEN", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Examen idExamen;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria idCategoria;

    public ResultadoExamen() {
    }

    public ResultadoExamen(Long idResultadoExamen) {
        this.idResultadoExamen = idResultadoExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdResultadoExamen() {
        return idResultadoExamen;
    }

    public void setIdResultadoExamen(Long idResultadoExamen) {
        this.idResultadoExamen = idResultadoExamen;
    }

    public Valores getIdValor() {
        return idValor;
    }

    public void setIdValor(Valores idValor) {
        this.idValor = idValor;
    }

    public SubCategoria getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(SubCategoria idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Examen getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Examen idExamen) {
        this.idExamen = idExamen;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoExamen != null ? idResultadoExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoExamen)) {
            return false;
        }
        ResultadoExamen other = (ResultadoExamen) object;
        if ((this.idResultadoExamen == null && other.idResultadoExamen != null) || (this.idResultadoExamen != null && !this.idResultadoExamen.equals(other.idResultadoExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.ResultadoExamen[ idResultadoExamen=" + idResultadoExamen + " ]";
    }

  
    
}
