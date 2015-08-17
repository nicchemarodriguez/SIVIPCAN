package ni.gob.minsa.vista.seguridad;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import ni.gob.minsa.ciportal.dto.InfoSesion;
import ni.gob.minsa.componente.MenuModelo;
import ni.gob.minsa.controlador.seguridad.SeguridadDA;
import ni.gob.minsa.servicios.seguridad.SeguridadService;
import ni.gob.minsa.soporte.Soporte;
import org.primefaces.model.MenuModel;

@ManagedBean
@RequestScoped
public class SeguridadController implements java.io.Serializable {

    private static final SeguridadService seguridadService = new SeguridadDA();

    //*********************Constructor
    public SeguridadController() {
      
    }

    //*********************Métodos    
    public void verificarCredenciales() {
        System.out.println("verificar credenciales");
        String bdSessionId = "s";  // dejar cadena vacía para activar seguridad, letra para desactivar
        HttpServletRequest httpServletRequest = Soporte.getHttpServletRequest();
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase("BDSESSIONID")) {
                    bdSessionId = cookies[i].getValue();
                }
            }
        }

        if (!bdSessionId.isEmpty()) {
                InfoSesion infoSesion = seguridadService.obtenerInfoSesion(bdSessionId);
            if (infoSesion != null) {
                getFacesContext().getExternalContext().getSessionMap().put("usuarioActual", infoSesion);
                MenuModel menuActual = MenuModelo.obtenerMenuModelo(obtenerInfoSesion().getUsuarioId(),
                        Soporte.CODIGO_SISTEMA);
                if (menuActual != null) {
                    getFacesContext().getExternalContext().getSessionMap().put("menuActual", menuActual);
                }
                Map<String,String> sistemasAutorizados = seguridadService.listarSistemasAutorizados(
                        infoSesion.getUsername());
                if(sistemasAutorizados!=null){
                    sistemasAutorizados.remove(Soporte.CODIGO_SISTEMA);
                    getFacesContext().getExternalContext().getSessionMap().put("sistemasAutorizados", sistemasAutorizados);
                }
            }
        }
        
        if (esUsuarioAutenticado() == false) {
            redirigirAUrlLogIn();
        }else{
            redirigirAInicio();
        }
    }
    
    public void verificarPermisoNavegacion() {
        if (esUsuarioAutenticado() == false) {
            redirigirAUrlLogIn();
        }
        //Verificamos si el usuario tiene permisos para acceder al recurso; de no tenerlo
        //eliminamos la sesión y lo redirigimos al PORTAL
        String viewId = getFacesContext().getViewRoot().getViewId();
        if (viewId.equals("/inicio.xhtml") == false) {
            if (seguridadService.esUsuarioAutorizado(obtenerInfoSesion().getUsuarioId(), 
                    viewId, Soporte.CODIGO_SISTEMA) == false) {
                borrarSesiones(null);
                redirigirAUrlLogIn();
            }
        }
    }

    public void borrarSesiones(ActionEvent pEvento) {
        FacesContext oFacesContext = getFacesContext();
        oFacesContext.getExternalContext().getSessionMap().remove("usuarioActual");
        oFacesContext.getExternalContext().getSessionMap().remove("menuActual");
        oFacesContext.getExternalContext().getSessionMap().remove("sistemasAutorizados");
        redirigirAUrlLogIn();
    }

    public void finalizarSesion(ActionEvent iEvento) {
        borrarSesiones(null);
    }

    public void redirigirAUrlLogIn() {
        try {
            getFacesContext().getExternalContext().redirect(seguridadService.obtenerUrlPortal());
        } catch (Throwable e) {
        }
    }
    
    public void redirigirAInicio() {
        try {
            getFacesContext().getExternalContext().redirect("inicio.xhtml");
        } catch (Throwable e) {
        }
    }

    //*********************Acceso a propiedades
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    private InfoSesion obtenerInfoSesion() {
        return (InfoSesion) getFacesContext().getExternalContext().getSessionMap().get("usuarioActual");
        
    }

    private boolean esUsuarioAutenticado() {
        return getFacesContext().getExternalContext().getSessionMap().containsKey("usuarioActual");
    }
    
}
