/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zpackage2;

import com.example.zpackage1.Cat;

/**
 *
 * @author pierre
 */
public class DriverClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Accessing a package-private class
        // Animal animal = new Animal(); // Animal class is only accessible within com.example.package1
        
        Cat cat = new Cat();
        cat.speak();
    }
    
}
