/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Simón & Pau
 */
public class Lloguer implements Serializable{
    
    private String nom = new String();
    
    private String categoria = new String();
    
    private String sinopsis = new String();
    
    private String productora = new String();
    
    private int any;
    
    private boolean disponible = true; // Creem que en principi sempre tindrem un item.
    
    ArrayList <Usuari> usuaris;
    
    /*
    *   Constructor
    */
    
    public Lloguer(){
        
    }
    
    /*
    *   Funcions
    */
    
    /*
    *   Aquesta funció s'encarrega de que al llogar o retorna un item (peli o serie)
    *   la boolear disponible cambie mostrant la seva disponibilitat de forma correcta.
    *
    */
    
    
    public void MostrarDisponibilitat(){
        
    }
    
    /*
    *   Getters & Setters
    */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
