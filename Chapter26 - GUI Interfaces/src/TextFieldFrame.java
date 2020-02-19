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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class TextFieldFrame extends JFrame{
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JPasswordField passwordField;
    
    public TextFieldFrame(){
        
        super("Testing JTextField & JPasswordField");
        setLayout(new FlowLayout());
        
        //Text Field 1 Construction
        textField1 = new JTextField(10);
        add(textField1);
        
        //Text Field 2 Construction
        textField2 = new JTextField("Enter text here");
        add(textField2);
        
        //Text Field 3 Construction
        textField3 = new JTextField("Uneditable Text Field", 21);
        textField3.setEditable(false);
        add(textField3);
        
        //Password Field Construction
        passwordField = new JPasswordField("hidden text");
        add(passwordField);
        
        
        //Registering the components for the ActionListener Event
        TextFieldHandler handler = new TextFieldHandler();
        //registers an ActionListener object to handle action events
        
        //List of all ActionListeners for this constructor
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
        
    }//end of ze constructor
    
    //Event Handling
    //1. create a private inner class
    //2. implement the proper interface
    //3. override the required method
    //4. register your components
    
    //JTextField, JPasswordField, an action event occurs
    
    private class TextFieldHandler implements ActionListener{ //This is an inner class
        
        @Override
        public void actionPerformed (ActionEvent event){
            String string = "";
            
            if(event.getSource() == textField1){
                string = String.format("textField1: %s", event.getActionCommand());
                //Get action command "get" returns the text generated from the text field
            }
            else if (event.getSource() == textField2){
                string = String.format("textField2: %s", event.getActionCommand());
            }
            else if (event.getSource() == textField3){
                string = String.format("textField3: %s", event.getActionCommand());
            }
            else if (event.getSource() == passwordField){
                string = String.format("passwordField: %s", event.getActionCommand());
            }
            
            JOptionPane.showMessageDialog(null, string);
        }
    }
}
