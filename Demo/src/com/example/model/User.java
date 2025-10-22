/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pierre
 */
public class User {
    
    public long id;
    public String username;
    public String password;
    
    public User() {
        id = 0L;
        username = "";
        password = "";
    }
    
    /**
     * Adds new user record.
     * 
     * @param newUsername username of the new user to be added. Must be unique.
     * @param newPassword password of the new user to be added.
     * 
     * @return number of user records added. Otherwise, -1 if an error occurred.
     */
    public int signUp(String newUsername, String newPassword) {
        StringBuilder query = new StringBuilder();
        query.append(" INSERT INTO user (username, password) ");
        query.append(" VALUES (?, ?)                         ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            
            // Execute adding of new user
            int numAdded = statement.executeUpdate();
            
            // Release JDBC resources
            statement.close();
            conn.close();
            
            return numAdded;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    /**
     * Logs in the user.
     * 
     * @param loginUsername username of the existing user.
     * @param loginPassword password of the existing user.
     * 
     * @return 1 if user logging in exists in DB. Otherwise, 0.
     */
    public int login(String loginUsername,  String loginPassword) {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT  *          ");
        query.append(" FROM    user       ");
        query.append(" WHERE   username=? ");
        query.append(" AND     password=? ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setString(1, loginUsername);
            statement.setString(2, loginPassword);
            
            // Execute login by getting user info
            ResultSet results = statement.executeQuery();
            
            id = 0L;
            username = "";
            password = "";
            
            // Get results
            while (results.next()) {
                id = results.getLong("id");
                username = results.getString("username");
            }
            
            // Check if user exists
            if (username.isBlank()) {
                return 0;
            }
            
            // Release JDBC resources
            results.close();
            statement.close();
            conn.close();
            
            return 1;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
}
