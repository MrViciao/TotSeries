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

    public void  verEpisodio(String serie_id, int temporada_id, int episodio_id){
        if (!catalogo.existeEpisodio(serie_id, temporada_id, episodio_id)){
            Consola.escriu("No existe episodio\n");
            return;
        }
        Episodio episodio = catalogo.verEpisodio(serie_id, temporada_id, episodio_id);
        Consola.escriu("Reproduciendo\n");
        Consola.escriu("Quiere valorar el episodio? Escribe yes para valorar");
        if(!Consola.llegeixString().equals("yes")) return;
        Consola.escriu("introduce una nota");
        Valoracion valoracion = new Valoracion(Consola.llegeixInt());
        episodio.addValoracion(valoracion);
        
        
    }
    
    public void verCatalogo(){
        System.out.println(catalogo.toString());
        
    }
    
    public void registrar(String usuari, String password, String nom, String dni, String adreca){
        while(!registro.hasUsuario(usuari)){
            Consola.escriu("Introduzca un nuevo username, este ya esta cogido/n");
            usuari=Consola.llegeixString();
        }
        registro.registrar(nom, dni, adreca, usuari, password);
    }
    
    public void verMejoresEpisodios(){
        Consola.escriu(catalogo.getMejoresEpisodios());
    }

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
