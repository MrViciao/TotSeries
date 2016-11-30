/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import totseries.Parser.Consola;

public class TotSeries {

    private Catalogo catalogo;
    private Registro registro;
    private Cliente actualCliente;

    public String reproducirEpisodio(String serie_id, int temporada_id, int episodio_id) {
        if (!catalogo.existeEpisodio(serie_id, temporada_id, episodio_id)) {
            return "No existe episodio\n";
        }

        Episodio episodio = catalogo.verEpisodio(serie_id, temporada_id, episodio_id);
        actualCliente.addVisualizacion();
        return "Reproduciendo episodio.\n";

    }
    
    public void valorarEpisodio(String serie_id, int temporada_id, int episodio_id, int puntuacion) {
        Episodio episodio = catalogo.verEpisodio(serie_id, temporada_id, episodio_id);
        
        Valoracion valoracion = new Valoracion(actualCliente.getId(), puntuacion);
        episodio.addValoracion(valoracion);
        
    }
    public String verCatalogo() {
        return catalogo.toString();
    }

    public String verTemporadas(String idSerie) {
        return catalogo.verTemporadas(idSerie);
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

    public String verMejoresEpisodios() {
        return catalogo.getMejoresEpisodios();
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
