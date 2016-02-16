/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.conn;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Jose Guaman
 */
public class HibernateUtilSeguridades {

    private static final SessionFactory sessionSeguridadFactory;
    private static final ServiceRegistry sessionServiceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/hibernate.cfg.xml");
            sessionServiceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionSeguridadFactory = configuration.buildSessionFactory(sessionServiceRegistry);
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionSeguridadFactory() {
        SessionFactory session = null;
        try {
            if (sessionSeguridadFactory != null) {
                session = sessionSeguridadFactory;
            }
        } catch (Exception e) {
            throw e;
        }
        return session;
    }

    public static void init() {
        if (sessionSeguridadFactory == null) {
            throw new NullPointerException("No se inica HibernateUtil previamente.");
        } else {
            System.out.println("Se inició la session de HIBERNATE.");
        }
    }
}
