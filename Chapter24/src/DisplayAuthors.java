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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */

public class DisplayAuthors {
    public static void main(String[] args) {
        final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
        final String SELECT_QUERY = "select AUTHORID FIRSTNAME LASTNAMES from AUTHORS";
        
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, "test", "test")){
            Statement statement = connection.createStatement();
            
            //select statement returns a result set
            //including a list of records + meta data

            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            
            ResultSetMetaData metaData = resultSet.getMetaData();
            //Gets the metadata, type of data that is stored
            
            int numberOfColumns = metaData.getColumnCount();
            
            System.out.printf("Authors Table of Books Database: \n\n");
            
            for(int i = 1; i < numberOfColumns; i++){
                
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                
            }
            
            System.out.println();
            //creates a spacer
            
            while(resultSet.next()){    //Returns a boolean and if false this will close the loop
                
                for(int i = 1; i <= numberOfColumns; i++){
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(DisplayAuthors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
