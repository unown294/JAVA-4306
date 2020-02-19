/*
 * Copyright (C) 2020 Dalton Redman <dalton.redman@mavs.uta.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class ComboBoxFrame extends JFrame{
    private final JComboBox <String> imagesComboBox;
    private final JLabel label;
    
    //Creates the files to collect
    private static final String [] names = {"bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif"};
    
    //Populates the Icon array
    private final Icon [] icons = {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
        new ImageIcon(getClass().getResource(names[2])),
        new ImageIcon(getClass().getResource(names[3])),
    };
    
    public ComboBoxFrame(){
        super("Demonstrating ComboBox");
        setLayout(new FlowLayout());
        
        imagesComboBox = new JComboBox <String> (names);
        imagesComboBox.setMaximumRowCount(names.length - 1);
        //Sets the maximum row count based on the length of the array to prevent out of bounds
        
        //anonymous inner class to register components
        //the class will have no-name
        //it will appear in a method
        //one object must be created at the point where the class is declared
        //It can access its top-level class members
        
        imagesComboBox.addItemListener(
                new ItemListener(){ //anonymous inner class
                
                @Override
                 public void itemStateChanged(ItemEvent event){
                     
                     if(event.getStateChange()== ItemEvent.SELECTED){
                         label.setIcon(icons[imagesComboBox.getSelectedIndex()]);
                     }//end of if
                                          
                 }//End of method
                }//End of class
        );//end of inner class/ methode
        
        add(imagesComboBox);
        label = new JLabel (icons[0]);
        //Sets the default label
        add(label);
        
    }//end of constructor
}
