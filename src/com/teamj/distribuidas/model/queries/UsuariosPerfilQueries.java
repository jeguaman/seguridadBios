/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Perfil;
import com.teamj.distribuidas.model.database.UsuarioXPerfil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class UsuariosPerfilQueries {

    public static UsuarioXPerfil insertarUsuariosXPerfil(UsuarioXPerfil userXPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        UsuarioXPerfil per = null;
        try {
            per = (UsuarioXPerfil) session.merge(userXPerfil);
        } catch (HibernateException he) {
            System.err.println("Error PersonaQueries al insertar.");
            throw he;
        }
        return per;
    }

    public static void actualizarUsuariosXPerfil(UsuarioXPerfil userXPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        session.update(userXPerfil);
    }

    public static void eliminarUsuarioXPerfil(UsuarioXPerfil userXPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        session.delete(userXPerfil);
    }

    public static UsuarioXPerfil retrieveUsuarioXPerfilByCode(Integer _code) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        UsuarioXPerfil patient = null;
        try {
            Query query = session.createQuery("from UsuarioXPerfil as p where p.codigoUsuarioPerfil=:codePatient");
            query.setParameter("codePatient", _code);
            patient = (UsuarioXPerfil) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error UsuarioXPerfil retrieve by code.");
            throw e;
        }
        return patient;
    }
    
    public static UsuarioXPerfil retrieveUsuarioXPerfilBy_CodUsuario_codPerfil(Integer codUsuario, Integer codPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        UsuarioXPerfil patient = null;
        try {
            Query query = session.createQuery("from UsuarioXPerfil as p where p.usuario.codigo=:codeUser and p.perfil.codigoPerfil=:codePerfil");
            query.setParameter("codeUser", codUsuario);
            query.setParameter("codePerfil", codPerfil);
            patient = (UsuarioXPerfil) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error UsuarioXPerfil retrieve by code.");
            throw e;
        }
        return patient;
    }
}
