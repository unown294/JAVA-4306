
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Copyright (C) 2020 Dalton
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

/**
 *
 * @author Dalton Redman
 */
public class Person implements Runnable{
    private String first_name;
    private String last_name;

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker " + first_name + " " + last_name + " has began its task");
            
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Worker " + first_name + " "  + last_name + " has finished its task");
    }
    
}
