/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import java.io.Serializable;

/**
 *
 * @author sylver
 */
public class Pelicula extends Lloguer {
    
    private int duracio;
    
    /*
    *   Constructor
    */
    
    public Pelicula (){
        
    }
    
    /*
    *   Gettes & Setters
    */

    public int getDuracio() {
        return duracio;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }
        
}
