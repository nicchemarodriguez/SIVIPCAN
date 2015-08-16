// -----------------------------------------------
// UsuarioEntidadService.java
// -----------------------------------------------
package ni.gob.minsa.servicios.seguridad;
import java.util.List;
import ni.gob.minsa.ciportal.dto.InfoResultado;
import ni.gob.minsa.modelo.seguridad.UsuarioEntidad;


/**
 * Esta clase define el interface para UsuarioEntidadService.
 * La implementaci�n de este servicio accede a la capa
 * de persistencia y proporciona el llamado a la base de
 * datos.  Este interface tambi�n proporciona las operaciones de
 * mantenimiento para los datos de la tabla USUARIOS_ENTIDADES.
 * <p>
 * @author Marlon Arr�liga
 * @author <a href=mailto:marrolig@hotmail.com>marrolig@hotmail.com</a>
 * @version 1.0, &nbsp; 19/03/2012
 * @since jdk1.6.0_21
 */
public interface UsuarioEntidadService {
    /**
        * Retorna una lista de objetos {@link UsuarioEntidad} asociados
        * a un usuario, con lo cual se obtienen todas las entidades
        * administrativas a los cuales se ha autorizado a dicho usuario
        * 
        * @param pUsuarioId Identificador del usuario
        * @return Lista de Objetos {@link UsuarioEntidad}
        */
    public List<UsuarioEntidad> obtenerEntidadesPorUsuario(long pUsuarioId);
    /**
        * Busca la asociación entre un usuario y una entidad administrativa,
        * mediante su identificador y retorna el objeto encontrado mediante
        * el objeto InfoResultado.
        * 
        * @param pUsuarioEntidadId Identificador de la asociación entre el usuario y la entidad
        * @return Objeto InfoResultado con el resultado de la operación
        */
    public InfoResultado obtenerPorId(long pUsuarioEntidadId);

}
