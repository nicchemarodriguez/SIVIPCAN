
package ni.gob.minsa.servicios.seguridad;

import java.util.Map;
import ni.gob.minsa.ciportal.dto.InfoResultado;
import ni.gob.minsa.ciportal.dto.InfoSesion;


/**
 * <p>
 * @author Felix Medina
 * @author <a href=mailto:desarrollo04@minsa.gob.ni>desarrollo04@minsa.gob.ni</a>
 * @version 1.0, &nbsp; 13/09/2013
 * @since jdk1.6.0_21
 */
public interface SeguridadService {
    
    /**
     * 
     * @param pBdSessionId 
     * @return 
     */
    public InfoSesion obtenerInfoSesion(String pBdSessionId);
    
    /**
     * 
     * @param pUsuarioId Identificador primario del usuario.
     * @param pViewId   Nombre la página.
     * @param pCodigoSistema Código del sistema.
     * @return 
     */
    public boolean esUsuarioAutorizado(long pUsuarioId,String pViewId,String pCodigoSistema);
    
    /**
     * 
     * @return  URL del portal de aplicaciones del MINSA.
     */
    public String obtenerUrlPortal();
    
    /**
     * 
     * @param pUserName Nombre de fantasía del usuario.
     * @return 
     */
    public Map<String,String> listarSistemasAutorizados(String pUserName);
    
    /**
     * 
     * @param pUsername Nombre de fantasía del usuario.
     * @param pSistema Código del sistema.
     * @return 
     */
    public InfoResultado solicitarAplicacion(String pUsername, String pSistema);
    
    /**
     * 
     * @param pUsername Nombre de fantasía del usuario.
     * @param pClaveAnterior Clave actual del usuario.
     * @param pClaveNueva Nueva clave.
     * @param pClaveRepite Nueva clave.
     * @return 
     */
    public InfoResultado cambiarClave(String pUsername, String pClaveAnterior, 
            String pClaveNueva, String pClaveRepite);
}
