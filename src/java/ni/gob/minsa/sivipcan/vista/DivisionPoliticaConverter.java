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
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;

@FacesConverter(forClass = DivisionPolitica.class,  value = "DivisionPolConverter")
public class DivisionPoliticaConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
               if (string != null && !string.isEmpty()) {
                   
            return (DivisionPolitica) uic.getAttributes().get(string);
        }
        return null;
    

        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof DivisionPolitica) {
            DivisionPolitica entity= (DivisionPolitica) o;
           if (entity != null && entity instanceof DivisionPolitica && entity.getCodigoNacional()!= null) {
                uic.getAttributes().put( entity.getCodigoNacional().toString(), entity);
                return entity.getCodigoNacional().toString();
            }
        }
        return "";
    } 
    
}
