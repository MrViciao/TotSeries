package Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Abel
 */
public class Catalogo {
    
    private List<Serie> series;
    
    public Catalogo(){
        this.series = new ArrayList<>();
    }
   
    public boolean existeEpisodio(String idSerie, int idTemporada, String idEpisodio){
        Iterator<Serie> iterador = this.series.iterator();
        while(iterador.hasNext()){
            if(iterador.next().equals(idSerie))
               return iterador.next().existeEpisodio(idTemporada, idEpisodio);
        }
        return false;
    }
    public String getMejoresEpisodios(){
        String lista="";
        Iterator<Serie> iterador = this.series.iterator();
        while(iterador.hasNext())
            lista += iterador.next().getMejoresEpisodio();
        return lista;
    }
    public Episodio verEpisodio(String idSerie, int idTemporada, String idEpisodio){
        if(this.existeEpisodio(idSerie,idTemporada,idEpisodio)){
            return this.getSerie(idSerie).verEpisodio(idTemporada,idEpisodio);
        }else
            return NULL;
    }
    public void addSerie(Serie serie){
        series.add(serie);
    }
    
    @Override
    public String toString(){
        String lista="";
        Iterator<Serie> iterador=this.series.iterator();
        while(iterador.hasNext()){
            lista+=iterador.next().toString();
        }
        return lista;
    }
    public Serie getSerie(String idSerie){
        Iterator<Serie> iterador = this.series.iterator();
        while(iterador.hasNext()){
            if(iterador.next().equals(idSerie))
               return iterador.next();
        }
        return NULL;
}
