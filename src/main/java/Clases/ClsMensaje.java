/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author larrc0
 */
public class ClsMensaje {
    public final static String OK ="OK";
    public final static String ERROR ="ERROR";
    public final static String ADVERTENCIA ="ADVERTENCIA";
    public final static String CANCEL ="CANCEL";
    
    private String tipo;
    private String texto;

    public ClsMensaje(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
}
