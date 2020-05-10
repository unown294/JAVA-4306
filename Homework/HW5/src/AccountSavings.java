
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
public class AccountSavings {
    static double amount;
    static double interestRate = .053;
    double savings = 10;
    
    public static void main(String[] args) {
        //For debugging purposes
        //
        //int count = 0;
        //        
        //        int number = (4800 + 1200)/ 12;
        //        
        //        while(true){
        //            monthlyInterest(count, interestRate, savings);
        //            count++;
        //            if(count == 501){
        //                break;
        //            }
        //        }
        AccountSavings t1 = new AccountSavings();
        t1.runThreads();

        System.out.printf("The savings balance is $%,.2f\n", amount);
        System.out.printf("The annual interest rate is %.1f%%\n", interestRate * 100);
    }
    
    public void runThreads(){
        //Creates the threads necessary to run the program
        
        System.out.println("Beginning Thread 1 task, please wait");
        
        //Thread 1
        Thread t1 = new Thread(
            new Runnable(){

            @Override
            public void run() {
                for(int i = 0; i<4800; i++){
                    monthlyInterest(i/12);
                }
            }
                
            }
        
        );
        
        //Sleep timer for thread
        try {
            Thread.sleep(5000);
            System.out.println("Thread 1 has completed and is preparing Thread 2 for tasking");
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Thread 2
        Thread t2 = new Thread(
            new Runnable(){

                @Override
                public void run() {
                    for(int i = 0; i<1200; i++){
                        monthlyInterest(i/12);
                    }
                }
                    
            } 
        );
        
        //Sleep Timer for threads
        try {
            Thread.sleep(5000);
            System.out.println("Thread 2 has completed, output is being printed below\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Starts the threads
        t1.start();
        t2.start();
        
        //Joins them to ensure synchronized data
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private synchronized void monthlyInterest(int N) {
        amount += (savings * Math.pow((1 + interestRate / 12),(12*N)) - savings);
        
        //Formula for monthly componded interest
        //Synchronized method to ensure the data comes out the same
    }
    
    
}

