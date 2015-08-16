/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
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

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "SIS_MEDICOS", catalog = "", schema = "SIS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGOSANITARIO"})})
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "SisMedicos.findAll", query = "SELECT s FROM SisMedicos s"),
    @NamedQuery(name = "SisMedicos.findByMedicoId", query = "SELECT s FROM SisMedicos s WHERE s.medicoId = :medicoId"),
    @NamedQuery(name = "SisMedicos.findByCodigosanitario", query = "SELECT s FROM SisMedicos s WHERE s.codigosanitario = :codigosanitario"),
    @NamedQuery(name = "SisMedicos.findByPrimerApellido", query = "SELECT s FROM SisMedicos s WHERE s.primerApellido = :primerApellido"),
    @NamedQuery(name = "SisMedicos.findBySegundoApellido", query = "SELECT s FROM SisMedicos s WHERE s.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "SisMedicos.findByPrimerNombre", query = "SELECT s FROM SisMedicos s WHERE s.primerNombre = :primerNombre"),
    @NamedQuery(name = "SisMedicos.findBySegundoNombre", query = "SELECT s FROM SisMedicos s WHERE s.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "SisMedicos.findByNombreCompleto", query = "SELECT s FROM SisMedicos s WHERE s.nombreCompleto like :nombreCompleto"),
    @NamedQuery(name = "SisMedicos.findByCodigoTipoidentificacion", query = "SELECT s FROM SisMedicos s WHERE s.codigoTipoidentificacion = :codigoTipoidentificacion"),
    @NamedQuery(name = "SisMedicos.findByIdentificacion", query = "SELECT s FROM SisMedicos s WHERE s.identificacion = :identificacion"),
    @NamedQuery(name = "SisMedicos.findBySexoId", query = "SELECT s FROM SisMedicos s WHERE s.sexoId = :sexoId"),
    @NamedQuery(name = "SisMedicos.findByFechaNacimiento", query = "SELECT s FROM SisMedicos s WHERE s.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "SisMedicos.findByPasivo", query = "SELECT s FROM SisMedicos s WHERE s.pasivo = :pasivo"),
    @NamedQuery(name = "SisMedicos.findByFechaRegistro", query = "SELECT s FROM SisMedicos s WHERE s.fechaRegistro = :fechaRegistro"),
    
    
      @NamedQuery(name = "SisMedicos.findByCodigosanitarioNombreCOmpleto", query = "SELECT s FROM SisMedicos s WHERE s.codigosanitario = :codigosanitario and s.nombreCompleto like :nombreCompleto"),
    
    @NamedQuery(name = "SisMedicos.findByUsuarioRegistro", query = "SELECT s FROM SisMedicos s WHERE s.usuarioRegistro = :usuarioRegistro")})
public class SisMedicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDICO_ID", nullable = false)
    private Long medicoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOSANITARIO", nullable = false)
    private long codigosanitario;
    @Size(max = 50)
    @Column(name = "PRIMER_APELLIDO", length = 50)
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO", length = 50)
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "PRIMER_NOMBRE", length = 50)
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE", length = 50)
    private String segundoNombre;
    @Size(max = 100)
    @Column(name = "NOMBRE_COMPLETO", length = 100)
    private String nombreCompleto;
    @Size(max = 60)
    @Column(name = "CODIGO_TIPOIDENTIFICACION", length = 60)
    private String codigoTipoidentificacion;
    @Size(max = 20)
    @Column(name = "IDENTIFICACION", length = 20)
    private String identificacion;
    @Size(max = 60)
    @Column(name = "SEXO_ID", length = 60)
    private String sexoId;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "PASIVO")
    private Short pasivo;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 60)
    @Column(name = "USUARIO_REGISTRO", length = 60)
    private String usuarioRegistro;
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoId", fetch = FetchType.LAZY)
    private List<Fxexu> listaFechas;

    public SisMedicos() {
    }

    public SisMedicos(Long medicoId) {
        this.medicoId = medicoId;
    }

    public SisMedicos(Long medicoId, long codigosanitario) {
        this.medicoId = medicoId;
        this.codigosanitario = codigosanitario;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public long getCodigosanitario() {
        return codigosanitario;
    }

    public void setCodigosanitario(long codigosanitario) {
        this.codigosanitario = codigosanitario;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigoTipoidentificacion() {
        return codigoTipoidentificacion;
    }

    public void setCodigoTipoidentificacion(String codigoTipoidentificacion) {
        this.codigoTipoidentificacion = codigoTipoidentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getSexoId() {
        return sexoId;
    }

    public void setSexoId(String sexoId) {
        this.sexoId = sexoId;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Short getPasivo() {
        return pasivo;
    }

    public void setPasivo(Short pasivo) {
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
    
    @XmlTransient
    public List<Fxexu> getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(List<Fxexu> listaFechas) {
        this.listaFechas = listaFechas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoId != null ? medicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisMedicos)) {
            return false;
        }
        SisMedicos other = (SisMedicos) object;
        if ((this.medicoId == null && other.medicoId != null) || (this.medicoId != null && !this.medicoId.equals(other.medicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.SisMedicos[ medicoId=" + medicoId + " ]";
    }
    
}
