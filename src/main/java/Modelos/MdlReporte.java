/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsJdbc;
import Clases.ClsReporte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author larrc0
 */
public class MdlReporte {
    MdlReporte modeloReporte;
    ClsJdbc jdbc;

    public MdlReporte() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }    
    
    public LinkedList<ClsReporte> obtenerReporte(){
        try {
            
            LinkedList<ClsReporte> lista = new LinkedList<>();
            
            String consulta = "select count(id_votante) as votos,tblcandidatos.nombre,tblcandidatos.cargo,tblcandidatos.partido_politico,tblelecciones.id_eleccion,tblelecciones.categoria " +
                    "from tblVotos join tblcandidatos on tblcandidatos.id_candidato = tblVotos.id_candidato join tblelecciones on tblelecciones.id_eleccion = tblVotos.id_eleccion " +
                    "group by tblVotos.id_candidato,tblelecciones.id_eleccion";
            
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();
            while(resultados.next()){
                String votos = resultados.getString("votos");
                String nombre = resultados.getString("nombre");
                String cargo = resultados.getString("cargo");
                String partido = resultados.getString("partido_politico");
                String eleccion = resultados.getString("id_eleccion");
                String categoria = resultados.getString("categoria");
                
                ClsReporte reporte = new ClsReporte(nombre,cargo,partido,eleccion,categoria,votos);
                lista.add(reporte);
            }
            return lista;
            
        }catch (SQLException e){
            return null;
        }
    }      

    
}
