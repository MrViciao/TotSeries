/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Temporada {

    private List<Episodio> episodios;
    int idTemporada;

    public Temporada(int idTemporada) {
        episodios = new ArrayList<>();
        this.idTemporada = idTemporada;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }

    public int size() {
        return this.episodios.size();
    }
    
    public void addEpisodio(Episodio episodio){
        this.episodios.add(episodio);
    }
    public String getMejoresEpisodio() {
        String lista= "";
        Iterator<Episodio> iterador = episodios.iterator();
        Episodio episodio;
        while(iterador.hasNext()){
            episodio=iterador.next();
            if(episodio.getPromedio() > 4)
                lista += episodio.toString();
        }
        return lista;
    }
    boolean existeEpisodio(String idEpisodio) {
        boolean exist = false;
        Iterator<Episodio> iterador= episodios.iterator();
        while(iterador.hasNext()) {
            if (iterador.next().equals(idEpisodio)) 
                exist = true;
        }
        return exist;
    }
    Episodio verEpisodio(String idEpisodio){
        Iterator<Episodio> iterador = episodios.iterator();
        Episodio episodio;
        while(iterador.hasNext()){
            episodio=iterador.next();
            if(episodio.equals(idEpisodio))
                return episodio;
        }
        return NULL;
    }
    @Override
    public String toString() {
        String lista = "";
        Episodio episodio;
        Iterator<Episodio> iterador= episodios.iterator();
        while(iterador.hasNext()) {
            episodio = iterador.next();
            lista += episodio.toString();
        }
        return lista;
    }

}
