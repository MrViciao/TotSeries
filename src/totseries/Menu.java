/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import totseries.Parser.Consola;

/**
 *
 * @author mrviciao
 */
public class Menu {

    /**
     * @param totseries
     */
    private final TotSeries totSeries;

    public Menu(TotSeries totSeries) {
        this.totSeries = totSeries;
    }

    public void run() {

        int selected = 1;
        while (selected != 0) {
            printMenu();
            selected = Consola.llegeixInt();
            switch (selected) {
                case 1:
                    Consola.escriu(
                            "================\n"
                            + "= Registrar\n"
                            + "================\n");
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
                    Consola.escriu("Registro realizado con exito\n");
                    break;
                    
                case 3:
                    Consola.escriu(
                            "================\n"
                            + "= Ver Catalogo\n"
                            + "================\n");
                    Consola.escriu(totSeries.verCatalogo());
                    break;
                    
                case 4:
                    Consola.escriu(
                            "================\n"
                            + "= Ver Episodio\n"
                            + "================\n");
                    Consola.escriu(totSeries.verCatalogo());
                    Consola.escriu("Escriu el id de una serie: ");
                    String serieId = Consola.llegeixString();
                    
                    Consola.escriu(totSeries.verTemporadas(serieId));
                    Consola.escriu("Escriu una temporada: ");
                    int temporadaId = Consola.llegeixInt();
                    
                    Consola.escriu(totSeries.verEpisodios(serieId, temporadaId));
                    Consola.escriu("Escriu un episodi: ");
                    int episodioId = Consola.llegeixInt();
                    
                    totSeries.reproducirEpisodio(serieId, temporadaId, episodioId);
                    break;
                    
                case 6:
                    Consola.escriu(
                            "================\n"
                            + "= Ver Mejores Episodios\n"
                            + "================\n");
                    Consola.escriu(totSeries.verMejoresEpisodios());
                    break;
            }
        }

    }
    
        
    public static void printMenu(){
        Consola.escriu("================\n");
        Consola.escriu("= Menu\n");
        Consola.escriu("================\n");
        Consola.escriu("1.Añadir Cliente\n");
        Consola.escriu("3.Ver Catalogo\n");
        Consola.escriu("4.Ver episodio\n");
        Consola.escriu("6.Ver mejores Episodios\n");
        Consola.escriu("0.Exit\n");
    }

}
