/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

/**
 *
 * @author Simón & Pau
 */
public class Usuari {
    
    private String nom = new String();
    
    private String cognoms = new String();
    
    private String dni = new String();
    
    private String direccio = new String();
    
    private String ciutat = new String();
    
    private int telefon, numTargeta, codiPostal;
    
    /*
    *   Constructor
    */
    
    public Usuari(){
        
    }
    
    /*
    *   Funcions
    */
    
    /*
    *   Aquest mètode s'encarrega de registrar un Usuari.
    *
    */
    
    public void Registrar(){
        
    }
    
    /*
    *   Aquest mètode permet al seu Usuari editar el seu perfil.
    *
    */
    
    public void Editar(){
        
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

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getNumTargeta() {
        return numTargeta;
    }

    public void setNumTargeta(int numTargeta) {
        this.numTargeta = numTargeta;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }
        
    
}
