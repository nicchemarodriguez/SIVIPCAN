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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "DIVISIONPOLITICA", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO_NACIONAL"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DivisionPolitica.findAll", query = "SELECT d FROM DivisionPolitica d"),
    @NamedQuery(name = "DivisionPolitica.findByDivisionpoliticaId", query = "SELECT d FROM DivisionPolitica d WHERE d.divisionpoliticaId = :divisionpoliticaId"),
    @NamedQuery(name = "DivisionPolitica.findByNombre", query = "SELECT d FROM DivisionPolitica d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DivisionPolitica.findByAdministracion", query = "SELECT d FROM DivisionPolitica d WHERE d.administracion = :administracion"),
    @NamedQuery(name = "DivisionPolitica.findByLatitud", query = "SELECT d FROM DivisionPolitica d WHERE d.latitud = :latitud"),
    @NamedQuery(name = "DivisionPolitica.findByLongitud", query = "SELECT d FROM DivisionPolitica d WHERE d.longitud = :longitud"),
    @NamedQuery(name = "DivisionPolitica.findByCodigoIso", query = "SELECT d FROM DivisionPolitica d WHERE d.codigoIso = :codigoIso"),
    @NamedQuery(name = "DivisionPolitica.findByCodigoNacional", query = "SELECT d FROM DivisionPolitica d WHERE d.codigoNacional = :codigoNacional"),
    @NamedQuery(name = "DivisionPolitica.findByPasivo", query = "SELECT d FROM DivisionPolitica d WHERE d.pasivo = :pasivo"),
    @NamedQuery(name = "DivisionPolitica.findByFechaRegistro", query = "SELECT d FROM DivisionPolitica d WHERE d.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "DivisionPolitica.findByUsuarioRegistro", query = "SELECT d FROM DivisionPolitica d WHERE d.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "DivisionPolitica.findByCodigoCse", query = "SELECT d FROM DivisionPolitica d WHERE d.codigoCse = :codigoCse"),
    @NamedQuery(name = "DivisionPolitica.findByDependenciaSilais", query = "SELECT d FROM DivisionPolitica d WHERE d.dependenciaSilais = :dependenciaSilais")})
public class DivisionPolitica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIVISIONPOLITICA_ID", nullable = false)
    private Long divisionpoliticaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Column(name = "ADMINISTRACION")
    private Long administracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUD", precision = 10, scale = 6)
    private BigDecimal latitud;
    @Column(name = "LONGITUD", precision = 10, scale = 6)
    private BigDecimal longitud;
    @Size(max = 2)
    @Column(name = "CODIGO_ISO", length = 2)
    private String codigoIso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_NACIONAL", nullable = false, length = 4)
    private String codigoNacional;
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
    @Column(name = "CODIGO_CSE")
    private Short codigoCse;
    @Column(name = "DEPENDENCIA_SILAIS")
    private Long dependenciaSilais;
    @OneToMany(mappedBy = "dependencia", fetch = FetchType.LAZY)
    private List<DivisionPolitica> divisionPoliticaList;
    @JoinColumn(name = "DEPENDENCIA", referencedColumnName = "DIVISIONPOLITICA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DivisionPolitica dependencia;

    public DivisionPolitica() {
    }

    public DivisionPolitica(Long divisionpoliticaId) {
        this.divisionpoliticaId = divisionpoliticaId;
    }

    public DivisionPolitica(Long divisionpoliticaId, String nombre, String codigoNacional, char pasivo, Date fechaRegistro, String usuarioRegistro) {
        this.divisionpoliticaId = divisionpoliticaId;
        this.nombre = nombre;
        this.codigoNacional = codigoNacional;
        this.pasivo = pasivo;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Long getDivisionpoliticaId() {
        return divisionpoliticaId;
    }

    public void setDivisionpoliticaId(Long divisionpoliticaId) {
        this.divisionpoliticaId = divisionpoliticaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getAdministracion() {
        return administracion;
    }

    public void setAdministracion(Long administracion) {
        this.administracion = administracion;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public String getCodigoNacional() {
        return codigoNacional;
    }

    public void setCodigoNacional(String codigoNacional) {
        this.codigoNacional = codigoNacional;
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

    public Short getCodigoCse() {
        return codigoCse;
    }

    public void setCodigoCse(Short codigoCse) {
        this.codigoCse = codigoCse;
    }

    public Long getDependenciaSilais() {
        return dependenciaSilais;
    }

    public void setDependenciaSilais(Long dependenciaSilais) {
        this.dependenciaSilais = dependenciaSilais;
    }

    @XmlTransient
    public List<DivisionPolitica> getDivisionPoliticaList() {
        return divisionPoliticaList;
    }

    public void setDivisionPoliticaList(List<DivisionPolitica> divisionPoliticaList) {
        this.divisionPoliticaList = divisionPoliticaList;
    }

    public DivisionPolitica getDependencia() {
        return dependencia;
    }

    public void setDependencia(DivisionPolitica dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (divisionpoliticaId != null ? divisionpoliticaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DivisionPolitica)) {
            return false;
        }
        DivisionPolitica other = (DivisionPolitica) object;
        if ((this.divisionpoliticaId == null && other.divisionpoliticaId != null) || (this.divisionpoliticaId != null && !this.divisionpoliticaId.equals(other.divisionpoliticaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.poblacion.DivisionPolitica[ divisionpoliticaId=" + divisionpoliticaId + " ]";
    }
    
}
