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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class WorkerOptions {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedstatement = null;
    
    //create database connection
    
    public WorkerOptions(){
        try {
            connection = DriverManager.getConnection(Database.DATABASE_URL, Database.USERNAME, Database.PASSWORD);
            System.out.println("Connection is successful");
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean login(String username, String password){
        try {
            String query = "select * from ADMIN where USERNAME=? AND PASSWORD=?";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);
            
            //select query returns a result set
            ResultSet rs = preparedstatement.executeQuery();
            return rs.next(); //Returns true or false depending on the next record determining if it exist
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList <Worker> viewWorkers(){
        try {
            ArrayList <Worker> worker = new ArrayList <>();
            String query = "Select * from WORKER";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("WORKERID");
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("LASTNAME");
                String department = rs.getString("DEPARTMENT");
                double salary = rs.getDouble("SALARY");
                
                //Adds a worker object to the Worker array list
                worker.add(new Worker(id, firstname, lastname, department, salary));
                
                
            }
            
            return worker;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
                
    }
    
    public void addWorker(String firstname, String lastname, String department, double salary){
        try {
            String query = "insert into WORKER(FIRSTNAME, LASTNAME, DEPARTMENT, SALARY) values (?, ?, ?, ?)";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, firstname);
            preparedstatement.setString(2, lastname);
            preparedstatement.setString(3, department);
            preparedstatement.setDouble(4, salary);
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteWorker(int id){
        try {
            String query = "delete from WORKER where WORKERID=?";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateWorker(int id, String firstname, String lastname, String department, double salary){
        try {
            String query = "update WORKER set FIRSTNAME=?, LASTNAME=?, DEPARTMENT=?, SALARY=? where WORKERID=?";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, firstname);
            preparedstatement.setString(2, lastname);
            preparedstatement.setString(3, department);
            preparedstatement.setDouble(4, salary);
            preparedstatement.setInt(5, id);
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
