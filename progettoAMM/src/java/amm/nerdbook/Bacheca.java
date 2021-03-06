package amm.nerdbook;

import amm.nerdbook.classi.GruppiFactory;
import amm.nerdbook.classi.Gruppo;
import amm.nerdbook.classi.Utente;
import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.UtentiFactory;
import amm.nerdbook.classi.PostFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giorgia Campanile
 */
public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        
        List<Gruppo> listaGruppi = GruppiFactory.getInstance().getListaGruppi();
        request.setAttribute("listaGruppi", listaGruppi);

        if (request.getParameter("postinviato") != null) {
            request.setAttribute("postinviato", true);
        }

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {

            String user = request.getParameter("user");

            int userID;

            if (user != null) {
                userID = Integer.parseInt(user);
            } else {
                Integer UserID = (Integer) session.getAttribute("UserID");
                userID = UserID;
            }

            Utente utente = UtentiFactory.getInstance().getUtenteById(userID);
            if (utente != null) {
                request.setAttribute("utente", utente);
                
            if (request.getParameter("inviopost") != null) {
                this.newPost(utente, request, session, response);
            }

            
                List<Utente> listaUtenti = UtentiFactory.getInstance().getListaUtenti(utente);
                request.setAttribute("listaUtenti", listaUtenti);

                if (request.getParameter("postgruppivisualizzati") != null) {

                    String idGroup = request.getParameter("idGruppoSideBar");
                    int idGruppo = Integer.parseInt(idGroup);
                    List<Post> posts = PostFactory.getInstance().getPostListGruppi(idGruppo);
                    request.setAttribute("posts", posts);
                    request.setAttribute("postgruppivisualizzati", null);

                } else {

                    if (request.getParameter("postvisualizzati") != null) {

                        if (request.getParameter("idUsers") != null) {
                                
                            String tmp = request.getParameter("idUsers");
                            session.setAttribute("tmp", tmp);
                            int idDaVisualizzare = Integer.parseInt(tmp);

                            List<Post> posts = PostFactory.getInstance().getPostListBachecaUtente(UtentiFactory.getInstance().getUtenteById(idDaVisualizzare));
                            Collections.reverse(posts);
                            request.setAttribute("posts", posts);
                            request.setAttribute("postvisualizzati", null);

                        } else {

                            List<Post> posts = PostFactory.getInstance().getGlobalPostList();
                            request.setAttribute("posts", posts);
                            request.setAttribute("postvisualizzati", null);
                        }

                    } else {

                        List<Post> posts = PostFactory.getInstance().getPostList(utente);
                        Collections.reverse(posts);
                        request.setAttribute("posts", posts);
                    }
                }
              

                request.getRequestDispatcher("/M3/bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            request.getRequestDispatcher("/M3/login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void newPost(Utente utente, HttpServletRequest richiesta, HttpSession session, HttpServletResponse response)
    throws ServletException, IOException {
    
        if(richiesta.getParameter("inviopost") != null) {
            
            String testo = richiesta.getParameter("testopost");
            String immagine = richiesta.getParameter("immaginepost");
            String link = richiesta.getParameter("linkpost");
            
            Post post = new Post();
            
            post.setTesto(testo);
            post.setLink(link);
            post.setUrlImmagine(immagine);
            post.setUt(utente);
            
            if(session.getAttribute("tmp")!= null){
                post.setBachecaUtente(Integer.parseInt((String)session.getAttribute("tmp")));
            }
            else{
                post.setBachecaUtente(utente.getIdUtente());
            }
            if(testo != null || immagine != null || link != null){
            
                PostFactory.getInstance().addNewPost(post);
                richiesta.removeAttribute("inviopost");
                response.setIntHeader("Refresh", 0);
            }
            

        }
    }
            
}





