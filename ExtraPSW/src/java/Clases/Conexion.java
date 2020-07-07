/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class Conexion {
    
    public static Connection getConexion() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost/ortopena";
            String userName = "root";
            String password = "Rexygreen";
            
            return DriverManager.getConnection(URL, userName, password);
        }catch(SQLException ex){
            System.out.println("Error en la BD");
            ex.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se conecto bien");
        }
        return null;
    }
    
}
