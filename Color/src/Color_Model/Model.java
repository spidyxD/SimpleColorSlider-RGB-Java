/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Color_Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Model extends Observable {
    List colores = new ArrayList();
    Color current;
    public Model(){
        current = new Color (0,0,0);
    }
    public Color getCurrent(){
    return this.current;
    }
    public void setCurrent(int a,int b, int c){
    this.current = new Color(a,b,c);
    }
     public void setCurrent2(Color aux){
    this.current = aux;
    }
    public void addColor(Color c){
    colores.add(c);
      setChanged();
      notifyObservers(null); 
    }
    public Color getBefore(){
        Color aux = new Color(0,0,0);
   if(!colores.isEmpty())
      aux = (Color) colores.get(colores.size()-1);
      setChanged();
      notifyObservers(null); 
    return aux;
    }
    
    
    
    
    
    
    
    
    
    
    
      @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null);
    }
    
}
