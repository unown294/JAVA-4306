
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
public class MyClass4 {
    public static void main(String[] args) {
        System.out.println("main thread is working");
        
        Thread print1 = new Thread(
            new Runnable(){

                @Override
                public void run() {
                    System.out.println("Thread is working....");
                    
                    for(int i =5; i>0; i--){
                        System.out.println("is printing "+ i);
                        
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MyClass4.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
                
        );
        
        print1.start();
        
        System.out.println("main thread is exiting");
    }
}
