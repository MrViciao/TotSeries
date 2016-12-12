/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.ArrayList;
import java.util.List;
import totseries.Parser.Consola;
import totseries.totseries.Exceptions.SerieNotFoundException;

public class TotSeries {

    private Catalogo catalogo;
    private Registro registro;
    private Cliente actualCliente;

    public boolean reproducirEpisodio(String serie_id, int temporada_id, int episodio_id) {
        if (!catalogo.existeEpisodio(serie_id, temporada_id, episodio_id)) {
            return false;
        }

        Episodio episodio = catalogo.getEpisodio(serie_id, temporada_id, episodio_id);
        Consola.escriu("Reproduciendo episodio.\n");
        actualCliente.addVisualizacion();
        return true;
    }

    public void valorarEpisodio(String serie_id, int temporada_id, int episodio_id, int puntuacion) {
        Episodio episodio = catalogo.getEpisodio(serie_id, temporada_id, episodio_id);

        Valoracion valoracion = new Valoracion(actualCliente.getId(), puntuacion);
        episodio.addValoracion(valoracion);

    }

    public String verCatalogo() {
        //Consola.escriu(catalogo.toString());
        return catalogo.toString();
    }

    public boolean verTemporadas(String idSerie) {
        //comprovar que exista serie!
        try {
            List<Temporada> temporadas = catalogo.getTemporadas(idSerie);
            for (Temporada temporada : temporadas) {
                Consola.escriu(temporada.toString());
            }
            if (temporadas.isEmpty()) {
                Consola.escriu("No hi han tempordas\n");
                return false;
            }
            return true;
        } catch (Exception e) {
            Consola.escriu("No existeix la serie!\n");
            return false;
        }
    }

    public boolean hasUsuario(String username) {
        return registro.hasUsuario(username);
    }

    public String verEpisodios(String idSerie, int idTemporada) {
        return catalogo.verEpisodios(idSerie, idTemporada);
    }

    public void registrar(String usuari, String password, String nom, String dni, String adreca) {
        registro.registrar(nom, dni, adreca, usuari, password);
    }

    public void verMejoresEpisodios() {
        ArrayList<Episodio> bestEpisodios = catalogo.getMejoresEpisodio();
        for (Episodio episodio : bestEpisodios) {
            Consola.escriu(episodio.toString());
        }
        if (bestEpisodios.isEmpty()) {
            Consola.escriu("No hi ha millors episodis\n");
        }
    }
    ///////////////////////////////
    //Getters and setters 

    /**
     * @return the catalogo
     */
    public Catalogo getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * @return the registro
     */
    public Registro getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    /**
     * @return the actualUsuario
     */
    public Cliente getActualCliente() {
        return actualCliente;
    }

    /**
     * @param actualCliente the actualUsuario to set
     */
    public void setActualCliente(Cliente actualCliente) {
        this.actualCliente = actualCliente;
    }

}
