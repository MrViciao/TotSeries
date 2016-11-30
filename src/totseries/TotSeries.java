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

    public void reproducirEpisodio(String serie_id, int temporada_id, int episodio_id) {
        if (!catalogo.existeEpisodio(serie_id, temporada_id, episodio_id)) {
            Consola.escriu("No existe episodio\n");
            return;
        }

        Episodio episodio = catalogo.verEpisodio(serie_id, temporada_id, episodio_id);
        Consola.escriu("Reproduciendo episodio.\n");

        Consola.escriu("Quiere valorar el episodio? Escribe true para valorar: ");
        actualCliente.addVisualizacion();
        if (!Consola.llegeixString().equals("true")) {
            return;
        }

        Consola.escriu("introduce una nota: ");
        int puntuacion = puntuacion = Consola.llegeixInt();
        while (puntuacion < 0 || puntuacion > 5) {
            Consola.escriu("Escribela entre 0 y 5!");
            puntuacion = Consola.llegeixInt();
        }

        Valoracion valoracion = new Valoracion(actualCliente.getId(), puntuacion);
        episodio.addValoracion(valoracion);

    }

    public void verCatalogo() {
        Consola.escriu(catalogo.toString());
    }

    public void verTemporadas(String idSerie) {
        Consola.escriu(catalogo.verTemporadas(idSerie));
    }
    
    public void verEpisodios(String idSerie, int idTemporada) {
        Consola.escriu(catalogo.verEpisodios(idSerie, idTemporada));
    }

    public void registrar(String usuari, String password, String nom, String dni, String adreca) {
        while (!registro.hasUsuario(usuari)) {
            Consola.escriu("Introduzca un nuevo username, este ya esta cogido/n");
            usuari = Consola.llegeixString();
        }
        registro.registrar(nom, dni, adreca, usuari, password);
    }

    public void verMejoresEpisodios() {
        Consola.escriu(catalogo.getMejoresEpisodios());
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
