/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.conn;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jose Guaman
 */
public class HibernateSessionHandlerSeguridades {

    private SessionFactory seguridadSession;

    public HibernateSessionHandlerSeguridades() {
        seguridadSession = HibernateUtilSeguridades.getSessionSeguridadFactory();
        try {
            seguridadSession.getCurrentSession().beginTransaction();
        } catch (HibernateException e) {
            System.err.println("Error en la session de hibernate. " + e);
        }
    }

    public void closeConnection() {
        try {
            seguridadSession.getCurrentSession().getTransaction().commit();
        } catch (HibernateException e) {
            if (seguridadSession.getCurrentSession().getTransaction().isActive()) {
                //System.err.println("Try to rollback database transaction." + e);
                seguridadSession.getCurrentSession().getTransaction().rollback();
            }
            throw e;
        } finally {
            seguridadSession.getCurrentSession().close();
        }
    }
}
