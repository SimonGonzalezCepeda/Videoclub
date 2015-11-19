/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author sylver
 */
public class Historic implements Serializable {
    
    private Date diaLloguer = new Date();
    
    private Date diaEntrega = new Date();
    
    public Usuari usuari;
    
    public Lloguer lloguer;
    
    /*
    *   Constructor
    */
    
    public Historic (Usuari usuari, Lloguer lloguer){
        this.usuari = usuari;
        this.lloguer = lloguer;
    }
    
    /*
    *   Funcions
    */
    
    /*
    *   Aquest mètode s'encarrega de dir que una pel.licula passa a ser càrrec d'un
    *   usuari. Genera el dia de creació i el d'entrega.
    *
    */
    
    public void Llogar(){
        
    }
    
    /*
    *   Aquest mètode ratifica que un usuari ha tornat una pel.licula.
    *
    */
    
    public void Entregar(){
        
    }
    
    /*
    *   Aquest mètode s'encarrega de desar tot l'històric.
    *
    */
    
    public void DesarHistoric(){
        
    }
    
    /*
    *   Getters & Setters
    */

    public Date getDiaLloguer() {
        return diaLloguer;
    }

    public void setDiaLloguer(Date diaLloguer) {
        this.diaLloguer = diaLloguer;
    }

    public Date getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(Date diaEntrega) {
        this.diaEntrega = diaEntrega;
    }
    
    
    
}
