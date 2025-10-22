/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.app;

import com.example.controller.AppController;
import com.example.model.Report;
import com.example.model.Savings;
import com.example.model.User;
import com.example.model.UserSavings;
import com.example.view.LoginFrame;

/**
 *
 * @author pierre
 */
public class SimpleSavingsTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User();
        AppController.setUserSession(user);
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
    
}
