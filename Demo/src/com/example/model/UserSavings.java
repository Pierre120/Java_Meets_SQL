/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author pierre
 */
public class UserSavings {
    
    public long userId;
    public ArrayList<Savings> userSavingsRecords;
    
    public UserSavings() {
        userId = 0L;
        userSavingsRecords = new ArrayList<>();
    }
    
    public void resetRecords() {
        userSavingsRecords.clear();
    }
    
    public int getRecords() {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT      *                                ");
        query.append(" FROM        savings                          ");
        query.append(" WHERE       user_id=?                        ");
        query.append(" ORDER BY    save_date DESC, create_dttm DESC ");
        
        try {
            // Establish connection to DB
            Connection conn = MySQLConnector.connectDB();
            
            // Prepare SQL statement to be executed
            PreparedStatement statement = conn.prepareStatement(query.toString());
            
            // Set the parameters
            statement.setLong(1, userId);
            
            // Execute statement to get records
            ResultSet results = statement.executeQuery();
            
            // Get results
            while (results.next()) {
                Savings savingsRecord = new Savings();
                savingsRecord.userId = results.getLong("id");
                savingsRecord.createDttm = results.getObject("create_dttm", LocalDateTime.class);
                savingsRecord.saveDate = results.getObject("save_date", LocalDate.class);
                savingsRecord.amount = results.getBigDecimal("amount");
            }
            
            // Check number of records retrieved
            if (userSavingsRecords.isEmpty()) {
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
            return -1;
        }
    }
}
