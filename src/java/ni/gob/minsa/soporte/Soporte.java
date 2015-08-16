package ni.gob.minsa.soporte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import ni.gob.minsa.ciportal.dto.InfoSesion;

/**
 * 
 * <p>
 * @author Felix Medina
 * @author <a href=mailto:desarrollo04@minsa.gob.ni>desarrollo04@minsa.gob.ni</a>
 * @version 1.0, &nbsp; 13/09/2013
 * @since jdk1.6.0_21
 */
public class Soporte {

    public static final String CODIGO_SISTEMA = "SIVIPCAN"; //desabilitando seguridad parte 2
    public static final String PAIS_CODIGO="NI";
    public static final String SEXO_MASCULINO="SEXO|M";
    public static final String SEXO_FEMENINO="SEXO|F";

    public Soporte() {
    }
    
    /**
     * Convierte una cadena de texto a un objeto fecha.
     * Retorna
     * <code>null</code> si se ha producido un error en la conversión
     *
     * @param pFechaTexto
     * @return  
     */
    public static Date stringAfecha(String pFechaTexto) {

        if (pFechaTexto == null) {
            return null;
        }
        if (pFechaTexto.isEmpty()) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(pFechaTexto);
        } catch (Throwable e) {
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }


    }
    
    /**
     * Retorna el objeto {@link InfoSesion} con los datos del usuario y sistema
     * a la cual pertenece la sesión y que ha sido autorizada. La información de
     * la sesión se encuentra almacenada en una variable de sesión inicializada
     * al establecer el marco de trabajo en el SeguridadController.
     *
     * @return Objeto InfoSesion
     */
    public static InfoSesion getInfoSesionActual() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (InfoSesion) facesContext.getExternalContext().getSessionMap().get("usuarioActual");
    }
    
    /**
     * Retorna un objeto de tipo ServletRequest, el cual provee información sobre la solicitud del cliente.
     * 
     * @return Objeto HttpServletRequest
     */
    public static HttpServletRequest getHttpServletRequest() {
        try {
            return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        } catch (Throwable e) {
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }
    }
    
    /**
     * Calucla la edad de la persona a partir de la fecha de Nacimiento.
     * 
     * @param pFechaNac
     * @return 
     */
    public static Integer calcularEdadEnAnios(Date pFechaNac) {
        try {
            Calendar hoy = Calendar.getInstance();
            Calendar fdn = Calendar.getInstance();
            fdn.setTime(pFechaNac);

            int age = hoy.get(Calendar.YEAR) - fdn.get(Calendar.YEAR);
            if (hoy.get(Calendar.MONTH) < fdn.get(Calendar.MONTH)) {
                age--;
            } else if (hoy.get(Calendar.MONTH) == fdn.get(Calendar.MONTH)) {
                if (hoy.get(Calendar.DAY_OF_MONTH) < fdn.get(Calendar.DAY_OF_MONTH)) {
                    age--;
                }
            }

            return new Integer(age);
        } catch (Exception e) {
            System.out.println("---------------------------- EXCEPCION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }
    }
    
    public static boolean compararCadenas(String pCadena1, String pCadena2) {
            if (pCadena1!=null && pCadena2!=null) return pCadena1.trim().equals(pCadena2.trim());
            if (pCadena1==null && pCadena2!=null && !pCadena2.trim().isEmpty()) return false;
            if (pCadena2==null && pCadena1!=null && !pCadena1.trim().isEmpty()) return false;
            return true;
    }
    
    /**
    * @author Rafael Márquez
    * Resta 3 años a una fecha.
    * @param fecha
    *          Fecha a la que se le resta años.
    * @return
    * @throws Exception
    */ 
  public static Date aniosAnteriores(final Date fecha) {
      int dias = -3;  
      if (fecha != null) {
           Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            cal.add(Calendar.YEAR, dias);
            return cal.getTime();
        }
        return null;
    }  
    /**
    * @author Rafael Márquez
    * Obtiene el año de una fecha.
    * @param fecha
    *    Fecha de la que se obtiene el año.
    * @return
    * @throws Exception
    */ 
    public static Date anioActual(final Date fecha) {
        Calendar calendar = Calendar.getInstance();
        if (fecha != null) {
           Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            calendar.get(Calendar.YEAR);
            return cal.getTime();
        }
        return null;
    }
    
    /**
    * Eliminar de un número la coma para el formato de miles.
    * Esto es necesario para el suggestion list, ya que si en
    * el formulario capturamos el valor del filtro con parseInt
    * lo que esta función hace es truncar el número hasta la coma.
    * @param numero
    * Número del cual se necesita eliminar la coma.
    * @return Integer número que representa el identificador
    * de un item.
    */
    public static Integer stringToInt(String numero) {
        int comma = numero.indexOf(",");
        // Si existe una coma en el número, se debe remover
        if (comma > -1) {
            StringBuilder stringbufferTo = new StringBuilder(numero);
            stringbufferTo.replace(comma, comma+1, "");
            numero = stringbufferTo.toString();
        }
        return Integer.valueOf(numero);
    }
}
