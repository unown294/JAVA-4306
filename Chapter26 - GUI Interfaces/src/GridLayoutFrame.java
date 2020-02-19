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

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class GridLayoutFrame extends JFrame implements ActionListener{

    private final JButton [] buttons;
    private static final String [] names = {"One", "Two", "Three", "Four", "Five", "Six"};
    private boolean toggle = true; //toggle between layouts
    private final Container container;
    private final GridLayout layout1;
    private final GridLayout layout2;
    
    public GridLayoutFrame(){
        super("Grid Layout Test");
        layout1 = new GridLayout(2, 3, 5, 5);
        //(2 Rows, 3 Columns, 5 horizontal gap, 5 Vertical Gap)
        //each component will have same width and height gap
        
        layout2 = new GridLayout(3,2);
        //(3 rows, 2 columns, no gaps
        
        container = getContentPane();
        setLayout(layout1);
        
        
        buttons = new JButton [names.length];
        for(int i = 0; i < names.length; i++){

            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(this);
            add(buttons[i]);
            //Components are added to a grid layout starting from the top-left cell of the grid
        
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(toggle){
            container.setLayout(layout2);
        }
        else{
            container.setLayout(layout1);
        }
        
        toggle = !toggle;
        
        container.validate(); //re-layout container
    }
    
}
