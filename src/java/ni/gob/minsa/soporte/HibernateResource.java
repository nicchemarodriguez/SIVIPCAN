package ni.gob.minsa.soporte;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Este es un bean de Aplicación que mantiene el Hibernate SessionFactory.  
 * 
 * Como este recurso es a nivel de aplicación el SessionFactory 
 * es creado una sola vez para la aplicación
 * <p>
 * @author Felix Medina
 * @author <a href=mailto:desarrollo04@minsa.gob.ni>desarrollo04@minsa.gob.ni</a>
 * @version 1.0, &nbsp; 13/09/2013
 * @since jdk1.6.0_21
 */
public class HibernateResource {

    private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
    private static final SessionFactory sessionFactory;

    static {

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public HibernateResource() {
    }

    /**
     * 
     * @return 
     */
    public Session getSession() {

        Session iSession = (Session) HibernateResource.session.get();

        if (iSession == null || iSession.isOpen() == false) {
            iSession = sessionFactory.openSession();
            HibernateResource.session.set(iSession);
        }
        return iSession;
    }

    /**
     * 
     */
    public void begin() {
        try {
            if (!getSession().getTransaction().isActive()) {
                getSession().beginTransaction();
            }
        } catch (Exception e) {
            System.out.println("---- EXCEPTION");
            System.out.println("Error en JDBC Transaction: " + e.toString());
        }

    }

    /**
     * 
     */
    public void commit() {
        try {
            if (getSession().getTransaction().isActive()) {
                getSession().getTransaction().commit();
            }

        } catch (Exception e) {
            System.out.println("---- EXCEPTION");
            System.out.println("Error en JDBC Transaction: " + e.toString());
        }
    }

    /**
     * 
     */
    public void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (Exception e) {
            System.out.println("---- EXCEPTION");
            System.out.println("Error en JDBC Transaction: " + e.toString());
        }

    }

   /**
    * 
    */
    public void close() {
        try {
            getSession().close();
            HibernateResource.session.set(null);
        } catch (Exception e) {
            System.out.println("---- EXCEPTION");
            System.out.println("Error en JDBC Transaction: " + e.toString());
        }
    }
}
