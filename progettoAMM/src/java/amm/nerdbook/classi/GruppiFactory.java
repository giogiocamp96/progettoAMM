/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;

/**
 *
 * @author Giorgia Campanile
 */
public class GruppiFactory {
    
    private static GruppiFactory singleton;
    private String connectionString;

    public static GruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppiFactory();
        }
        return singleton;
    }
    
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private GruppiFactory() {
               
        Gruppo gruppo0 = new Gruppo();
        gruppo0.setIdGruppo(0);
        gruppo0.setNome("Ignoranti disagiati");
        gruppo0.setUrlFoto("M3/immagini");
        gruppo0.setFrase("");
     
     
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setIdGruppo(1);
        gruppo1.setNome("Sesi de Murera se...");
        gruppo1.setUrlFoto("M3/immagini");
        gruppo1.setFrase("");
                        
                    
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setIdGruppo(2);
        gruppo2.setNome("Fotografia");
        gruppo2.setUrlFoto("M3/immagini");
        gruppo2.setFrase("");
        
        
        this.listaGruppi.add(gruppo0);
        this.listaGruppi.add(gruppo1);
        this.listaGruppi.add(gruppo2);
    }
    
     
    public ArrayList<Gruppo> getListaGruppi() {

        return this.listaGruppi;
    }
    
    public Gruppo getGruppiById(int id) {
        for (Gruppo gruppi : this.listaGruppi) {
            if (gruppi.getIdGruppo() == id) {
                return gruppi;
            }
        }
        return null;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }
    
}
