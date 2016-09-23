/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.model;

/**
 *
 * @author Irbing Martinez Garcia
 */
public class Credito {
    private int idCredito;
    private String tipo;
    private String fechaExpedicion;
    private String nombre;

    public Credito() {
        this(0,"","","");
    }

    public Credito(int idCredito, String tipo, String fechaExpedicion, String nombre) {
        this.idCredito = idCredito;
        this.tipo = tipo;
        this.fechaExpedicion = fechaExpedicion;
        this.nombre = nombre;
    }

    public int getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(int idCredito) {
        this.idCredito = idCredito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Credito{" + "idCredito=" + idCredito + ", tipo=" + tipo + ", fechaExpedicion=" + fechaExpedicion + ", nombre=" + nombre + '}';
    }
    
    
}
