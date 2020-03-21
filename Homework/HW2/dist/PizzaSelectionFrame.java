/*
 * Copyright (C) 2020 Dalton Redman <dalton.redman@mavs.uta.edu>
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

//Import list
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.edu>
 */

public class PizzaSelectionFrame extends JFrame{
    
    //Instance variables for main constructors
    private final JCheckBox mushroomCheckBox;
    private final JCheckBox baconCheckBox;
    private final JRadioButton smallRadioButton;
    private final JRadioButton mediumRadioButton;
    private final JRadioButton largeRadioButton;
    private final JComboBox pizzaTypeComboBox;
    private final JButton orderButton;
    private final JLabel pizzaIcon;
    private final ButtonGroup radioButtonGroup;
    private final JLabel size;
    private final JLabel toppings;
    
    //Primary states for most of the action listener logics
    private String sizeOutput = "small";
    private boolean mushroomState = false;
    private boolean baconState = false;
    private boolean mushroomAndBaconState = false;
    
    //Prestating the names of the images and list variables
    private static final String [] pizzaNames = {"chicken.PNG", "pepperoni.PNG", "veggie.PNG"};
    private static final String [] pizza = {"chicken pizza", "pepperonni pizza", "veggie pizza"};
    
    //Pre-load for all of the images
    private final Icon [] pizzaIcons = {
        new ImageIcon(getClass().getResource(pizzaNames[0])),
        new ImageIcon(getClass().getResource(pizzaNames[1])),
        new ImageIcon(getClass().getResource(pizzaNames[2]))
    };
    
    //Constructor
    public PizzaSelectionFrame(){
        super("Order Pizza");
        setLayout(new FlowLayout());
        
        //Used to create an Icon displaying an image
        pizzaIcon = new JLabel(pizzaIcons[0]);
        add(pizzaIcon);
        
        //Creating the pizza type combo box
        pizzaTypeComboBox = new JComboBox <String> (pizza);
        pizzaTypeComboBox.setMaximumRowCount(pizza.length - 1);
        add(pizzaTypeComboBox);
        
        //Image itemListener
        ImagesComboBoxHandler iconHandler = new ImagesComboBoxHandler();
        pizzaTypeComboBox.addItemListener(iconHandler);
        
        //Label for size message
        size = new JLabel("Select Size: ");
        add(size);
        
        //Creation of the radio buttons
        smallRadioButton = new JRadioButton("Small", true);
        mediumRadioButton = new JRadioButton("Medium", false);
        largeRadioButton = new JRadioButton("Large", false);
        add(smallRadioButton);
        add(mediumRadioButton);
        add(largeRadioButton);
        
        //RadioButton Listener
        smallRadioButton.addItemListener(new SizeHandler("small"));
        mediumRadioButton.addItemListener(new SizeHandler("medium"));
        largeRadioButton.addItemListener(new SizeHandler("large"));
        
        //Logical Relationships between Radio buttons
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(smallRadioButton);
        radioButtonGroup.add(mediumRadioButton);
        radioButtonGroup.add(largeRadioButton);
        
        //Creates a label for toppings selection
        toppings = new JLabel("Select Topping(s): ");
        add(toppings);
       
        //Creating topping checkbox
        mushroomCheckBox = new JCheckBox("Mushroom");
        baconCheckBox = new JCheckBox("Bacon");
        add(mushroomCheckBox);
        add(baconCheckBox);
        
        //Action Listeners checkbox toppings
        CheckBoxHandler handler = new CheckBoxHandler();
        mushroomCheckBox.addItemListener(handler);
        baconCheckBox.addItemListener(handler);
        
        //Creating Order Button
        orderButton = new JButton("Submit Order");
        orderButton.addActionListener(
            new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    //Gets the selected option from the list in the menu, returns a string for the output
                    String pizzaType = pizza[pizzaTypeComboBox.getSelectedIndex()];
                    Output order = new Output(baconState, mushroomState, mushroomAndBaconState, sizeOutput, pizzaType);
                    
                    //Determines if the order is ok based on the output returned
                    int response = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, String.format("Order Summary: " + order.getOrder()), "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    //Convert to a message dialog box for the further
                    
                    if(response == 0){
                        //Closes the current frame
                        PizzaSelectionFrame.this.setVisible(false);
                        
                        //Opens up a new frame after hidding the visibility of the frame
                        PaymentFrame paymentWindow = new PaymentFrame();
                        paymentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        paymentWindow.setVisible(true);
                        paymentWindow.setSize(600,200);
                        paymentWindow.getContentPane().setBackground(java.awt.Color.LIGHT_GRAY);
                    }
                }
            }
        );
        add(orderButton);
        
        
    }//End of class
    
    private class CheckBoxHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(mushroomCheckBox.isSelected() && baconCheckBox.isSelected()){
                //Enables a state that states that mushrooms and bacon are the only one selected
                mushroomAndBaconState = true;
                mushroomState = false;
                baconState = false;
            }
            else if(mushroomCheckBox.isSelected()){
                //Enables a state that says that mushrooms is the only one selected
                mushroomAndBaconState = false;
                mushroomState = true;
                baconState = false;
            }
            else if(baconCheckBox.isSelected()){
                //Enables a state that says that bacon is the only one selected
                mushroomAndBaconState = false;
                mushroomState = false;
                baconState = true;
            }
            else{
                //disables all states as none are selected if this triggers
                mushroomState = false;
                baconState = false;
                mushroomAndBaconState = false;
            }
        }
    }//End of class
    
    private class ImagesComboBoxHandler implements ItemListener{
        //Handles the changing of the images when the list item is selected
        
        @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange()== ItemEvent.SELECTED){
                    //Switches the image when it is selected
                    pizzaIcon.setIcon(pizzaIcons[pizzaTypeComboBox.getSelectedIndex()]);
                }//end of if
            }//End of itemListener    

    }//End of class
    
    private class SizeHandler implements ItemListener{
        //Handles the changing of the size states when the radio button is selected
        private String size;
        
        public SizeHandler(String s){
            //Reads the sent state from each button
            size = s;
        }
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            //sets the size state based on whats is read by the handler constructor
            sizeOutput = size;
        }
        
    }//End of class
    
    private class Output{
        
        //All instance variables
        private String sizeOutput;
        private String toppingsOutput;
        private String pizzaOrderType;
        private String order;
        
        //Constructor, builds the output based on the various stats collected by the other constructor
        public Output(boolean bacon, boolean mushroom,boolean mushroomAndBaconState, String size, String pizzaType){
            this.pizzaOrderType = (" " + pizzaType);
            
            if(bacon == true){
                this.toppingsOutput = " with bacon";
            }
            else if(mushroom == true){
                this.toppingsOutput = " with mushroom";
            }
            else if(mushroomAndBaconState == true){
                this.toppingsOutput = " with mushroom and bacon";
            }
            else{
                this.toppingsOutput = "";
            }
            
            this.sizeOutput = size + " size";
            
            //Builds the final output that is returned
            this.order = sizeOutput + pizzaOrderType + toppingsOutput;
        }

        //Get Methods
        public String getSizeOutput() {
            return sizeOutput;
        }

        public String getToppingsOutput() {
            return toppingsOutput;
        }

        public String getPizzaOrderType() {
            return pizzaOrderType;
        }

        public String getOrder() {
            return order;
        }

        //Set Methods
        public void setSizeOutput(String sizeOutput) {
            this.sizeOutput = sizeOutput;
        }

        public void setToppingsOutput(String toppingsOutput) {
            this.toppingsOutput = toppingsOutput;
        }

        public void setPizzaOrderType(String pizzaOrderType) {
            this.pizzaOrderType = pizzaOrderType;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }//End of class
}
