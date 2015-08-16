/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.estructura;

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
@Table(name = "ENTIDADES_ADTVAS", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"}),
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadAdtva.findAll", query = "SELECT e FROM EntidadAdtva e"),
    @NamedQuery(name = "EntidadAdtva.findByEntidadAdtvaId", query = "SELECT e FROM EntidadAdtva e WHERE e.entidadAdtvaId = :entidadAdtvaId"),
    @NamedQuery(name = "EntidadAdtva.findByNombre", query = "SELECT e FROM EntidadAdtva e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EntidadAdtva.findByMunicipio", query = "SELECT e FROM EntidadAdtva e WHERE e.municipio = :municipio"),
    @NamedQuery(name = "EntidadAdtva.findByTelefono", query = "SELECT e FROM EntidadAdtva e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EntidadAdtva.findByFax", query = "SELECT e FROM EntidadAdtva e WHERE e.fax = :fax"),
    @NamedQuery(name = "EntidadAdtva.findByEmail", query = "SELECT e FROM EntidadAdtva e WHERE e.email = :email"),
    @NamedQuery(name = "EntidadAdtva.findByLatitud", query = "SELECT e FROM EntidadAdtva e WHERE e.latitud = :latitud"),
    @NamedQuery(name = "EntidadAdtva.findByLongitud", query = "SELECT e FROM EntidadAdtva e WHERE e.longitud = :longitud"),
    @NamedQuery(name = "EntidadAdtva.findByCodigo", query = "SELECT e FROM EntidadAdtva e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "EntidadAdtva.findByPasivo", query = "SELECT e FROM EntidadAdtva e WHERE e.pasivo = :pasivo"),
    @NamedQuery(name = "EntidadAdtva.findByFechaRegistro", query = "SELECT e FROM EntidadAdtva e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EntidadAdtva.findByUsuarioRegistro", query = "SELECT e FROM EntidadAdtva e WHERE e.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "EntidadAdtva.findByDireccion", query = "SELECT e FROM EntidadAdtva e WHERE e.direccion = :direccion")})
public class EntidadAdtva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTIDAD_ADTVA_ID", nullable = false)
    private Long entidadAdtvaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MUNICIPIO", nullable = false, length = 4)
    private String municipio;
    @Size(max = 50)
    @Column(name = "TELEFONO", length = 50)
    private String telefono;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX", length = 50)
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUD", precision = 10, scale = 6)
    private BigDecimal latitud;
    @Column(name = "LONGITUD", precision = 10, scale = 6)
    private BigDecimal longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    private long codigo;
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
    @Size(max = 200)
    @Column(name = "DIRECCION", length = 200)
    private String direccion;
    @OneToMany(mappedBy = "dependencia", fetch = FetchType.LAZY)
    private List<EntidadAdtva> entidadAdtvaList;
    @JoinColumn(name = "DEPENDENCIA", referencedColumnName = "ENTIDAD_ADTVA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EntidadAdtva dependencia;

    public EntidadAdtva() {
    }

    public EntidadAdtva(Long entidadAdtvaId) {
        this.entidadAdtvaId = entidadAdtvaId;
    }

    public EntidadAdtva(Long entidadAdtvaId, String nombre, String municipio, long codigo, char pasivo, Date fechaRegistro, String usuarioRegistro) {
        this.entidadAdtvaId = entidadAdtvaId;
        this.nombre = nombre;
        this.municipio = municipio;
        this.codigo = codigo;
        this.pasivo = pasivo;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Long getEntidadAdtvaId() {
        return entidadAdtvaId;
    }

    public void setEntidadAdtvaId(Long entidadAdtvaId) {
        this.entidadAdtvaId = entidadAdtvaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<EntidadAdtva> getEntidadAdtvaList() {
        return entidadAdtvaList;
    }

    public void setEntidadAdtvaList(List<EntidadAdtva> entidadAdtvaList) {
        this.entidadAdtvaList = entidadAdtvaList;
    }

    public EntidadAdtva getDependencia() {
        return dependencia;
    }

    public void setDependencia(EntidadAdtva dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entidadAdtvaId != null ? entidadAdtvaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadAdtva)) {
            return false;
        }
        EntidadAdtva other = (EntidadAdtva) object;
        if ((this.entidadAdtvaId == null && other.entidadAdtvaId != null) || (this.entidadAdtvaId != null && !this.entidadAdtvaId.equals(other.entidadAdtvaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.estructura.EntidadAdtva[ entidadAdtvaId=" + entidadAdtvaId + " ]";
    }
    
}
