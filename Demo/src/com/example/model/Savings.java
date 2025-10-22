/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author pierre
 */
public class Savings {
    
    public long userId;
    public LocalDateTime createDttm;
    public LocalDate saveDate;
    public BigDecimal amount;
    
    public Savings() {
        userId = 0;
        createDttm = null;
        saveDate = null;
        amount = BigDecimal.ZERO;
    }
    
    public int addRecord() {
        StringBuilder query = new StringBuilder();
        query.append(" INSERT INTO user (user_id, save_date, amount) ");
        query.append(" VALUES (?, ?, ?)                              ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setLong(1, userId);
            statement.setDate(2, Date.valueOf(saveDate));
            statement.setBigDecimal(3, amount);
            
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
    
    public int deleteRecord() {
        StringBuilder query = new StringBuilder();
        query.append(" DELETE  FROM savings  ");
        query.append(" WHERE   user_id=?     ");
        query.append(" AND     create_dttm=? ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setLong(1, userId);
            statement.setObject(2, createDttm);
            
            // Execute adding of new user
            int numDeleted = statement.executeUpdate();
            
            // Release JDBC resources
            statement.close();
            conn.close();
            
            return numDeleted;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    
    public int modifyRecord() {
        StringBuilder query = new StringBuilder();
        query.append(" UPDATE  savings    ");
        query.append(" SET     save_date=?, amount=?       ");
        query.append(" WHERE   user_id=? and create_dttm=? ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setDate(1, Date.valueOf(saveDate));
            statement.setBigDecimal(2, amount);
            statement.setLong(3, userId);
            statement.setObject(4, createDttm);
            
            // Execute adding of new user
            int numDeleted = statement.executeUpdate();
            
            // Release JDBC resources
            statement.close();
            conn.close();
            
            return numDeleted;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public int getRecord() {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT  *             ");
        query.append(" FROM    savings       ");
        query.append(" WHERE   user_id=?     ");
        query.append(" AND     create_dttm=? ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setLong(1, userId);
            statement.setObject(2, createDttm);
            
            // Execute statement to get record
            ResultSet results = statement.executeQuery();
            
            // Get results
            while (results.next()) {
                userId = results.getLong("id");
                createDttm = results.getObject("create_dttm", LocalDateTime.class);
                saveDate = results.getObject("save_date", LocalDate.class);
                amount = results.getBigDecimal("amount");
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
