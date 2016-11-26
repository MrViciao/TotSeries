/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.Date;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Episodio {
    private String nombre;
    private int duracion;
    private String idioma;
    private String descripcion;
    private int valoracion_media;
    private Date fecha;
    private int id;
    
    private List<Valoracion> valoraciones;
    
    @Override
    public String toString(){
        return nombre;
    }
    
    private void calcular_media(){
        
    }

    /**
     * @return the Id
     */
    public int getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.id = Id;
    }
}
