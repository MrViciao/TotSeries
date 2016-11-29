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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TotSeries tot_series = new TotSeries();
        tot_series = cargarDatos(tot_series);
        int selected = 1;
        while (selected != 0) {
            Consola.printMenu();
            selected = Consola.llegeixInt();
            switch (selected) {
                case 1:
                    Consola.escriu("Escriu username");
                    String username = Consola.llegeixString();
                    Consola.escriu("Escriu password");
                    String password = Consola.llegeixString();
                    Consola.escriu("Escriu nom");
                    String nombre = Consola.llegeixString();
                    Consola.escriu("Escriu dni");
                    String dni = Consola.llegeixString();
                    Consola.escriu("Escriu direccion");
                    String direccion = Consola.llegeixString();
                    tot_series.registrar(username, password, nombre, dni, direccion);
                    break;
                case 3:
                    tot_series.verCatalogo();
                    break;
                case 4:
                    System.out.println("Not working");
                    break;
                case 6:
                    tot_series.verMejoresEpisodios();
                    break;
            }
        }

    }

    public static TotSeries cargarDatos(TotSeries tot_Series) {
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        dataManager.cargarDatos(tot_Series);
        return tot_Series;
    }

}
