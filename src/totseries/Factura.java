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
public class Factura {
    private float precio;
    private Date fecha;
    private int visualizaciones;
    
    public Factura(Date fecha){
        this.precio = 0;
        this.visualizaciones = 0;
        this.fecha = fecha;
    }
    public float getPrecio() {
        return precio;
    }
    public void setVisualizacion(){
        this.visualizaciones++;
    }
    public void setprecio(){
        this.precio=this.visualizaciones*1;
    }
}
