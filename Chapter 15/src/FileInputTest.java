/*
 * Copyright (C) 2020 Dalton Redman <dalton.redman@mavs.uta.com>
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class FileInputTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream("myfile2.txt");
            
//            System.out.println("1.Character: "+ (char)fis.read());
//            System.out.println("2.Character: "+ (char)fis.read());
//            System.out.println("3.Character: "+ (char)fis.read());
            
//            fis.skip(5);
//            System.out.println("6.Character: "+ (char)fis.read());
            
            
            //Prints the entire contents
//            int value;
//            String s = "";
//            
//            while((value = fis.read())!= -1){
//                s+= (char)value;
//            }
//            
//            System.out.println("File Contents is: " +s);
            
            //
            int count = 0;
            fis.skip(5);
            int value;
            String s = "";
            
            while((value = fis.read())!= -1){
                
            }
            
            System.out.println("File Contents is: " +s);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInputTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileInputTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileInputTest.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            }
        }
    }
}
