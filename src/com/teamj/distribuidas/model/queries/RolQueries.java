/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Opcion;
import com.teamj.distribuidas.model.database.Rol;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Guaman
 */
public class RolQueries {

    public static Rol retrieveRolesByCodigoOpcion(Integer codOpcion) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Rol lista = null;
        Query query = session.createQuery("from Rol p left join fetch p.opcionDePerfil op left join fetch op.opcion n where n.codigo=:codePatient");
        query.setParameter("codePatient", codOpcion);
        lista = (Rol) query.uniqueResult();
        return lista;
    }

    public static Rol retrieveRolesByCodigoOpcionAndCodigoPerfil(Integer codOpcion, Integer codPerfil) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Rol lista = null;
        Query query = session.createQuery("from Rol p left join fetch p.opcionDePerfil op left join fetch op.opcion n left join fetch op.perfil pe where n.codigo=:codePatient and pe.codigoPerfil=:codPerf");
        query.setParameter("codePatient", codOpcion);
        query.setParameter("codPerf", codPerfil);
        lista = (Rol) query.uniqueResult();
        return lista;
    }

    public static void updateRoles(Rol rol) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        session.update(rol);
    }

    public static Rol insertarRolesOpcionPerfil(Rol rol) {
        Session session = HibernateUtilSeguridades.getSessionSeguridadFactory().getCurrentSession();
        Rol per = null;
        try {
            per = (Rol) session.merge(rol);
        } catch (HibernateException he) {
            System.err.println("Error RolQueries al insertar.");
            throw he;
        }
        return per;
    }
}
