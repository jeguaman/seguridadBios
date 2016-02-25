package com.teamj.distribuidas.model.database;
// Generated Feb 15, 2016 11:39:15 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OpcionDePerfil generated by hbm2java
 */
public class OpcionDePerfil  implements java.io.Serializable {


     private Integer codigoOpcionPerfil;
     private Perfil perfil;
     private Opcion opcion;
     private Date fechaAsignacion;
     private Boolean estado;
     private Set rols = new HashSet(0);

    public OpcionDePerfil() {
    }

	
    public OpcionDePerfil(Perfil perfil, Opcion opcion) {
        this.perfil = perfil;
        this.opcion = opcion;
    }
    public OpcionDePerfil(Perfil perfil, Opcion opcion, Date fechaAsignacion, Boolean estado, Set rols) {
       this.perfil = perfil;
       this.opcion = opcion;
       this.fechaAsignacion = fechaAsignacion;
       this.estado = estado;
       this.rols = rols;
    }
   
    public Integer getCodigoOpcionPerfil() {
        return this.codigoOpcionPerfil;
    }
    
    public void setCodigoOpcionPerfil(Integer codigoOpcionPerfil) {
        this.codigoOpcionPerfil = codigoOpcionPerfil;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public Opcion getOpcion() {
        return this.opcion;
    }
    
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
    public Date getFechaAsignacion() {
        return this.fechaAsignacion;
    }
    
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getRols() {
        return this.rols;
    }
    
    public void setRols(Set rols) {
        this.rols = rols;
    }




}


