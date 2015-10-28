/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import java.util.Date;

/**
 *
 * @author sylver
 */
public class Historic {
    
    private Date diaLloguer = new Date();
    
    private Date diaEntrega = new Date();
    
    public Usuari usuari;
    
    public Lloguer lloguer;
    
    public Historic (Usuari usuari, Lloguer lloguer){
        this.usuari = usuari;
        this.lloguer = lloguer;
    }
    
    public void Llogar(){
        
    }
    
    public void Entregar(){
        
    }
    
    public void DesarHistoric(){
        
    }
    
}
