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
    
    private String id;
    private int puntuacion;
    private Date fecha;
    
    public Valoracion(){};
    public Valoracion(String id, int puntuacion, Date fecha){
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
