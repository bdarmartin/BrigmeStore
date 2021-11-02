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
public class Videojuego {
    protected int id;
    protected String slug;
    protected String nombre;
    protected String descripcion;
    protected int cantidad_total;
    protected int existencias;
    protected float precio_prestamo;
    
    
    /**
     * 
     * @param id
     * @param slug
     * @param nombre
     * @param descripcion
     * @param cantidad
     * @param existencias
     * @param precio 
     */
    Videojuego(int id, String slug, String nombre, String descripcion, int cantidad, int existencias, float precio) {
        this.id = id;
        this.slug = slug;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad_total = cantidad;
        this.existencias = existencias;
        this.precio_prestamo = precio;
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
     * @param slug 
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    /**
     * 
     * @return slug
     */
    public String getSlug() {
        return slug;
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
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * @return cantidad_total
     */
    public int getCantidadTotal() {
        return cantidad_total;
    }
    
    /**
     * @param cantidad
     */
    public void setCantidadTotal(int cantidad) {
        this.cantidad_total = cantidad;
    }
    
    /**
     * @return existencias
     */
    public int getExistencias() {
        return existencias;
    }
    
    /**
     * @param existencias 
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
    /**
     * @param precio 
     */
    public void setPrecioPrestamo(float precio) {
        this.precio_prestamo = precio;
    }
    
    /**
     * @return precio_prestamo 
     */
    public float getPrecioPrestamo() {
        return precio_prestamo;
    }
}
