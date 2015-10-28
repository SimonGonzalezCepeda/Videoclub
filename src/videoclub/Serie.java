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
public class Serie extends Lloguer {
    
    private boolean emissio = true; 
    
    private int totalTemporades;
    
    /*
    *   Constructor.
    */
    
    public Serie(){
        
    }
    
    /*
    *   Getters & Setters
    */

    public boolean isEmissio() {
        return emissio;
    }

    public void setEmissio(boolean emissio) {
        this.emissio = emissio;
    }

    public int getTotalTemporades() {
        return totalTemporades;
    }

    public void setTotalTemporades(int totalTemporades) {
        this.totalTemporades = totalTemporades;
    }
    
    
            
}
