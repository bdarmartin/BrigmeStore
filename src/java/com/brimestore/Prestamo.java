/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brimestore;

import java.util.Date;

/**
 *
 * @author BrinSirias
 */
public class Prestamo {
    protected int id;
    protected float total;
    protected Date prestado_el;
    protected Date devuelto_el;
    protected int extension;
    protected float multa;
    protected Cliente cliente;
    // private Courses courses;
    
    
    /**
     * 
     * @param id
     * @param total
     * @param prestado
     * @param entregado
     * @param extension
     * @param multa
     * @param cliente 
     */
    Prestamo(int id, float total, Date prestado, Date entregado, int extension, float multa, Cliente cliente) {
        this.id = id;
        this.total = total;
        this.prestado_el = prestado;
        this.devuelto_el = entregado;
        this.extension = extension;
        this.multa = multa;
        this.cliente = cliente;
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
     * @param total 
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
    /**
     * 
     * @return total
     */
    public float getTotal() {
        return total;
    }
    
    /**
     * 
     * @param prestado 
     */
    public void setPrestadoEl(Date prestado) {
        this.prestado_el = prestado;
    }
    
    /**
     * 
     * @return 
     */
    public Date getPrestadoEl() {
        return prestado_el;
    }
    
    /**
     * 
     * @return devuelto_el
     */
    public Date getDevueltoEl() {
        return devuelto_el;
    }
    
    /**
     * @param devuelto
     */
    public void setDevueltoEl(Date devuelto) {
        this.devuelto_el = devuelto;
    }
    
    /**
     * @return extension
     */
    public int getExtension() {
        return extension;
    }
    
    /**
     * @param extension
     */
    public void setExtension(int extension) {
        this.extension = extension;
    }
    
    /**
     * @return multa
     */
    public float getMulta() {
        return multa;
    }
    
    /**
     * @param multa 
     */
    public void setMulta(float multa) {
        this.multa = multa;
    }
    
    /**
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     * @return cliente 
     */
    public Cliente getCliente() {
        return cliente;
    }
}
