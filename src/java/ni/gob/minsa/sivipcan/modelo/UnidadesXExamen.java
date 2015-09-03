/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
import ni.gob.minsa.modelo.estructura.Unidad;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "UNIDADES_X_EXAMEN", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadesXExamen.findAll", query = "SELECT u FROM UnidadesXExamen u"),
    @NamedQuery(name = "UnidadesXExamen.findByUnidadId", query = "SELECT u FROM UnidadesXExamen u WHERE u.unidadId = :unidadId"),
    @NamedQuery(name = "UnidadesXExamen.findByTipoEvento", query = "SELECT u FROM UnidadesXExamen u WHERE u.tipoEvento = :tipoEvento"),
    @NamedQuery(name = "UnidadesXExamen.findBySilais", query = "SELECT u FROM UnidadesXExamen u WHERE u.silais = :silais"),
    @NamedQuery(name = "UnidadesXExamen.findByMunicipio", query = "SELECT u FROM UnidadesXExamen u WHERE u.municipio = :municipio"),
    @NamedQuery(name = "UnidadesXExamen.findByDepartamento", query = "SELECT u FROM UnidadesXExamen u WHERE u.departamento = :departamento"),
    @NamedQuery(name = "UnidadesXExamen.findByIdUxe", query = "SELECT u FROM UnidadesXExamen u WHERE u.idUxe = :idUxe")})
public class UnidadesXExamen implements Serializable {

   
    @Size(max = 20)
    @Column(name = "EVENTO", length = 20)
    private String evento;
    private static final long serialVersionUID = 1L;
 @JoinColumn(name = "UNIDAD_ID", referencedColumnName = "UNIDAD_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Unidad unidadId; 
    @Column(name = "TIPO_EVENTO")
    private Character tipoEvento;
    @Column(name = "SILAIS")
    private BigInteger silais;
    @Column(name = "MUNICIPIO")
    private BigInteger municipio;
    @Column(name = "DEPARTAMENTO")
    private BigInteger departamento;
    @Id 
    @SequenceGenerator(name = "SEQ_GENU", sequenceName = "SECUENCIA_UNIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENU")
    @Column(name = "ID_UXE", nullable = false)
    private Long idUxe;
    @JoinColumn(name = "ID_EXAMEN", referencedColumnName = "ID_EXAMEN", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Examen idExamen;

    public UnidadesXExamen() {
    }

    public UnidadesXExamen(Long idUxe) {
        this.idUxe = idUxe;
    }

    public UnidadesXExamen(Long idUxe, Unidad unidadId) {
        this.idUxe = idUxe;
        this.unidadId = unidadId;
    }

    public Unidad getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Unidad unidadId) {
        this.unidadId = unidadId;
    }

   

    public Character getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Character tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public BigInteger getSilais() {
        return silais;
    }

    public void setSilais(BigInteger silais) {
        this.silais = silais;
    }

    public BigInteger getMunicipio() {
        return municipio;
    }

    public void setMunicipio(BigInteger municipio) {
        this.municipio = municipio;
    }

    public BigInteger getDepartamento() {
        return departamento;
    }

    public void setDepartamento(BigInteger departamento) {
        this.departamento = departamento;
    }

    public Long getIdUxe() {
        return idUxe;
    }

    public void setIdUxe(Long idUxe) {
        this.idUxe = idUxe;
    }

    public Examen getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Examen idExamen) {
        this.idExamen = idExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUxe != null ? idUxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesXExamen)) {
            return false;
        }
        UnidadesXExamen other = (UnidadesXExamen) object;
        if ((this.idUxe == null && other.idUxe != null) || (this.idUxe != null && !this.idUxe.equals(other.idUxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.UnidadesXExamen[ idUxe=" + idUxe + " ]";
    }

   

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }



  
    
}
