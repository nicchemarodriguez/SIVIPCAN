// -----------------------------------------------
// UsuarioEntidad.java
// -----------------------------------------------
package ni.gob.minsa.modelo.seguridad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import ni.gob.minsa.modelo.estructura.EntidadAdtva;
import ni.gob.minsa.modelo.portal.Sistema;
import ni.gob.minsa.modelo.portal.Usuario;

@Entity
@Table(name="USUARIOS_ENTIDADES", schema="GENERAL")
@NamedQueries({
	@NamedQuery(
			name="entidadesPorUsuario",
			query="select tue from UsuarioEntidad tue " +
					"where tue.usuario.usuarioId=:pUsuarioId " +
					"order by tue.entidadAdtva.nombre")
})
/**
 * La clase persistente para la tabla USUARIOS_ENTIDADES 
 * de la base de datos en el esquema GENERAL
 * <p>
 * @author Marlon Arr�liga
 * @author <a href=mailto:marrolig@hotmail.com>marrolig@hotmail.com</a>
 * @version 1.0, &nbsp; 08/05/2012
 * @since jdk1.6.0_21
 */

public class UsuarioEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOSENTIDADES_USUARIOENTIDADID_GENERATOR", sequenceName="USUARIOSENTS_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOSENTIDADES_USUARIOENTIDADID_GENERATOR")
	@Column(name="USUARIO_ENTIDAD_ID", insertable=true, updatable=false, unique=true, nullable=false, precision=10)
	private long usuarioEntidadId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="FECHA_REGISTRO", updatable=false, nullable=false)
	private Date fechaRegistro;

	@Column(name="USUARIO_REGISTRO", nullable=false, length=100)
	private String usuarioRegistro;

	@ManyToOne(targetEntity=Sistema.class,fetch=FetchType.LAZY)
	@JoinColumn(name="SISTEMA", unique=false, nullable=false, updatable=false)
	private Sistema sistema;

	@ManyToOne(targetEntity=EntidadAdtva.class,fetch=FetchType.LAZY)
	@JoinColumn(name="ENTIDAD_ADTVA", nullable=false,updatable=false)
	private EntidadAdtva entidadAdtva;

	@ManyToOne(targetEntity=Usuario.class,fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO", nullable=false,updatable=false)
	private Usuario usuario;

    public UsuarioEntidad() {
    }

	public long getUsuarioEntidadId() {
		return this.usuarioEntidadId;
	}

	public void setUsuarioEntidadId(long usuarioEntidadId) {
		this.usuarioEntidadId = usuarioEntidadId;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public EntidadAdtva getEntidadAdtva() {
		return this.entidadAdtva;
	}

	public void setEntidadAdtva(EntidadAdtva entidadAdtva) {
		this.entidadAdtva = entidadAdtva;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
}
