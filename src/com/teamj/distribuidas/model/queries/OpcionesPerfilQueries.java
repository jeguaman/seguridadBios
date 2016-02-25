/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.OpcionDePerfil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class OpcionesPerfilQueries {

    public static List<OpcionDePerfil> retrieveListaOpcionesDePerfil() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from OpcionDePerfil p");
        List<OpcionDePerfil> lista = (List<OpcionDePerfil>) query.list();
        return lista;
    }

    public static List<OpcionDePerfil> retrieveListaOpcionesDePerfilJoin() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from OpcionDePerfil p left join fetch p.opcion left join fetch p.perfil ");
        List<OpcionDePerfil> lista = (List<OpcionDePerfil>) query.list();
        return lista;
    }

    public static OpcionDePerfil insertarOpcionesXPerfil(OpcionDePerfil opcionesXPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        OpcionDePerfil per = null;
        try {
            per = (OpcionDePerfil) session.merge(opcionesXPerfil);
        } catch (HibernateException he) {
            System.err.println("Error OpcionDePerfil al insertar.");
            throw he;
        }
        return per;
    }

    public static OpcionDePerfil retrieveOpcionesXPerfilByCodPerfilAndCodOpcion(Integer codigoPerfil, Integer codigoOpcion) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        OpcionDePerfil per = null;
        Query query = session.createQuery("from OpcionDePerfil p where p.perfil.codigoPerfil=:codPerf and p.opcion.codigo=:codOpc");
        query.setParameter("codPerf", codigoPerfil);
        query.setParameter("codOpc", codigoOpcion);
        per = (OpcionDePerfil) query.uniqueResult();
        return per;
    }

    public static void actualizarOpcionesPorPerfil(OpcionDePerfil pac) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        session.update(pac);
    }
}
