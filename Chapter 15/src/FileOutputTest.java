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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class FileOutputTest {
    
    //FileOutputStream
        //Write in a stream of bytes to a file
    
    //FileInputStream
        //obtains input bytes from a file
    
    public static void main(String[] args) {
        
        FileOutputStream fos = null;
        File file = new File("myfile.txt");
        
        try {
            fos = new FileOutputStream (file);
            //True 
            
            //Character writing
            //fos.write(65);  //ASCII Character A
            //fos.write(74);  //ASCII Character J
            
            //byte [] array = {101, 75, 65, 36};
            //fos.write(array);
            
            String s = "UTA Business";
            byte [] s_array = s.getBytes();
            fos.write(s_array);
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("File was unable to be found");
        } catch (IOException ex) {
            System.out.println("An error occured while writing to the file");
        }
        finally{
            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("An exception occured while the file was being closed");
            }
        }
        
    }
    
}
