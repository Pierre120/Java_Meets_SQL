/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pierre
 */
public class My3BorderLayout {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw&t=3379s
     */
    public static void main(String[] args) {
        // Layout Manager = Defines the natural layout for components within a container
        // 3 common layouts: BorderLayout, FlowLayout, GridLayout
        
        // BorderLayout = A BorderLayout places components in five areas:
        //                NORTH, SOUTH, EAST, WEST, and CENTER.
        //                All extra space is placed in the center area
        
        JFrame frame = new JFrame("JFrame title goes here"); // creates a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application (terminate app)
        frame.setSize(500,500); // sets the x-dimension, and y-dimension of frame
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(new BorderLayout(12, 4)); // sets to use the BorderLayout manager
        frame.setVisible(true); // make frame visible
        
        // Main panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        
        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.GREEN);
        panel3.setBackground(Color.YELLOW);
        panel4.setBackground(Color.MAGENTA);
        panel5.setBackground(Color.BLUE);
        
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));
        
        // Sub panels
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        
        panel6.setBackground(Color.BLACK);
        panel7.setBackground(Color.DARK_GRAY);
        panel8.setBackground(Color.GRAY);
        panel9.setBackground(Color.LIGHT_GRAY);
        panel10.setBackground(Color.WHITE);
        
        panel6.setPreferredSize(new Dimension(50, 50));
        panel7.setPreferredSize(new Dimension(50, 50));
        panel8.setPreferredSize(new Dimension(50, 50));
        panel9.setPreferredSize(new Dimension(50, 50));
        panel10.setPreferredSize(new Dimension(50, 50));
        
        panel5.setLayout(new BorderLayout());
        
        panel5.add(panel6, BorderLayout.NORTH);
        panel5.add(panel7, BorderLayout.WEST);
        panel5.add(panel8, BorderLayout.EAST);
        panel5.add(panel9, BorderLayout.SOUTH);
        panel5.add(panel10, BorderLayout.CENTER);
        
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.EAST);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.CENTER);
    }
    
}
