/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.model.Report;
import com.example.model.Savings;
import com.example.model.User;
import com.example.model.UserSavings;
import com.example.view.DashboardFrame;
import java.util.ArrayList;

/**
 *
 * @author pierre
 */
public class AppController {
    
    private static User user = new User();
    
    public static void setUserSession(User userModel) {
        user = userModel;
    }
    
    public static boolean loginUser(String loginUsername,  String loginPassword) {
        if (user.login(loginUsername, loginPassword) == 1) {
            DashboardFrame dashboardFrame = new DashboardFrame();
            dashboardFrame.setVisible(true);
            return true;
        }
        return false;
    }
    
    public static String[][] getUserSavingsRecord() {
        UserSavings userSavings = new UserSavings();
        userSavings.userId = user.id;
        int res = userSavings.getRecords();
        if (res == 1) {
            ArrayList<Savings> savingsRecords = userSavings.userSavingsRecords;
            String[][] data = new String[savingsRecords.size()][4];
            
            int i = 0;
            for (Savings savings: savingsRecords) {
                data[i][0] = String.valueOf(savings.userId);
                data[i][1] = savings.createDttm.toString();
                data[i][2] = savings.amount.toString();
                data[i][3] = savings.saveDate.toString();
                ++i;
            }
            
            if (i > 0) {
                return data;
            }
        }
        
        return new String[][] { {null, null, null, null} };
    }
}
