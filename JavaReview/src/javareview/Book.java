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
public enum Book {
    //enum stands for enumeration
    //it is including a set of constants
    
    JHTF("Java How to Program", "2018"),
    CHTP("C How to Program", "2016"),
    CPPHTP("C++ How to Program", "2017"),
    VBHTP("Visual Basic How to Program", "2014");
    
    //Instance Field
    private final String title;
    private final String copyrightYear;
    
    //enum Constructor

    private Book(String title, String copyrightYear) {
        this.title = title;
        this.copyrightYear = copyrightYear;
    }

    public String getTitle() {
        return title;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }
    
    
}
