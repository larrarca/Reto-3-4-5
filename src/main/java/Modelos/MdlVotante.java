/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsPropuesta;
import Clases.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author larrc0
 */
public class MdlVotante {
    MdlVotante modeloVotante;
    ClsJdbc jdbc;

    public MdlVotante() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }
    
    
    public ClsMensaje agregarVotante(ClsVotante votante){
        ClsMensaje mensaje;
        try {
            String consulta = "INSERT INTO tblvotantes(id_votante,tipo_documento,nombre,telefono,email,direccion,contrasena) "
                + "VALUES (?,?,?,?,?,?,?)";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, votante.getNumeroDocumento());
            sentencia.setString (2, votante.getTipoDocumento());
            sentencia.setString (3, votante.getNombre());
            sentencia.setString (4, votante.getTelefono());
            sentencia.setString (5, votante.getEmail());
            sentencia.setString (6, votante.getDireccion());
            sentencia.setString (7, votante.getContrasena());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha creado el votante con exito!!");
            }else{
                mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error!!"); 
            }
            return mensaje;
            
            
        }catch (Exception e){
           mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error: " + e.getMessage()); 
           return mensaje;
        }
    }
    
    
    public ClsVotante recuperarVotante(String id){
        try {
            ClsVotante votante = null;
            
            String consulta = "SELECT * FROM tblvotantes WHERE id_votante = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, id);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                String direccion = resultados.getString("direccion");
                String contrasena = resultados.getString("contrasena");
                String tipodoc = resultados.getString("tipo_documento");
                String cedula = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("email");
                
                votante = new ClsVotante(direccion,contrasena,tipodoc,cedula,nombre,telefono,correo);
            }
            return votante;
            
        }catch (Exception e){
            return null;
        }
    }        
    
    public ClsMensaje eliminarVotante(String idVotante){
        ClsMensaje mensaje = null;    

        try {
            String consulta = "DELETE FROM tblvotantes WHERE id_votante = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idVotante);
            
            int respuesta =JOptionPane.showConfirmDialog(null, "Se eliminará el votante, ¿desea continuar?", "Eliminando Votantes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == YES_OPTION){
                int resultado = sentencia.executeUpdate();
                if (resultado >= 1){
                    mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha eliminado el votante con exito!!");
                }else{
                    mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error!!"); 
                }
            }else{
              mensaje = new ClsMensaje(ClsMensaje.CANCEL,"Se cancelo el proceso!!"); 
            }
            return mensaje;

            //this.jdbc.conexion.close();
        }catch (SQLException e){
           mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error: " + e.getMessage()); 
           return mensaje;
        }        
    }
    
    
    public ClsMensaje actualizarVotante(ClsVotante votante){
        ClsMensaje mensaje;
        
        try {
            String consulta = "UPDATE tblvotantes SET tipo_documento=?,nombre=?,telefono=?,email=?,direccion=?,contrasena=? " +
                                "WHERE id_votante = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, votante.getTipoDocumento());
            sentencia.setString (2, votante.getNombre());
            sentencia.setString (3, votante.getTelefono());
            sentencia.setString (4, votante.getEmail());
            sentencia.setString (5, votante.getDireccion());
            sentencia.setString (6, votante.getContrasena());
            sentencia.setString (7, votante.getNumeroDocumento());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha actualizado la propuesta con exito!!");
            }else{
                mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error!!"); 
            }
            return mensaje;

            //this.jdbc.conexion.close();
        }catch (SQLException e){
           mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error: " + e.getMessage()); 
           return mensaje;
        }
    }        
   
}
