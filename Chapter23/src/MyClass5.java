
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class MyClass5 {
    public static void main(String[] args) {
        
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            
            for(int i = 1; i<=5; i++){
                executor.submit(new Worker(String.valueOf(i),i));
            }
            
            executor.shutdown();
            
            System.out.println("All task have been submitted");
            
            executor.awaitTermination(1, TimeUnit.DAYS);
            
            /*
            Thread t1 = new Thread(new Worker("1", 1));
            Thread t2 = new Thread(new Worker("2", 2));
            Thread t3 = new Thread(new Worker("3", 3));
            Thread t4 = new Thread(new Worker("4", 4));
            Thread t5 = new Thread(new Worker("5", 5));
            
            System.out.println("All task have been submitted");

            t1.start();
            t2.start();
            
            t1.join();
            t2.join();
            
            t3.start();
            t4.start();
            
            t3.join();
            t4.join();
                        
            t5.start();
            t5.join();
            
            } catch (InterruptedException ex) {
            Logger.getLogger(MyClass5.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        } catch (InterruptedException ex) {
            Logger.getLogger(MyClass5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("All tasks are completed");
    }
}
