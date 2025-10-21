/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author pierre
 */
public class My8JTable {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=S6evF1T_lrU
     */
    public static void main(String[] args) {
        String[] columnNames = new String[] { "ID", "Phrase" };
        String[][] data = new String[][] {
            {"123", "You're doing great."},
            {"456", "You're handsome/gorgeous."},
            {"789", "All is well."},
        };
        
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table); // adds scroll feature to table
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.add(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
    
}
