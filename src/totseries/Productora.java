/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.Date;

/**
 *
 * @author Abel
 */
public class Productora {
    private String nombre;
    private String id;
    private Date fCreacion;
    
    public Productora(String id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }
    
    public Productora(String id, String nombre,Date fCreacion){
        this(id, nombre);
        this.fCreacion=fCreacion;
    };
    
    public Productora (){
        this.nombre = "";
        this.id = "";
        this.fCreacion = new Date();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getfCreacion() {
        return fCreacion;
    }

    public void setfCreacion(Date fCreacion) {
        this.fCreacion = fCreacion;
    }
}
