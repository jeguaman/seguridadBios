/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.model.queries;

import com.teamj.distribuidas.conn.HibernateUtilSeguridades;
import com.teamj.distribuidas.model.database.Opcion;
import com.teamj.distribuidas.model.database.OpcionDePerfil;
import java.util.List;
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
}
