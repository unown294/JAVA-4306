
import java.util.ArrayList;
import java.util.Random;
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

public class ListWorker {
    ArrayList <Integer> list1 = new ArrayList <Integer>();
    ArrayList <Integer> list2 = new ArrayList <Integer>();
    Random random = new Random();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    
    public void list1AddValue(){
        
        synchronized(lock1){
        
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
            }

            /*for(int i=0; i<2000; i++){
                try {
                    list1.add(i);
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/

            list1.add(random.nextInt(100));
        }
    }
    
    public void list2AddValue(){
        synchronized(lock2){
        
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
            }

            /*for(int i=0; i<2000; i++){
                try {
                    list2.add(i);
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/


            list2.add(random.nextInt(100));
        }
    }
    
    public void addValue(){
        for(int i = 0; i<1000; i++){
        
            list1AddValue();
            list2AddValue();
        }
        //System.out.println("List 1 Size: " + list1.size()+ "\nList2 Size: "+list2.size());
    }
    
    public void runThreads(){
        try {
            Thread t1 = new Thread(
                    new Runnable(){
                        
                        @Override
                        public void run() {
                            addValue();
                        }
                        
                    }
            );
            
            Thread t2 = new Thread(
                    new Runnable(){
                        
                        @Override
                        public void run() {
                            addValue();
                        }
                        
                    }
            );
            
            long starting = System.currentTimeMillis();
            t1.start();
            t2.start();
            
            t1.join();
            t2.join();
            
            System.out.println("List 1 Size: " + list1.size()
                + "\nList2 Size: "+list2.size()
            );
            
            long endingTime = System.currentTimeMillis();
            System.out.println("Passed Time: " + (endingTime - starting)+" Milliseconds");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        ListWorker worker = new ListWorker();
        worker.runThreads();
        
//        long startingTime = System.currentTimeMillis();
//        worker.addValue();
//        long endingTime = System.currentTimeMillis();
//        System.out.println("Passed Time: " + (endingTime - startingTime)+" Milliseconds");
        
    }
}
