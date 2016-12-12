/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import totseries.Parser.TotSeriesDataManager;
import totseries.vista.MainVista;

/**
 *
 * @author mrviciao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TotSeries tot_series = new TotSeries();
        tot_series = cargarDatos(tot_series);

        //Este es un usuario que esta aqui para no hacer login.
        Cliente user = new Cliente("c0", "test", "test", "test");
        tot_series.setActualCliente(user);

        //MainVista mv = new MainVista();
        //mv.main(null);
        Menu menu = new Menu(tot_series);
        menu.run();
    }

    public static TotSeries cargarDatos(TotSeries tot_Series) {
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        tot_Series = dataManager.cargarDatos(tot_Series);
        return tot_Series;
    }

}
