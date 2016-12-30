package totseries.Modelo.Media;

import java.util.ArrayList;
import java.util.List;
import totseries.Modelo.Artista;
import totseries.Modelo.Productora;

/**
 *
 * @author Abel
 */
public class Serie{

    private String id;
    private String titulo;
    private String descripcion;
    private List<Temporada> temporadas;
    private List<Artista> artistas;
    private List<Productora> productora;

    public Serie(String id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.artistas = new ArrayList<>();
        this.productora = new ArrayList<>();
        this.temporadas = new ArrayList<>();
    }

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
    //// si no hay una temporada no deberia existir la serie
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
        /*
        String string = "\nTitol: " + titulo + " - " + id
                + " \nTemporadas:" + temporadas.size()
                + "\nDescripcion: " + descripcion + "\n";
        return string;
    */
        return titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }
    
    public List<Temporada> getTemporadas(){
        return temporadas;
    }
    
    public int countReproducciones(){
        int total=0;
        for(Temporada temporada : temporadas){
            total+=temporada.countReproducciones();
        }
        return total;
    }
    
    public List getEpisodios(){
        List<Episodio> episodios=new ArrayList<>();
        for (Temporada temporada : temporadas){
            episodios.addAll(temporada.getEpisodios());
        }
        return episodios;
    }
    
    public float getPromedio() {
        float total = 0;
        for (Temporada temporada : temporadas) {
            total += temporada.getPromedio();
        }
        return total / temporadas.size();
    }
    
    public List<Episodio> getEpisodio(int idTemporada){
        for (Temporada temporada : temporadas){
            if (temporada.getId()==idTemporada)
                return this.temporadas.get(idTemporada).getEpisodio();   
        }
        return null;
    }
    
    public String getNombre(){
        return this.titulo;
    }

    public List<String> showTemporada() {
        List<String> lista = new ArrayList<>();
        for (Temporada tempo: this.temporadas){
            lista.add(tempo.showTemporada());
        }
        return lista;
    }
    
    public List<String> showEpisodio(int idTemporada){
        for (Temporada temporada : temporadas){
            if (temporada.getId()==idTemporada)
                return this.temporadas.get(idTemporada).showEpisodio();   
        }
        return null;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    //// SIN USO    
    public boolean existeEpisodio(int idTemporada, int idEpisodio) {
        for (Temporada temporada : temporadas) {
            if (temporada.getId() == idTemporada) {
                return temporada.existeEpisodio(idEpisodio);
            }
        }
        return false;
    }
    ///sin uso
    public Episodio getEpisodio(int idTemporada, int idEpisodio) {
        return find(idTemporada).getEpisodio(idEpisodio);
    }
    //// sin uso
    public String verEpisodios(int idTemporada) {
        Temporada temporada = find(idTemporada);
        if(temporada==null) return "No existe temporada\n";
        return temporada.verEpisodios();
    }
    //// sin uso
    public Temporada find(int idTemporada){
        for (Temporada temporada : temporadas){
            if (temporada.getId()==idTemporada) return temporada;
        }
        return null;
    }
}
