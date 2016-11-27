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
    private String titulo;
    private String duracion;
    private String idioma;
    private String descripcion;
    private float valoracion_media;
    private Date fecha;
    private String id;
    
    private List<Valoracion> valoraciones;
    
    public Episodio(){};
    public Episodio(String title, String duration, String idioma, String description, Date data){
        this.titulo=title;
        this.duracion=duration;
        this.idioma=idioma;
        this.descripcion=description;
        this.fecha=data;
    }
    
    @Override
    public String toString(){
        String text="Titol: " + titulo + "\n";
        text+="--------------------------------------------------\n";
        text+="Duracion: " + duracion + "\n";
        text+="Estreno: " + fecha + "\n";
        text+="Idioma: " + idioma + "\n";
        text+="Descripcion: " + descripcion + "\n";
        return text;
    }
    
    private void calcular_media(){
        
    }

    /**
     * @return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.id = Id;
    }
}
