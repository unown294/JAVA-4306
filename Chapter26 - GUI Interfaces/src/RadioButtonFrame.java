
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class RadioButtonFrame extends JFrame{
    private JTextField textField;
    private JRadioButton plainRadioButton;
    private JRadioButton boldRadioButton;
    private JRadioButton italicRadioButton;
    private JRadioButton boldItalicRadioButton;
    private ButtonGroup buttonGroup;
    //Needed to organize radio buttons
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;
    private Font plainFont;
    
    public RadioButtonFrame(){
        super("Radio Button Test");
        setLayout(new FlowLayout());
        
        //Defines the first/default message
        textField = new JTextField("Watch the font style change", 20);
        add(textField);
        
        //Radio Buttons
        plainRadioButton = new JRadioButton("Plain", true);
        //true - by default plain is selected
        boldRadioButton = new JRadioButton("Bold", false);
        italicRadioButton = new JRadioButton("Italic", false);
        boldItalicRadioButton = new JRadioButton("Bold/Italic", false);
        
        //Adds the constructed buttons
        add(plainRadioButton);
        add(boldRadioButton);
        add(italicRadioButton);
        add(boldItalicRadioButton);
        
        //Logical Relationships between Radio buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(plainRadioButton);
        buttonGroup.add(boldRadioButton);
        buttonGroup.add(italicRadioButton);
        buttonGroup.add(boldItalicRadioButton);
        
        //Fonts
        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        
        //Sets the text field to the default value for this program
        textField.setFont(plainFont);
        
        //Item Listeners
        plainRadioButton.addItemListener(new RadioButtonHandler(plainFont));
        boldRadioButton.addItemListener(new RadioButtonHandler(boldFont));
        italicRadioButton.addItemListener(new RadioButtonHandler(italicFont));
        boldItalicRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
        
    }//End of constructor
    
    private class RadioButtonHandler implements ItemListener{
        private Font font;
        
        public RadioButtonHandler(Font f){
            font = f;
        }
        
        @Override
        public void itemStateChanged(ItemEvent event){

            textField.setFont(font);
            
        }
    }
    
}
