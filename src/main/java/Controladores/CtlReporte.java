/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsPropuesta;
import Clases.ClsReporte;
import Modelos.MdlPropuesta;
import Modelos.MdlReporte;
import java.util.LinkedList;

/**
 *
 * @author larrc0
 */
public class CtlReporte {
    MdlReporte modeloReporte;

    public CtlReporte() {
        this.modeloReporte = new MdlReporte();
    }    
    
    public LinkedList<ClsReporte> obtenerReporte(){
        LinkedList<ClsReporte> listaPropuestas = this.modeloReporte.obtenerReporte();
        return listaPropuestas;
    }
    
}
