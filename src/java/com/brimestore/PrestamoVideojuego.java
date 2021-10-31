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
public class PrestamoVideojuego {
    protected int id;
    protected Prestamo prestamo;
    protected Videojuego videojuego;
    // private Courses courses;
    
    
    /**
     * 
     * @param id
     * @param prestamo
     * @param videojuego 
     */
    PrestamoVideojuego(int id, Prestamo prestamo, Videojuego videojuego) {
        this.id = id;
        this.prestamo = prestamo;
        this.videojuego = videojuego;
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
     * @param prestamo 
     */
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    /**
     * 
     * @return prestamo
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }
    
    /**
     * 
     * @param videojuego
     */
    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }
    
    /**
     * 
     * @return videojuego
     */
    public Videojuego getVideojuego() {
        return videojuego;
    }
}
