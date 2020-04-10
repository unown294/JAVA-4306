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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class MyConnection {
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";
    Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public MyConnection(){
        //Select the Surround block with catch option when creating these blocks
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connection is Successful");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DisplayAuthors(){
        //Select the Surround block with catch option when creating these blocks
        try {
            String query = "Select * from AUTHORS";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                String authorid = rs.getString("AUTHORID");
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("LASTNAME");
                
                System.out.println("Author ID: "+ authorid + " First Name: " + firstname + " Last Name: " + lastname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Adds data into the Database
    public void addAuthor(){
        
        //Select the Surround block with catch option when creating these blocks
        try {
            String query = "insert into AUTHORS (FIRSTNAME, LASTNAME) values ('Dalton', 'Redman')";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateAuthor(){
        try {
            String query = "update AUTHORS set LASTNAME='Redman' where AUTHORID=1";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteAuthor(){
        try {
            String query = "delete from AUTHORS where AUTHORID > 5";
            
            statement = connection.createStatement();
            int value = statement.executeUpdate(query);
            System.out.println(value+ " record(s) is/are deleted");
            
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void preparedDisplayAuthors(String firstname, int id){
        try {
            String query = "select * from AUTHORs where FIRSTNAME like ? AND AUTHORID > ?"; //May be written wrong

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setInt(2, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                String authorid = rs.getString("AUTHORID");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                
                System.out.println(authorid + " "+ firstName + " "+ lastName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commitRollBack(){
        try {
            Scanner in = new Scanner(System.in);
            
            connection.setAutoCommit(false);
            String query1 = "update AUTHORS set LASTNAME = 'Redman' where AUTHORID = 3";
            String query2 = "update AUTHORS set LASTNAME = 'Dalton' where AUTHORID = 2";
            
            statement = connection.createStatement();
            statement.executeUpdate(query2);
            statement.executeUpdate(query1);
            
            System.out.println("Would you like to process? yes/no");
            String answer = in.nextLine();
            
            if(answer.equals("yes")){
                connection.commit();
                System.out.println("Changes have been commited");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        MyConnection myconnection = new MyConnection();
        myconnection.DisplayAuthors();
        
        //Adds a new Author and displays it
        myconnection.addAuthor();
        myconnection.DisplayAuthors();
        
        //Displays updated AUTHORID's
        myconnection.updateAuthor();
        myconnection.DisplayAuthors();
        
        myconnection.deleteAuthor();
        
        myconnection.preparedDisplayAuthors("Harvey", 1);
        
        myconnection.commitRollBack();
    }
}
