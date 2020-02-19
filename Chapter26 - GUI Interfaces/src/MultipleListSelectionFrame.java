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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class MultipleListSelectionFrame extends JFrame{
    private final JList <String> colorList;
    private final JList <String> copyList;
    private final JButton copyButton;
    
        private static final String[] colorNames = {"Black", "Blue", "Cyan", 
        "Dark Grey", "Green", "Light Gray", "Magenta", "Orange", "Pink", 
        "Red", "White", "Yellow"
    };
    
    private static final Color [] colors = {Color.BLACK, Color.BLUE, Color.CYAN,
        Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    
    public MultipleListSelectionFrame(){
        super("Demonstrating JList Multiple Selections");
        setLayout(new FlowLayout());
        
        colorList = new JList <String> (colorNames);
        colorList.setVisibleRowCount(5);
        colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(colorList));
        
        copyButton = new JButton("Copy>>>");
        
        copyButton.addActionListener(
                new ActionListener(){
                    
                    @Override
                    
                    public void actionPerformed(ActionEvent event){
                        copyList.setListData(colorList.getSelectedValuesList().toArray(new String[0]));
                    }
                }
        
        );
        add(copyButton);
        
        copyList = new JList <String>();
        copyList.setVisibleRowCount(5);
        copyList.setFixedCellHeight(15);
        copyList.setFixedCellWidth(100);
        copyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(copyList));
    }
    
}
