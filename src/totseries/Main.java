/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import totseries.Controlador.TotSeries;
import totseries.Modelo.Usuario.AdministradorCreator;
import totseries.Modelo.Usuario.Cliente;
import totseries.Modelo.Usuario.Usuario;
import totseries.Modelo.Usuario.ClienteCreator;
import totseries.Parser.TotSeriesDataManager;
import totseries.Vista.MainVista;

/**
 *
 * @author mrviciao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TotSeries tot_series = TotSeries.getInstance();
        tot_series = cargarDatos(tot_series);

        //Este es un usuario que esta aqui para no hacer login.
        AdministradorCreator cc = new AdministradorCreator();
        Usuario user = cc.createUsuario("c0", "test", "test", "test");
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
