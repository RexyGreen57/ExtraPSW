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
public class DetalleCita {
    
    private int id_detcita;
    private int id_cita;
    private int id_serv;
    private float sub_cita;

    public DetalleCita(){
        
    }
    
    
    
    public int getId_detcita() {
        return id_detcita;
    }

    public void setId_detcita(int id_detcita) {
        this.id_detcita = id_detcita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_serv() {
        return id_serv;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public float getSub_cita() {
        return sub_cita;
    }

    public void setSub_cita(float sub_cita) {
        this.sub_cita = sub_cita;
    }
    
    
}
