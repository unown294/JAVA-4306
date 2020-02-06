/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Scanner;

/**
 *
 * @author New User
 */
public class CardTest {
    
    private static Card [][] cards = new Card [4][4];
    
    //psvm then tab generates a main class
    public static void main(String[] args) {
        //Row One
        cards [0][0] = new Card ('E');
        cards [0][1] = new Card ('A');
        cards [0][2] = new Card ('B');
        cards [0][3] = new Card ('F');
        
        //Row Two
        cards [1][0] = new Card ('G');
        cards [1][1] = new Card ('A');
        cards [1][2] = new Card ('D');
        cards [1][3] = new Card ('H');
        
        //Row Three
        cards [2][0] = new Card ('F');
        cards [2][1] = new Card ('C');
        cards [2][2] = new Card ('D');
        cards [2][3] = new Card ('H');
        
        //Row Four
        cards [3][0] = new Card ('E');
        cards [3][1] = new Card ('G');
        cards [3][2] = new Card ('B');
        cards [3][3] = new Card ('C');
     
        //Runs and manages the opperations of the game. Also shows the table
        //at various states of the game.
        while(isFinished ()==false){
            
            gameTable();
            guess();
            
            if(isFinished ()){
                gameTable();
            }
        }
    }
        
    public static void guess () {
            Scanner in = new Scanner (System.in);
            //ctrl + Shift + i to import classes
            
            //'sout' then tab
            System.out.print("First guess (enter i and j values with a space): ");
            int i1 = in.nextInt();
            int j1 = in.nextInt();
            
            //Error check
            //Sets defualt if values is beyond the scope of the array
            if(i1 < 0 || i1 > 3){
                i1 = 0;
            }
            //Sets defualt if values is beyond the scope of the array
            if(j1 < 0 || j1 > 3){
                i1 = 0;
            }
            
            cards[i1][j1].setGuess(true);
            
            System.out.print("Second guess (enter i and j values with a space): ");
            int i2 = in.nextInt();
            int j2 = in.nextInt();
            
            //Error check
            //Sets defualt if values is beyond the scope of the array
            if(i1 < 0 || i1 > 3){
                i1 = 0;
            }
            //Sets defualt if values is beyond the scope of the array
            if(j1 < 0 || j1 > 3){
                i1 = 0;
            }
            
            cards[i2][j2].setGuess(true);
            
            if(cards[i1][j1].getValue() == cards[i2][j2].getValue()){
                
                System.out.println("Correct!");
                cards[i2][j2].setGuess(true);
                
            }
            else{
                
                System.out.println("Wrong!");
                cards[i1][j1].setGuess(false);
                
            }
        }
    
    public static boolean isFinished(){
        for(int i=0;i<4;i++){ //Row
            for(int j=0;j<4;j++){ //Column
                
                //Test the state of the game if its running
                if(cards[i][j].isGuess()==false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void gameTable(){
        for(int i=0;i<4;i++){
            System.out.println("...........................");
            
            for(int j=0;j<4;j++){
                
                if(cards[i][j].isGuess()){
                    
                    System.out.print(" |"+ cards[i][j].getValue()+"| ");
                    
                }
                else{
                    System.out.print(" | | ");
                }
                
            }//Inner looup
            
            System.out.println("");
        }//Outer Loop
        
        System.out.println("...........................");
    }
}
