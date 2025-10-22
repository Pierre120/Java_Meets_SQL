/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.jxsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.*;


/**
 *
 * @author pierre
 */
public class World {
    
    // IMPORTANT: Define DB connection URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    
    private static Connection conn = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Testing DB Connection...");
        connectDB();
        getCountryLanguage("PHL", "");
    }
    
    // 1. Establish a connection to the DB
    public static void connectDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to World DB!");
        } catch (SQLException ex) {
            System.getLogger(World.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public static void getCountryLanguage(String countryCode, String official) {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT  *               ");
        query.append(" FROM    CountryLanguage ");
        query.append(" WHERE   CountryCode = ? ");
        
        if (official.equals("T") || official.equals("F")) {
            query.append(" AND IsOfficial = ? ");
        }
        
        try {
            PreparedStatement stmt;
            stmt = conn.prepareCall(query.toString());
            // Setting of parameter index starts at index 1.
            stmt.setString(1, countryCode);
            
            if (official.equals("T") || official.equals("F")) {
                stmt.setString(2, official);
            }
            
            // For fetching multilple records
            ResultSet rs;
            rs = stmt.executeQuery();
            
            // For checking if a specific record exists
            // stmt.execute();

            // For INSERT, DELETE, and UPDATE instructions. trackng number of rows updated
            // stmt.executeUpdate();
            
            while (rs.next()) {
                String code = rs.getString("CountryCode");
                String language = rs.getString("Language");
                String isOfficial = rs.getString("IsOfficial");
                double percentage = rs.getDouble("Percentage");
                System.out.println(code + ", " + language + ", "
                        + isOfficial + ", "
                        + percentage);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
