
package ni.gob.minsa.controlador.seguridad;

import java.util.List;
import ni.gob.minsa.ciportal.dto.InfoResultado;
import ni.gob.minsa.modelo.seguridad.UsuarioUnidad;
import ni.gob.minsa.servicios.seguridad.UsuarioUnidadService;
import ni.gob.minsa.soporte.HibernateResource;
import ni.gob.minsa.soporte.Mensajes;
import org.hibernate.Hibernate;
import org.hibernate.Query;


public class UsuarioUnidadDA  implements UsuarioUnidadService{
    
    private static final HibernateResource hibernateResource = new HibernateResource();
    
    public UsuarioUnidadDA(){ 
        
    }

    @Override
    public List<UsuarioUnidad> obtenerUnidadesPorUsuario(long pUsuarioId) {
         try{
            Query query = hibernateResource.getSession().getNamedQuery("unidadesPorUsuario");
            query.setLong("pUsuarioId", pUsuarioId);
            
            List<UsuarioUnidad> usuarioUnidades = (List<UsuarioUnidad>)query.list();
            
            if(usuarioUnidades!=null){
                for(int i=0; i < usuarioUnidades.size();i++){
                    Hibernate.initialize(usuarioUnidades.get(i).getUsuario());
                    Hibernate.initialize(usuarioUnidades.get(i).getUnidad());
                    if(usuarioUnidades.get(i).getUnidad()!=null){
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getEntidadAdtva());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getCategoria()); 
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getMunicipio());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getRegimen());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getTipoUnidad());
                    }
                   
                }
            }
            
            return usuarioUnidades;
        }catch(Exception e){
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }finally{
             hibernateResource.close();
         }
    }

    @Override
    public List<UsuarioUnidad> obtenerUnidadesPorUsuario(long pUsuarioId, long pEntidadId, long pTipoUnidadId) {
        try{
            Query query = hibernateResource.getSession().getNamedQuery("unidadesPorUsuarioEntidadYTipo");
            query.setLong("pUsuarioId", pUsuarioId);
            query.setLong("pEntidadId", pEntidadId);
            query.setLong("pTipoUnidadId", pTipoUnidadId);
           
            List<UsuarioUnidad> usuarioUnidades = (List<UsuarioUnidad>)query.list();
            
            if(usuarioUnidades!=null){
                for(int i=0; i < usuarioUnidades.size();i++){
                    Hibernate.initialize(usuarioUnidades.get(i).getUsuario());
                    Hibernate.initialize(usuarioUnidades.get(i).getUnidad());
                    if(usuarioUnidades.get(i).getUnidad()!=null){
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getEntidadAdtva());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getCategoria());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getMunicipio());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getRegimen());
                        Hibernate.initialize(usuarioUnidades.get(i).getUnidad().getTipoUnidad());
                    }
                   
                }
            }
            
            return usuarioUnidades;
        }catch(Exception e){
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }finally{
            hibernateResource.close();
        }
    }

    @Override
    public InfoResultado obtenerPorId(long pUsuarioUnidadId) {
       
        try{
            InfoResultado infoResultado = new InfoResultado();
        
        try{
            UsuarioUnidad usuarioUnidad = (UsuarioUnidad) hibernateResource.getSession().get(UsuarioUnidad.class, pUsuarioUnidadId);
            
            if(usuarioUnidad!=null) {
                infoResultado.setFilasAfectadas(1);
                infoResultado.setOk(true);
                infoResultado.setObjeto((Object)usuarioUnidad);
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
        }
        
        return infoResultado;
        }catch(Exception e){
            System.out.println("---- EXCEPTION");
            System.out.println("Error no controlado: " + e.toString());
            return null;
        }finally{
            hibernateResource.close();
        }
    }
    
}
