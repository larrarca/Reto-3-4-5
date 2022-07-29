/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author larrc0
 */
public class MdlCandidato {
    ClsJdbc jdbc;

    public MdlCandidato() {
        //this.modeloVotante = new MdlVotante();
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();        
    }
    

    public ClsCandidato recuperarCandidato(String id){
        try {
            ClsCandidato candidato = null;
            
            String consulta = "SELECT * From tblcandidatos WHERE id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, id);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                String partido = resultados.getString("partido_politico");
                String ciudad = resultados.getString("ciudad_origen");
                String descripcion = resultados.getString("descripcion");
                String campania = resultados.getString("mensaje_campania");
                String tipodoc = resultados.getString("tipo_documento");
                String cedula = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("email");
                String cargo = resultados.getString("cargo");
                
                candidato = new ClsCandidato(partido,ciudad,descripcion,campania,cargo,tipodoc,cedula,nombre,telefono,correo);
            }
            return candidato;
            
        }catch (Exception e){
            return null;
        }
    }    

    
    public ClsMensaje eliminarCandidato(String id){
        ClsMensaje mensaje;
        
        try {
            String consulta = "DELETE FROM tblcandidatos WHERE id_candidato = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, id);
            
            int respuesta =JOptionPane.showConfirmDialog(null, "Se eliminará el candidato, ¿desea continuar?", "Eliminando Candidatos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == YES_OPTION){
                int resultado = sentencia.executeUpdate();
                if (resultado >= 1){
                    mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha eliminado el candidato con exito!!");
                }else{
                    mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error!!"); 
                }
            }else{
                mensaje = new ClsMensaje(ClsMensaje.CANCEL,"Se cancelo el proceso!!"); 
            }            
            return mensaje;

            //this.jdbc.conexion.close();
        }catch (Exception e){
           mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error: " + e.getMessage()); 
           return mensaje;
        }
    }    
    
    public ClsMensaje actualizarCandidato(ClsCandidato candidato){
        ClsMensaje mensaje;
        
        try {
            String consulta = "UPDATE tblcandidatos SET tipo_documento=?,nombre=?,telefono=?,email=?,partido_politico=?,ciudad_origen=?,descripcion=?,mensaje_campania=?,cargo=? " +
                                "WHERE id_candidato = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, candidato.getTipoDocumento());
            sentencia.setString (2, candidato.getNombre());
            sentencia.setString (3, candidato.getTelefono());
            sentencia.setString (4, candidato.getEmail());
            sentencia.setString (5, candidato.getPartidopolitico());
            sentencia.setString (6, candidato.getCiudadorigen());
            sentencia.setString (7, candidato.getDescripcion());
            sentencia.setString (8, candidato.getMensajecampania());
            sentencia.setString (9, candidato.getCargo());
            sentencia.setString (10, candidato.getNumeroDocumento());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha actualizado el candidato con exito!!");
            }else{
                mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error!!"); 
            }
            return mensaje;

            //this.jdbc.conexion.close();
        }catch (Exception e){
           mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error: " + e.getMessage()); 
           return mensaje;
        }
    }
    
    public ClsMensaje agregarCandidato(ClsCandidato candidato){
        ClsMensaje mensaje;
        
        try {
            String consulta = "INSERT INTO tblcandidatos(id_candidato,tipo_documento,nombre,telefono,email,partido_politico,ciudad_origen,descripcion,mensaje_campania,cargo) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, candidato.getNumeroDocumento());
            sentencia.setString (2, candidato.getTipoDocumento());
            sentencia.setString (3, candidato.getNombre());
            sentencia.setString (4, candidato.getTelefono());
            sentencia.setString (5, candidato.getEmail());
            sentencia.setString (6, candidato.getPartidopolitico());
            sentencia.setString (7, candidato.getCiudadorigen());
            sentencia.setString (8, candidato.getDescripcion());
            sentencia.setString (9, candidato.getMensajecampania());
            sentencia.setString (10, candidato.getCargo());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha creado el candidato con exito!!");
            }else{
                mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error!!"); 
            }
            return mensaje;

            //this.jdbc.conexion.close();
        }catch (Exception e){
           mensaje = new ClsMensaje(ClsMensaje.ERROR,"Se generó un error: " + e.getMessage()); 
           return mensaje;
        }
    }
    
    public LinkedList<ClsCandidato> obtenerCandidatos(){
        try {
            
            LinkedList<ClsCandidato> lista = new LinkedList<>();
            
            String consulta = "Select * From tblcandidatos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                
                String partido = resultados.getString("partido_politico");
                String ciudad = resultados.getString("ciudad_origen");
                String descripcion = resultados.getString("descripcion");
                String campania = resultados.getString("mensaje_campania");
                String tipodoc = resultados.getString("tipo_documento");
                String cedula = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("email");
                String cargo = resultados.getString("cargo");
                
                ClsCandidato candidato = new ClsCandidato(partido,ciudad,descripcion,campania,cargo,tipodoc,cedula,nombre,telefono,correo);
                lista.add(candidato);
            }
            return lista;
            
        }catch (Exception e){
            return null;
        }
    }
    
}
