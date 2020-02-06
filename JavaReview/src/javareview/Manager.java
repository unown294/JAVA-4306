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
public class Manager extends Worker{
    private int numberOfPeople;

    public Manager(String firstName, String lastName, int id, int numberOfPeople) {
        super(firstName, lastName, id);
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
   
    public void increaseSalary (int amount){
        System.out.println(getFirstName() + " is increasing the salary by the amount of " + amount);
    }

    @Override
    public String toString() {
        return String.format("%s%d", super.toString(), numberOfPeople);
    }
    
    
}
