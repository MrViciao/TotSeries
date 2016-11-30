package totseries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public String getMejoresEpisodios() {
        String lista = "";
        for (Serie serie : series) {
            lista += serie.getMejoresEpisodio();
        }
        if (lista.isEmpty()) {
            lista = "Ninguno de nuestros episodios tiene una media suficiente."
                    + "\nPrueba a valorar una serie para subir su nota\n";
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

    public String verTemporadas(String idSerie) {
        Serie serie = getSerie(idSerie);
        if (serie == null) {
            return "No existe Serie\n";
        }
        return serie.verTemporadas();
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

    public Serie getSerie(String idSerie) {
        for (Serie serie : series) {
            if (serie.getId().equals(idSerie)) {
                return serie;
            }
        }
        return null;
    }

    public Serie getLastSerie() {
        return series.get(series.size() - 1);
    }

}
