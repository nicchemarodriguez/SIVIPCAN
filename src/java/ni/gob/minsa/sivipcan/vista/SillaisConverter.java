/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
package ni.gob.minsa.sivipcan.vista;
//


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ni.gob.minsa.modelo.estructura.EntidadAdtva;

///*
//
///**
// *
// * @win7
// */
//@FacesConverter("silaisConverter" )
//

@FacesConverter(forClass =EntidadAdtva.class,  value = "EntidadAdConverter")
public class SillaisConverter implements Converter{
     

  


    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
               if (string != null && !string.isEmpty()) {
                   
            return (EntidadAdtva) uic.getAttributes().get(string);
        }
        return null;
    

        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof EntidadAdtva) {
            EntidadAdtva entity= (EntidadAdtva) o;
           if (entity != null && entity instanceof EntidadAdtva && entity.getEntidadAdtvaId()!= null) {
                uic.getAttributes().put( entity.getEntidadAdtvaId().toString(), entity);
                return entity.getEntidadAdtvaId().toString();
            }
        }
        return "";
    } //To change body of generated methods, choose Tools | Templates.
    }

   



