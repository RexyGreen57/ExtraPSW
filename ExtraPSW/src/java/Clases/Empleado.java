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
import java.util.*;
import java.sql.*;
public class Empleado {
    
    private int id_emp;
    private String nom_emp;
    private int id_suc;
    private String status_emp;
    
    public Empleado(){
        
    }
    
    public static Vector<Empleado> getEmpleados() throws ClassNotFoundException{
        Vector<Empleado> emp = new Vector<Empleado>();
        Connection cn= null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String q;
        
        try{
           cn = Conexion.getConexion();
           q= "select * from cservicio";
           pr = cn.prepareStatement(q);
           rs = pr.executeQuery();
           while(rs.next()){
               Empleado empleado = new Empleado();
               empleado.setId_emp(rs.getInt("id_emp"));
               empleado.setNom_emp(rs.getString("nom_emp"));
               empleado.setId_suc(rs.getInt("id_suc"));
               empleado.setStatus_emp(rs.getString("status_emp"));
               emp.add(empleado);
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            emp = null;
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
        return emp;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public int getId_suc() {
        return id_suc;
    }

    public void setId_suc(int id_suc) {
        this.id_suc = id_suc;
    }

    public String getStatus_emp() {
        return status_emp;
    }

    public void setStatus_emp(String status_emp) {
        this.status_emp = status_emp;
    }
    
    
}
