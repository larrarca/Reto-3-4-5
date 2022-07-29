/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author larrc0
 */
public class ClsJdbc {
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String pwd ="";
    String bd ="bd_elecciones_g8";
    String url = "jdbc:mysql://localhost:3306/" + this.bd;

 
    public Connection conexion;
    
    
    public void CrearConexion(){
        try{
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url,user,pwd);
            if(this.conexion != null){
                System.out.println("Conexión exitosa !!!");
            }
        }catch(Exception error){
            System.out.println("Ocurrió un error al conectar: " + error.getMessage());
        }
    }
}
