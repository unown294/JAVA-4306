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
//import.javax.swing.*;
//Imports all packages under javax.swing
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class ButtonFrame extends JFrame{
    private final JButton plainButton;
    private final JButton fancyButton;
    
    public ButtonFrame(){
        
        super("Testing Buttons");
        setLayout(new FlowLayout());
        
        plainButton = new JButton("Plain Button");
        add(plainButton);
        
        Icon bug1 = new ImageIcon(getClass().getResource("bug1.GIF"));
        Icon bug2 = new ImageIcon(getClass().getResource("bug2.GIF"));
        
        fancyButton = new JButton("Fancy Button", bug1);
        fancyButton.setRolloverIcon(bug2); //Sets rollover image
        add(fancyButton);
        
        ButtonHandler myHandler = new ButtonHandler();
        plainButton.addActionListener(myHandler);
        fancyButton.addActionListener(myHandler);
        
    }//End of constructor
    
    
    private class ButtonHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s", event.getActionCommand()));
        }
    }
}
