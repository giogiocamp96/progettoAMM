package amm.nerdbook.classi;

import java.util.List;
import java.util.ArrayList;
import amm.nerdbook.classi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Giorgia Campanile
 */
public class PostFactory {

    private static PostFactory singleton;
    private String connectionString;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {

    }

//    public Post getPostById(int id) {
//       
//        UtentiFactory utentiFactory = UtentiFactory.getInstance();
//        
//        try {
//            // path, username, password
//            Connection conn = DriverManager.getConnection(connectionString, "giorgia", "gio");
//            
//            String query = 
//                      "select * from post "
//                    + "where idPost = ?";
//            
//            PreparedStatement stmt = conn.prepareStatement(query);
//            
//            stmt.setInt(1, id);
//            ResultSet res = stmt.executeQuery();
//            
//            if (res.next()) {
//                Post current = new Post();
//                current.setIdPost(res.getInt("id"));
//                current.setTesto(res.getString("testo"));
//                current.setUrlImmagine
//                current.setLink   
//                        
//                Gatto autore = gattoFactory.getGattoById(res.getInt("author"));
//                current.setUser(autore);
//
//                stmt.close();
//                conn.close();
//                return current;
//            }
//
//            stmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public List getPostList(Utente obj) {

        ArrayList<Post> nuovaListaPost = new ArrayList<Post>();

        try{
            
            Connection connessione = DriverManager.getConnection(connectionString, "giorgia", "gio");
            
            String query = "select * from post "
                            + " where idUtente = ?";
            PreparedStatement statem = connessione.prepareStatement(query);
            
            statem.setInt(1, obj.getIdUtente());
            
            ResultSet res = statem.executeQuery();
            
            while(res.next()){
                Post current = new Post();
                
                current.setIdPost(res.getInt("id"));
                current.setTesto(res.getString("testo"));
                current.setLink(res.getString("urlLink"));
                current.setUrlImmagine(res.getString("UrlImmagine"));
                current.setUt(obj);
                
                nuovaListaPost.add(current);
                
            }
            
            statem.close();
            connessione.close();
            
        }catch(SQLException e){
            e.printStackTrace();
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
    
    public void addNewPost(Post nuovo) {
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "giorgia", "gio");
        
            String query = "insert into post (id, testo, urlImmagine, urlLink, idUtente) "
                            + "values (default, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nuovo.getTesto());
            stmt.setString(2, nuovo.getUrlImmagine());
            stmt.setString(3, nuovo.getLink());
            stmt.setInt(4, nuovo.getUt().getIdUtente());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
  
}
