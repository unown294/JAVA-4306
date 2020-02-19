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

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class ListFrame extends JFrame{
    private final JList <String> colorList;
    
    private static final String[] colorNames = {"Black", "Blue", "Cyan", 
        "Dark Grey", "Green", "Light Gray", "Magenta", "Orange", "Pink", 
        "Red", "White", "Yellow"
    };
    
    private static final Color [] colors = {Color.BLACK, Color.BLUE, Color.CYAN,
        Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    
    public ListFrame () {
        super("Demonstrating JList");
        setLayout(new FlowLayout());
        
        colorList = new JList <> (colorNames); //Still is using the <String> but since its default its not needed
        colorList.setVisibleRowCount(5);
        //Only Displays 5 rows at a time
        
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Sets how many the user can select
        //in this case only one selection can be selected
        
        add(new JScrollPane(colorList));
        //A scroll pane is not added automatically for a JList
        
        colorList.addListSelectionListener(
            new ListSelectionListener(){
            //JList a List Selection event occurs
            //implements ListSelectionListener interface
                    
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    //1.Background
                    //2.Content Pane (including components)
                    //3.Glass Pane  (tool tip text values are displayed)
                    
                    getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
                    
                }
            }
        );//End of Selection Listener
        
    }
}

