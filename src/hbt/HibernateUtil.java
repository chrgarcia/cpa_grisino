package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import negocio.*;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(Provincia.class);
             config.addAnnotatedClass(Localidad.class);
             config.addAnnotatedClass(Paraje.class);
             config.addAnnotatedClass(CP.class);
             config.addAnnotatedClass(Calle.class);
             config.addAnnotatedClass(Altura.class);
             config.addAnnotatedClass(CPA.class);
             config.addAnnotatedClass(Solicitud.class);


             

             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
