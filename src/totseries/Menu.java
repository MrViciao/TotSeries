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
        tot_series=cargarDatos(tot_series);
        int selected=1;
        while(selected!=0){
            Consola.printMenu();
            selected=Consola.llegeixInt();
        }
        
        
    }
    
    public static TotSeries cargarDatos(TotSeries tot_Series){
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        dataManager.cargarDatos(tot_Series);
        return tot_Series;
    }
    
    
}
