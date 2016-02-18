/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.facade;

import com.teamj.distribuidas.conn.HibernateSessionHandlerSeguridades;
import com.teamj.distribuidas.model.database.Opcion;
import com.teamj.distribuidas.model.database.OpcionDePerfil;
import com.teamj.distribuidas.model.database.Perfil;
import com.teamj.distribuidas.model.database.Persona;
import com.teamj.distribuidas.model.database.Sistema;
import com.teamj.distribuidas.model.database.Usuario;
import com.teamj.distribuidas.model.database.UsuarioXPerfil;
import com.teamj.distribuidas.model.queries.OpcionQueries;
import com.teamj.distribuidas.model.queries.OpcionesPerfilQueries;
import com.teamj.distribuidas.model.queries.PerfilQueries;
import com.teamj.distribuidas.model.queries.PersonalQueries;
import com.teamj.distribuidas.model.queries.SistemaQueries;
import com.teamj.distribuidas.model.queries.UsuarioQueries;
import com.teamj.distribuidas.model.queries.UsuariosPerfilQueries;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jose Guaman
 */
public class FacadeNegocio {

    public static Boolean insertarUsuario(Usuario usuario, Integer codPersona) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            Persona persona = PersonalQueries.retrievePersonabyCode(codPersona);
            usuario.setPersona(persona);
            if (UsuarioQueries.insertarUsuario(usuario) != null) {
                success = true;
            }
        } catch (Exception e) {
            System.err.println("No se inserto el usuario.");
            System.err.println("No se inserto el usuario.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static Usuario retrieveUsuarioByCode(Integer codigo) throws Exception {
        Usuario patient = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            patient = UsuarioQueries.retrieveUsuariobyCode(codigo);
        } catch (Exception e) {
            System.err.println("No se puede traer el usuario con el codigo " + codigo);
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return patient;
    }

    public static Usuario retrieveUsuarioByNombreUsuario(String nombre) throws Exception {
        Usuario patient = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            patient = UsuarioQueries.retrieveUsuarioByNombre(nombre);
        } catch (Exception e) {
            System.err.println("No se puede traer el usuario con el nombre " + nombre);
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return patient;
    }

    public static Boolean updateUsuario(Usuario usuario) throws Exception {
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        Boolean success = false;
        try {
            UsuarioQueries.actualizarServicio(usuario);
            success = true;
        } catch (Exception ex) {
            System.err.println("Error al actualizar usuario.");
            delegateException = ex;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static List<Usuario> retrieveTodosUsuarios() throws Exception {
        List<Usuario> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = UsuarioQueries.retrieveListUsuarios();
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Boolean deleteUsuario(Usuario usuario) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            UsuarioQueries.eliminarUsuario(usuario);
            success = true;
        } catch (Exception e) {
            System.err.println("No se elimino el usuario.");
            delegateException = e;
        } finally {
            try {
                hss.closeConnection();
                if (delegateException != null) {
                    throw delegateException;
                }
            } catch (Exception e) {
                success = false;
            }
        }
        return success;
    }

    public static Usuario autentificacionUsuario(String nombreUsuario, String clave) throws Exception {
        Usuario usuario = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            usuario = UsuarioQueries.autentificacionUsuario(nombreUsuario, clave);
        } catch (Exception e) {
            System.err.println("No se puede validar el usuario ");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return usuario;
    }

    public static List<Persona> retrieveTodosPersonal() throws Exception {
        List<Persona> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = PersonalQueries.retrieveListaPersonas();
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Boolean insertarPersona(Persona persona) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            if (PersonalQueries.insertarPersona(persona) != null) {
                success = true;
            }
        } catch (Exception e) {
            System.err.println("No se inserto el usuario.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static Persona retrievePersonaByIdentificacion(String identificacion) throws Exception {
        Persona patient = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            patient = PersonalQueries.retrievePersonaByIdentificacion(identificacion);
        } catch (Exception e) {
            System.err.println("No se puede traer la persona con el nombre " + identificacion);
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return patient;
    }

    public static Boolean insertarPerfil(Perfil perfil) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            if (PerfilQueries.insertarPerfil(perfil) != null) {
                success = true;
            }
        } catch (Exception e) {
            System.err.println("No se inserto el perfil.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static List<Perfil> retrieveTodosPerfil() throws Exception {
        List<Perfil> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = PerfilQueries.retrieveListaPerfiles();
        } catch (Exception e) {
            System.err.println("No se puede traer los perfiles.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static List<Opcion> retrieveTodasOpciones() throws Exception {
        List<Opcion> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveListaOpciones();
        } catch (Exception e) {
            System.err.println("No se puede traer los perfiles.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Boolean insertarOpcion(Opcion perfil) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            if (OpcionQueries.insertarOpcion(perfil) != null) {
                success = true;
            }
        } catch (Exception e) {
            System.err.println("No se inserto el perfil.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static List<Sistema> retrieveTodosSistemasActivos() throws Exception {
        List<Sistema> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = SistemaQueries.retrieveListSistemasActivos();
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static List<Sistema> retrieveTodosSistemas() throws Exception {
        List<Sistema> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = SistemaQueries.retrieveListSistemas();
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Boolean insertarSistemas(Sistema sistema) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            if (SistemaQueries.insertarSistema(sistema) != null) {
                success = true;
            }
        } catch (Exception e) {
            System.err.println("No se inserto el Sistema.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static List<Usuario> retrieveTodosUsuariosByPerfil(Integer codigo_perfil) throws Exception {
        List<Usuario> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = UsuarioQueries.retrieveListUsuariosByPerfil(codigo_perfil);
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static List<Usuario> retrieveListUsuariosNoAsignados() throws Exception {
        List<Usuario> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = UsuarioQueries.retrieveListUsuariosNoAsignados();
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static UsuarioXPerfil retrieveUsuarioXPerfilBy_CodUsuario_codPerfil(Integer codUser, Integer codPerfil) throws Exception {
        UsuarioXPerfil lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = UsuariosPerfilQueries.retrieveUsuarioXPerfilBy_CodUsuario_codPerfil(codUser, codPerfil);
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Boolean eliminarUsuarioXPerfilBy_CodUsuario_codPerfil(Integer codUser, Integer codPerfil) throws Exception {
        UsuarioXPerfil userXPerfil = null;
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            userXPerfil = UsuariosPerfilQueries.retrieveUsuarioXPerfilBy_CodUsuario_codPerfil(codUser, codPerfil);
            if (userXPerfil != null) {
                UsuariosPerfilQueries.eliminarUsuarioXPerfil(userXPerfil);
                success = true;
            }
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static Boolean insertarUsuariosXPerfil(Integer codPerfil, List<Usuario> listaUsuario) throws Exception {
        Boolean success = false;
        Usuario user = null;
        UsuarioXPerfil userXperfil = new UsuarioXPerfil();
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            Perfil perfil = PerfilQueries.retrievePerfilByCodigo(codPerfil);
            for (int i = 0; i < listaUsuario.size(); i++) {
                user = UsuarioQueries.retrieveUsuariobyCode(listaUsuario.get(i).getCodigo());
                userXperfil.setPerfil(perfil);
                userXperfil.setUsuario(user);
                userXperfil.setFechaAsignacion(new Date());
                userXperfil.setMotivo("Valor ingresado manualmente.");
                UsuariosPerfilQueries.insertarUsuariosXPerfil(userXperfil);
            }
            success = true;
        } catch (Exception e) {
            System.err.println("No se inserto el perfil.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static Boolean eliminarUsuariosXPerfil(Integer codPerfil, List<Usuario> listaUsuario) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            for (int i = 0; i < listaUsuario.size(); i++) {
                UsuarioXPerfil userElim = UsuariosPerfilQueries.retrieveUsuarioXPerfilBy_CodUsuario_codPerfil(listaUsuario.get(i).getCodigo(), codPerfil);
                UsuariosPerfilQueries.eliminarUsuarioXPerfil(userElim);
            }
            success = true;
        } catch (Exception e) {
            System.err.println("No se inserto el perfil.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static List<Opcion> retrieveOpcionesByCodigoSistema(Integer cod) throws Exception {
        List<Opcion> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveListaOpciones();
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por sistema.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static List<OpcionDePerfil> retrieveListaOpcionesDePerfil() throws Exception {
        List<OpcionDePerfil> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionesPerfilQueries.retrieveListaOpcionesDePerfil();
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static UsuarioXPerfil retrieveUsuarioXPerfilBy_CodUsuario(Integer codUser) throws Exception {
        UsuarioXPerfil lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = UsuariosPerfilQueries.retrieveUsuarioXPerfilBy_CodUsuario(codUser);
        } catch (Exception e) {
            System.err.println("No se puede traer los servicios.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }
}
