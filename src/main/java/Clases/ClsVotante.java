/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.logging.Logger;

/**
 *
 * @author larrc0
 */
public class ClsVotante extends ClsPersona{
    private String direccion;
    private String contrasena;

    public ClsVotante(String direccion, String contrasena, String tipoDocumento, String numeroDocumento, String nombre, String telefono, String email) {
        super(tipoDocumento, numeroDocumento, nombre, telefono, email);
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
