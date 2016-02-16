/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

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
public class UsuarioQueries {

    public static Usuario insertarUsuario(Usuario usuario) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Usuario user = null;
        try {
            user = (Usuario) session.merge(usuario);
        } catch (HibernateException he) {
            System.err.println("Error UsuarioQueries al insertar.");
            throw he;
        }
        return user;
    }

    public static Usuario retrieveUsuariobyCode(Integer _code) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Usuario patient = null;
        try {
            Query query = session.createQuery("from Usuario as p where p.codigo=:codePatient");
            query.setParameter("codePatient", _code);
            patient = (Usuario) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error UsuarioQueries retrieve by code.");
            throw e;
        }
        return patient;
    }

    public static Usuario retrieveUsuarioByNombre(String nombre) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Usuario user = null;
        try {
            Query query = session.createQuery("from Usuario as p where p.nombreUsuario=:codePatient");
            query.setParameter("codePatient", nombre);
            user = (Usuario) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error UsuarioQueries retrieve by nombre.");
            throw e;
        }
        return user;
    }

    public static List<Usuario> retrieveListUsuarios() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Usuario p");
        List<Usuario> lista = (List<Usuario>) query.list();
        return lista;
    }

    public static void actualizarServicio(Usuario pac) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        session.update(pac);
    }

    public static void eliminarUsuario(Usuario _objPatient) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        session.delete(_objPatient);
    }

    public static Usuario autentificacionUsuario(String nombre, String clave) {
        Usuario user = null;
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        try {
            Query query = session.createQuery("from Usuario as p where p.nombreUsuario=:codePatient and p.password=:passwd");
            query.setParameter("codePatient", nombre);
            query.setParameter("passwd", clave);
            user = (Usuario) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println("Error UsuarioQueries retrieve by nombre.");
            throw e;
        }

        return user;
    }

    public static List<Usuario> retrieveListUsuariosByPerfil(Integer codigoPerf) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("from Usuario as p inner join fetch p.usuarioXPerfils u where u.perfil.codigoPerfil=:codg");
        query.setParameter("codg", codigoPerf);
        List<Usuario> lista = (List<Usuario>) query.list();
        return lista;
    }

    public static List<Usuario> retrieveListUsuariosNoAsignados() {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Query query = session.createQuery("FROM Usuario as u where u.codigo not in (select distinct(p.usuario.codigo) from UsuarioXPerfil as p)");
        //SELECT * FROM seguridad.usuario where codigo not in (select distinct(usuario_codigo) from usuario_x_perfil);
        List<Usuario> lista = (List<Usuario>) query.list();
        return lista;
    }
}
