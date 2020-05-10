/*
 * Copyright (C) 2020 Dalton
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton
 */
public class GradeList {
    public static String getLetterGrade(String name, int exam1, int exam2, int finalExam){
        String letter="";
        
        double average = (exam1*3/10.0) + (exam2*3/10.0) + (finalExam*4/10.0);
        
        if(average >= 90){
            letter = name + " gets an A";
        }
        else if(average >= 80){
            letter = name+ " gets a B";
        }
        else if(average >= 70){
            letter = name+ " gets a C";
        }
        else if(average >= 60){
            letter = name + " gets a D";
        }
        else{
            letter = name + " gets an F";
        }
        
        return letter;
    }
    
    public static void main(String[] args) {
        boolean debug = true;
        
        try(Scanner in = new Scanner(new FileReader("grade-list.txt"))){
            FileWriter writer = new FileWriter("lettergrades.txt");
            
            while(in.hasNext()){
                
                String student = in.nextLine();
                String [] studentarray = student.split(",");
                
                int exam1 = Integer.valueOf(studentarray[1]);
                int exam2 = Integer.valueOf(studentarray[2]);
                int finalExam = Integer.valueOf(studentarray[3]);
                String output = getLetterGrade(studentarray[0], exam1, exam2, finalExam);
                writer.write(output+"\n");
                
                if(debug = true){
                    System.out.println(studentarray[0]);
                    System.out.println(exam1);
                    System.out.println(exam2);
                    System.out.println(finalExam);
                    System.out.println(output);
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GradeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GradeList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
