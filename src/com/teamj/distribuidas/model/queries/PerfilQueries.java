/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Perfil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class PerfilQueries {

    public static Perfil insertarPerfil(Perfil perfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Perfil per = null;
        try {
            per = (Perfil) session.merge(perfil);
        } catch (HibernateException he) {
            System.err.println("Error PersonaQueries al insertar.");
            throw he;
        }
        return per;
    }

    public static List<Perfil> retrieveListaPerfiles() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Perfil p");
        List<Perfil> lista = (List<Perfil>) query.list();
        return lista;
    }

    public static Perfil retrievePerfilByCodigo(Integer _code) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Perfil perfil = null;
        try {
            Query query = session.createQuery("from Perfil as p where p.codigoPerfil=:codePatient");
            query.setParameter("codePatient", _code);
            perfil = (Perfil) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error PacienteQueries retrieve by code.");
            throw e;
        }
        return perfil;
    }
}
