/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Media;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Temporada {

    private List<Episodio> episodios;
    private int id;
    private int numEpisodis;

    ///////////////////////////////
    //Constructores
    public Temporada() {
        episodios = new ArrayList<>();
    }

    public Temporada(int idTemporada) {
        this();
        this.id = idTemporada;
        numEpisodis = episodios.size();
    }

    ///////////////////////////////
    // Metodos
    public int size() {
        return this.episodios.size();
    }

    public void addEpisodio(Episodio episodio) {
        this.episodios.add(episodio);
        episodio.setId(episodios.size());
        numEpisodis += 1;
    }

    public boolean existeEpisodio(int idEpisodio) {
        for (Episodio episodio : episodios) {
            if (episodio.getId() == idEpisodio) {
                return true;
            }
        }
        return false;
    }

    public Episodio getEpisodio(int idEpisodio) {
        for (Episodio episodio : episodios) {
            if (episodio.getId() == idEpisodio) {
                return episodio;
            }
        }
        return null;
    }

    public String verEpisodios() {
        String lista = "";
        for (Episodio episodio : episodios) {
            lista += episodio.toString();
        }
        if (lista.isEmpty()) {
            lista = "No hay episodios disponibles";
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Temporada: "+id;
        //return "Temporada: " + id + " - Episodios: " + numEpisodis + "\n";
    }

    ///////////////////////////////
    //Getters and setters 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int countReproducciones() {
        int total = 0;
        for (Episodio episodio : episodios) {
            total += episodio.countReproducciones();
        }
        return total;
    }

    public List getEpisodios() {
        return episodios;
    }

    public float getPromedio() {
        float total = 0;
        for (Episodio episodio : episodios) {
            total += episodio.getPromedio();
        }
        return total / episodios.size();
    }
        public List<Episodio> getEpisodio(){
        return this.episodios;
    }
    public String showTemporada(){
        String nombre;
        nombre = "Season: ";
        nombre += this.getId();
        return nombre;
    }

    public List<String> showEpisodio() {
        List<String> lista = null;
        for (Episodio epi : this.episodios){
            lista.add(epi.getTitulo());
        }
        return lista;
    }
}
