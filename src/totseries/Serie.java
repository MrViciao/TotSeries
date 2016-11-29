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
    private Productora productora;

    public Serie() {
        this.temporadas=new ArrayList<>();
        this.id = "";
        this.titulo = "";
        this.descripcion = "";
        this.artistas= new ArrayList<>();
        this.productora = null;
    }

    public Serie(String id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.artistas= new ArrayList<>();
        this.productora = new Productora();
        this.temporadas= new ArrayList<>();
    }

    @Override
    public String toString() {
        String string="\nTitol: " + titulo + " - " + id
                        +" \nTemporadas:" + temporadas.size()
                        +"\nDescripcion: " + descripcion + "\n";
        return string;
    }
    
    public String getMejoresEpisodio() {
        String lista = "";
        for (Temporada temporada : temporadas) {
            lista += temporada.getMejoresEpisodio();
        }
        return lista;
    }

    public boolean existeEpisodio(int idTemporada, String idEpisodio) {
        if(idTemporada >= 0 && idTemporada < this.temporadas.size())
            return this.temporadas.get(idTemporada).existeEpisodio(idEpisodio);
        else
            return false;
    }
    
    public Episodio verEpisodio(int idTemporada,String idEpisodio){
        return this.temporadas.get(idTemporada).verEpisodio(idEpisodio);
    }
    
    public String getId() {
        return id;
    }
    public void setId(String Id) {
        this.id = Id;
    }
    
    public void addTemporada(Temporada temporada){
        temporadas.add(temporada);
    }
    
    public Temporada getLastTemporada(){
        if(temporadas.isEmpty()) return null;
        return temporadas.get(temporadas.size()-1);
    }
    public boolean equals (String idSerie){
        return this.id.equals(idSerie);
    }
}
