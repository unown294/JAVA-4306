/*
 * Copyright (C) 2020 Dalton Redman <dalton.redman@mavs.uta.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class TabbedPaneFrame extends JFrame{
    
    public TabbedPaneFrame(){
        
        super("Testing Tabbed Pane");
        JTabbedPane tabbedpane = new JTabbedPane();
        
        //set up pane 1
        
        JLabel label1 = new JLabel("Pane one", SwingConstants.CENTER);
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        tabbedpane.addTab("tab one", null, panel1, "First Panel");
        
        //Setup pane 2
        
        JLabel label2 = new JLabel("Pane Two", SwingConstants.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.PINK);
        panel2.add(label2);
        tabbedpane.addTab("tab two", null, panel2, "Second Panel");
        
        //Setup pane 3
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(new JButton ("North"), BorderLayout.NORTH);
        panel3.add(new JButton ("West"), BorderLayout.WEST);
        panel3.add(new JButton ("East"), BorderLayout.EAST);
        panel3.add(new JButton ("South"), BorderLayout.SOUTH);
        tabbedpane.addTab("tab three", null, panel3, "Third Panel");
        
        add(tabbedpane);
    }
}
