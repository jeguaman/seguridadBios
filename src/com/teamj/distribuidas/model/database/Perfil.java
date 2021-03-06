package com.teamj.distribuidas.model.database;
// Generated Feb 15, 2016 11:39:15 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private Integer codigoPerfil;
     private String nombrePerfil;
     private String descripcion;
     private Set usuarioXPerfils = new HashSet(0);
     private Set opcionDePerfils = new HashSet(0);

    public Perfil() {
    }

	
    public Perfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    public Perfil(String nombrePerfil, String descripcion, Set usuarioXPerfils, Set opcionDePerfils) {
       this.nombrePerfil = nombrePerfil;
       this.descripcion = descripcion;
       this.usuarioXPerfils = usuarioXPerfils;
       this.opcionDePerfils = opcionDePerfils;
    }
   
    public Integer getCodigoPerfil() {
        return this.codigoPerfil;
    }
    
    public void setCodigoPerfil(Integer codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
    public String getNombrePerfil() {
        return this.nombrePerfil;
    }
    
    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getUsuarioXPerfils() {
        return this.usuarioXPerfils;
    }
    
    public void setUsuarioXPerfils(Set usuarioXPerfils) {
        this.usuarioXPerfils = usuarioXPerfils;
    }
    public Set getOpcionDePerfils() {
        return this.opcionDePerfils;
    }
    
    public void setOpcionDePerfils(Set opcionDePerfils) {
        this.opcionDePerfils = opcionDePerfils;
    }




}


