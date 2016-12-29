/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Controlador;

import totseries.Modelo.Media.Temporada;
import totseries.Modelo.Media.Valoracion;
import totseries.Modelo.Usuario.Cliente;
import totseries.Modelo.Usuario.Registro;
import totseries.Modelo.Media.Catalogo;
import totseries.Modelo.Media.Episodio;
import java.util.ArrayList;
import java.util.List;
import totseries.Modelo.Media.Reproduccion;
import totseries.Modelo.Usuario.Usuario;
import totseries.Parser.Consola;

public class TotSeries {

    private Catalogo catalogo;
    private Registro registro;
    private static TotSeries instance;

    private TotSeries() {
        catalogo = new Catalogo();
        registro = new Registro();
    }

    public static TotSeries getInstance() {
        if (instance == null) {
            return new TotSeries();
        }
        return instance;
    }
    
    // rEPRODUCCION
    ////////////////////////////////////////////
    public void empezarReproduccion(Episodio episodio) {
        Cliente cliente = registro.getLoggedAsCliente();
        if (!cliente.canViewEpisode()) {
            return;
        }
        cliente.nextActivityState();
    }

    public void finalizarReproduccion(Episodio episodio, boolean finalizado) {
        Cliente cliente = registro.getLoggedAsCliente();
        cliente.nextActivityState();
        if (!finalizado) {
            return;
        }
        episodio.addReproduccion(
                new Reproduccion(cliente.getUsername()));
    }

    public void valorarEpisodio(Episodio episodio, int puntuacion) {
        Valoracion valoracion = new Valoracion(registro.getLoggedUser().getId(), puntuacion);
        episodio.addValoracion(valoracion);
    }
    
    // LOGIN Y REGISTRO
    ////////////////////////////////////////////
    
    public boolean login(String username, String password) {
        if (registro.isLogged()) {
            return false;
        }
        Usuario user = registro.login(username, password);
        return user != null;
    }

    public void logout() {
        registro.setLoggedUser(null);
    }

    public boolean islogged() {
        return this.registro.isLogged();
    }

    public boolean hasUsuario(String username) {
        return registro.hasUsuario(username);
    }

    public boolean registrar(String usuari, String password, String nom, String dni, String adreca) {
        if (registro.hasUsuario(usuari)) {
            return false;
        }
        registro.registrarCliente(nom, dni, adreca, usuari, password);
        return true;
    }

    public boolean registrar(String usuari, String password, String nom) {
        if (registro.hasUsuario(usuari)) {
            return false;
        }
        registro.registrarAdmin(usuari, password, nom);
        return true;
    }
    
    public boolean isloggedAdmin() {
        return this.registro.isLoggedAdmin();
    }
    
    // Registro
    //////////////////////////////////////////////
    public List<Usuario> getClientesNonVIP() {
        return this.registro.getClientesNonVIP();
    }    
        
    public void hacerVip(Cliente cliente){ 
        this.registro.setVIP(cliente); 
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
    
    // MEDIA
    /////////////////////////////////////////
    public List getSeries() {
        return catalogo.getSeries();
    }
    
    public List getEpisodiosMasVistos() {
        return catalogo.getEpisodiosMasVistos();
    }
    
    public List getEpisodiosMasValorados() {
        return catalogo.getEpisodiosMasValorados();
    }

}
