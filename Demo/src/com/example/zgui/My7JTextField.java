/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author pierre
 */
public class My7JTextField {
    
    private static JButton button;
    private static JTextField textField;

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw&t=6603s
     */
    public static void main(String[] args) {
        // JTextField = A GUI textbox component that can be used to add, set, or get text

        button = new JButton("Submit");
        button.addActionListener(new ButtonListener());

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas",Font.PLAIN,35));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setText("username");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(textField);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static class ButtonListener implements ActionListener {
        @Override
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button) {
                System.out.println("Welcome "+ textField.getText());
                //button.setEnabled(false);
                //textField.setEditable(false);
            }
        }
    }
}
