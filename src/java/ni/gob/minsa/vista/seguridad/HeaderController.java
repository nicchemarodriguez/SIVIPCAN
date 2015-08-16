/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.vista.seguridad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import ni.gob.minsa.ciportal.dto.InfoResultado;
import ni.gob.minsa.ciportal.dto.InfoSesion;
import ni.gob.minsa.controlador.seguridad.SeguridadDA;
import ni.gob.minsa.servicios.seguridad.SeguridadService;
import ni.gob.minsa.soporte.Mensajes;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.MenuModel;

@ManagedBean
@ViewScoped
public class HeaderController implements java.io.Serializable {

    private static final SeguridadService seguridadService = new SeguridadDA();
    private String claveActual = "";
    private String claveNueva = "";
    private String claveRepite = "";
    private Map.Entry<String, String> sistemaSelected;

    //*********************Constructor
    public HeaderController() {
    }

    //*********************Eventos
    public void onClickCambiarClave(ActionEvent pActionEvent) {
        this.claveActual = "";
        this.claveNueva = "";
        this.claveRepite = "";
    }

    public void onClickAceptarCambio(ActionEvent pActionEvent) {
        InfoResultado infoResultado = new InfoResultado();
        RequestContext oContext = RequestContext.getCurrentInstance();
        InfoSesion infoSesion = (InfoSesion) getFacesContext().getExternalContext().getSessionMap().get("usuarioActual");

        if (infoSesion != null) {
            infoResultado = seguridadService.cambiarClave(infoSesion.getUsername(),
                    this.claveActual, this.claveNueva, this.claveRepite);
        } else {
            infoResultado.setExcepcion(false);
            infoResultado.setMensaje("La información del usuario actual no ha podido ser recuperada.");
            infoResultado.setGravedad(InfoResultado.SEVERITY_WARN);
            infoResultado.setOk(false);
            infoResultado.setFilasAfectadas(0);
        }
        if (infoResultado.isOk()) {
            oContext.addCallbackParam("logOK", true);
        } else {
            oContext.addCallbackParam("logOK", false);
        }
        Mensajes.enviarMensaje(infoResultado);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void onSelectSistema(SelectEvent iEvento) {

        RequestContext context = RequestContext.getCurrentInstance();

        InfoResultado oInfoResultado = seguridadService.solicitarAplicacion(getNombreUsrActual(), this.sistemaSelected.getKey());
        if (!oInfoResultado.isOk()) {
            Mensajes.enviarMensaje(oInfoResultado);
            String aComponentes[] = {"frmHeader:grwMensaje"};
            Collection iComponentes = Arrays.asList(aComponentes);
            context.update(iComponentes);
        } else {
            try {
                getFacesContext().getExternalContext().redirect((String) oInfoResultado.getObjeto());
            } catch (Throwable e) {
            }
        }
    }

    //*********************Acceso a propiedades
    private FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public List<Map.Entry<String, String>> getSistemas() {
        Map<String, String> sistemasAutorizados = (Map<String, String>) getFacesContext().getExternalContext().getSessionMap().get("sistemasAutorizados");
        if (sistemasAutorizados != null) {
            Set<Map.Entry<String, String>> sistemaSet =
                    sistemasAutorizados.entrySet();
            return new ArrayList<Map.Entry<String, String>>(sistemaSet);
        } else {
            return null;
        }
    }

    public MenuModel getMenuModel() {
        return (MenuModel) getFacesContext().getExternalContext().getSessionMap().get("menuActual");
    }

    public String getNombreUsrActual() {
        InfoSesion infoSesion = (InfoSesion) getFacesContext().getExternalContext().getSessionMap().get("usuarioActual");
        if (infoSesion != null) {
            return infoSesion.getUsername();
        } else {
            return "";
        }
    }

    public String getFechaYHora() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es"));
        return simpleDateFormat.format(new Date());
    }

    public String getClaveActual() {
        return claveActual;
    }

    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    public String getClaveNueva() {
        return claveNueva;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

    public String getClaveRepite() {
        return claveRepite;
    }

    public void setClaveRepite(String claveRepite) {
        this.claveRepite = claveRepite;
    }

    public Map.Entry<String, String> getSistemaSelected() {
        return sistemaSelected;
    }

    public void setSistemaSelected(Map.Entry<String, String> sistemaSelected) {
        this.sistemaSelected = sistemaSelected;
    }
    
    
}
