
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class MP3Copy {
    private static ArrayList <Integer> content = new ArrayList <>();
    
    public static void readFile(){
        try {
            FileInputStream in = new FileInputStream("applause.mp3");
            int contentRead;
            
            while((contentRead = in.read())!= -1){
                content.add(contentRead);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MP3Copy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MP3Copy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void copyContent(String fileName){
        try {
            FileOutputStream out = new FileOutputStream (fileName);
            
            for(int value: content){
                out.write(value);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MP3Copy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MP3Copy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        readFile();
        copyContent("applause1.mp3");
    }
}
