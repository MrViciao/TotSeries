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
public class Serie {
    private int id;
    private List<Temporada> temporadas;
    
    @Override
    public String toString(){
        String lista="";
        for(Temporada temporada : temporadas){
            lista+=temporada.toString();
        }
        return lista;
    }
    
    void getMejoresEpisodio(){
        
    }
    
    boolean existeEpisodio(int temporada_id, int episodio_id){
        boolean exist=false;
        Temporada temporada_existente=null;
        for(Temporada temporada : temporadas){
            if(temporada_id==temporada.getId()){
                exist=true;
                temporada_existente=temporada;
            }
            
        }
        if(exist){
            exist=temporada_existente.existeEpisodio(episodio_id);
        }
        return exist;
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
