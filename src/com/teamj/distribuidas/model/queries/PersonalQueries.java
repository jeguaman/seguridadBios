/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.model.database.Persona;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class PersonalQueries {

    public static List<Persona> retrieveListaPersonas() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Persona p");
        List<Persona> lista = (List<Persona>) query.list();
        return lista;
    }

    public static Persona retrievePersonabyCode(Integer _code) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Persona patient = null;
        try {
            Query query = session.createQuery("from Persona as p where p.codigo=:codePatient");
            query.setParameter("codePatient", _code);
            patient = (Persona) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error PersonalQueries retrieve by code.");
            throw e;
        }
        return patient;
    }
    public static Persona retrievePersonaByIdentificacion(String ident) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Persona patient = null;
        try {
            Query query = session.createQuery("from Persona as p where p.cedula=:codePatient");
            query.setParameter("codePatient", ident);
            patient = (Persona) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error PersonalQueries retrieve by identificacion.");
            throw e;
        }
        return patient;
    }
    
    public static Persona insertarPersona(Persona persona) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Persona user = null;
        try {
            user = (Persona) session.merge(persona);
        } catch (HibernateException he) {
            System.err.println("Error PersonaQueries al insertar.");
            throw he;
        }
        return user;
    }
}
