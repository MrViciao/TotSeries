/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.Date;

/**
 *
 * @author mrviciao
 */
public class Valoracion {
    
    private String usuario;
    private int puntuacion;
    private Date fecha;
    
    public Valoracion(int puntuacion){
        this.puntuacion=puntuacion;
        this.fecha=new Date();
    }
    
    public Valoracion(String usuario, int puntuacion){
        this.usuario=usuario;
        this.puntuacion=puntuacion;
        this.fecha=new Date();
    }
    
    public Valoracion(String usuario, int puntuacion, Date fecha){
        this.usuario=usuario;
        this.puntuacion=puntuacion;
        this.fecha=fecha;
    }
    
    public String getId() {
        return usuario;
    }

    public void setId(String id) {
        this.usuario = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
