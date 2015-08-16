
package ni.gob.minsa.controlador.seguridad;

import java.util.List;
import ni.gob.minsa.ciportal.dto.InfoResultado;
import ni.gob.minsa.soporte.HibernateResource;
import ni.gob.minsa.modelo.seguridad.UsuarioEntidad;
import ni.gob.minsa.servicios.seguridad.UsuarioEntidadService;
import ni.gob.minsa.soporte.Mensajes;
import org.hibernate.Hibernate;
import org.hibernate.Query;


public class UsuarioEntidadDA extends HibernateResource implements UsuarioEntidadService{
    private static final HibernateResource hibernateResource = new HibernateResource();
   
    public UsuarioEntidadDA(){
        
    }

    @Override
    public List<UsuarioEntidad> obtenerEntidadesPorUsuario(long pUsuarioId) {
        try{
            Query query = getSession().getNamedQuery("entidadesPorUsuario");
            query.setParameter("pUsuarioId", pUsuarioId);
            List<UsuarioEntidad> oUsuariosEntidades = query.list();
            for (UsuarioEntidad oUsuarioEntidad : oUsuariosEntidades) {
                Hibernate.initialize(oUsuarioEntidad.getEntidadAdtva());
            }
            return query.list();
        }catch(Exception e){
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }finally{
            hibernateResource.close();
        }
    }

    @Override
    public InfoResultado obtenerPorId(long pUsuarioEntidadId) {
        try{
            InfoResultado infoResultado = new InfoResultado();
        
        try{
            UsuarioEntidad usuarioEntidad = (UsuarioEntidad) getSession().get(UsuarioEntidad.class, pUsuarioEntidadId);
            
            if(usuarioEntidad!=null) {
                infoResultado.setFilasAfectadas(1);
                infoResultado.setOk(true);
                infoResultado.setObjeto((Object)usuarioEntidad);
             }else{
                infoResultado.setMensaje(Mensajes.ENCONTRAR_REGISTRO_NO_EXISTE);
    		infoResultado.setOk(false);
    		infoResultado.setFilasAfectadas(0);
            }
        }catch(Exception e){
            infoResultado.setExcepcion(true);
            infoResultado.setMensaje(Mensajes.ERROR_NO_CONTROLADO + e.getMessage());
            infoResultado.setFuenteError(e.toString().split(":",1).toString());
            infoResultado.setGravedad(InfoResultado.SEVERITY_FATAL);
            infoResultado.setOk(false);
            infoResultado.setFilasAfectadas(0);
        }finally{
            hibernateResource.close();
        }
        
        return infoResultado;
        }catch(Exception e){
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }
    }


}
