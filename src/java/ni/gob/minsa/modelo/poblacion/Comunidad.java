/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.poblacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import ni.gob.minsa.sivipcan.modelo.Examen;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "COMUNIDADES", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidad.findAll", query = "SELECT c FROM Comunidad c"),
    @NamedQuery(name = "Comunidad.findByComunidadId", query = "SELECT c FROM Comunidad c WHERE c.comunidadId = :comunidadId"),
    @NamedQuery(name = "Comunidad.findByNombre", query = "SELECT c FROM Comunidad c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Comunidad.findBySector", query = "SELECT c FROM Comunidad c WHERE c.sector = :sector"),
    @NamedQuery(name = "Comunidad.findByReferencias", query = "SELECT c FROM Comunidad c WHERE c.referencias = :referencias"),
    @NamedQuery(name = "Comunidad.findByTipoArea", query = "SELECT c FROM Comunidad c WHERE c.tipoArea = :tipoArea"),
    @NamedQuery(name = "Comunidad.findByCodigo", query = "SELECT c FROM Comunidad c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Comunidad.findByCaracteristicas", query = "SELECT c FROM Comunidad c WHERE c.caracteristicas = :caracteristicas"),
    @NamedQuery(name = "Comunidad.findByPasivo", query = "SELECT c FROM Comunidad c WHERE c.pasivo = :pasivo"),
    @NamedQuery(name = "Comunidad.findByFechaRegistro", query = "SELECT c FROM Comunidad c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Comunidad.findByUsuarioRegistro", query = "SELECT c FROM Comunidad c WHERE c.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "Comunidad.findByLongitud", query = "SELECT c FROM Comunidad c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Comunidad.findByLatitud", query = "SELECT c FROM Comunidad c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Comunidad.findByZona", query = "SELECT c FROM Comunidad c WHERE c.zona = :zona")})
public class Comunidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMUNIDAD_ID", nullable = false)
    private Long comunidadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "SECTOR", nullable = false, length = 7)
    private String sector;
    @Size(max = 1000)
    @Column(name = "REFERENCIAS", length = 1000)
    private String referencias;
    @Column(name = "TIPO_AREA")
    private Character tipoArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CODIGO", nullable = false, length = 9)
    private String codigo;
    @Size(max = 1000)
    @Column(name = "CARACTERISTICAS", length = 1000)
    private String caracteristicas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASIVO", nullable = false)
    private char pasivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 100)
    private String usuarioRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUD", precision = 10, scale = 6)
    private BigDecimal longitud;
    @Column(name = "LATITUD", precision = 10, scale = 6)
    private BigDecimal latitud;
    @Size(max = 50)
    @Column(name = "ZONA", length = 50)
    private String zona;
     @OneToMany(mappedBy = "idComunidadResidencia", fetch = FetchType.LAZY)
    private List<Examen> examenList;

    public Comunidad() {
    }

    public Comunidad(Long comunidadId) {
        this.comunidadId = comunidadId;
    }

    public Comunidad(Long comunidadId, String nombre, String sector, String codigo, char pasivo, Date fechaRegistro, String usuarioRegistro) {
        this.comunidadId = comunidadId;
        this.nombre = nombre;
        this.sector = sector;
        this.codigo = codigo;
        this.pasivo = pasivo;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }
     @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    
    public Long getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(Long comunidadId) {
        this.comunidadId = comunidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public Character getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(Character tipoArea) {
        this.tipoArea = tipoArea;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public char getPasivo() {
        return pasivo;
    }

    public void setPasivo(char pasivo) {
        this.pasivo = pasivo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comunidadId != null ? comunidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidad)) {
            return false;
        }
        Comunidad other = (Comunidad) object;
        if ((this.comunidadId == null && other.comunidadId != null) || (this.comunidadId != null && !this.comunidadId.equals(other.comunidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.poblacion.Comunidad[ comunidadId=" + comunidadId + " ]";
    }
    
}
