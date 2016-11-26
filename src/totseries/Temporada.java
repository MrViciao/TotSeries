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
public class Temporada {
    
    private List<Episodio> episodios;
    private int id;
    
    @Override
    public String toString(){
        String lista="";
        for(Episodio episodio : episodios){
            lista+=episodios.toString();
        }
        return lista;
    }
    
    void getMejoresEpisodio(){
        
    }
    
    boolean existeEpisodio(int episodio_id){
        boolean exist=false;
        for(Episodio episodio : episodios){
            if(episodio_id == episodio.getId()) exist=true;
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
