/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

/**
 *
 * @author mrviciao
 */
public abstract class Artista {
    protected String id;
    protected String nombre;
    protected String pais;
    
    public Artista(String id, String nombre, String pais){
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
