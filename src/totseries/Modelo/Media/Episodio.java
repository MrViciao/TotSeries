/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Media;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Abel
 */
public class Episodio extends Observable {

    private int id;
    private String titulo;
    private String duracion;
    private String idioma;
    private String descripcion;
    private float promedio;
    private Date fecha;
    private List<Valoracion> valoraciones;
    private List<Reproduccion> reproducciones;

    public Episodio() {
        this.valoraciones = new ArrayList<>();
        this.reproducciones = new ArrayList<>();
    }

    public Episodio(String title, String duration, String idioma, String description, Date data) {
        this();
        this.titulo = title;
        this.duracion = duration;
        this.idioma = idioma;
        this.descripcion = description;
        this.fecha = data;
        this.promedio = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPromedio() {
        return promedio;
    }

    public Episodio verEpisodio() {
        return this;
    }

    private void setPromedio() {
        Iterator<Valoracion> iterador = valoraciones.iterator();
        Valoracion valoracion;
        float valor = 0;
        while (iterador.hasNext()) {
            valoracion = iterador.next();
            valor += valoracion.getPuntuacion();
        }
        this.promedio = valor / this.valoraciones.size();
    }

    public void addValoracion(Valoracion valoracion) {
        valoraciones.add(valoracion);
        this.setPromedio();
        setChanged();
        notifyObservers(0);
    }

    @Override
    public String toString() {
        /*
        String string="\n Titulo: " + titulo +
        "\nDuracion: " + duracion+
        "\nIdioma" + idioma +
        "\nCreacion: " + fecha+
        "\nvaloracion : " + promedio +
        "\nDescripcion: " + descripcion + "\n";
        return string;
         */
        return id + " - " + titulo;
    }

    public int countReproducciones() {
        return reproducciones.size();
    }

    public void addReproduccion(Reproduccion r) {
        reproducciones.add(r);
        setChanged();
        notifyObservers(1);
    }

    public void addReproduccion(String username) {
        reproducciones.add(new Reproduccion(username));
        setChanged();
        notifyObservers(1);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void addValoracion(float puntuacion, String user_id) {
        valoraciones.add(new Valoracion(user_id, puntuacion));
        this.setPromedio();
        setChanged();
        notifyObservers(0);
    }
}
