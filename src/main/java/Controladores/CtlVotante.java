/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import Clases.ClsMensaje;
import Clases.ClsPropuesta;
import Clases.ClsVotante;
import Modelos.MdlVotante;
import java.util.LinkedList;

/**
 *
 * @author larrc0
 */
public class CtlVotante {
    MdlVotante modeloVotante;

    public CtlVotante() {
        this.modeloVotante = new MdlVotante();
    }
    
    
    public ClsMensaje agregarVotante(ClsVotante votante){
        ClsMensaje mensaje = this.modeloVotante.agregarVotante(votante);
        return mensaje;
    }
    
    public ClsVotante recuperarVotante(String idvotante){
        ClsVotante votante = this.modeloVotante.recuperarVotante(idvotante);
        return votante;
    }    
    
    public ClsMensaje eliminarVotante(String idvotante){
        ClsMensaje mensaje = this.modeloVotante.eliminarVotante(idvotante);
        return mensaje;
    }    

    public ClsMensaje actualizarVotante(ClsVotante votante){
        ClsMensaje mensaje = this.modeloVotante.actualizarVotante(votante);
        return mensaje;
    }    
    
}
