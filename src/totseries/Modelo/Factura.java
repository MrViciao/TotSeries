/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo;

import java.util.Date;

/**
 *
 * @author mrviciao
 */
public class Factura {
    
    public static final int PRICE=1;
    
    private float total;
    private Date fecha;
    private int visualizaciones;
 
    public Factura(){
        fecha=new Date();
        total=0;
        visualizaciones=0;
    }
    
    public Factura(int precio){
        fecha=new Date();
        this.total=precio;
        visualizaciones=0;
    }
    
    public void addVisualizacion(boolean isVip){
        visualizaciones+=1;
        if (isVip){
            total+=PRICE*0.9;
        }
        else total+=PRICE;
    }
}
