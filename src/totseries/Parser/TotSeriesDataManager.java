package totseries.Parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import totseries.Actor;
import totseries.Administrador;
import totseries.Artista;
import totseries.Catalogo;
import totseries.Cliente;
import totseries.Director;
import totseries.Episodio;
import totseries.Productora;
import totseries.Registro;
import totseries.Serie;
import totseries.Temporada;
import totseries.TotSeries;
import totseries.Valoracion;

/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries 
 * per a manegar l'aplicació de gestió de TotSeries.
 * 
 */
public class TotSeriesDataManager {

        Catalogo catalogo;
        Registro registro;

        public TotSeriesDataManager() {
            this.catalogo = new Catalogo();
            this.registro = new Registro();
        }
	/**
	 * Obté les dades del fitxer XML passat per paràmetre
	 * 
	 * @param nomFitxer ruta del fitxer XML del que obtenir les dades
	 */
	public void obtenirDades(String nomFitxer) {
		TotSeriesXMLParser parser = new TotSeriesXMLParser(this);
		parser.parse(nomFitxer);
	}
        
        public TotSeries cargarDatos(TotSeries totseries){
            totseries.setCatalogo(this.catalogo);
            totseries.setRegistro(this.registro);
            return totseries;
        }

	/**
	 * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la serie. El podeu utilitzar o no
	 * @param title títol de la serie
         * @param desc descripcio de la serie
	 */
	
	public void crearSerie(String id, String title, String desc) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova serie.
		 */
                
                Serie serie = new Serie(id, title, desc);
                catalogo.addSerie(serie);
//              System.out.println();
//		System.out.println("\nSerie amb ID: " + id);
//		System.out.println("--------------------------------------------------");
//		System.out.println("Titol: " + title);
//		System.out.println("Descripció: " + desc);
	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param numTemporada numero de la temporada
	 * @param numEpisodis numero d'episodis
         * 
	 */
	
	public void crearTemporada(String numTemporada, String numEpisodis) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova temporada.
		 */
                
                Temporada temporada=new Temporada(Integer.parseInt(numTemporada), Integer.parseInt(numEpisodis));
                catalogo.getLastSerie().addTemporada(temporada);
//		System.out.println("Temporada: " + numTemporada + " Numero Episodis: "+ numEpisodis);
//                System.out.println("--------------------------------------------------");

	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param title titol de lepisodi
	 * @param duration duració de l'episodi
         * @param idioma idioma de l'episodi V.O.
         * @param description sinopsi de l'episodi
         * @param data data d'estrena de l'episodi
         * 
	 */
	
	public void crearEpisodi(String title, String duration, String idioma, String description, String data){		

            try {
                /*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
                *  d'una nou episodi.
                */
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(data);
                Episodio episodio = new Episodio(title, duration, idioma, description, date);
                catalogo.getLastSerie().getLastTemporada().addEpisodio(episodio);
//                System.out.println(episodio.toString());
            } catch (ParseException ex) {
                System.out.println("Error al parsear Date");
            }
                
	}

	/**
	 * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del artista. El podeu utilitzar o no
	 * @param nom nom del artista
	 * @param tipus tipus (director\actor) del artista
	 * @param idSerie serie a la qual treballa. El podeu utilitzar o no
         * @param nacionalitat 
	 */

	public void crearArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {

		/* TODO: Aqui feu el necessari per a crear els artistes per a la serie
		 */
                if(tipus.equals("actor")){
                    Artista artista = new Actor(id, nom, nacionalitat);
                }
                else if(tipus.equals("director")){
                    Artista artista = new Director(id, nom, nacionalitat);
                }
                
//		System.out.println("\nArtista amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Tipus: " + tipus);
//		System.out.println("Serie ID: " + idSerie);
//                System.out.println("Nacionalitat: " + nacionalitat);
	}
	
		
	/**
	 * Crea productora del fitxer XML
	 * 
	 * @param id id de la productora
	 * @param nom nom de la productora
	 * @param idSerie id de la serie que va fer. El podeu utilitzar o no
	 */
	public void crearProductora (String id, String nom, String idSerie) {

		/* TODO: Aqui feu el necessari per a crear les productores per a les series
		 */
                Productora productora = new Productora(id, nom);
//		System.out.println("\nProductora amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Serie ID: " + idSerie);
	}

	/**
	 * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la valoracio. El podeu utilitzar o no
	 * @param client identificador del client. El podeu utilitzar o no
	 * @param episodi identificador de la serie. El podeu utilitzar o no
	 * @param puntuacio puntuacio donada al episodi
	 * @param data data en la que es va fer la puntuacio
	 */
	
	public void crearValoracio(String id, String client, String episodi, String puntuacio, String data) {

            try {
                /* TODO: A partir d'aqui creeu la valoracio
                */
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(data);
                
                Valoracion valoracion = new Valoracion(id, Integer.parseInt(puntuacio), date);
//                System.out.println("\nValoracio amb ID: " + id);
//                System.out.println("--------------------------------------");
//                System.out.println("Client: " + client);
//                System.out.println("Episodi: " + episodi);
//                System.out.println("Puntuacio: " + puntuacio);
//                System.out.println("Data: " + data);
            } catch (ParseException ex) {
                Logger.getLogger(TotSeriesDataManager.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	/**
	 * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del administrador
	 * @param nom nom del administrador
	 * @param usuari usuari del administrador
	 * @param password password del administrador
	 */
	public void crearAdmin(String id, String nom, String usuari, String password) {

		/* TODO: Creeu aqui el vostre admin
		 */
                Administrador administrador = new Administrador(id, usuari, password, nom); 
//		System.out.println("\nAdmin ID: " + id);
//		System.out.println("-----------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Usuari: " + usuari);
//		System.out.println("Password: " + password);
	}

	/**
	 * Crea un nou client a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del client
	 * @param nom nom del client
	 * @param dni dni del client
	 * @param adreca adreça del client
	 * @param usuari usuari al sistema del client
	 * @param password password del client
	 * @param vip true si el client es vip. false si no
	  */

	public void crearClient(String id, String nom, String dni, String adreca, String usuari, String password, String vip) {

		/* TODO: Creeu aqui el vostre client
		 */
                Cliente cliente = new Cliente(id, nom, dni, adreca, usuari, password, Boolean.valueOf(vip));
//		System.out.println("\nClient ID: " + id);
//		System.out.println("-----------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Usuari: " + usuari);
//		System.out.println("Dni: " + dni);
//		System.out.println("Adreça: " + adreca);
//		System.out.println("Password: " + password);
//		System.out.println("Es VIP: " + vip);
		
	}
}
