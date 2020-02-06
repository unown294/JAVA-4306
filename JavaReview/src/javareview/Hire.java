/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class Hire {
    public Worker hire (String workerType){
        
        if(workerType.equals("programmer")){
            return new Programmer("Dalton", "Redman", 12345, "Java");
        }
        
        else if(workerType.equals("manager")){
            return new Manager("Brad", "Brad", 12345, 6);
        }
        else{
            return null;
        }
    }
}
