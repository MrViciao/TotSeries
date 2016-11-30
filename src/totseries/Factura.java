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
 
    public Factura(){
        fecha=new Date();
        precio=2;
        visualizaciones=0;
    }
    
    public Factura(int precio){
        fecha=new Date();
        this.precio=precio;
        visualizaciones=0;
    }
    
    public void addVisualizacion(){
        visualizaciones+=1;
    }
}
