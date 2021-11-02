/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brimestore;

/**
 *
 * @author BrinSirias
 */
public class Cliente {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String telefono;
    protected String nit;
    protected String contrasena;
    
    
    /**
     * 
     * @param id
     * @param nombre
     * @param correo
     * @param telefono
     * @param nit
     * @param contrasena 
     */
    public Cliente(int id, String nombre, String correo, String telefono, String nit, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.nit = nit;
        this.contrasena = contrasena;
    }

    /**
     * 
     * @param nombre
     * @param correo
     * @param telefono
     * @param nit
     * @param contrasena 
     */
    public Cliente(String nombre, String correo, String telefono, String nit, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.nit = nit;
        this.contrasena = contrasena;
    }
    
    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return id 
     */
    public int getId() {
        return id;
    }
    
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @return correo 
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * @return telefono 
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * @param tel 
     */
    public void setTelefono(String tel) {
        this.telefono = tel;
    }
    
    /**
     * @return nit 
     */
    public String getNit() {
        return nit;
    }
    
    /**
     * @param nit 
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
    
    /**
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    /**
     * @return contrasena 
     */
    public String getContrasena() {
        return contrasena;
    }
}
