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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */

public class MyMenuFrame extends JFrame{
    
    private final Color [] colorValues = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
    
    private final JRadioButtonMenuItem [] colorItems;
    private final JRadioButtonMenuItem [] fonts;
    private final JCheckBoxMenuItem [] styleItems;
    private final JLabel displayLabel;
    private final ButtonGroup fontButtonGroup;
    private final ButtonGroup colorButtonGroup;
    
    public MyMenuFrame(){
        super("Using Menus");
        
        JMenu fileMenu = new JMenu ("File");
        fileMenu.setMnemonic('F');
        //Types ALT+F, it will open File menu
        
        JMenuItem aboutItem = new JMenuItem("About...");
        aboutItem.setMnemonic('A');
        //Types ALT+A, it will open file menu
        
        fileMenu.add(aboutItem);
        //add about to file menu
        
        aboutItem.addActionListener(
            new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(MyMenuFrame.this, "This is an example\nof using menus.", "About", JOptionPane.PLAIN_MESSAGE);
                    
                    
                }
                    
            }
        
        );
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');
        fileMenu.add(exitItem);
        
        exitItem.addActionListener(
        
            new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
                
            }
        );
        
        JMenuBar bar = new JMenuBar();
        setJMenuBar (bar);
        bar.add(fileMenu);
        //FileMenu is completed
        
        JMenu formatMenu = new JMenu("Format");
        formatMenu.setMnemonic('R');
        
        String [] colors = {"Black", "Blue", "Red", "Green"};
        
        JMenu colorMenu = new JMenu ("Colors");
        colorMenu.setMnemonic('C');
        colorButtonGroup = new ButtonGroup();
        colorItems = new JRadioButtonMenuItem[colors.length];
        ItemHandler itemHandler = new ItemHandler();
        
        for(int count = 0; count < colors.length; count++){
            
            colorItems[count] = new JRadioButtonMenuItem(colors[count]);
            colorMenu.add(colorItems[count]);
            colorButtonGroup.add(colorItems[count]);
            colorItems[count].addActionListener(itemHandler);
            
        }
        
        colorItems[0].setSelected(true);
        //By default it selects black as default color
        
        //Format Menu creation
        formatMenu.add(colorMenu);
        formatMenu.addSeparator();
        
        String [] fontNames = {"Serif", "Monospaces", "SansSerif"};
        JMenu fontMenu = new JMenu("Font");
        fontMenu.setMnemonic('N');
        
        fonts = new JRadioButtonMenuItem[fontNames.length];
        fontButtonGroup = new ButtonGroup();
        
        for(int count = 0; count < fontNames.length; count++){
            
            fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
            fontMenu.add(fonts[count]);
            fonts[count].addActionListener(itemHandler);
            
        }
        
        fonts[0].setSelected(true);
        fontMenu.addSeparator();
        
        String [] styleNames = {"Bold", "Italic"};
        styleItems = new JCheckBoxMenuItem[styleNames.length];
        StyleHandler styleHandler = new StyleHandler();
        
        for(int count = 0; count < styleNames.length; count++){
            styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
            fontMenu.add(styleItems[count]);
            styleItems[count].addItemListener(styleHandler);
        }
        
        bar.add(formatMenu);
        formatMenu.add(fontMenu);
        getContentPane().setBackground(Color.CYAN);
                
        
        displayLabel = new JLabel("Sample text", SwingConstants.CENTER);
        displayLabel.setFont(new Font ("Serif", Font.PLAIN, 72));
        add(displayLabel, BorderLayout.CENTER);
    }

    private class ItemHandler implements ActionListener{
        //ActionListener
        //it does not know about button group
        //and all other select/deselect operations
        //it just understands there is a click that creates an ActionEvent
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Color Selection
            for(int count = 0; count<colorItems.length; count++){
                
                displayLabel.setForeground(colorValues[count]);
                break;
            }
            
            //Font Selection
            
            for(int count=0; count < fonts.length; count++){
                if(e.getSource() == fonts[count]){
                    displayLabel.setFont(new Font(fonts[count].getText(), Font.PLAIN, 72));
                }
            }
            
            repaint();//Redraw the application
        }
    }

    private class StyleHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
           
            String name = displayLabel.getFont().getName();
            //Get current font
            Font font;
            
            if(styleItems[0].isSelected() && styleItems[1].isSelected()){
                font = new Font(name, Font.BOLD+Font.ITALIC, 72);
            }
            
            else if(styleItems[0].isSelected()){
                font = new Font(name, Font.BOLD, 72);
            }
            
            else if(styleItems[1].isSelected()){
                font = new Font(name, Font.ITALIC, 72);
            }
            
            else{
                font = new Font(name, Font.PLAIN, 72);
            }
            
            displayLabel.setFont(font);
            repaint();
        }

    }
}
