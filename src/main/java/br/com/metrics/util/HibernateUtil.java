package br.com.metrics.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author barbara.lopes
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	  
    @SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        getSessionFactory().close();
    }
}