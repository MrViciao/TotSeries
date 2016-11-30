/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Temporada {

    private List<Episodio> episodios;
    private int idTemporada;
    private int numEpisodis;
            
    public Temporada(){
        episodios = new ArrayList<>(); 
    }
    public Temporada(int idTemporada) {
        this();
        this.idTemporada = idTemporada;
        numEpisodis=episodios.size();
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
        episodio.setId(episodios.size());
        numEpisodis+=1;
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
    boolean existeEpisodio(int idEpisodio) {
        
        for (Episodio episodio : episodios){
            if(episodio.getId()==idEpisodio)
                return true;
        }
        return false;
    }
    Episodio verEpisodio(int idEpisodio){
        System.out.println(this.toString());
        return find(idEpisodio);
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
    
    public Episodio find(int idEpisodio){
        for(Episodio episodio : episodios){
           if(episodio.getId()==idEpisodio)
               return episodio;
        }
        return null;
    }

}
