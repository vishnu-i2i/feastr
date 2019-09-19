package com.ideas2it.feastr.configuration;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.feastr.exception.CustomException;

/**
 *  Creates new session factory and closes the built session factory
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException exception) {
            System.out.println("Initial Session Factory creation failed"
                               + exception);
        }
    }
    
    /**Used to Build a new session factory if not existed previously or returns 
     * the already existing factory 
     */
    public static SessionFactory buildSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Closes the session factory at the end of the program
     */
    public static void closeFactory() {
        try {
            sessionFactory.close();
        } catch (HibernateException exception) {
            System.out.println("Error while closing session Factory" + exception);
        }
    }
}
