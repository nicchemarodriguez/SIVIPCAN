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
import javax.persistence.CascadeType;
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
import ni.gob.minsa.sivipcan.modelo.UnidadesXExamen;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "UNIDADES", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByUnidadId", query = "SELECT u FROM Unidad u WHERE u.unidadId = :unidadId"),
    @NamedQuery(name = "Unidad.findByNombre", query = "SELECT u FROM Unidad u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Unidad.findByRazonSocial", query = "SELECT u FROM Unidad u WHERE u.razonSocial = :razonSocial"),
    @NamedQuery(name = "Unidad.findByDireccion", query = "SELECT u FROM Unidad u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Unidad.findByTipoUnidad", query = "SELECT u FROM Unidad u WHERE u.tipoUnidad = :tipoUnidad"),
    @NamedQuery(name = "Unidad.findByMunicipio", query = "SELECT u FROM Unidad u WHERE u.municipio = :municipio"),
    @NamedQuery(name = "Unidad.findByEntidadAdtva", query = "SELECT u FROM Unidad u WHERE u.entidadAdtva = :entidadAdtva"),
    @NamedQuery(name = "Unidad.findByDeclaraSector", query = "SELECT u FROM Unidad u WHERE u.declaraSector = :declaraSector"),
    @NamedQuery(name = "Unidad.findByTelefono", query = "SELECT u FROM Unidad u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Unidad.findByFax", query = "SELECT u FROM Unidad u WHERE u.fax = :fax"),
    @NamedQuery(name = "Unidad.findByEmail", query = "SELECT u FROM Unidad u WHERE u.email = :email"),
    @NamedQuery(name = "Unidad.findByGrupoEconomico", query = "SELECT u FROM Unidad u WHERE u.grupoEconomico = :grupoEconomico"),
    @NamedQuery(name = "Unidad.findByRegimen", query = "SELECT u FROM Unidad u WHERE u.regimen = :regimen"),
    @NamedQuery(name = "Unidad.findByCategoria", query = "SELECT u FROM Unidad u WHERE u.categoria = :categoria"),
    @NamedQuery(name = "Unidad.findByLongitud", query = "SELECT u FROM Unidad u WHERE u.longitud = :longitud"),
    @NamedQuery(name = "Unidad.findByLatitud", query = "SELECT u FROM Unidad u WHERE u.latitud = :latitud"),
    @NamedQuery(name = "Unidad.findByConectividad", query = "SELECT u FROM Unidad u WHERE u.conectividad = :conectividad"),
    @NamedQuery(name = "Unidad.findByCodigo", query = "SELECT u FROM Unidad u WHERE u.codigo = :codigo"),
    @NamedQuery(name = "Unidad.findByPasivo", query = "SELECT u FROM Unidad u WHERE u.pasivo = :pasivo"),
    @NamedQuery(name = "Unidad.findByFechaRegistro", query = "SELECT u FROM Unidad u WHERE u.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Unidad.findByUsuarioRegistro", query = "SELECT u FROM Unidad u WHERE u.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "Unidad.findByFicha", query = "SELECT u FROM Unidad u WHERE u.ficha = :ficha"),
    @NamedQuery(name = "Unidad.findByUbicacionGeografica", query = "SELECT u FROM Unidad u WHERE u.ubicacionGeografica = :ubicacionGeografica"),
    @NamedQuery(name = "Unidad.findByZona", query = "SELECT u FROM Unidad u WHERE u.zona = :zona"),
    @NamedQuery(name = "Unidad.findByUnidadAdtva", query = "SELECT u FROM Unidad u WHERE u.unidadAdtva = :unidadAdtva")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIDAD_ID", nullable = false)
    private Long unidadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Size(max = 100)
    @Column(name = "RAZON_SOCIAL", length = 100)
    private String razonSocial;
    @Size(max = 200)
    @Column(name = "DIRECCION", length = 200)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_UNIDAD", nullable = false)
    private long tipoUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MUNICIPIO", nullable = false, length = 4)
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTIDAD_ADTVA", nullable = false)
    private long entidadAdtva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DECLARA_SECTOR", nullable = false)
    private char declaraSector;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRUPO_ECONOMICO", nullable = false)
    private char grupoEconomico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGIMEN", nullable = false)
    private long regimen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIA", nullable = false)
    private long categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUD", precision = 13, scale = 6)
    private BigDecimal longitud;
    @Column(name = "LATITUD", precision = 13, scale = 6)
    private BigDecimal latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONECTIVIDAD", nullable = false)
    private char conectividad;
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
    @Column(name = "FICHA")
    private Long ficha;
    @Size(max = 4)
    @Column(name = "UBICACION_GEOGRAFICA", length = 4)
    private String ubicacionGeografica;
    @Size(max = 50)
    @Column(name = "ZONA", length = 50)
    private String zona;
    @Column(name = "UNIDAD_ADTVA")
    private Long unidadAdtva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadId", fetch = FetchType.LAZY)
    private List<UnidadesXExamen> unidadesXExamenList;

    public Unidad() {
    }

    public Unidad(Long unidadId) {
        this.unidadId = unidadId;
    }

    public Unidad(Long unidadId, String nombre, long tipoUnidad, String municipio, long entidadAdtva, char declaraSector, char grupoEconomico, long regimen, long categoria, char conectividad, long codigo, char pasivo, Date fechaRegistro, String usuarioRegistro) {
        this.unidadId = unidadId;
        this.nombre = nombre;
        this.tipoUnidad = tipoUnidad;
        this.municipio = municipio;
        this.entidadAdtva = entidadAdtva;
        this.declaraSector = declaraSector;
        this.grupoEconomico = grupoEconomico;
        this.regimen = regimen;
        this.categoria = categoria;
        this.conectividad = conectividad;
        this.codigo = codigo;
        this.pasivo = pasivo;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }
    @XmlTransient
    public List<UnidadesXExamen> getUnidadesXExamenList() {
        return unidadesXExamenList;
    }

    public void setUnidadesXExamenList(List<UnidadesXExamen> unidadesXExamenList) {
        this.unidadesXExamenList = unidadesXExamenList;
    }
    

    public Long getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Long unidadId) {
        this.unidadId = unidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(long tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public long getEntidadAdtva() {
        return entidadAdtva;
    }

    public void setEntidadAdtva(long entidadAdtva) {
        this.entidadAdtva = entidadAdtva;
    }

    public char getDeclaraSector() {
        return declaraSector;
    }

    public void setDeclaraSector(char declaraSector) {
        this.declaraSector = declaraSector;
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

    public char getGrupoEconomico() {
        return grupoEconomico;
    }

    public void setGrupoEconomico(char grupoEconomico) {
        this.grupoEconomico = grupoEconomico;
    }

    public long getRegimen() {
        return regimen;
    }

    public void setRegimen(long regimen) {
        this.regimen = regimen;
    }

    public long getCategoria() {
        return categoria;
    }

    public void setCategoria(long categoria) {
        this.categoria = categoria;
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

    public char getConectividad() {
        return conectividad;
    }

    public void setConectividad(char conectividad) {
        this.conectividad = conectividad;
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

    public Long getFicha() {
        return ficha;
    }

    public void setFicha(Long ficha) {
        this.ficha = ficha;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Long getUnidadAdtva() {
        return unidadAdtva;
    }

    public void setUnidadAdtva(Long unidadAdtva) {
        this.unidadAdtva = unidadAdtva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadId != null ? unidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.unidadId == null && other.unidadId != null) || (this.unidadId != null && !this.unidadId.equals(other.unidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.estructura.Unidad[ unidadId=" + unidadId + " ]";
    }
    
}
