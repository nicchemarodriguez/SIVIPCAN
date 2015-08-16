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
import ni.gob.minsa.sivipcan.modelo.Valores;

@FacesConverter(forClass = Valores.class, value="converterValores")
public class ValoresConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
               if (string != null && !string.isEmpty()) {
                   
            return ( Valores ) uic.getAttributes().get(string);
        }
        return null;
    

        //To change body of generated methods, choose Tools | Templates.
    }
        @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Valores) {
            Valores entity= ( Valores ) o;
           if (entity != null && entity instanceof Valores && entity.getIdValor()!= null) {
                uic.getAttributes().put( entity.getIdValor().toString(), entity);
                return entity.getIdValor().toString();
            }
        }
        return "";
    }
    
}
