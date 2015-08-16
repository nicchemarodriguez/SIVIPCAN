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
import ni.gob.minsa.sivipcan.modelo.SubCategoria;

@FacesConverter(forClass =SubCategoria.class, value="converterSub")
public class SubCategoriaConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
               if (string != null && !string.isEmpty()) {
                   
            return ( SubCategoria ) uic.getAttributes().get(string);
        }
        return null;
    

        //To change body of generated methods, choose Tools | Templates.
    }
        @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof SubCategoria) {
            SubCategoria entity= ( SubCategoria ) o;
           if (entity != null && entity instanceof SubCategoria && entity.getIdSubcategoria()!= null) {
                uic.getAttributes().put( entity.getIdSubcategoria().toString(), entity);
                return entity.getIdSubcategoria().toString();
            }
        }
        return "";
    }
    
}
