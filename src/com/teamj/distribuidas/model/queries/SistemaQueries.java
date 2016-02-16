/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Sistema;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class SistemaQueries {

    public static List<Sistema> retrieveListSistemasActivos() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Sistema p where p.estado=:valor");
        query.setParameter("valor", true);
        List<Sistema> lista = (List<Sistema>) query.list();
        return lista;
    }

    public static Sistema insertarSistema(Sistema sist) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Sistema per = null;
        try {
            per = (Sistema) session.merge(sist);
        } catch (HibernateException he) {
            System.err.println("Error PersonaQueries al insertar.");
            throw he;
        }
        return per;
    }
    public static List<Sistema> retrieveListSistemas() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Sistema p");
        List<Sistema> lista = (List<Sistema>) query.list();
        return lista;
    }

}
