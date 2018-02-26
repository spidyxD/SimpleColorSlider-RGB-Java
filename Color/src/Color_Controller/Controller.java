/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Color_Controller;

import Color_Model.Model;
import Color_View.View;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
/**
 *
 * @author LENOVO
 */
public class Controller extends MouseAdapter implements MouseListener, ActionListener{
    Model model;
    View view;
    MouseEvent aux;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.aux = null;
        view.setModel(model);
        view.setController(this);
    }

    @Override
    public void mouseReleased(MouseEvent me){  //contiene clickcount
        aux = me;
      switch(((JSlider)me.getSource()).getName()){ //nombre del slider
            case "Red":
                model.setCurrent(((JSlider)me.getSource()).getValue(),model.getCurrent().getGreen(), model.getCurrent().getBlue());
                model.addColor(model.getCurrent());
                break;
            case "Green":
                 model.setCurrent(model.getCurrent().getRed(),((JSlider)me.getSource()).getValue(), model.getCurrent().getBlue());
                 model.addColor(model.getCurrent());
                break;
            case "Blue":
                 model.setCurrent(model.getCurrent().getRed(),model.getCurrent().getGreen(),((JSlider)me.getSource()).getValue());
                 model.addColor(model.getCurrent());
                break;
        }
    }
        @Override
        public void actionPerformed(ActionEvent evt) {
       
          // mouseReleased(aux);
            switch(evt.getActionCommand()){
           case "undo":   //CUIDADO ESCRIBIR BIEN EL NOMBRE DEL BOTON
              if(((JSlider)aux.getSource()).getName() == "Red"){
               model.setCurrent2(model.getBefore());
              }
              else if(((JSlider)aux.getSource()).getName() == "Green"){
               model.setCurrent2(model.getBefore());
              }
              else if(((JSlider)aux.getSource()).getName() == "Blue")
               model.setCurrent2(model.getBefore());
               break;
            }
               
       }

    
    }






