/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.EnumSet;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class EnumTest {
    
    public static void main(String[] args) {
        System.out.println("All Books: ");
        
        //enhanced for iteration
        for(Book book: Book.values()){
            System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
        }
        
        System.out.printf("%nDisplay a range of enum constants%n");
        
        for(Book book: EnumSet.range(Book.JHTF, Book.VBHTP)){
            System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
        }
    }
}
