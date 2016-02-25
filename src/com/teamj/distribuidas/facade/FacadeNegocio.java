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
import com.teamj.distribuidas.model.database.Rol;
import com.teamj.distribuidas.model.database.Sistema;
import com.teamj.distribuidas.model.database.Usuario;
import com.teamj.distribuidas.model.database.UsuarioXPerfil;
import com.teamj.distribuidas.model.queries.OpcionQueries;
import com.teamj.distribuidas.model.queries.OpcionesPerfilQueries;
import com.teamj.distribuidas.model.queries.PerfilQueries;
import com.teamj.distribuidas.model.queries.PersonalQueries;
import com.teamj.distribuidas.model.queries.RolQueries;
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
            UsuarioQueries.actualizarUsuario(usuario);
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

    public static Boolean insertarOpcion(Opcion opcion) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            if (OpcionQueries.insertarOpcion(opcion) != null) {
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
            lista = OpcionQueries.retrieveOpcionesByCodigoSistema(cod);
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

    public static List<OpcionDePerfil> retrieveListaSoloOpcionesDePerfil() throws Exception {
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

    public static List<Opcion> retrieveOpcionByNivel(String nivel) throws Exception {
        List<Opcion> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveOpcionesByNivel(nivel);
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por nivel.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Sistema retrieveSistemaById(Integer codigo) throws Exception {
        Sistema lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = SistemaQueries.retrieveSistemaById(codigo);
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

    public static Opcion retrieveOpcionByCodigo(Integer cod) throws Exception {
        Opcion lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveOpcionByCodigo(cod);
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

    public static List<Opcion> retrieveOpcionByNivelAndCodigoPadre(String nivel, Integer codPadre) throws Exception {
        List<Opcion> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveOpcionByNivelAndCodigoPadre(nivel, codPadre);
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por nivel y codigopadre.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static List<OpcionDePerfil> retrieveListaOpcionesDePerfilJoin() throws Exception {
        List<OpcionDePerfil> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionesPerfilQueries.retrieveListaOpcionesDePerfilJoin();
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

    public static List<Opcion> retrieveListaOpcionesPadres() throws Exception {
        List<Opcion> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveListaOpcionesPadres();
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

    public static List<Opcion> retrieveOpcionesByPerfil(Integer nivel) throws Exception {
        List<Opcion> lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = OpcionQueries.retrieveOpcionesByPerfil(nivel);
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por nivel.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Rol retrieveRolesByCodigoOpcion(Integer nivel) throws Exception {
        Rol lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = RolQueries.retrieveRolesByCodigoOpcion(nivel);
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por nivel.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Rol retrieveRolesByCodigoOpcionAndCodigoPerfil(Integer codigoOpcion, Integer codPerfil) throws Exception {
        Rol lista = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            lista = RolQueries.retrieveRolesByCodigoOpcionAndCodigoPerfil(codigoOpcion, codPerfil);
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por nivel.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return lista;
    }

    public static Boolean updateRoles(Rol rol) throws Exception {
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            RolQueries.updateRoles(rol);
            success = true;
        } catch (Exception e) {
            System.err.println("No se puede traer las opciones por nivel.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }

    public static OpcionDePerfil insertarOpcionesXPerfil(Integer codPerfil, Integer codOpcion) throws Exception {
        OpcionDePerfil odp = null;
        OpcionDePerfil opcionXperfil = new OpcionDePerfil();
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            opcionXperfil.setFechaAsignacion(new Date());
            opcionXperfil.setEstado(Boolean.TRUE);
            opcionXperfil.setOpcion(OpcionQueries.retrieveOpcionByCodigo(codOpcion));
            opcionXperfil.setPerfil(PerfilQueries.retrievePerfilByCodigo(codPerfil));
            odp = OpcionesPerfilQueries.insertarOpcionesXPerfil(opcionXperfil);
        } catch (Exception e) {
            System.err.println("No se inserto el OpcionDePerfil.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return odp;
    }

    public static Rol insertarRol(Rol rol) throws Exception {
        Rol r = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            r = RolQueries.insertarRolesOpcionPerfil(rol);
        } catch (Exception e) {
            System.err.println("No se inserto el rol.");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return r;
    }

    public static OpcionDePerfil retrieveOpcionesXPerfilByCodPerfilAndCodOpcion(Integer codigoPerfil, Integer codigoOpcion) throws Exception {
        OpcionDePerfil r = null;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            r = OpcionesPerfilQueries.retrieveOpcionesXPerfilByCodPerfilAndCodOpcion(codigoPerfil, codigoOpcion);
        } catch (Exception e) {
            System.err.println("No se puede traer la opcion de perfilF");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return r;
    }

    public static Boolean updateOpcionesXPerfilByCodPerfilAndCodOpcion(Integer codigoPerfil, Integer codigoOpcion, Boolean valor) throws Exception {
        OpcionDePerfil r = null;
        Boolean success = false;
        HibernateSessionHandlerSeguridades hss = new HibernateSessionHandlerSeguridades();
        Exception delegateException = null;
        try {
            r = OpcionesPerfilQueries.retrieveOpcionesXPerfilByCodPerfilAndCodOpcion(codigoPerfil, codigoOpcion);
            r.setEstado(valor);
            OpcionesPerfilQueries.actualizarOpcionesPorPerfil(r);
            success=true;
        } catch (Exception e) {
            System.err.println("No se puede traer la opcion de perfilF");
            delegateException = e;
        } finally {
            hss.closeConnection();
            if (delegateException != null) {
                throw delegateException;
            }
        }
        return success;
    }
}
