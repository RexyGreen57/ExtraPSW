/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Christian
 */
public class Usuario {
    
    private int id_usu;
    private String nom_usu;
    private String dir_usu;
    private int tel_usu;
    private String email_usu;
    private String password_usu;
    private int priv_usu;

    public Usuario(){
        
    }
    
    //La primera operacion es la verificacion del tipo de usuario
    
    public Usuario verificarUsuario(String email, String password) throws SQLException, ClassNotFoundException{
        //objeto de usuario
        Usuario u = null;
        //objeto de conexion
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        
        try{
        cn = Conexion.getConexion();
            String q;
            q = "Select * from usuario where email_usu = ? AND password_usu = ?";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, email);
            pr.setString(2, password);
            
            rs = pr.executeQuery();    
            
            while(rs.next()){
                u = new Usuario();
                u.setId_usu(rs.getInt("id_usu"));
                u.setNom_usu(rs.getString("nom_usu"));
                u.setEmail_usu(rs.getString("user_email"));
                u.setPassword_usu(rs.getString("password_usu"));
                u.setPriv_usu(rs.getInt("priv_usu"));
                
                break;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            u=null;
        } finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return u;
        
    }
    
    public Usuario cerrarSesion(){
       Usuario u = null;
        return u;
    }
    
    public boolean registrarUsuario(String name, String email, String password, String direccion, int tel) throws ClassNotFoundException{
        boolean val;
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        
        try{
            cn = Conexion.getConexion();
            String q;
            q = "insert into usuario (nom_usu, email_usu, password_usu, dir_usu, tel_usu, priv_usu) values (?,?,?,?,?,?)";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, name);
            pr.setString(2, email);
            pr.setString(3, password);
            pr.setString(4, direccion);
            pr.setInt(5, tel);
            pr.setInt(6, 0);
            pr.executeUpdate();
            val=true;
        }catch(SQLException ex){
            ex.printStackTrace();
            val=false;
        }
        return val;
    }
    
    public boolean eliminarUsuarioAdmin(String name, String email) throws ClassNotFoundException{
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        boolean val;
        
        try{
        cn = Conexion.getConexion();
            String q;
            q = "delete from usuario where user_name = ? AND user_email = ?";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, name);
            pr.setString(2, email);
            
            pr.executeUpdate();
            val=true;
        }catch(SQLException ex){
            ex.printStackTrace();
            val=false;
        }    
        return val;
    }
    
    public boolean modificarNombre(String name,String nameA) throws ClassNotFoundException{
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        boolean val;
        
        try{
        cn = Conexion.getConexion();
            String q;
            q = "update usuario set nom_usu = ? where nom_usu = ?";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, name);
            pr.setString(2, nameA);
            
            pr.executeUpdate();
            val=true;
        }catch(SQLException ex){
            ex.printStackTrace();
            val=false;
        }    
        return val;
    }
    
    public boolean modificarEmail(String email,String emailA) throws ClassNotFoundException{
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        boolean val;
        
        try{
            System.out.println("1");
        cn = Conexion.getConexion();
            String q;
            q = "update usuario set email_usu = ? where email_usu = ?";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, email);
            pr.setString(2, emailA);
            
            pr.executeUpdate();
            val=true;
        }catch(SQLException ex){
            ex.printStackTrace();
            val=false;
        }    
        return val;
    }
    
    public boolean modificarPassword(String password,String passwordA) throws ClassNotFoundException{
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        boolean val;
        
        try{
        cn = Conexion.getConexion();
            String q;
            q = "update set usuario password_usu = ? where password_usu = ?";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, password);
            pr.setString(2, passwordA);
            
            pr.executeUpdate();
            val=true;
        }catch(SQLException ex){
            ex.printStackTrace();
            val=false;
        }    
        return val;
    }
    
    
    
    public boolean promoverAdmin(String name, String email) throws ClassNotFoundException{
        Connection cn = null;
        //sentencias sql
        PreparedStatement pr = null;
        //consultas sql
        ResultSet rs = null;
        boolean val;
        
        try{
        cn = Conexion.getConexion();
            String q;
            q = "UPDATE usuario SET priv_usu = '1' where nom_usu = ? AND email_usu = ?";
            
            pr = cn.prepareStatement(q);
            pr.setString(1, name);
            pr.setString(2, email);
            
            pr.executeUpdate();
            val=true;
        }catch(SQLException ex){
            ex.printStackTrace();
            val=false;
        }    
        return val;
    }
    
    
    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getDir_usu() {
        return dir_usu;
    }

    public void setDir_usu(String dir_usu) {
        this.dir_usu = dir_usu;
    }

    public int getTel_usu() {
        return tel_usu;
    }

    public void setTel_usu(int tel_usu) {
        this.tel_usu = tel_usu;
    }

    public String getEmail_usu() {
        return email_usu;
    }

    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

    public String getPassword() {
        return password_usu;
    }

    public void setPassword_usu(String password_usu) {
        this.password_usu = password_usu;
    }

    public int getPriv_usu() {
        return priv_usu;
    }

    public void setPriv_usu(int priv_usu) {
        this.priv_usu = priv_usu;
    }
    
    
}
