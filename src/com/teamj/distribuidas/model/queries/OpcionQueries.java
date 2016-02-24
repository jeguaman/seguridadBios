/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Opcion;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class OpcionQueries {

    public static List<Opcion> retrieveListaOpciones() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Opcion p");
        List<Opcion> lista = (List<Opcion>) query.list();
        return lista;
    }

    public static Opcion insertarOpcion(Opcion opcion) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Opcion per = null;
        try {
            per = (Opcion) session.merge(opcion);
        } catch (HibernateException he) {
            System.err.println("Error PersonaQueries al insertar.");
            throw he;
        }
        return per;
    }

    public static List<Opcion> retrieveOpcionesByCodigoSistema(Integer codigo) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        List<Opcion> lista = null;
        Query query = session.createQuery("from Opcion p where p.sistema.codigo=:codePatient");
        query.setParameter("codePatient", codigo);
        lista = (List<Opcion>) query.list();
        return lista;
    }

    public static List<Opcion> retrieveOpcionesByNivel(String nivel) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        List<Opcion> lista = null;
        Query query = session.createQuery("from Opcion p where p.nivel=:codePatient");
        query.setParameter("codePatient", nivel);
        lista = (List<Opcion>) query.list();
        return lista;
    }

    public static Opcion retrieveOpcionByCodigo(Integer codigo) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Opcion lista = null;
        Query query = session.createQuery("from Opcion p where p.codigo=:codePatient");
        query.setParameter("codePatient", codigo);
        lista = (Opcion) query.uniqueResult();
        return lista;
    }

    public static List<Opcion> retrieveOpcionByNivelAndCodigoPadre(String nivel, Integer codPadre) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        List<Opcion> lista = null;
        Query query = session.createQuery("from Opcion p where p.nivel=:codePatient and p.opcion.codigo=:codPadre");
        query.setParameter("codePatient", nivel);
        query.setParameter("codPadre", codPadre);
        lista = (List<Opcion>) query.list();
        return lista;
    }

    public static List<Opcion> retrieveListaOpcionesPadres() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Opcion p where p.opcion.codigo=:valor");
        query.setParameter("valor", null);
        List<Opcion> lista = (List<Opcion>) query.list();
        return lista;
    }
    
    public static List<Opcion> retrieveOpcionesByPerfil(Integer codPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        List<Opcion> lista = null;
        Query query = session.createQuery("from Opcion p left join fetch p.opcionDePerfils per where per.perfil.codigoPerfil=:codePatient");
        query.setParameter("codePatient", codPerfil);
        lista = (List<Opcion>) query.list();
        return lista;
    }
}
