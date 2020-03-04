
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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class ConvertFrame extends JFrame{
    
    //All Private objects required for the frame and 
    private final JButton fahreinheitButton;
    private final JButton inchButton;
    private final JLabel labelFahren1;
    private final JLabel labelFahren2;
    private final JLabel labelInch1;
    private final JLabel labelInch2;
    private final JTextField fahreinheitTextField;
    private final JTextField inchTextField;
    private final JLabel resultFahreinheit;
    private final JLabel resultInch;
    
    public ConvertFrame(){
        super("Converter");
        setLayout(new FlowLayout());
        
        //Fahreinheit Label 1 Construction
        labelFahren1 = new JLabel("Enter Fahrenheit temperature: ");
        add(labelFahren1);
        
        //Textfield Fahreinheit construction
        fahreinheitTextField = new JTextField(5);
        add(fahreinheitTextField);
        
        //Button Convert Fahreinheit to celsius
        fahreinheitButton = new JButton("Convert");
        add(fahreinheitButton);
        
        //Fahreinheit Label 2 Construction
        labelFahren2 = new JLabel("Fahrenheit to Celsius is: ");
        add(labelFahren2);
        
        //Fahreinheit Label Result Construction
        resultFahreinheit = new JLabel("");
        add(resultFahreinheit);
        
        //Inch Label 1 Construction
        labelInch1 = new JLabel("Enter Inch length: ");
        add(labelInch1);
        
        //Textfield Inch Construction
        inchTextField = new JTextField(5);
        add(inchTextField);
        
        //Button Convert Inches to Centimeters
        inchButton = new JButton("Convert");
        add(inchButton);
        
        //Inch Label 2 Construction
        labelInch2 = new JLabel("Inch to Centimeters is: ");
        add(labelInch2);
        
        //Fahreinheit Label Result Construction
        resultInch = new JLabel("");
        add(resultInch);
        
        //Action Listeners
        
        fahreinheitButton.addActionListener(
            new ActionListener(){
        
                @Override
                public void actionPerformed(ActionEvent event){
                    int conversion = Integer.parseInt(fahreinheitTextField.getText());
                    double calculation = (conversion - 32) / 1.8;
                    int result = (int) calculation;

                    resultFahreinheit.setText(Integer.toString(result));

                }//End of actionPerformed
            }//End of ActionListener
        );//End of inner Class
        
		fahreinheitTextField.addActionListener(
			new ActionListener(){
        
                @Override
                public void actionPerformed(ActionEvent event){
                    int conversion = Integer.parseInt(fahreinheitTextField.getText());
                    double calculation = (conversion - 32) / 1.8;
                    int result = (int) calculation;

                    resultFahreinheit.setText(Integer.toString(result));

                }//End of actionPerformed
            }//End of ActionListener
		);
		
        inchButton.addActionListener(
            new ActionListener(){
        
                @Override
                public void actionPerformed(ActionEvent event){
                    int conversion = Integer.parseInt(inchTextField.getText()); //Retrieves the Text in the inchTextField, converts string to integer
                    double calculation = conversion * 2.54;                     //Conversion formula for Inch to Centimeters
                    int result = (int) calculation;                             //Converts the Double result to an Integer
                    resultInch.setText(Integer.toString(result));
                    
                    //For debuggin purpose only. Was added to see why was outputing zero
                    //resultInch.setText(Double.toString(result));
                    //resultInch.setText(inchTextField.getText());                    

                }//End of actionPerformed
            }//End of ActionListener
        );//End of inner Class
        
		inchTextField.addActionListener(
			new ActionListener(){
        
                @Override
                public void actionPerformed(ActionEvent event){
                    int conversion = Integer.parseInt(inchTextField.getText()); //Retrieves the Text in the inchTextField, converts string to integer
                    double calculation = conversion * 2.54;                     //Conversion formula for Inch to Centimeters
                    int result = (int) calculation;                             //Converts the Double result to an Integer
                    resultInch.setText(Integer.toString(result));
                    
                    //For debuggin purpose only. Was added to see why was outputing zero
                    //resultInch.setText(Double.toString(result));
                    //resultInch.setText(inchTextField.getText());                    

                }//End of actionPerformed
            }//End of ActionListener
		);//End of inner class
		
    }//End of constructor
    
}//End of class
