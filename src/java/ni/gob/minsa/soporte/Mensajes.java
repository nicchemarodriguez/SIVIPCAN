package ni.gob.minsa.soporte;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import ni.gob.minsa.ciportal.dto.InfoResultado;


public class Mensajes {
    
    /**
        * Mensaje de error cuando se produce un error no controlado y se produce una
        * excepción
        */
    public static final String ERROR_NO_CONTROLADO="Se ha producido un error no controlado: ";
    /**
        * Mensaje que según la gravedad del error, se solicita la notificación al
        * administrador del sistema
        */
    public static final String NOTIFICACION_ADMINISTRADOR="Anote el detalle del mensaje y notifique al administrador del sistema. ";
    /**
        * Mensaje que se presenta cuando se guarda un registro
        * de forma exitosa.
        */
    public static final String REGISTRO_GUARDADO="El registro ha sido almacenado con éxito. ";
    public static final String REGISTRO_ACTUALIZADO="El registro ha sido actualizado con éxito. ";
    public static final String REGISTRO_ELIMINADO="El registro ha sido eliminado con éxito. ";
    public static final String EXCEPCION_REGISTRO_EXISTE="El registro no puede ser guardado. El registro ya existe. ";
    public static final String REGISTRO_NO_GUARDADO="Se ha producido un error al guardar el registro. ";
    public static final String REGISTRO_DUPLICADO="El registro ya existe y no puede estar duplicado.";
    public static final String ELIMINAR_REGISTRO_NO_EXISTE="El registro ya no existe y por tanto, no puede ser eliminado";
    public static final String ENCONTRAR_REGISTRO_NO_EXISTE="El registro ya no existe, ha sido eliminado por otro usuario";
    public static final String ELIMINAR_RESTRICCION="El registro no puede ser eliminado ya que otros registros dependen de él";
    public static final String REGISTRO_AGREGADO="Registro Agregado con éxito";
    public static final String REGISTRO_NO_ENCONTRADO="No se han encontrado resultados";
    public static final String EXCEPCION_VALORES_REQUERIDOS="El registro no puede ser guardado. Valores requeridos sin definir.";
    public static final String AUTENTICACION_FALLIDA="El nombre de usuario o contraseña es incorrecto.";
    public static final String REGISTRO_NO_SELECCIONADO="El registro no ha sido seleccionado.";
    public static final String EXCEPCION_DETALLE_REGISTRO="El detalle del registro no pudo ser cargado.";
    public static final String RESTRICCION_BUSQUEDA="La busqueda solo es permitida para un numero superior a 3 caracteres";
    public static final String SERVICIO_NO_ENCONTRADO="El servicio requerido para efectuar esta operaci�n no se encuentra activo";
    /**
     * Seviridad del mensaje a generar.
     */
    public static final FacesMessage.Severity SEVERITY_INFO = FacesMessage.SEVERITY_INFO;
    public static final FacesMessage.Severity SEVERITY_ERROR = FacesMessage.SEVERITY_ERROR;
    public static final FacesMessage.Severity SEVERITY_FATAL = FacesMessage.SEVERITY_FATAL;
    public static final FacesMessage.Severity ADVERTENCIA = FacesMessage.SEVERITY_WARN;
    
    public Mensajes() { 

    }
    
    public static FacesMessage getMensaje(Severity pGravedad,String pMensajeGeneral,String pMensajeDetalle) {
        FacesMessage mensaje;
        mensaje = new FacesMessage(pGravedad,pMensajeGeneral,pMensajeDetalle);
        return mensaje;
    }
    
    public static FacesMessage enviarMensaje(Severity pGravedad,
            String pMensajeGeneral,String pMensajeDetalle) {	
        FacesMessage msg = null;
        msg = new FacesMessage(pGravedad,pMensajeGeneral,pMensajeDetalle);
        return msg;

    }
    
    public static void enviarMensaje(InfoResultado pResultado) {

        if ((pResultado.getMensaje()==null) || (pResultado.getMensaje().isEmpty())) {
            return;
        }

        FacesMessage mensaje;
        FacesMessage.Severity gravedad=FacesMessage.SEVERITY_INFO;;

        switch(pResultado.getGravedad()) {
                case 2:
                        gravedad=FacesMessage.SEVERITY_WARN;
                        break;
                case 3:
                        gravedad=FacesMessage.SEVERITY_ERROR;
                        break;
                case 4:
                        gravedad=FacesMessage.SEVERITY_FATAL;
        }

        String detalle="";
        if ((pResultado.getMensajeDetalle()!=null) && (!pResultado.getMensajeDetalle().isEmpty())) {
                detalle=pResultado.getFuenteError();
        }

        if (pResultado.isExcepcion()) {
                if ((pResultado.getFuenteError()!=null) && (!pResultado.getFuenteError().isEmpty())) {
                        detalle=detalle.isEmpty() ? pResultado.getFuenteError(): detalle+": "+pResultado.getFuenteError();
                }
        }

        mensaje = new FacesMessage(gravedad,pResultado.getMensaje(),detalle);
        FacesContext.getCurrentInstance().addMessage(null,mensaje);
    }
}
