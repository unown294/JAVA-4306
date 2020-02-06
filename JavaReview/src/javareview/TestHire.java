/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Scanner;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class TestHire {
    public static void main(String[] args) {
        System.out.println("Welcome to Worker Application");
        System.out.println("Press q to exit");
        
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("Which type of worker do you want to hire? : ");
            String option = in.nextLine();
            option = option.toLowerCase();
            
            if(option.equals("q")){
                System.out.println("Exiting...");
                break;
            }
            else{
                Hire myhire = new Hire();
                Worker myworker = myhire.hire(option);
                
                if(myworker == null){
                    System.out.println("Enter a valid worker type");
                }
                
                else{
                    System.out.printf("%s%n", myworker.toString());
                }
            }
        }
    }
}
