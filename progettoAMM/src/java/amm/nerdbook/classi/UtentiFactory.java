package amm.nerdbook.classi;

import java.util.ArrayList;
import amm.nerdbook.classi.*;

/**
 *
 * @author Giorgia Campanile
 */
public class UtentiFactory {

    private static UtentiFactory singleton;

    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtentiFactory() {
        //Creazione utenti

        //Violet
        Utente utente1 = new Utente();
        utente1.setIdUtente(1);
        utente1.setNome("Violet");
        utente1.setCognome("Baudelaire");
        utente1.setEmail("violet1999@gmail.com");
        utente1.setPassword("tredicipiudiciotto");
        utente1.setDataNascita("25/12/0000");
        utente1.setFrasePresentazione("Adoro costruire marchingegni. Hihi.");
        utente1.setUrlFoto("M2/immagini/violet.jpg");

        //Sunny
        Utente utente2 = new Utente();
        utente2.setIdUtente(2);
        utente2.setNome("Sunny");
        utente2.setCognome("Baudelaire");
        utente2.setEmail("sunnnypaxxerella@gmail.com");
        utente2.setPassword("99scimmie");
        utente2.setDataNascita("25/12/0000");
        utente2.setFrasePresentazione("Levigare con i dentini: troppo figo.");
        utente2.setUrlFoto("M2/immagini/sunny.jpg");

        //Klaus
        Utente utente3 = new Utente();
        utente3.setIdUtente(3);
        utente3.setNome("Klaus");
        utente3.setCognome("Baudelaire");
        utente3.setEmail("Klausssss23@gmail.com");
        utente3.setPassword("ehiguys");
        utente3.setDataNascita("25/12/0000");
        utente3.setFrasePresentazione("Libri di giurisprudenza e cannocchiali sono il mio forte!");
        utente3.setUrlFoto("M2/immagini/klaus.jpg");

        //Klaus
        Utente utente4 = new Utente();
        utente4.setIdUtente(4);
        utente4.setNome("Prova");
        utente4.setCognome("Baudelaire");
        utente4.setEmail("");
        utente4.setPassword("1234");
        utente4.setFrasePresentazione("Libri di giurisprudenza e cannocchiali sono il mio forte!");
        utente4.setUrlFoto("M2/immagini/klaus.jpg");

        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);

    }

    public Utente getUtenteById(int id) {
        for (Utente utente : this.listaUtenti) {
            if (utente.getIdUtente() == id) {
                return utente;
            }
        }
        return null;
    }

    //metodo da rivedere preso da gattender
   
    public int getIdByUserAndPassword(String user, String password) {
        for (Utente utente : this.listaUtenti) {
            if (utente.getNome().equals(user) && utente.getPassword().equals(password)) {
                return utente.getIdUtente();
            }
        }
        return -1;
    }

    
    public boolean controllo(int loggedUserID) {

        for (Utente utente : this.listaUtenti) {
            if (utente != null) {
                if (utente.getIdUtente() == loggedUserID) {
                    if (utente.profileControl(utente) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    public ArrayList<Utente> getListaUtenti(Utente utenteloggato) {
        ArrayList<Utente> nuovalista = new ArrayList<Utente>();
        for (Utente utente : this.listaUtenti) {
            if (utente != null) {
                if (!(utente.equals(utenteloggato))) {
                    nuovalista.add(utente);
                }
            }
        }
        return nuovalista;
    }

    
    public ArrayList<Utente> getListaUtenti() {

        return this.listaUtenti;

    }

}
