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
public class MyClass implements Runnable{
    
    @Override
    
    public void run(){
        //We are creating a new thread
        //the job of this thread is printing something
        
        System.out.println("My Class is running");
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread (new MyClass());
        //Thread has a constructor expecting a Runnable Object
        
        System.out.println("main thread is running");
        //it is the job of main thread
        
        t1.start();
        System.out.println("main thread is done");
        
    }
}
