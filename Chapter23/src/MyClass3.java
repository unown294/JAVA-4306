
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
public class MyClass3 extends Thread{
    private String name;
    
    public MyClass3(String name) {
        this.name = name;
    }
    
    @Override 
    public void run(){
        System.out.println(name + "is working");
        
        for(int i = 5; i > 0; i--){
            try {
                System.out.println(name + "is printing: "+ i);
                Thread.sleep(1000); //1000 millisecond or 1 second
            } catch (InterruptedException ex) {
                //InterruptedException is a checked exception
                System.out.println(name +" is interrupted");
                
                Logger.getLogger(MyClass3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        System.out.println(name + " is exiting");
    }
    
    public static void main(String[] args) {
        MyClass3 t1 = new MyClass3("t1");
        MyClass3 t2 = new MyClass3("t2");
        System.out.println("Main thread is running");
        t1.start();
        t2.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyClass3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Main thread is exiting");
    }
}
