

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
public class AddressOptions {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedstatement = null;
    
    public AddressOptions(){
        try {
            connection = DriverManager.getConnection(Database.DATABASE_URL, Database.USERNAME, Database.PASSWORD);
            System.out.println("Connection is successful");
            
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList <Address> viewAddress(){
        try {
            ArrayList <Address> address = new ArrayList <>();
            String query = "select * from ADDRESSES";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("AddressID");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                String phoneNumber = rs.getString("PHONENUMBER");
                
                address.add(new Address(id, firstName, lastName, email, phoneNumber));
            }
            
            return address;
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    public void addAddress(String firstName, String lastName, String email, String phoneNumber){
        try {
            String query = "insert into ADDRESSES(FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER) values (?, ?, ?, ?)";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, firstName);
            preparedstatement.setString(2, lastName);
            preparedstatement.setString(3, email);
            preparedstatement.setString(4, phoneNumber);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteAddress(int id){
        try {
            String query = "delete from ADDRESSES where ADDRESSID=?";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteAllAddress(){
        try {
            String query = "DELETE FROM ADDRESSES";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAddress(int id, String firstName, String lastName, String email, String phoneNumber){
        try {
            String query = "update ADDRESSES set FIRSTNAME=?, LASTNAME=?, EMAIL=?, PHONENUMBER=? where ADDRESSID=?";
            
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, firstName);
            preparedstatement.setString(2, lastName);
            preparedstatement.setString(3, email);
            preparedstatement.setString(4, phoneNumber);
            preparedstatement.setInt(5, id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
