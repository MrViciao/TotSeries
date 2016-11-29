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

    public void  verEpisodio(int serie, int temporada, int episodio){
        
    }
    
    public void verCatalogo(){
        System.out.println(catalogo.toString());
        
    }
    
    public void registrar(String usuari, String password, String nom, String dni, String adreca){
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
