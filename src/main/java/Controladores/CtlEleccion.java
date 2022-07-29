/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsMensaje;
import Modelos.MdlCandidato;
import Modelos.MdlEleccion;
import java.util.LinkedList;

/**
 *
 * @author larrc0
 */
public class CtlEleccion {
    MdlEleccion modeloEleccion;

    public CtlEleccion() {
        this.modeloEleccion = new MdlEleccion();
    }
    

    public String obtenerFilas(){
        String filas = this.modeloEleccion.obtenerFilas();
        return filas;
    }
    
    public LinkedList<ClsEleccion> ObtenerElecciones(){
        LinkedList<ClsEleccion> listaElecciones = this.modeloEleccion.obtenerElecciones();
        return listaElecciones;
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatosEleccion(String IdEleccion){
        LinkedList<ClsCandidato> listaCandidatos = this.modeloEleccion.ObtenerCandidatosEleccion(IdEleccion);
        return listaCandidatos;
    }
            

    public ClsMensaje borraAsociarCandidato(String idCandidato,String idEleccion){
        ClsMensaje mensaje = this.modeloEleccion.borraAsociarCandidato(idCandidato,idEleccion);
        return mensaje;
    }        
       

    public ClsMensaje registrarVoto(String idCandidato,String idEleccion,String idVotante){
        ClsMensaje mensaje = this.modeloEleccion.registrarVoto(idCandidato,idEleccion,idVotante);
        return mensaje;
    }        
            
    public ClsMensaje asociarCandidato(String idCandidato,String idEleccion){
        ClsMensaje mensaje = this.modeloEleccion.asociarCandidato(idCandidato,idEleccion);
        return mensaje;
    }        
            
    public ClsMensaje eliminarEleccion(String id){
        ClsMensaje mensaje = this.modeloEleccion.eliminarEleccion(id);
        return mensaje;
    }        
    
    public ClsMensaje agregarEleccion(ClsEleccion eleccion){
        ClsMensaje mensaje = this.modeloEleccion.agregarEleccion(eleccion);
        return mensaje;
    } 
    
    public ClsMensaje actualizarEleccion(ClsEleccion eleccion){
        ClsMensaje mensaje = this.modeloEleccion.actualizarEleccion(eleccion);
        return mensaje;
    }      
    
    public ClsEleccion recuperarEleccion(String id) {
        ClsEleccion eleccion = this.modeloEleccion.recuperarEleccion(id);
        return eleccion;
    }
    
}
