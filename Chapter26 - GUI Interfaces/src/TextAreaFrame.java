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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class TextAreaFrame extends JFrame{
    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JButton copyButton;
    
    public TextAreaFrame (){
        super("Text Area Demonstration");
        Box box = Box.createHorizontalBox();
            //Box is a container
            //Arranges components from left to right
        
        String testValue = "This is a test string\n"+
                "illustrate copying text\nfrom one textarea"+
                "using an external event";
        
        textArea1 = new JTextArea(testValue, 10, 15); //(Variable, 10 rows, 15 columns)
        
        box.add(new JScrollPane(textArea1));
        //by default, they will be displayed when it is needed
        
        box.add(new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        
        copyButton = new JButton ("Copy>>>>");
        box.add(copyButton);
        copyButton.addActionListener(
            new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea2.setText(textArea1.getSelectedText());
                }
            }
        );
        
        //Text Area 2 creation
        textArea2 = new JTextArea(10, 15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));
        add(box);
        
    }
}
