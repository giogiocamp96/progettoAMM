package amm.nerdbook.classi;

import java.util.List;
import java.util.ArrayList;
import amm.nerdbook.classi.*;

/**
 *
 * @author Giorgia Campanile
 */
public class PostFactory {

    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {

        UtentiFactory utentiFactory = UtentiFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setTesto("Il Conte avrà una sorpresina grazie alla mia nuova invenzione! Ahahah!");
        post1.setIdPost(1);
        post1.setUt(utentiFactory.getUtenteById(1));
        post1.setUrlImmagine("M3/immagini/olaf.jpg");

        Post post2 = new Post();
        post2.setTesto("Mi hanno appena regalato una trottola di legno, ma l'ho mangiata! ;)");
        post2.setIdPost(2);
        post2.setUt(utentiFactory.getUtenteById(2));

        Post post3 = new Post();
        post3.setTesto("Questa è la brutta copia del mio cannocchiale speciale. #povery");
        post3.setIdPost(3);
        post3.setUt(utentiFactory.getUtenteById(3));
        post3.setLink("https://it.wikipedia.org/wiki/Cannocchiale");

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getIdPost() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(Utente obj) {

        ArrayList<Post> nuovaListaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUt().equals(obj)) {
                nuovaListaPost.add(post);
            }
        }
        return nuovaListaPost;
    }

    public List getPostListforId(int userID) {

        Utente utente = UtentiFactory.getInstance().getUtenteById(userID);
        List<Post> lista = PostFactory.getInstance().getPostList(utente);

        return lista;
    }
    
    public List getGlobalPostList() {

     
        return this.listaPost;
    }

    public List getPostListGruppi(int idGruppo) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getGruppo() != null) {
                if (post.getGruppo().getIdGruppo() == idGruppo) {
                    listaPost.add(post);
                }
            }
        }
        return listaPost;
    }
}
