package amm.nerdbook.classi;

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
public class UtentiFactory {

    private static UtentiFactory singleton;
    private String connectionString;

    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtentiFactory() {

    }

    public Utente getUtenteById(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "giorgia", "gio");

            String query = "select * from utente "
                    + "where id =?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Utente current = new Utente();
                current.setIdUtente(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setUrlFoto(res.getString("urlFoto"));

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdByUserAndPassword(String user, String password) {
        try {

            Connection conn = DriverManager.getConnection(connectionString, "giorgia", "gio");

            String query
                    = "select id from utente "
                    + "where nome = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user);
            stmt.setString(2, password);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        try {
            Connection conn = DriverManager.getConnection(connectionString, "giorgia", "gio");

            String query = "select * from utente ";

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Utente current = new Utente();
                current.setIdUtente(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setUrlFoto(res.getString("urlFoto"));

                nuovalista.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nuovalista;
    }

    public ArrayList<Utente> getListaUtenti() {

        return this.listaUtenti;

    }

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    public void eliminaUtente(Utente u) {

        String query;
        PreparedStatement stmt;
        Connection connessione;

        try {

            connessione = DriverManager.getConnection(connectionString, "giorgia", "gio");

            query = "delete from gruppo " + "where adminG = ?";
            stmt = connessione.prepareStatement(query);
            stmt.setInt(1, u.getIdUtente());
            stmt.executeUpdate();

            query = "delete from appartenenza " + "where id_utente = ?";
            stmt = connessione.prepareStatement(query);
            stmt.setInt(1, u.getIdUtente());
            stmt.executeUpdate();

            query = "delete from amicizia " + "where id_ut1 = ? or id_ut2 = ?";
            stmt = connessione.prepareStatement(query);
            stmt.setInt(1, u.getIdUtente());
            stmt.setInt(2, u.getIdUtente());
            stmt.executeUpdate();

            query = "delete from utente " + "where id = ?";
            stmt = connessione.prepareStatement(query);
            stmt.setInt(1, u.getIdUtente());
            stmt.executeUpdate();

            stmt.close();
            connessione.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
