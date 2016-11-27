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

    private String id;
    private String titulo;
    private String descripcion;
    private List<Temporada> temporadas;

    public Serie() {

    }

    public Serie(String id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        String lista = "";
        for (Temporada temporada : temporadas) {
            lista += temporada.toString();
        }
        return lista;
    }

    void getMejoresEpisodio() {

    }

    boolean existeEpisodio(int num_temporada, String episodio_id) {
        boolean exist = false;
        Temporada temporada_existente = null;
        for (Temporada temporada : temporadas) {
            if (num_temporada == temporada.getNum_temporada()) {
                exist = true;
                temporada_existente = temporada;
            }

        }
        if (exist) {
            exist = temporada_existente.existeEpisodio(episodio_id);
        }
        return exist;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.id = Id;
    }
}
