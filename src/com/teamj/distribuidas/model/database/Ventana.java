package com.teamj.distribuidas.model.database;
// Generated Feb 15, 2016 11:39:15 PM by Hibernate Tools 3.6.0



/**
 * Ventana generated by hbm2java
 */
public class Ventana  implements java.io.Serializable {


     private Integer codigo;
     private Opcion opcion;
     private String nombre;
     private String descripcion;

    public Ventana() {
    }

	
    public Ventana(Opcion opcion) {
        this.opcion = opcion;
    }
    public Ventana(Opcion opcion, String nombre, String descripcion) {
       this.opcion = opcion;
       this.nombre = nombre;
       this.descripcion = descripcion;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Opcion getOpcion() {
        return this.opcion;
    }
    
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


