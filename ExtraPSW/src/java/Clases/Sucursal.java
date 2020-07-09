/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Christian
 */
public class Sucursal {
    
    private int id_suc;
    private String nom_suc;
    private String dir_suc;
    
    public Sucursal(){
        
    }
    
    public static Vector<Sucursal> getSucursales() throws ClassNotFoundException{
        
        Vector<Sucursal> suc = new Vector<Sucursal>();
        Connection cn= null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String q;
        
        try{
           cn = Conexion.getConexion();
           q= "select * from csucursal";
           pr = cn.prepareStatement(q);
           rs = pr.executeQuery();
           while(rs.next()){
               Sucursal sucursal = new Sucursal();
               sucursal.setId_suc(rs.getInt("id_suc"));
               sucursal.setNom_suc(rs.getString("nom_suc"));
               sucursal.setDir_suc(rs.getString("dir_suc"));
               suc.add(sucursal);
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            suc = null;
        }
        return suc;
    }

    public int getId_suc() {
        return id_suc;
    }

    public void setId_suc(int id_suc) {
        this.id_suc = id_suc;
    }

    public String getNom_suc() {
        return nom_suc;
    }

    public void setNom_suc(String nom_suc) {
        this.nom_suc = nom_suc;
    }

    public String getDir_suc() {
        return dir_suc;
    }

    public void setDir_suc(String dir_suc) {
        this.dir_suc = dir_suc;
    }
    
    
    
}
