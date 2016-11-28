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
public class Catalogo {
    
    private List<Serie> series;
    
    public Catalogo(){
        this.series = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        String lista="";
        for(Serie serie : series){
            lista+=serie.toString();
        }
        return lista;
    }
    
    public boolean existeEpisodio(String serie_id, int num_temporada, String episodio_id){
        boolean exist=false;
        Serie serie_existente=null;
        for(Serie serie : series){
            if(serie_id.equals(serie.getId())){
                exist=true;
                serie_existente=serie;
            }
        }
        if(exist){
            exist=serie_existente.existeEpisodio(num_temporada, episodio_id);
        }
        return exist;
    }
    public void getMejoresEpisodios(){
        
    }
    
    public void addSerie(Serie serie){
        series.add(serie);
    }
    
    public Serie getLastSerie(){
        if(series.size()==0) return null;
        return series.get(series.size()-1);
    }
    
    
}
