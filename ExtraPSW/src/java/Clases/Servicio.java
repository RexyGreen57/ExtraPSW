/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Christian
 */

import java.sql.*;
import java.util.*;
public class Servicio {
    
    private int id_serv;
    private String nom_serv;
    private int dur_serv;
    private double pre_serv;

    public Servicio(){
        
    }
    
    public static Vector<Servicio> getServicios() throws ClassNotFoundException{
        Vector<Servicio> serv = new Vector<Servicio>();
        Connection cn= null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String q;
        
        try{
           cn = Conexion.getConexion();
           q= "select * from cservicios";
           pr = cn.prepareStatement(q);
           rs = pr.executeQuery();
           while(rs.next()){
               Servicio servicio = new Servicio();
               servicio.setId_serv(rs.getInt("id_serv"));
               servicio.setNom_serv(rs.getString("nom_serv"));
               servicio.setDur_serv(rs.getInt("dur_serv"));
               servicio.setPre_serv(rs.getDouble("pre_serv"));
               serv.add(servicio);
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            serv = null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
                
            }catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }
        return serv;
    }
    
    public Servicio getServiciosById(int id_serv) throws ClassNotFoundException{
        Servicio servicio = null;
        Connection cn= null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String q;
        
        try{
           cn = Conexion.getConexion();
           q= "select * from cservicios where id_serv = ?";
           pr = cn.prepareStatement(q);
           pr.setInt(1, id_serv);
           rs = pr.executeQuery();
           while(rs.next()){
               servicio = new Servicio();
               servicio.setId_serv(rs.getInt("id_serv"));
               servicio.setNom_serv(rs.getString("nom_serv"));
               servicio.setDur_serv(rs.getInt("dur_serv"));
               servicio.setPre_serv(rs.getDouble("pre_serv"));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            servicio = null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
                
            }catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }
        return servicio;
    }
    
    
    
    public int getId_serv() {
        return id_serv;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public String getNom_serv() {
        return nom_serv;
    }

    public void setNom_serv(String nom_serv) {
        this.nom_serv = nom_serv;
    }

    public int getDur_serv() {
        return dur_serv;
    }

    public void setDur_serv(int dur_serv) {
        this.dur_serv = dur_serv;
    }

    public double getPre_serv() {
        return pre_serv;
    }

    public void setPre_serv(double pre_serv) {
        this.pre_serv = pre_serv;
    }

}
