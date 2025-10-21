/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zpackage1;

/**
 *
 * @author pierre
 */
class Animal {
    
    private int id = 0xF1;
    protected String protectedValue = "You";
    boolean canYouAccessThisDefaultScopeAttr = true;
    public boolean isAnimal = true;
    
    public void speak() {
        System.out.println("This is the Animal Parent Class.");
    }
    
    public void showAttributes() {
        // Access modifier: private
        System.out.println("private (id) is: " + id); // accessible within the class
        
        // Access modifier: protected
        System.out.println("protected (protectedValue) is: " + protectedValue); // accessible within the class
        
        // Access modifier: <default>
        System.out.println("<default> (canYouAccessThisDefaultScopeAttr) is:" 
                + canYouAccessThisDefaultScopeAttr); //accessible within the class
        
        // Access modifier: public
        System.out.println("public (isAnimal) is:" + isAnimal); // accessible within the class
    }
    
    public int getId() {
        return id;
    }
    
}
