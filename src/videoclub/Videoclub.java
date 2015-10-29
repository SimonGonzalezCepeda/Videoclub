/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Simón i Pau
 */
public class Videoclub {

    public Usuari usuari;
    public Lloguer lloguer;
    
    /*
    *   Constructor
    */
    
    public Videoclub(){
        usuari = new Usuari();
        lloguer = new Lloguer();
    }
    
    /*
    *   Funcuions.
    */
    
    /*
    *   Métode per a cercar els continguts de l'aplicació.
    *
    *   @args: int;
    *   @return: ArrayList <String>;
    */
    
    public ArrayList <String> buscarLloguer(){
           
        ArrayList <String> lista = new ArrayList<String>(); //carregarBD();
            
        Collections.sort(lista);
        
        return lista;
        
    }
    
    /*
    *   Mètode per a que els usuaris es puguin conectar.
    *
    */
    
    public void loguejar(){
        
    }
    
    /*
    *   Mètode amb el que es carrega tota l'informació en variables.
    *
    */
    
    public void carregarBD(){
        
        int i;
        
        
        
    }
    
    /*
    *   Mètode amb el que es desa tota l'informació en variables.
    *
    */
    public void desarBD(){
        
    }
    
    /*
    *   Mètode amb el que filtrem els continguts de les búsquedes.
    *
    */
    public void filtrarContingut(){
                
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Videoclub aplicacio = new Videoclub();
        
        System.out.print(aplicacio.buscarLloguer());
        
        
    }
    
}
