/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.poblacion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "PAISES", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO_ALFATRES"}),
    @UniqueConstraint(columnNames = {"CODIGO_ALFADOS"}),
    @UniqueConstraint(columnNames = {"CODIGO_NUMERICO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByPaisId", query = "SELECT p FROM Pais p WHERE p.paisId = :paisId"),
    @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pais.findByCodigoNumerico", query = "SELECT p FROM Pais p WHERE p.codigoNumerico = :codigoNumerico"),
    @NamedQuery(name = "Pais.findByCodigoAlfados", query = "SELECT p FROM Pais p WHERE p.codigoAlfados = :codigoAlfados"),
    @NamedQuery(name = "Pais.findByCodigoAlfatres", query = "SELECT p FROM Pais p WHERE p.codigoAlfatres = :codigoAlfatres"),
    @NamedQuery(name = "Pais.findByCodigoIso", query = "SELECT p FROM Pais p WHERE p.codigoIso = :codigoIso"),
    @NamedQuery(name = "Pais.findByFechaRegistro", query = "SELECT p FROM Pais p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Pais.findByUsuarioRegistro", query = "SELECT p FROM Pais p WHERE p.usuarioRegistro = :usuarioRegistro")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAIS_ID", nullable = false)
    private Long paisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO_NUMERICO", nullable = false, length = 20)
    private String codigoNumerico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_ALFADOS", nullable = false, length = 2)
    private String codigoAlfados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_ALFATRES", nullable = false, length = 3)
    private String codigoAlfatres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO_ISO", nullable = false, length = 20)
    private String codigoIso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
    private String usuarioRegistro;

    public Pais() {
    }

    public Pais(Long paisId) {
        this.paisId = paisId;
    }

    public Pais(Long paisId, String nombre, String codigoNumerico, String codigoAlfados, String codigoAlfatres, String codigoIso, Date fechaRegistro, String usuarioRegistro) {
        this.paisId = paisId;
        this.nombre = nombre;
        this.codigoNumerico = codigoNumerico;
        this.codigoAlfados = codigoAlfados;
        this.codigoAlfatres = codigoAlfatres;
        this.codigoIso = codigoIso;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(String codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getCodigoAlfados() {
        return codigoAlfados;
    }

    public void setCodigoAlfados(String codigoAlfados) {
        this.codigoAlfados = codigoAlfados;
    }

    public String getCodigoAlfatres() {
        return codigoAlfatres;
    }

    public void setCodigoAlfatres(String codigoAlfatres) {
        this.codigoAlfatres = codigoAlfatres;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
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
        hash += (paisId != null ? paisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.paisId == null && other.paisId != null) || (this.paisId != null && !this.paisId.equals(other.paisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.poblacion.Pais[ paisId=" + paisId + " ]";
    }
    
}
