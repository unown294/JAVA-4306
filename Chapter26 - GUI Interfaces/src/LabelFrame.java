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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class LabelFrame extends JFrame{
    private final JLabel label1; //Label with only text value
    private final JLabel label2; //Label with text and icon
    private final JLabel label3; //Label with added text and icon
    
    public LabelFrame(){
        super("Testing JLabel");
        setLayout(new FlowLayout());
        
        //Label 1 Construction
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1"); //Tool tip when mouse is over the label
        
        add(label1);
        //Attaches your component to a container/window/JFrame
        
        //Label 2 Construction
        Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
        
        label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
        //Label contents will be left justified
        //by default it is right justified
        
        add(label2);
        
        //Label 3 construction
        label3 = new JLabel();
        label3.setText("label with icon and text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setToolTipText("This is label3");
        add(label3);
    }
}
