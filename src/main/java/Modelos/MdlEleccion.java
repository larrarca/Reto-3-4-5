/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author larrc0
 */
public class MdlEleccion {
    ClsJdbc jdbc;

    public MdlEleccion() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();        
    }
    
    public String obtenerFilas(){
        String fila = null;
        try {
            String consulta = "Select Count(*) filas From tblelecciones";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                fila = resultados.getString("filas");
            }
            return fila;
        }catch (Exception e){
            return null;
        }
    }
    
    public LinkedList<ClsEleccion> obtenerElecciones(){
        try {
            
            LinkedList<ClsEleccion> lista = new LinkedList<>();
            
            String consulta = "Select * From tblelecciones";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                
                String ideleccion = resultados.getString("id_eleccion");
                String descripcion = resultados.getString("descripcion");
                String categoria = resultados.getString("categoria");
                String fechaini = resultados.getString("fecha_inicio");
                String fechafin = resultados.getString("fecha_final");
                String estado = resultados.getString("estado");
                
                ClsEleccion eleccion = new ClsEleccion(ideleccion,descripcion,categoria,fechaini,fechafin,estado);
                lista.add(eleccion);
            }
            return lista;
            
        }catch (Exception e){
            return null;
        }
    } 
    
    public ClsMensaje eliminarEleccion(String id){
        ClsMensaje mensaje;
        
        try {
            String consulta = "DELETE FROM tblelecciones WHERE id_eleccion = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, id);
            
            int respuesta =JOptionPane.showConfirmDialog(null, "Se eliminará la elección, ¿desea continuar?", "Eliminando Elecciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == YES_OPTION){
                int resultado = sentencia.executeUpdate();
                if (resultado >= 1){
                    mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha eliminado la elección con exito!!");
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
    
    public ClsMensaje borraAsociarCandidato(String idCandidato, String idEleccion){
        ClsMensaje mensaje;
        
        try {
            String consulta = "DELETE FROM tbleleccioncandidatos WHERE id_candidato= ? AND id_eleccion = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idCandidato);
            sentencia.setString (2, idEleccion);
            
            int respuesta =JOptionPane.showConfirmDialog(null, "Se eliminará la asociación del candidato, ¿desea continuar?", "Eliminando Asociaciones de Candidatos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == YES_OPTION){
                int resultado = sentencia.executeUpdate();
                if (resultado >= 1){
                    mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha eliminado la asociación con exito!!");
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



    public ClsMensaje registrarVoto(String idCandidato, String idEleccion, String idVotante){
        ClsMensaje mensaje;
        
        try {
            String consulta = "INSERT INTO tblvotos(id_candidato,id_eleccion,id_votante,fechavoto) "
                + "VALUES (?,?,?,?)";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idCandidato);
            sentencia.setString (2, idEleccion);
            sentencia.setString (3, idVotante);
            
            try {
                Date today = java.sql.Date.valueOf(LocalDate.now());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                String fechavoto = dateFormat.format(today);                  
                sentencia.setString (4, fechavoto);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha registrado el voto con exito!!");
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

        
        
        
    public ClsMensaje asociarCandidato(String idCandidato, String idEleccion){
        ClsMensaje mensaje;
        
        try {
            String consulta = "INSERT INTO tbleleccioncandidatos(id_candidato,id_eleccion) "
                + "VALUES (?,?)";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idCandidato);
            sentencia.setString (2, idEleccion);
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha creado la asociación con exito!!");
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

    public ClsMensaje agregarEleccion(ClsEleccion eleccion){
        ClsMensaje mensaje;
        
        try {
            String consulta = "INSERT INTO tblelecciones(id_eleccion,descripcion,categoria,fecha_inicio,fecha_final,estado) "
                + "VALUES (?,?,?,?,?,?)";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, eleccion.getIdeleccion());
            sentencia.setString (2, eleccion.getDescripcion());
            sentencia.setString (3, eleccion.getCategoria());
            sentencia.setString (4, eleccion.getFechainicio());
            sentencia.setString (5, eleccion.getFechafinal());
            sentencia.setString (6, eleccion.getEstado());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha creado la elección con exito!!");
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
    
    
    public ClsMensaje actualizarEleccion(ClsEleccion eleccion){
        ClsMensaje mensaje;
        
        try {
            String consulta = "UPDATE tblelecciones SET descripcion=?,categoria=?,fecha_inicio=?,fecha_final=?,estado=? " +
                                "WHERE id_eleccion = ?";
        
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, eleccion.getDescripcion());
            sentencia.setString (2, eleccion.getCategoria());
            sentencia.setString (3, eleccion.getFechainicio());
            sentencia.setString (4, eleccion.getFechafinal());
            sentencia.setString (5, eleccion.getEstado());
            sentencia.setString (6, eleccion.getIdeleccion());
            
            int resultado = sentencia.executeUpdate();
            if (resultado >= 1){
                mensaje = new ClsMensaje(ClsMensaje.OK,"Se ha actualizado la elección con exito!!");
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
    
    
    public LinkedList<ClsCandidato> ObtenerCandidatosEleccion(String idEleccion){
        try {
            
            LinkedList<ClsCandidato> lista = new LinkedList<>();
            
            String consulta = "Select tc.* From tbleleccioncandidatos te, tblcandidatos tc WHERE te.id_eleccion = ? AND te.id_candidato=tc.id_candidato";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, idEleccion);
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
    
    public ClsEleccion recuperarEleccion(String id){
        try {
            ClsEleccion eleccion = null;
            
            String consulta = "SELECT * From tblelecciones WHERE id_eleccion = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString (1, id);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                String ideleccion = resultados.getString("id_eleccion");
                String descripcion = resultados.getString("descripcion");
                String categoria = resultados.getString("categoria");
                String fechaini = resultados.getString("fecha_inicio");
                String fechafin = resultados.getString("fecha_final");
                String estado = resultados.getString("estado");
                
                eleccion = new ClsEleccion(ideleccion,descripcion,categoria,fechaini,fechafin,estado);
            }
            return eleccion;
            
        }catch (Exception e){
            return null;
        }
    }        
    
    
}
