package totseries.Modelo.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    //Metodos de clase
    public void addSerie(Serie serie) {
        series.add(serie);
    }

    @Override
    public String toString() {
        String lista_series = "";
        for (Serie serie : series) {
            lista_series += serie.toString();
        }
        if (series.isEmpty()) {
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
        //throws new SerieNotFoundException("Serie con idSerie no encontrada");
        return null;
    }
    
    public List<Temporada> getTemporadas(String idSerie) {
        Serie serie = getSerie(idSerie);
        return serie.getTemporadas();
    }
    
    public Serie getLastSerie() {
        return series.get(series.size() - 1);
    }

    public boolean existSerie(String idSerie) {
        return this.getSerie(idSerie) != null;
    }

    public List<String> showCatalogo(){
        List<String> lista = new ArrayList();
        for (Serie serie : series) {
            lista.add(serie.getNombre());
        }
        return lista;
    }

    public List<Episodio> getEpisodiosMasValorados() {
        List<Episodio> lista = new ArrayList<>();
        series.forEach((serie) -> {
            lista.addAll(serie.getEpisodios());
        });
        Collections.sort(lista, (Episodio p1, Episodio p2) -> Float.compare(p2.getPromedio(), p1.getPromedio()));
        if (lista.isEmpty())return lista;
        return lista.subList(0, 10);
    }

    public List<Temporada> getTemporadasMasValoradas() {
        List<Temporada> lista = new ArrayList<>();
        series.forEach((serie) -> {
            lista.addAll(serie.getTemporadas());
        });
        Collections.sort(lista, (Temporada p1, Temporada p2) -> Float.compare(p2.getPromedio(), p1.getPromedio()));
        return lista.subList(0, 10);
    }

    public List<Serie> getSeriesMasValoradas() {
        List<Serie> lista = new ArrayList<>();
        Collections.sort(lista, (Serie p1, Serie p2) -> Float.compare(p2.getPromedio(), p1.getPromedio()));
        if (lista.isEmpty())return lista;
        return lista.subList(0, 10);
    }

    public List<Episodio> getEpisodiosMasVistos() {
        List<Episodio> lista = new ArrayList<>();
        series.forEach((serie) -> {
            lista.addAll(serie.getEpisodios());
        });
        Collections.sort(lista, (Episodio p1, Episodio p2) -> Float.compare(p2.countReproducciones(), p1.countReproducciones()));
        if (lista.isEmpty())return lista;
        return lista.subList(0, 10);
    }

    public List<Temporada> getTemporadasMasVistas() {
        List<Temporada> lista = new ArrayList<>();
        series.forEach((serie) -> {
            lista.addAll(serie.getTemporadas());
        });
        Collections.sort(lista, (Temporada p1, Temporada p2) -> Float.compare(p2.countReproducciones(), p1.countReproducciones()));
        return lista.subList(0, 10);
    }

    public List<Serie> getSeriesMasVistas() {
        List<Serie> lista = new ArrayList<>(series);
        Collections.sort(series, (Serie p1, Serie p2) -> Float.compare(p2.countReproducciones(), p1.countReproducciones()));
        return lista.subList(0, 10);
    }
    
    public List<String> showTemporada(String idSerie) {
        for (Serie serie : this.series) {
            if (serie.equals(idSerie)) {
                return serie.showTemporada();
            }
        }
        return null;
    }

    public List<String> showEpisodio(String idSerie, int idTemporada) {
        for (Serie serie : this.series) {
            if (serie.equals(idSerie)) {
                return serie.showEpisodio(idTemporada);
            }
        }
        return null;
    }

    public List<Episodio> getEpisodio(String idSerie, int idTemporada) {
        for (Serie serie : series) {
            if (serie.getId().equals(idSerie)) {
                return serie.getEpisodio(idTemporada);
            }
        }
        //throws new SerieNotFoundException("Serie con idSerie no encontrada");
        return null;
    }

    public String getDescripcion(String idSerie) {
        for (Serie serie : this.series) {
            if (serie.equals(idSerie)) {
                return serie.getDescripcion();
            }
        }
        return null;
    }
    
    public List getSeries(){
        return series;
    }
    /////Sin uso
    public boolean existeEpisodio(String idSerie, int idTemporada, int idEpisodio) {
        for (Serie serie : series) {
            if (serie.getId().equals(idSerie)) {
                return serie.existeEpisodio(idTemporada, idEpisodio);
            }
        }
        return false;
    }
    ////Sin Uso
    public Episodio getEpisodio(String idSerie, int idTemporada, int idEpisodio) {
        if (this.existeEpisodio(idSerie, idTemporada, idEpisodio)) {
            return this.getSerie(idSerie).getEpisodio(idTemporada, idEpisodio);
        } else {
            return null;
        }
    }
    ////Sin Uso
    public String verEpisodios(String idSerie, int idTemporada) {
        Serie serie = getSerie(idSerie);
        if (serie == null) {
            return "No existe Serie\n";
        }
        return serie.verEpisodios(idTemporada);
    }

}
