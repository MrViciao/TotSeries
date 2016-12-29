/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Media;

import java.util.Date;

/**
 *
 * @author mrviciao
 */
public class Valoracion {
    
    private String usuario;
    private float puntuacion;
    private Date fecha;
    
    public Valoracion(String usuario, float puntuacion){
        this.usuario=usuario;
        this.puntuacion=puntuacion;
        this.fecha=new Date();
    }
    
    public Valoracion(String usuario, float puntuacion, Date fecha){
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

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha; 
    }
}
