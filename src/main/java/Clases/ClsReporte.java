/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author larrc0
 */
public class ClsReporte {
    private String nombrecandidato;
    private String cargocandidato;
    private String partidopolitico;
    private String ideleccion;
    private String categoriaeleccion;
    private String votos;

    public ClsReporte(String nombrecandidato, String cargocandidato, String partidopolitico, String ideleccion, String categoriaeleccion, String votos) {
        this.nombrecandidato = nombrecandidato;
        this.cargocandidato = cargocandidato;
        this.partidopolitico = partidopolitico;
        this.ideleccion = ideleccion;
        this.categoriaeleccion = categoriaeleccion;
        this.votos = votos;
    }

    public String getCategoriaeleccion() {
        return categoriaeleccion;
    }

    public void setCategoriaeleccion(String categoriaeleccion) {
        this.categoriaeleccion = categoriaeleccion;
    }

    public String getNombrecandidato() {
        return nombrecandidato;
    }

    public void setNombrecandidato(String nombrecandidato) {
        this.nombrecandidato = nombrecandidato;
    }

    public String getCargocandidato() {
        return cargocandidato;
    }

    public void setCargocandidato(String cargocandidato) {
        this.cargocandidato = cargocandidato;
    }

    public String getPartidopolitico() {
        return partidopolitico;
    }

    public void setPartidopolitico(String partidopolitico) {
        this.partidopolitico = partidopolitico;
    }

    public String getIdeleccion() {
        return ideleccion;
    }

    public void setIdeleccion(String ideleccion) {
        this.ideleccion = ideleccion;
    }
   
    public String getVotos() {
        return votos;
    }

    public void setVotos(String votos) {
        this.votos = votos;
    }
    
}
