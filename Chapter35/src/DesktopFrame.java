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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class DesktopFrame extends JFrame{
    private final JDesktopPane theDesktop;
    
    public DesktopFrame(){
        super("Using Desktop Frame");
        
        JMenuBar bar = new JMenuBar();
        JMenu addMenu = new JMenu("Add");
        JMenuItem newFrame = new JMenuItem("Internal Frame");
        
        //Adding the components
        addMenu.add(newFrame);
        bar.add(addMenu);
        setJMenuBar(bar);
        
        theDesktop = new JDesktopPane();
        add(theDesktop);
        
        newFrame.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
                        //                         JInternalFrame(Title, resizable window, close button, maximization button, minimization button)
                        
                        MyPanel panel = new MyPanel();
                        frame.add(panel, BorderLayout.CENTER);
                        frame.pack();
                        theDesktop.add(frame);
                        frame.setVisible(true);
                        
                    }

                }//End of actionlistener
        );//end of inner class
        
    }//End of constructor

}
    
class MyPanel extends JPanel{
        private static final SecureRandom generator = new SecureRandom();
        private final ImageIcon picture;
        private static final String[] images = {"purpleflowers.png","redflowers.png","redflowers2.png","yellowflowers.png"};
        
        //load an image
        public MyPanel(){
            int randomNumber = generator.nextInt(images.length);
            picture = new ImageIcon(images[randomNumber]);
            
            
        }
        
        @Override
        public void paintComponent (Graphics g){
            
            super.paintComponent(g);
            picture.paintIcon(this, g, 0, 0);
            //this is the component to be used as an observer
            //0 = x coordinate - top left corner
            //0 = y coordinate - top left corner
            
        }
        
        public Dimension getPreferredSize(){
            return new Dimension(picture.getIconWidth(), picture.getIconHeight());
        }
        
    }

