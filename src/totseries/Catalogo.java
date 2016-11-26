/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Catalogo {
    
    private List<Serie> series;
    
    @Override
    public String toString(){
        String lista="";
        for(Serie serie : series){
            lista+=serie.toString();
        }
        return lista;
    }
    
    boolean existeEpisodio(int serie_id, int temporada_id, int episodio_id){
        boolean exist=false;
        Serie serie_existente=null;
        for(Serie serie : series){
            if(serie_id==serie.getId()){
                exist=true;
                serie_existente=serie;
            }
            
        }
        if(exist){
            exist=serie_existente.existeEpisodio(temporada_id, episodio_id);
        }
        return exist;
    }
    void getMejoresEpisodios(){
        
    }
    
    
}