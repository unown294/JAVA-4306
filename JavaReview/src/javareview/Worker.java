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
public class Worker {
    private String firstName;
    private String lastName;
    private int id;

    //Constructor
    public Worker(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s%n%s: %d%n",
                "First Name", getFirstName(),
                "Last Name", getLastName(),
                "ID", getId());
    }
    
    
}
