
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

//Import List
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.edu>
 */
public class PaymentFrame extends JFrame{
    //Instance variables
    private final JLabel nameSurnameLabel;
    private final JTextField nameField;
    private final JLabel addressLabel;
    private final JTextField addressTextField;
    private final JLabel creditCardLabel;
    private final JTextField creditCardTextField;
    private final JLabel expirationDateLabel;
    private final JTextField expirationDateTextField;
    private final JLabel cvcLabel;
    private final JTextField cvcTextField;
    private final JButton payButton;
    private final GridLayout layout1;
    private final Container container;
    
    public PaymentFrame(){
        super("Payment");
        layout1 = new GridLayout(6, 2, 5, 5);
        //(6 Rows, 2 Columns, 5 horizontal gap, 5 Vertical Gap)
        
        container = getContentPane();
        setLayout(layout1);
        
        //Name field Label
        nameSurnameLabel = new JLabel("Name and Surname:");
        add(nameSurnameLabel);
        
        //Text field for names and surnames
        nameField = new JTextField(20);
        add(nameField);
        
        //Address Label
        addressLabel = new JLabel("Address:");
        add(addressLabel);
        
        //Address TextField
        addressTextField = new JTextField(20);
        add(addressTextField);
        
        //Credit Card Label
        creditCardLabel = new JLabel("Credit Card Number:");
        add(creditCardLabel);
        
        //Credit Card TextField
        creditCardTextField = new JTextField(20);
        add(creditCardTextField);
        
        //Expiration Date Label
        expirationDateLabel = new JLabel("Expiration Date:");
        add(expirationDateLabel);
        
        //Expiration Date TextField
        expirationDateTextField = new JTextField(20);
        add(expirationDateTextField);
        
        //CVC Label
        cvcLabel = new JLabel("CVC:");
        add(cvcLabel);
        
        //CVC Text Field
        cvcTextField = new JTextField(20);
        add(cvcTextField);
        
        //Pay button construction and ActionListener
        payButton = new JButton("pay");
        payButton.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(PaymentFrame.this, "Your order will be delivered in 30 minutes");
                    
                    System.exit(0);
                }
        
            }
        );
        
        add(payButton);
        
    }
    
}
