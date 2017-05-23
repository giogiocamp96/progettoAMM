package amm.nerdbook;

import amm.nerdbook.classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Giorgia Campanile
 */

@WebServlet (loadOnStartup = 0)

public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       // request.getRequestDispatcher("login.jsp").forward(request, response);
        
       /** ripreso da gatteender, da elaborare*/
        HttpSession session = request.getSession();
        
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("/M3/login.jsp").forward(request, response);
            return;
        }
        
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {

            request.getRequestDispatcher("Bacheca").forward(request, response);
            return;
        
       
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("pswd");
        
            
            if (username != null && password != null) 
            {
                int UserID = UtentiFactory.getInstance().getIdByUserAndPassword(username, password);
                
                
                if(UserID!=-1)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("UserID", UserID);
                    
                    Utente utente = UtentiFactory.getInstance().getUtenteById(UserID);

                if (utente.profileControl(utente) == true) {
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                    return;
                } else {
                    request.getRequestDispatcher("Profilo").forward(request, response);
                    return;
                }
            
                } else { 
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("/M3/login.jsp").forward(request, response);
                    return;
                }
                
                
            }
        }
        
        request.getRequestDispatcher("/M3/login.jsp").forward(request, response);
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
    
    @Override
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
           Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtentiFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
        GruppiFactory.getInstance().setConnectionString(dbConnection);
        
   }
}
