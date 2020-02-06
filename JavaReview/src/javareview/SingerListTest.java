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
public class SingerListTest {
    private static SingerList singers = new SingerList();
    private static Scanner in = new Scanner(System.in); 
    
    public static void viewOptions(){
        System.out.println("\t0 - View Options");
        System.out.println("\t1 - View Singers");
        System.out.println("\t2 - Add Singer");
        System.out.println("\t3 - Update Singer");
        System.out.println("\t4 - Delete Singer");
        System.out.println("\t5 - Search Singer");
        System.out.println("\t6 - Exit");
    }
    
    public static void viewSinger(){
        singers.viewSingers();
    }//end viewSinger
    
    public static void addSinger(){
        System.out.println("Please enter your singer name: ");
        
        //Scanner object variable
        String Name = in.nextLine();
        
        //Singer list object value
        singers.addSinger(Name);
    }//end addSinger
    
    public static void updateSinger(){
        System.out.println("Please enter the position of the singer");
        int position = in.nextInt();
        
        //5\n
        //dalton
        //dummy read to allow the reading of proper placement
        in.nextLine();
        
        System.out.printf("Please update the name of the singer at %d:" ,position);
        String name = in.nextLine();
        
        singers.updateSingers(name, position-1);
    }
    
    public static void deleteSinger(){
        System.out.println("Please enter the position of the singer you wish to remove: ");
        int position = in.nextInt();
        
        singers.deleteSingers(position);
    }
    
    public static void searchSinger(){
        System.out.println("Please enter the name of the singer you wish to search: ");
        String name = in.nextLine();
        
        singers.searchSinger(name);
    }
    
    public static void main(String[] args) {
        System.out.println("\t Welcome to Singer Application...");
        viewOptions();
        
        //variables
        boolean exit = false;
        int choice;
        
        while(!exit){
            System.out.println("\nSelect an option: ");
            choice = in.nextInt();
            
            in.nextLine();
            
            switch(choice){
                case 0:
                    viewOptions();
                    break;
                case 1:
                    viewSinger();
                    break;
                case 2:
                    addSinger();
                    break;
                case 3:
                    updateSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    searchSinger();
                    break;
                case 6:
                    exit = true;
                    System.out.println("You are exiting...");
                    break;
                default:
                    System.out.println("Invalid option selected. Please select a value between 1 & 6");
                    break;
            }
        }
    }
}
