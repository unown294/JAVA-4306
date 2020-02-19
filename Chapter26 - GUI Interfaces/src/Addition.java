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
import javax.swing.JOptionPane;

public class Addition {
    public static void main(String[] args) {
        String number1 = JOptionPane.showInputDialog("Enter first integer: ");
        String number2 = JOptionPane.showInputDialog("Enter second integer: ");
        
        int firstNumber = Integer.parseInt(number1);
        int secondNumber = Integer.parseInt(number2);
        
        int sum = firstNumber + secondNumber;
        
        JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of two integers", JOptionPane.PLAIN_MESSAGE);
        //1. Parameter: "null" means it will be centered on your screen
        //2. Parameter: is the message that will be displayed
        //3. Parameter: Is the title of the Dialog box
        //4. Parameter: type of message dialog to be displayed
        
        
    }
}
