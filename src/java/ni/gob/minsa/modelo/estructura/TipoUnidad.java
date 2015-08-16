/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.estructura;

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
@Table(name = "TIPOS_UNIDADES", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"}),
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUnidad.findAll", query = "SELECT t FROM TipoUnidad t"),
    @NamedQuery(name = "TipoUnidad.findByTipoUnidadId", query = "SELECT t FROM TipoUnidad t WHERE t.tipoUnidadId = :tipoUnidadId"),
    @NamedQuery(name = "TipoUnidad.findByNombre", query = "SELECT t FROM TipoUnidad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoUnidad.findByOrden", query = "SELECT t FROM TipoUnidad t WHERE t.orden = :orden"),
    @NamedQuery(name = "TipoUnidad.findByCodigo", query = "SELECT t FROM TipoUnidad t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TipoUnidad.findByPasivo", query = "SELECT t FROM TipoUnidad t WHERE t.pasivo = :pasivo"),
    @NamedQuery(name = "TipoUnidad.findByFechaRegistro", query = "SELECT t FROM TipoUnidad t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TipoUnidad.findByUsuarioRegistro", query = "SELECT t FROM TipoUnidad t WHERE t.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "TipoUnidad.findByMarcador", query = "SELECT t FROM TipoUnidad t WHERE t.marcador = :marcador")})
public class TipoUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_UNIDAD_ID", nullable = false)
    private Long tipoUnidadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Column(name = "ORDEN")
    private Short orden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    private short codigo;
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
    @Size(max = 20)
    @Column(name = "MARCADOR", length = 20)
    private String marcador;

    public TipoUnidad() {
    }

    public TipoUnidad(Long tipoUnidadId) {
        this.tipoUnidadId = tipoUnidadId;
    }

    public TipoUnidad(Long tipoUnidadId, String nombre, short codigo, char pasivo, Date fechaRegistro, String usuarioRegistro) {
        this.tipoUnidadId = tipoUnidadId;
        this.nombre = nombre;
        this.codigo = codigo;
        this.pasivo = pasivo;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Long getTipoUnidadId() {
        return tipoUnidadId;
    }

    public void setTipoUnidadId(Long tipoUnidadId) {
        this.tipoUnidadId = tipoUnidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
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

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoUnidadId != null ? tipoUnidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUnidad)) {
            return false;
        }
        TipoUnidad other = (TipoUnidad) object;
        if ((this.tipoUnidadId == null && other.tipoUnidadId != null) || (this.tipoUnidadId != null && !this.tipoUnidadId.equals(other.tipoUnidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.estructura.TipoUnidad[ tipoUnidadId=" + tipoUnidadId + " ]";
    }
    
}
