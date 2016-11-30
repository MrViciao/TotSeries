/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import totseries.Parser.Consola;
import totseries.Parser.TotSeriesDataManager;

/**
 *
 * @author mrviciao
 */
public class Menu {

    /**
     * @param totseries
     */
    
    private TotSeries totSeries;
    
    public Menu(TotSeries totSeries){
        this.totSeries=totSeries;
    }
    public void run() {
        
        int selected = 1;
        while (selected != 0) {
            Consola.printMenu();
            selected = Consola.llegeixInt();
            switch (selected) {
                case 1:
                    Consola.escriu("Escriu username: ");
                    String username = Consola.llegeixString();
                    Consola.escriu("Escriu password: ");
                    String password = Consola.llegeixString();
                    Consola.escriu("Escriu nom: ");
                    String nombre = Consola.llegeixString();
                    Consola.escriu("Escriu dni: ");
                    String dni = Consola.llegeixString();
                    Consola.escriu("Escriu direccion: ");
                    String direccion = Consola.llegeixString();
                    totSeries.registrar(username, password, nombre, dni, direccion);
                    break;
                case 3:
                    totSeries.verCatalogo();
                    break;
                case 4:
                    totSeries.verCatalogo();
                    Consola.escriu("Escriu el id de una serie: ");
                    String serieId=Consola.llegeixString();
                    totSeries.verTemporadas(serieId);
                    Consola.escriu("Escriu una temporada: ");
                    int temporadaId=Consola.llegeixInt();
                    Consola.escriu("Escriu un episodi: ");
                    int episodioId=Consola.llegeixInt();
                    totSeries.reproducirEpisodio(serieId, temporadaId, episodioId);
                    break;
                case 6:
                    totSeries.verMejoresEpisodios();
                    break;
            }
        }

    }

}
