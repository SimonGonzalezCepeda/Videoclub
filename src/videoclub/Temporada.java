/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

/**
 *
 * @author sylver
 */
public class Temporada extends Serie {
    
    private int numeroTemporada, totalCapitols;
    
    /*
    *   Constructor.
    */
    
    public Temporada(){
        
    }
    
    /*
    *   Getters and Setters
    */

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getTotalCapitols() {
        return totalCapitols;
    }

    public void setTotalCapitols(int totalCapitols) {
        this.totalCapitols = totalCapitols;
    }
    
    
}
