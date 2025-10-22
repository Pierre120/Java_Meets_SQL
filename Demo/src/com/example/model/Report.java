/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;

/**
 *
 * @author pierre
 */
public class Report {
    
    public long userId;
    public int reportYear;
    public Month reportMonth;
    public ArrayList<Savings> savingsReportList;
    
    public Report() {
        userId = 0L;
        reportYear = 0;
        reportMonth = null;
        savingsReportList = new ArrayList<>();
    }
    
    public void resetReport() {
        savingsReportList.clear();
    }
    
    public int generateReport() {
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
            statement.setObject(2, null);
            
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
}
