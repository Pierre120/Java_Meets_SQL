/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author pierre
 */
public class My1JLabel {

    /**
     * @param args the command line arguments
     * @see https://www.youtube.com/watch?v=Kmgo00avvEw&t=729s
     */
    public static void main(String[] args) {
        // JLabel = a GUI display area for a string of text, an image, or both
        
        ImageIcon imgIcon = new ImageIcon("images/cooked_dog_meme-square.jpg");
        Image img = imgIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT); // get scaled image
        imgIcon.setImage(img); // sets the image icon with the new/scaled image
        Border border = BorderFactory.createLineBorder(Color.yellow, 4); // border component to be added to label
        
        JLabel label = new JLabel(); // create a label
        label.setText("POV: You thought the deadline was 11:59PM but it was 11:59AM."); // set text of label
        label.setIcon(imgIcon);
        label.setSize(300, 300); // sets the size of the label
        label.setHorizontalTextPosition(JLabel.CENTER); // set text position in x-axis: LEFT, CENTER, RIGHT
        label.setVerticalTextPosition(JLabel.TOP); // set text position in y-axis: TOP, CENTER, BOTTOM
        label.setForeground(Color.WHITE); // ets font color of text
        label.setFont(new Font("Consolas", Font.BOLD, 20)); // sets the font style of text
        label.setIconTextGap(12); // sets the gap of the text and image of label (values in pixels)
        label.setBackground(Color.BLACK); // sets the background of label
        label.setOpaque(true); // to make the background color show
        label.setBorder(border); // sets the border of the label
        label.setHorizontalAlignment(JLabel.RIGHT); // sets the alignment in x-axis of the label in which it is added to
        label.setVerticalAlignment(JLabel.CENTER); // sets the alignment in y-axis of the label in which it is added to
        // label.setBounds(100, 100, 250, 250); // sets the x,y position within the frame as well as the dimension
        
        JFrame frame = new JFrame("JFrame title goes here"); // creates a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application (terminate app)
        frame.setSize(500,500); // sets the x-dimension, and y-dimension of frame
        // frame.setLayout(null); // allow the JLabel to set its bounds (position and dimension)
        frame.setVisible(true); // make frame visible
        frame.add(label); // add label to the frame
        frame.pack(); // resize to frame to fit the size of the components
        // NOTE: Add all components first in the frame before calling the pack() method
    }
    
}
