/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Controlador;

import totseries.Modelo.Media.Valoracion;
import totseries.Modelo.Usuario.Cliente;
import totseries.Modelo.Usuario.Registro;
import totseries.Modelo.Media.Catalogo;
import totseries.Modelo.Media.Episodio;
import java.util.List;
import totseries.Modelo.Media.Reproduccion;
import totseries.Modelo.Usuario.Usuario;

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
        episodio.addReproduccion(
                new Reproduccion(cliente.getUsername()));
    }

    public void valorarEpisodio(Episodio episodio, float puntuacion) {
        catalogo.valorarEpisodio(episodio, puntuacion, registro.getLoggedUser().getId());
    }
   
    public boolean login(String username, String password) {
        /*se hace a nivel grafico GUI
        if (registro.isLogged()) {
            return false;
        }*/
        Usuario user = registro.login(username, password);
        return user != null;
    }

    public void logout() {
        registro.setLoggedUser(null);
    }

    public boolean islogged() {
        return this.registro.isLogged();
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
    
    public List<Usuario> getClientesNonVIP() {
        return this.registro.getClientesNonVIP();
    }    
    
    public void hacerVip(Cliente cliente){ 
        this.registro.setVIP(cliente); 
    } 
    
    public Catalogo getCatalogo() {
        return catalogo;
    }
    
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    
    public Registro getRegistro() {
        return registro;
    }
    
    // MEDIA
    public List getSeries() {
        return catalogo.getSeries();
    }
    
    public List getEpisodiosMasVistos() {
        return catalogo.getEpisodiosMasVistos();
    }
    
    public List getEpisodiosMasValorados() {
        return catalogo.getEpisodiosMasValorados();
    }
    
    public boolean hasUsuario(String username) {
        return registro.hasUsuario(username);
    }

}
