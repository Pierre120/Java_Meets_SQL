/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author pierre
 */
public class My0JFrame {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw
     */
    public static void main(String[] args) {
        // JFrame = a GUI window to add components to
        
        JFrame frame = new JFrame(); // creates a frame
        frame.setTitle("JFrame title goes here"); // Sets a new title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application (terminate app)
        frame.setSize(420,420); // sets the x-dimension, and y-dimension of frame
        frame.setResizable(false); // prevent frame from being resized
        frame.getContentPane().setBackground(Color.GREEN); // change background color of frame
        frame.setVisible(true); // make frame visible
        
        // Changing image icon of JFrame instead of default Java icon image
        ImageIcon iconImg = new ImageIcon("images/cooked_dog_meme-square.jpg");
        frame.setIconImage(iconImg.getImage());
    }
    
}
