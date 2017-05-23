package amm.nerdbook.classi;

/**
 *
 * @author Giorgia Campanile
 */

public class Utente {
    
    private int idUtente;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String email;
    private String password;
    private String frasePresentazione;
    private String urlFoto;
    private String tipo;
    
    public Utente(){
        
        this.idUtente = -1;
        this.nome = "";
        this.cognome = "";
        this.dataNascita = "";
        this.email = "";
        this.password = "";
        this.frasePresentazione = "";
    }
      /**
     * @return the idUtente
     */
    public int getIdUtente() {
        return idUtente;
    }

    /**
     * @param idUtente the idUtente to set
     */
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the frasePresentazione
     */
    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    /**
     * @param frasePresentazione the frasePresentazione to set
     */
    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }
    
     /**
     * @return the urlFoto
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * @param urlFoto the urlFoto to set
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Utente)
            if (this.getIdUtente() == ((Utente)obj).getIdUtente()) 
                return true;
        
        return false;
    }
    


    public boolean profileControl(Utente utente){

        if (utente.getNome().equals("") || utente.getCognome().equals("") || utente.getPassword().equals("")
                || utente.getUrlFoto().equals("") || utente.getEmail().equals("") || 
                utente.getFrasePresentazione().equals("") || utente.getDataNascita().equals("")) {
           
            return false;
        } else {
            return true;
        }

    }
    
}

