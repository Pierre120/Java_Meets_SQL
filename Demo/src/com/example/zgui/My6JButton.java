/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author pierre
 */
public class My6JButton {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw&t=2547s
     */
    public static void main(String[] args) {
        // JButton = a button that performs an action when clicked on
        
        MyFrame frame = new MyFrame();
    }
    
}

class MyFrame extends JFrame implements ActionListener{
    
    private final String actionCmd = "BUTTON CLICK";

    private JButton button;
    private JLabel label;

    public MyFrame() {
            ImageIcon icon = new ImageIcon("images/cat.jpg");
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); // get scaled image
            icon.setImage(img); // sets the image icon with the new/scaled image

            label = new JLabel();
            label.setIcon(icon);
            label.setBounds(150, 250, 150, 150);
            label.setVisible(false);

            button = new JButton();
            button.setBounds(100, 100, 250, 100);
            button.setActionCommand(actionCmd);
            button.addActionListener(this);
            button.setText("I'm a button!");

            button.setFocusable(false);
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.BOTTOM);
            button.setFont(new Font("Comic Sans",Font.BOLD,25));
            button.setIconTextGap(-15);
            button.setForeground(Color.cyan);
            button.setBackground(Color.lightGray);
            button.setBorder(BorderFactory.createEtchedBorder());

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setSize(500,500);
            this.setVisible(true);
            this.add(button);
            this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if(e.getSource()==button) {
        if(e.getActionCommand().equals(actionCmd)) {
            System.out.println("Button clicked.");
            button.setEnabled(false);
            label.setVisible(true);
        }	
    }
}
