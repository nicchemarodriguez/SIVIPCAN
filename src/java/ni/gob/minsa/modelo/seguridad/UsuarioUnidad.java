// -----------------------------------------------
// UsuarioUnidad.java
// -----------------------------------------------
package ni.gob.minsa.modelo.seguridad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import ni.gob.minsa.modelo.estructura.Unidad;
import ni.gob.minsa.modelo.portal.Sistema;
import ni.gob.minsa.modelo.portal.Usuario;

@Entity
@Table(name="USUARIOS_UNIDADES", schema="GENERAL")
@NamedQueries({
	@NamedQuery(
			name="unidadesPorUsuario",
			query="select tuu from UsuarioUnidad tuu " +
					"where tuu.usuario.usuarioId=:pUsuarioId and " +
					       "tuu.unidad.pasivo='0' " +
					"order by tuu.unidad.nombre"),
//	@NamedQuery(
//			name="unidadesPorUsuarioEntidadYTipo",
//			query="select tuu from UsuarioUnidad tuu " +
//					"where tuu.usuario.usuarioId=:pUsuarioId and " +
//						  "tuu.unidad.pasivo='0' and " +
//						  "tuu.unidad.entidadAdtva.entidadAdtvaId=:pEntidadId and " +
//						  "(:pTipoUnidadId=0 or " +
//						  "tuu.unidad.tipoUnidad.tipoUnidadId=:pTipoUnidadId) " +
//					"order by tuu.unidad.nombre")					
})
/**
 * La clase persistente para la tabla USUARIOS_UNIDADES 
 * de la base de datos en el esquema GENERAL
 * 
 */
public class UsuarioUnidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOSUNIDADES_USUARIOUNIDADID_GENERATOR", sequenceName="USUARIOSUNDS_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOSUNIDADES_USUARIOUNIDADID_GENERATOR")
	@Column(name="USUARIO_UNIDAD_ID", insertable=true, updatable=false, unique=true, nullable=false, precision=10)
	private long usuarioUnidadId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="FECHA_REGISTRO", updatable=false, nullable=false)
	private Date fechaRegistro;

	@Column(name="USUARIO_REGISTRO", nullable=false, length=100)
	private String usuarioRegistro;

	@ManyToOne(targetEntity=Sistema.class,fetch=FetchType.LAZY)
	@JoinColumn(name="SISTEMA", unique=false, nullable=false, updatable=false)
	private Sistema sistema;
	
	@ManyToOne(targetEntity=Unidad.class,fetch=FetchType.LAZY)
	@JoinColumn(name="UNIDAD", unique=false, nullable=false, updatable=false)
	private Unidad unidad;

	@ManyToOne(targetEntity=Usuario.class,fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO", nullable=false, updatable=false, unique=false)
	private Usuario usuario;

        public UsuarioUnidad() {
        }

	public long getUsuarioUnidadId() {
		return this.usuarioUnidadId;
	}

	public void setUsuarioUnidadId(long usuarioUnidadId) {
		this.usuarioUnidadId = usuarioUnidadId;
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

	public Unidad getUnidad() {
		return this.unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Sistema getSistema() {
		return sistema;
	}
	
}