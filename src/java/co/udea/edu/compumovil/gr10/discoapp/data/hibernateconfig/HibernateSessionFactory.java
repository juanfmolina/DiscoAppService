/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.compumovil.gr10.discoapp.data.hibernateconfig;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author juanf.molina
 */
public class HibernateSessionFactory {

    private static HibernateSessionFactory instancia = null;
    private static SessionFactory sessionFactory = null;
    private static Configuration configuration = new Configuration();

    private HibernateSessionFactory() {

    }

    public static HibernateSessionFactory getInstance() {
        if (instancia == null) {
            instancia = new HibernateSessionFactory();
        }

        return instancia;
    }

    /**
     * Construye la factoria de sesiones con el archivo de configuración de
     * Hibernate dado
     *
     * @throws IWDAOException
     */
    private static void rebuildSessionFactory() {
        try {
            configuration.configure("co/udea/edu/compumovil/gr10/discoapp/data/hibernateconfig/hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Obtiene una sesión activa
     *
     * @return
     */
    public Session getSession() {
        if (sessionFactory == null) {
            rebuildSessionFactory();
        }
        return sessionFactory.openSession();

    }

}
