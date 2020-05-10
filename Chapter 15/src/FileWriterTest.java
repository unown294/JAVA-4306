
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

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class FileWriterTest {
    //File Writer
    //File Reader
    //They work with streams of characters
    
    public static void main(String[] args) {
        FileWriter writer = null;
        
        try {
            writer = new FileWriter("myfile3.txt", true);
            writer.write("java programming\n");
            writer.write("language\n");
            writer.write("test");
            
            
        } catch (IOException ex) {
            Logger.getLogger(FileWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileWriterTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
