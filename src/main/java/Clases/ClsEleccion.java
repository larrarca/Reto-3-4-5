/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author larrc0
 */
public class ClsEleccion {
    private String ideleccion;
    private String descripcion;
    private String categoria;
    private String fechainicio;
    private String fechafinal;
    private String estado;
    

    public ClsEleccion(String ideleccion, String descripcion, String categoria,String fechainicio, String fechafinal, String estado) {
        this.ideleccion = ideleccion;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdeleccion() {
        return ideleccion;
    }

    public void setIdeleccion(String ideleccion) {
        this.ideleccion = ideleccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }
    
    
    
}
