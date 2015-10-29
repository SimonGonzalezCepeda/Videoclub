/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.ArrayList;

/**
 *
 * @author sylver
 */
public class Serie extends Lloguer {
    
    private boolean emissio = true; 
    
    private int totalTemporades;
    
    ArrayList<Temporada> temporadas;
    
    /*
    *   Constructor.
    */
    
    public Serie(){
        //hem d'afegir les temporades.
        temporadas = new ArrayList<Temporada>();
        temporadas.add();
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
