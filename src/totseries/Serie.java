package totseries;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abel
 */
public class Serie {

    private String id;
    private String titulo;
    private String descripcion;
    private List<Temporada> temporadas;
    private List<Artista> artistas;
    private List<Artista> productora;

    public Serie(String id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.artistas = new ArrayList<>();
        this.productora = new ArrayList<>();
        this.temporadas = new ArrayList<>();
    }

    //metodos de sin responsabilidad
    /////////////////
    public String getMejoresEpisodio() {
        String lista = "";
        for (Temporada temporada : temporadas) {
            lista += temporada.getMejoresEpisodio();
        }
        return lista;
    }

    public boolean existeEpisodio(int idTemporada, int idEpisodio) {
        for (Temporada temporada : temporadas) {
            if (temporada.getId() == idTemporada) {
                return temporada.existeEpisodio(idEpisodio);
            }
        }
        return false;
    }

    public Episodio verEpisodio(int idTemporada, int idEpisodio) {
        return find(idTemporada).verEpisodio(idEpisodio);
    }
    
    public String verEpisodios(int idTemporada) {
        Temporada temporada = find(idTemporada);
        if(temporada==null) return "No existe temporada\n";
        return temporada.verEpisodios();
    }

    //Metodos de clase
    /////////////////
    public void addTemporada(Temporada temporada) {
        if (hasTemporada(temporada.getId())) {
            return;
        }
        temporadas.add(temporada);
    }

    public Temporada getLastTemporada() {
        if (temporadas.isEmpty()) {
            return null;
        }
        return temporadas.get(temporadas.size() - 1);
    }

    public String verTemporadas() {
        String lista = "";
        for (Temporada temporada : temporadas) {
            lista += temporada.toString();
        }
        if (lista.equals("")) {
            lista = "No hay temporadas disponibles para esta serie";
        }
        return lista;
    }

    public boolean hasTemporada(int idTemporada) {
        for (Temporada temporada : temporadas) {
            if (temporada.getId() == idTemporada) {
                if (temporada.getId() == idTemporada) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String string = "\nTitol: " + titulo + " - " + id
                + " \nTemporadas:" + temporadas.size()
                + "\nDescripcion: " + descripcion + "\n";
        return string;
    }

    //Metodos getter/setter
    /////////////////
    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }
    
    public Temporada find(int idTemporada){
        for (Temporada temporada : temporadas){
            if (temporada.getId()==idTemporada) return temporada;
        }
        return null;
    }

}
