/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsMensaje;
import Clases.ClsPropuesta;
import Modelos.MdlPropuesta;
import java.util.LinkedList;

/**
 *
 * @author larrc0
 */
public class CtlPropuesta {
    MdlPropuesta modeloPropuesta;

    public CtlPropuesta() {
        this.modeloPropuesta = new MdlPropuesta();
    }
    
    
    public LinkedList<ClsPropuesta> obtenerPropuestas(String id){
        LinkedList<ClsPropuesta> listaPropuestas = this.modeloPropuesta.obtenerPropuestas(id);
        return listaPropuestas;
    }
    
    public ClsMensaje agregarPropuesta(ClsPropuesta propuesta){
        // se agregab logicas de negocio
        //if votante.getEdad() > 30 
        
        ClsMensaje mensaje = this.modeloPropuesta.agregarPropuesta(propuesta);
        return mensaje;
    }    
    
    public ClsMensaje actualizarPropuesta(ClsPropuesta propuesta){
        ClsMensaje mensaje = this.modeloPropuesta.actualizarPropuesta(propuesta);
        return mensaje;
    }    

    
    public ClsMensaje eliminarPropuesta(String idpropuesta,String idcandidato){
        ClsMensaje mensaje = this.modeloPropuesta.eliminarPropuesta(idpropuesta,idcandidato);
        return mensaje;
    }    

    public ClsPropuesta recuperarPropuesta(String idpropuesta,String idcandidato){
        ClsPropuesta propuesta = this.modeloPropuesta.recuperarPropuesta(idpropuesta,idcandidato);
        return propuesta;
    }        
    
    
}
