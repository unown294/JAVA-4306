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
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class CheckBoxFrame extends JFrame{
    private final JTextField textField;
    private final JCheckBox boldCheckBox;
    private final JCheckBox italicCheckBox;
    
    public CheckBoxFrame(){
        super("Check box test");
        setLayout(new FlowLayout());
        
        textField = new JTextField ("Watch the font style change", 20);
        //font size 20
        textField.setFont(new Font("Serif",Font.PLAIN, 14));
        //Font type, format, size
        add(textField);
        
        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");
        add(boldCheckBox);
        add(italicCheckBox);
        
        CheckBoxHandler handler = new CheckBoxHandler();
        boldCheckBox.addItemListener(handler);
        italicCheckBox.addItemListener(handler);
        
    }//End of constructor
    
    //JCheckBox - An item event occurs
    //Interface Item Listeners
    private class CheckBoxHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            Font font = null;
            
            if(boldCheckBox.isSelected() && italicCheckBox.isSelected()){
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            }
            else if(boldCheckBox.isSelected()){
                font = new Font("Serif", Font.BOLD, 14);
            }
            else{
                font = new Font("Serif", Font.PLAIN, 14);
            }
            
            textField.setFont(font);
        }
    }
    
}
