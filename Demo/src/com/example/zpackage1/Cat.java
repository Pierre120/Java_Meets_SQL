/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zpackage1;

import java.util.Random;

/**
 *
 * @author pierre
 */
public class Cat extends Animal {
    
    private int cutenessLevel = 1000;
    
    public void showAllAttributes() {
        // Access modifier: private
        // System.out.println("private (id) is: " + id); // Can only be accessed by the parent class
        System.out.println("private (id) is: " + getId()); // Access private attribute via getter method
        
        // Access modifier: protected
        System.out.println("protected (protectedValue) is: " + protectedValue); // accessible in a child class
        
        // Access modifier: <default>
        System.out.println("<default> (canYouAccessThisDefaultScopeAttr) is:" 
                + canYouAccessThisDefaultScopeAttr); // accessible in child class
        
        // Access modifier: public
        System.out.println("public (isAnimal) is:" + isAnimal); // accessible in child class
        
        System.out.println("private (cutenessLevel) is: " + cutenessLevel); // only accessible to this child class
    }

    @Override
    public void speak() {
        System.out.println(generateMeowAction());
    }
    
    private String generateMeowAction() {
        Random rn = new Random();
        
        if (rn.nextBoolean()) {
            return "*Loaf* Meow.";
        }
        
        return "*Stretch* Meow.";
    }
    
}
