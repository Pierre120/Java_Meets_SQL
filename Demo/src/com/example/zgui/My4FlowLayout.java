/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author pierre
 */
public class My4FlowLayout {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw&t=4045s
     */
    public static void main(String[] args) {
        // Layout Manager = Defines the natural layout for components within a container
        // 3 common layouts: BorderLayout, FlowLayout, GridLayout

        // FlowLayout = places components in a row, sized at their preferred size. 
        //              If the horizontal space in the container is too small,
        //              the FlowLayout class uses the next available row.

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));

        frame.setVisible(true);
    }
    
}
