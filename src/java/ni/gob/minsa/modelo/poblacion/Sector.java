/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.poblacion;

import java.io.Serializable;
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
@Table(name = "SECTORES", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findBySectorId", query = "SELECT s FROM Sector s WHERE s.sectorId = :sectorId"),
    @NamedQuery(name = "Sector.findByNombre", query = "SELECT s FROM Sector s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sector.findByReferencias", query = "SELECT s FROM Sector s WHERE s.referencias = :referencias"),
    @NamedQuery(name = "Sector.findByUnidad", query = "SELECT s FROM Sector s WHERE s.unidad = :unidad"),
    @NamedQuery(name = "Sector.findByMunicipio", query = "SELECT s FROM Sector s WHERE s.municipio = :municipio"),
    @NamedQuery(name = "Sector.findByCodigo", query = "SELECT s FROM Sector s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Sector.findBySede", query = "SELECT s FROM Sector s WHERE s.sede = :sede"),
    @NamedQuery(name = "Sector.findByPasivo", query = "SELECT s FROM Sector s WHERE s.pasivo = :pasivo"),
    @NamedQuery(name = "Sector.findByFechaRegistro", query = "SELECT s FROM Sector s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Sector.findByUsuarioRegistro", query = "SELECT s FROM Sector s WHERE s.usuarioRegistro = :usuarioRegistro")})
public class Sector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECTOR_ID", nullable = false)
    private Long sectorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Size(max = 500)
    @Column(name = "REFERENCIAS", length = 500)
    private String referencias;
    @Column(name = "UNIDAD")
    private Long unidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MUNICIPIO", nullable = false, length = 4)
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CODIGO", nullable = false, length = 7)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEDE", nullable = false)
    private char sede;
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
     @OneToMany(mappedBy = "idSectorResidencia", fetch = FetchType.LAZY)
    private List<Examen> examenList;

    public Sector() {
    }

    public Sector(Long sectorId) {
        this.sectorId = sectorId;
    }

    public Sector(Long sectorId, String nombre, String municipio, String codigo, char sede, char pasivo, Date fechaRegistro, String usuarioRegistro) {
        this.sectorId = sectorId;
        this.nombre = nombre;
        this.municipio = municipio;
        this.codigo = codigo;
        this.sede = sede;
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

    
    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public Long getUnidad() {
        return unidad;
    }

    public void setUnidad(Long unidad) {
        this.unidad = unidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public char getSede() {
        return sede;
    }

    public void setSede(char sede) {
        this.sede = sede;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectorId != null ? sectorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.sectorId == null && other.sectorId != null) || (this.sectorId != null && !this.sectorId.equals(other.sectorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.poblacion.Sector[ sectorId=" + sectorId + " ]";
    }
    
}
