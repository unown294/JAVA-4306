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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class FlowLayoutFrame extends JFrame{
    
    private final JButton leftButton;
    private final JButton centerButton;
    private final JButton rightButton;
    private final FlowLayout layout;
    private final Container container;
    
    public FlowLayoutFrame (){
        
        super("FlowLayout Test");
        layout = new FlowLayout();      //Reference type, meaning a memory address
        container = getContentPane();   //Getting container 
        
        setLayout(layout);
        
        //LeftButton Constructor
        leftButton = new JButton ("Left");
        leftButton.addActionListener(
                new ActionListener(){
                    
                    @Override
                    public void actionPerformed (ActionEvent event){
                    
                        layout.setAlignment(FlowLayout.LEFT);
                        layout.layoutContainer(container);
                        //JFrame should be rearranged based on the adjusted layout
                    }


                }
        );
        add(leftButton);
        
        //Center Button Constructor
        centerButton = new JButton ("Center");
        centerButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        layout.setAlignment(FlowLayout.CENTER);
                        layout.layoutContainer(container);
                    }
                    
                }
        );
        add(centerButton);
        
        //Right Button Constructor
        rightButton = new JButton ("Right");
        rightButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        layout.setAlignment(FlowLayout.RIGHT);
                        layout.layoutContainer(container);
                    }
                    
                }
        );
        add(rightButton);
        
    }
}
