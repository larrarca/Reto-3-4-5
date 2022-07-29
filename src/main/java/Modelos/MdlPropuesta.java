/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsPropuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author larrc0
 */
public class MdlPropuesta {
    ClsJdbc jdbc;    

    public MdlPropuesta() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();        
    }
    
    public ClsMensaje agregarPropuesta(ClsPropuesta propuesta){
        ClsMensaje mensaje;
        
        try {
            String consulta = "INSERT INTO tblpropuestas(id_propuesta,sector,descripcion,id_candidato) "
                + "VALUES (?,?,?,?)";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, propuesta.getIdPropuesta());
            sentencia.setString (2, propuesta.getSector());
            sentencia.setString (3, propuesta.getDescripcion());
            sentencia.setString (4, propuesta.getIdCandidato());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha creado el candidato con exito!!");
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

    public ClsPropuesta recuperarPropuesta(String idPropuesta, String idCandidato){
        try {
            ClsPropuesta propuesta = null;
            
            String consulta = "SELECT * From tblpropuestas WHERE id_propuesta = ? AND id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idPropuesta);
            sentencia.setString (2, idCandidato);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                String sector = resultados.getString("sector");
                String descripcion = resultados.getString("descripcion");
                String idpropuesta = resultados.getString("id_propuesta");
                String idcandidato = resultados.getString("id_candidato");
                
                propuesta = new ClsPropuesta(idpropuesta,sector,descripcion,idcandidato);
               
            }
            return propuesta;
            
        }catch (SQLException e){
            return null;
        }
    }        
   
    public ClsMensaje eliminarPropuesta(String idPropuesta, String idCandidato){
        ClsMensaje mensaje = null;
        
        try {
            String consulta = "DELETE FROM tblpropuestas WHERE id_propuesta = ? AND id_candidato = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idPropuesta);
            sentencia.setString (2, idCandidato);
            
            int respuesta =JOptionPane.showConfirmDialog(null, "Se eliminará la propuesta, ¿desea continuar?", "Eliminando Propuestas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == YES_OPTION){
                int resultado = sentencia.executeUpdate();
                if (resultado >= 1){
                    mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha eliminado la propuesta con exito!!");
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
    
    public ClsMensaje actualizarPropuesta(ClsPropuesta propuesta){
        ClsMensaje mensaje;
        
        try {
            String consulta = "UPDATE tblpropuestas SET sector=?,descripcion=? " +
                                "WHERE id_propuesta = ? AND id_candidato=?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, propuesta.getSector());
            sentencia.setString (2, propuesta.getDescripcion());
            sentencia.setString (3, propuesta.getIdPropuesta());
            sentencia.setString (4, propuesta.getIdCandidato());
            
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
    
    
    public LinkedList<ClsPropuesta> obtenerPropuestas(String id){
        try {
            
            LinkedList<ClsPropuesta> lista = new LinkedList<>();

            String consulta = "SELECT * FROM tblpropuestas WHERE id_candidato=?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, id);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                String idpropuesta = resultados.getString("id_propuesta");
                String sector = resultados.getString("sector");
                String descripcion = resultados.getString("descripcion");
                String idcandidato = resultados.getString("id_candidato");

                ClsPropuesta propuesta = new ClsPropuesta(idpropuesta,sector,descripcion,idcandidato);
                lista.add(propuesta);
            }
            return lista;
            
        }catch (SQLException e){
            return null;
        }
    }    
    
}
