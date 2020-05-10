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

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class FileReaderTest {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(new BufferedReader(new FileReader("students.txt")))){
            //BufferedReader - Reads characters
            //But buffer them as to provide for the efficient
            //reading of characters
            
            while(in.hasNextLine()){
                String student = in.nextLine();
                
                String [] array = student.split(",");
                
                if(array[1].equals("Information System")){
                    System.out.println("Student Info: " + student);
                }
                
            }
            
            System.out.println();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //BufferedWriter
        //Buffer characters so as to provide
        //for efficient writing of single character, strings
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))){
            writer.write("\n");
            writer.write("Tom Hanks,Information Systems");
        } catch (IOException ex) {
            Logger.getLogger(FileReaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
