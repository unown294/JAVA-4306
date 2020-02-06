/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.ArrayList;

/**
 *
 * @author New User
 */
public class ArrayListTest {
    
    public static void main(String[] args) {
        ArrayList <String> mylist = new ArrayList <String>();
    
        ArrayList <Integer> mylist2 = new ArrayList <Integer>();
    
        int a=5;
        Integer b=6;
            //System.out.println("b+7");
            
        for(int i = 0; i<10; i++){
            mylist2.add(Integer.valueOf(i*4));
            //Converting primative type to the object of its corresponding
            //wrapper class
            //Term: Autoboxing
        }
        
        for(int i=0; i < mylist2.size(); i++){
            System.out.println(mylist2.get(i).intValue());
            
        }
        
        for(int i = 0; i<10; i++){
            mylist2.add(Integer.valueOf(i*4));
            //Converting primative type to the object of its corresponding
            //wrapper class
            //Term: Autoboxing
        }
        
        for(int i=0; i < mylist2.size(); i++){
            System.out.println(mylist2.get(i));
            
        }
    }
}
