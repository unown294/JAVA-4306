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
public class Programmer extends Worker{
    private String language;

    public Programmer(String firstName, String lastName, int id, String language) {
        super(firstName, lastName, id);
        this.language = language;
    }

    //Getter
    public String getLanguage() {
        return language;
    }

    //Setter
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public void installComputer (String operatingSystem){
        System.out.println(getFirstName() + " is installing " + operatingSystem);
    }

    @Override
    public String toString() {
        return String.format("%s%s", super.toString(), language); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
