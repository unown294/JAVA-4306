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
public class SingerList {
    
    private ArrayList <String> singer_list = new ArrayList <String>();
    
    public void viewSingers(){
        
        System.out.println("In the list, there are "+ singer_list.size());
        
        for(int i=0; i<singer_list.size(); i++){
            System.out.println((i+1)+".singer is "+ singer_list.get(i));
        }
    }
    
    public void addSinger (String name){
        singer_list.add(name);
        System.out.println("Singer is added...");
    }
    
    
    public void updateSingers(String newname, int position){
        singer_list.set(position, newname);
        System.out.println("Singer list is updated...");
    }
    
    public void deleteSingers(int position){
        
        String name = singer_list.get(position);
        singer_list.remove(position);
        
        System.out.println("Singer" + name + "is deleted.");
    }
    
    public void searchSinger(String name){
        
        int position = singer_list.indexOf(name);
        
        if( position >= 0){
            System.out.println("Singer is in the list");
            System.out.println("Singer" + name + " is in the "+ (position + 1)+ ". Position");
        }
        else{
            System.out.println("Singer is not in the list. Sorry");
        }
    }
}
