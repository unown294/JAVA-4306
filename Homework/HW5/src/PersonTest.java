
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
public class PersonTest {
    public static void main(String[] args) {
        try {
            //Creates a new thread pool of 3 that runs the program
            ExecutorService executor = Executors.newFixedThreadPool(3);
            
            //Creates 4 threads in total
            for(int i = 1; i<=4; i++){
                executor.submit(new Person("Dalton","Redman"));
            }
            
            executor.shutdown();
            
            System.out.println("All task have been submitted");
            
            //States an autotermination in the event of an error
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("All tasks are completed");
    }
}
