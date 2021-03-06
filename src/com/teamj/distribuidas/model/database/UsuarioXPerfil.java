package com.teamj.distribuidas.model.database;
// Generated Feb 15, 2016 11:39:15 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * UsuarioXPerfil generated by hbm2java
 */
public class UsuarioXPerfil  implements java.io.Serializable {


     private Integer codigoUsuarioPerfil;
     private Usuario usuario;
     private Perfil perfil;
     private Date fechaAsignacion;
     private String motivo;

    public UsuarioXPerfil() {
    }

	
    public UsuarioXPerfil(Usuario usuario, Perfil perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
    }
    public UsuarioXPerfil(Usuario usuario, Perfil perfil, Date fechaAsignacion, String motivo) {
       this.usuario = usuario;
       this.perfil = perfil;
       this.fechaAsignacion = fechaAsignacion;
       this.motivo = motivo;
    }
   
    public Integer getCodigoUsuarioPerfil() {
        return this.codigoUsuarioPerfil;
    }
    
    public void setCodigoUsuarioPerfil(Integer codigoUsuarioPerfil) {
        this.codigoUsuarioPerfil = codigoUsuarioPerfil;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public Date getFechaAsignacion() {
        return this.fechaAsignacion;
    }
    
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }




}


