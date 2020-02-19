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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */

public class BorderLayoutFrame extends JFrame implements ActionListener{
    //in a borderlayout we have five regions
    //north, east, south, west, and center
    //in each region, we can locate a maximum 5 components
    
    private final JButton [] buttons;
    private static final String [] names = {"Hide North", "Hide South", "Hide East", "Hide Center", "Hide West"};
    private final BorderLayout layout;
    
    public BorderLayoutFrame(){
        super("BorderLayout Test");
        layout = new BorderLayout(5,5); //(Horizontal Gap , Vertical Gap) Distance between components
        setLayout(layout);
        
        buttons = new JButton [names.length];
        
        //Makes the buttons
        for(int i = 0; i < names.length; i++){
            buttons[i] = new JButton (names[i]);
            buttons[i].addActionListener(this);
        }
        
        add(buttons[0], BorderLayout.NORTH);
        add(buttons[1], BorderLayout.SOUTH);
        add(buttons[2], BorderLayout.EAST);
        add(buttons[3], BorderLayout.CENTER);
        add(buttons[4], BorderLayout.WEST);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for(JButton button: buttons){
            if(event.getSource() == button){
                button.setVisible(false);
            }
            else{
                button.setVisible(true);
            }
        }
        
        layout.layoutContainer(getContentPane());
    }
    
}
