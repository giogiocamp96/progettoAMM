package amm.nerdbook;

import amm.nerdbook.classi.GruppiFactory;
import amm.nerdbook.classi.Gruppo;

import amm.nerdbook.classi.UtentiFactory;
import amm.nerdbook.classi.Utente;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Profilo extends HttpServlet {

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

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {

            String user = request.getParameter("user");

            int userID;

            if (user != null) {
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer) session.getAttribute("UserID");
                userID = loggedUserID;
            }

            this.profileManagement(userID, request, session, response);

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

    public void profileManagement(int userID, HttpServletRequest request, HttpSession session, HttpServletResponse response)
            throws ServletException, IOException {

        Utente utente = UtentiFactory.getInstance().getUtenteById(userID);
        if (utente != null) {

            if (request.getParameter("flag") != null) {

                this.dataProfile(session, request);

            } else {

                request.setAttribute("utente", utente);

            }
            List<Utente> ListaUtenti = UtentiFactory.getInstance().getListaUtenti(utente);
            request.setAttribute("ListaUtenti", ListaUtenti);

            request.getRequestDispatcher("/M3/profilo.jsp").forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    public void dataProfile(HttpSession session, HttpServletRequest request) {

        String nome = request.getParameter("nome");
        request.setAttribute("nome", nome);

        String cognome = request.getParameter("cognome");
        request.setAttribute("cognome", cognome);

        String foto = request.getParameter("foto");
        request.setAttribute("foto", foto);

        String dataNascita = request.getParameter("dataNascita");
        request.setAttribute("dataNascita", dataNascita);

        String email = request.getParameter("email");
        request.setAttribute("email", email);

        String pswd = request.getParameter("pswd");
        request.setAttribute("pswd", pswd);

        String frase = request.getParameter("frase");
        request.setAttribute("frase", frase);

        request.setAttribute("flag", true);
    }

}
