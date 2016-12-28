/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import totseries.Modelo.Media.Temporada;
import totseries.Modelo.Media.Valoracion;
import totseries.Modelo.Usuario.Cliente;
import totseries.Modelo.Usuario.Registro;
import totseries.Modelo.Media.Catalogo;
import totseries.Modelo.Media.Episodio;
import java.util.ArrayList;
import java.util.List;
import totseries.Modelo.Usuario.Usuario;
import totseries.Parser.Consola;

public class TotSeries {

    private Catalogo catalogo;
    private Registro registro;
    private static TotSeries instance;

    public static TotSeries getInstance() {
        if (instance == null) {
            return new TotSeries();
        }
        return instance;
    }

    public boolean reproducirEpisodio(String serie_id, int temporada_id, int episodio_id) {
        Cliente cliente = registro.getLoggedAsCliente();
        if (cliente==null){
            return false;
        }
        if (!cliente.canViewEpisode()) {
            return false;
        }
        if (!catalogo.existeEpisodio(serie_id, temporada_id, episodio_id)) {
            return false;
        }

        cliente.nextActivityState();
        Episodio episodio = catalogo.getEpisodio(serie_id, temporada_id, episodio_id);
        Consola.escriu("Reproduciendo episodio.\n");
        cliente.addVisualizacion();
        cliente.nextActivityState();
        return true;
    }

    public void valorarEpisodio(String serie_id, int temporada_id, int episodio_id, int puntuacion) {
        Episodio episodio = catalogo.getEpisodio(serie_id, temporada_id, episodio_id);
        Valoracion valoracion = new Valoracion(registro.getLoggedUser().getId(), puntuacion);
        episodio.addValoracion(valoracion);

    }
    
    public boolean login(String username, String password){
        if (registro.isLogged()) return false;
        Usuario user= registro.login(username, password);
        return user != null;
    }
    
    public void logout(){
        registro.setLoggedUser(null);
    }
    

    public void verCatalogo() {
        catalogo.showCatalogo();
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
        registro.registrarCliente(nom, dni, adreca, usuari, password);
    }

    public void verMejoresEpisodios() {
        List<Episodio> bestEpisodios = catalogo.getEpisodiosMasValorados();
        for (Episodio episodio : bestEpisodios) {
            Consola.escriu(episodio.toString());
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

}
