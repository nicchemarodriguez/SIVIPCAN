/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.vista;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.sivipcan.modelo.Categoria;

/**
 *
 * @author WIN 7
 */
@FacesConverter(forClass = Comunidad.class, value="converterComunidad")
public class ComunidadConverter implements Converter {
    
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
               if (string != null && !string.isEmpty()) {
                   
            return ( Comunidad ) uic.getAttributes().get(string);
        }
        return null;
    

        //To change body of generated methods, choose Tools | Templates.
    }
        @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Comunidad) {
            Comunidad entity= ( Comunidad ) o;
           if (entity != null && entity instanceof Comunidad && entity.getComunidadId()!= null) {
                uic.getAttributes().put( entity.getComunidadId().toString(), entity);
                return entity.getComunidadId().toString();
            }
        }
        return "";
    }
    
}
