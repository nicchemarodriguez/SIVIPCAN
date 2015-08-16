package ni.gob.minsa.controlador.seguridad;

import java.util.Map;
import javax.naming.InitialContext;
import ni.gob.minsa.aplicacion.Seguridad;
import ni.gob.minsa.ciportal.dto.InfoResultado;
import ni.gob.minsa.ciportal.dto.InfoSesion;
import ni.gob.minsa.ciportal.servicios.PortalService;
import ni.gob.minsa.servicios.seguridad.SeguridadService;
import ni.gob.minsa.soporte.Mensajes;

public class SeguridadDA implements SeguridadService {

    /*
     * (non-Javadoc)
     * @see ni.gob.minsa.chagas.servicios.seguridad.SeguridadService#obtenerInfoSesion(String)
     */
    @Override
    public InfoSesion obtenerInfoSesion(String pBdSessionId) {
        InfoSesion infoSesion = null;
        try {
            PortalService portalService = obtenerPortalService();
            InfoResultado infoResultado = portalService.obtenerInfoSesion(pBdSessionId);
            if (infoResultado.isOk()) {
                infoSesion = (InfoSesion) infoResultado.getObjeto();
            }
        } catch (Throwable e) {
        }

        /*MANUALMENTE SE CREA LA SESION*/
        infoSesion = new InfoSesion();
        infoSesion.setUsuarioId(25);
        infoSesion.setUsername("SIVIPCAN");
        infoSesion.setNombre("SIVIPCAN");
        infoSesion.setSistemaSesion("SIVIPCAN"); //cargando menú SIVIPCAN
        System.out.println("" + infoSesion.getUsuarioId() + " " + infoSesion.getUsername() + " " + infoSesion.getSistemaSesion() + " " + infoSesion.getNombre());
        return infoSesion;
    }

    @Override
    public boolean esUsuarioAutorizado(long pUsuarioId, String pViewId, String pCodigoSistema) {
        try {
            PortalService portalService = obtenerPortalService();
            return portalService.esUsuarioAutorizado(pUsuarioId, pViewId, pCodigoSistema);
        } catch (Throwable e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see ni.gob.minsa.chagas.servicios.seguridad.SeguridadService#obtenerUrlPortal()
     */
    @Override
    public String obtenerUrlPortal() {
        try {
            PortalService portalService = obtenerPortalService();
            return portalService.obtenerUrlLogin();
        } catch (Throwable e) {
            return "";
        }
    }

    /*
     * (non-Javadoc)
     * @see ni.gob.minsa.chagas.servicios.seguridad.SeguridadService#obtenerPortalService()
     */
    private PortalService obtenerPortalService() {
        PortalService portalService = null;
        try {
            InitialContext ctx = new InitialContext();
            portalService = (PortalService) ctx.lookup("ejb/Portal");
        } catch (Throwable e) {
        }
        return portalService;
    }

    /*
     * (non-Javadoc)
     * @see ni.gob.minsa.chagas.servicios.seguridad.SeguridadService#cambiarClave(String,String,String,String)
     */
    @Override
    public InfoResultado cambiarClave(String pUsername, String pClaveAnterior,
            String pClaveNueva, String pClaveRepite) {
        InfoResultado infoResultado = new InfoResultado();

        if ((pUsername == null || pUsername.isEmpty())
                || (pClaveAnterior == null || pClaveAnterior.isEmpty())
                || (pClaveNueva == null || pClaveNueva.isEmpty())
                || (pClaveRepite == null || pClaveRepite.isEmpty())) {
            infoResultado.setExcepcion(false);
            infoResultado.setMensaje(Mensajes.EXCEPCION_VALORES_REQUERIDOS);
            infoResultado.setGravedad(InfoResultado.SEVERITY_WARN);
            infoResultado.setOk(false);
            infoResultado.setFilasAfectadas(0);
            return infoResultado;
        }

        if (pClaveAnterior.equals(pClaveRepite) == false) {
            infoResultado.setExcepcion(false);
            infoResultado.setMensaje("La nueva clave no coincide con la de confirmación.");
            infoResultado.setGravedad(InfoResultado.SEVERITY_WARN);
            infoResultado.setOk(false);
            infoResultado.setFilasAfectadas(0);
            return infoResultado;
        }

        try {
            return Seguridad.guardarClave(pUsername, pClaveAnterior, pClaveNueva);
        } catch (Throwable e) {
            InfoResultado oResultado = new InfoResultado();
            oResultado.setExcepcion(true);
            oResultado.setMensaje(Mensajes.ERROR_NO_CONTROLADO + e.getMessage());
            oResultado.setFuenteError(e.toString().split(":", 1).toString());
            oResultado.setOk(false);
            oResultado.setGravedad(InfoResultado.SEVERITY_FATAL);
            oResultado.setFilasAfectadas(0);
            return oResultado;
        }
    }

    /*
     * (non-Javadoc)
     * @see ni.gob.minsa.chagas.servicios.seguridad.SeguridadService#listarSistemasAutorizados(String,Map)
     */
    @Override
    public Map<String, String> listarSistemasAutorizados(String pUserName) {
        Map<String, String> sistemasAutorizados = null;
        try {
            PortalService portalService = obtenerPortalService();
            sistemasAutorizados = portalService.listarSistemasAutorizados(pUserName);
        } catch (Throwable e) {
        }
        return sistemasAutorizados;
    }

    /*
     * (non-Javadoc)
     * @see ni.gob.minsa.chagas.servicios.seguridad.SeguridadService#solicitarAplicacion(String,String)
     */
    @Override
    public InfoResultado solicitarAplicacion(String pUsername, String pSistema) {
        try {
            return Seguridad.solicitarAplicacion(pUsername, pSistema);
        } catch (Throwable e) {
            InfoResultado oResultado = new InfoResultado();
            oResultado.setExcepcion(true);
            oResultado.setMensaje(Mensajes.ERROR_NO_CONTROLADO + e.getMessage());
            oResultado.setFuenteError(e.toString().split(":", 1).toString());
            oResultado.setOk(false);
            oResultado.setGravedad(InfoResultado.SEVERITY_FATAL);
            oResultado.setFilasAfectadas(0);
            return oResultado;
        }
    }
}
