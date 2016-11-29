/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Abel
 */
public class Episodio {
    private String titulo;
    private String duracion;
    private String idioma;
    private String descripcion;
    private float promedio;
    private Date fecha;
    private List<Valoracion> valoraciones;
    
    public Episodio(String title, String duration, String idioma, String description, Date data){
        this.titulo=title;
        this.duracion=duration;
        this.idioma=idioma;
        this.descripcion=description;
        this.fecha=data;
        this.promedio = 0;
        this.valoraciones = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPromedio() {
        return promedio;
    }
    
    public Episodio verEpisodio(){
        return this;
    }
    private void setPromedio(){
        Iterator<Valoracion> iterador= valoraciones.iterator();
        Valoracion valoracion;
        int valor=0;
        while(iterador.hasNext()){
            valoracion = iterador.next();
            valor+=valoracion.getPuntuacion();
        }
        this.promedio = valor/this.valoraciones.size();
    }
    
    /*
    public boolean equals(String idEpisodio){
        return this.id == idEpisodio;
    }
*/
    
    @Override
    public String toString(){
        String string="\n Titulo: " + titulo +
        "\nDuracion: " + duracion+
        "\nIdioma" + idioma +
        "\nCreacion: " + fecha+
        "\nvaloracion : " + promedio +
        "\nDescripcion: " + descripcion + "\n";
        return string;
    }
}
