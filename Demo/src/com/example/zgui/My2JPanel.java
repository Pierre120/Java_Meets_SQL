/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pierre
 */
public class My2JPanel {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw&t=1775s
     */
    public static void main(String[] args) {
        // JPanel = a GUI component that functions as a container to hold other components
        
        ImageIcon imgIcon = new ImageIcon("images/cooked_dog_meme-square.jpg");
        Image img = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // get scaled image
        imgIcon.setImage(img); // sets the image icon with the new/scaled image
        
        JLabel label = new JLabel();
        label.setIcon(imgIcon);
        
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0, 0, 250, 250);
        greenPanel.add(label);
        
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(250, 0, 250, 250);
        whitePanel.add(new JLabel("Some text here."));
        // whitePanel.add(label);
        
        JPanel blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBounds(100, 250, 200, 200);
        // blackPanel.add(label);
        
        JFrame frame = new JFrame("JFrame title goes here"); // creates a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application (terminate app)
        frame.setSize(500,500); // sets the x-dimension, and y-dimension of frame
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null); // manually set the positions of each component
        frame.setVisible(true); // make frame visible
        frame.add(greenPanel);
        frame.add(whitePanel);
        frame.add(blackPanel);
    }
    
}
