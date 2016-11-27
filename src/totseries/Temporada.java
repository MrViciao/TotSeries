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
    private int num_temporada;
    private int num_episodios;

    public Temporada() {
    }

    ;
    public Temporada(int num_temporada, int n_episodios) {
        this.num_episodios = n_episodios;
        this.num_temporada = num_temporada;
    }


    @Override
    public String toString() {
        String lista = "";
        for (Episodio episodio : episodios) {
            lista += episodios.toString();
        }
        return lista;
    }

    void getMejoresEpisodio() {

    }

    boolean existeEpisodio(String episodio_id) {
        boolean exist = false;
        for (Episodio episodio : episodios) {
            if (episodio_id.equals(episodio.getId())) {
                exist = true;
            }
        }
        return exist;
    }

    /**
     * @return the num_temporada
     */
    public int getNum_temporada() {
        return num_temporada;
    }

    /**
     * @param num_temporada the num_temporada to set
     */
    public void setNum_temporada(int num_temporada) {
        this.num_temporada = num_temporada;
    }

    /**
     * @return the num_episodios
     */
    public int getNum_episodios() {
        return num_episodios;
    }

    /**
     * @param num_episodios the num_episodios to set
     */
    public void setNum_episodios(int num_episodios) {
        this.num_episodios = num_episodios;
    }

}
