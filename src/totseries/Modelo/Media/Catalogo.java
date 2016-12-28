package totseries.Modelo.Media;

import java.util.ArrayList;
import java.util.List;
import totseries.Parser.Consola;

/**
 *
 * @author Abel
 */
public class Catalogo {

    private List<Serie> series;

    public Catalogo() {
        this.series = new ArrayList<>();
    }

    //metodos de sin responsabilidad
    /////////////////
    public boolean existeEpisodio(String idSerie, int idTemporada, int idEpisodio) {
        for (Serie serie : series) {
            if (serie.getId().equals(idSerie)) {
                return serie.existeEpisodio(idTemporada, idEpisodio);
            }
        }
        return false;
    }

    public ArrayList<Episodio> getMejoresEpisodio() {
        ArrayList<Episodio> lista = new ArrayList();
        for (Serie serie : series) {
            lista.addAll(serie.getMejoresEpisodio());
        }
        return lista;
    }

    public Episodio getEpisodio(String idSerie, int idTemporada, int idEpisodio) {
        if (this.existeEpisodio(idSerie, idTemporada, idEpisodio)) {
            return this.getSerie(idSerie).getEpisodio(idTemporada, idEpisodio);
        } else {
            return null;
        }
    }

    public List<Temporada> getTemporadas(String idSerie) {
        Serie serie = getSerie(idSerie);
        return serie.getTemporadas();
    }

    public String verEpisodios(String idSerie, int idTemporada) {
        Serie serie = getSerie(idSerie);
        if (serie == null) {
            return "No existe Serie\n";
        }
        return serie.verEpisodios(idTemporada);
    }

    //Metodos de clase
    /////////////////
    public void addSerie(Serie serie) {
        series.add(serie);
    }

    @Override
    public String toString() {
        String lista_series = "";
        for (Serie serie : series) {
            lista_series += serie.toString();
        }
        if (series.size() == 0) {
            lista_series = "No hay series";
        }
        return lista_series;
    }

    public Serie getSerie(String idSerie){
        for (Serie serie : series) {
            if (serie.getId().equals(idSerie)) {
                return serie;
            }
        }
        //throws new SerieNotFoundException("Serie con idSerie no encontrada");
        return null;
    }

    public Serie getLastSerie() {
        return series.get(series.size() - 1);
    }

    public boolean existSerie(String idSerie) {
        if (this.getSerie(idSerie) == null) {
            return false;
        }
        return true;
    }
    
    public void showCatalogo(){
        Consola.escriu(this.toString());
    }

}
