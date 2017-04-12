package amm.nerdbook.classi;

/**
 *
 * @author Giorgia Campanile
 */

public class Post {


    
    protected int idPost;
    protected Utente ut;
    private String testo;
    private String urlImmagine;
    private String link;
    private String imageUt;
    private String nomeUt;  
    private Gruppo gruppo; 
    
    public Post(){
        
        this.idPost = (-1);
        this.ut = null;
        this.testo = "";
        this.urlImmagine = "";
        this.link = "";
        this.gruppo=null;
    }
    
    /**
     * @return the idPost
     */
    public int getIdPost() {
        return this.idPost;
    }

    /**
     * @param idPost the idPost to set
     */
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    /**
     * @return the ut
     */
    public Utente getUt() {
        return this.ut;
    }

    /**
     * @param ut the ut to set
     */
    public void setUt(Utente ut) {
        this.ut = ut;
        this.imageUt=this.ut.getUrlFoto();  //trick da rivedere
        this.nomeUt=this.ut.getNome()+" "+this.ut.getCognome(); //trick da rivedere
    }
    
    
    /**
     * @return the testo
     */
    public String getTesto() {
        return this.testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @return the urlImmagine
     */
    public String getUrlImmagine() {
        return this.urlImmagine;
    }

    /**
     * @param urlImmagine the urlImmagine to set
     */
    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return this.link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    
    /**
     * @return the imageUt
     */
    public String getImageUt() {
        return imageUt;
    }

    /**
     * @param imageUt the imageUt to set
     */
    public void setImageUt(String imageUt) {
        this.imageUt = imageUt;
    }

    /**
     * @return the nomeUt
     */
    public String getNomeUt() {
        return nomeUt;
    }

    /**
     * @param nomeUt the nomeUt to set
     */
    public void setNomeUt(String nomeUt) {
        this.nomeUt = nomeUt;
    }
    
        /**
     * @return the gruppo
     */
    public Gruppo getGruppo() {
        return gruppo;
    }

    /**
     * @param gruppo the gruppo to set
     */
    public void setGruppo(Gruppo gruppo) {
        this.gruppo = gruppo;
    }

}
