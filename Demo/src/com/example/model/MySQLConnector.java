/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pierre
 */
class MySQLConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sst_db";
    private static final String USER = "demo_user";
    private static final String PASSWORD = "1234";
    
    /**
     * Attempts to establish a connection to the specified database.
     * 
     * @return connection to the given DB connection URL
     * @throws java.sql.SQLException if a database access error occurs
     */
    public static Connection connectDB() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
    
    
//    public static void main(String[] args) {
//        System.out.println("Testing DB Connection...");
//        try {
//            connectDB();
//        } catch (SQLException ex) {
//            System.out.println("Connection failed!");
//            System.getLogger(MySQLConnector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
//    }
    
}
