/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.zpackage1;

/**
 *
 * @author pierre
 */
public class DriverClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Parent class object
        Animal animal = new Animal();
        
        // Directly accessing Animal attributes via Animal object
        System.out.println("DriverClass accessing Animal attributes via Animal object...");
        // Access modifier: private
        // System.out.println("private (id) is: " + animal.id); // Can only be accessed by the class
        
        // Access modifier: protected
        System.out.println("protected (protectedValue) is: " + animal.protectedValue); // accessible within package
        
        // Access modifier: <default>
        System.out.println("<default> (canYouAccessThisDefaultScopeAttr) is:" 
                + animal.canYouAccessThisDefaultScopeAttr); // accessible within the package
        
        // Access modifier: public
        System.out.println("public (isAnimal) is:" + animal.isAnimal); // accessible inside and outside the package
        
        System.out.println();
        
        // Animal object accessing its attributes within itself
        System.out.println("Animal object accessing its attribute within itself...");
        animal.showAttributes();
        System.out.println();
        
        // Child class object
        Cat cat = new Cat();
        
        // Directly accessing Cat attributes via Cat object
        System.out.println("DriverClass accessing Cat attributes via Animal object...");
        // Access modifier: private
        // System.out.println("private (id) is: " + cat.id); // Can only be accessed within Animal class
        // System.out.println("private (cutenessLevel) is: " + cat.cutenessLevel); // only accessible within cat class
        
        // Access modifier: protected
        System.out.println("protected (protectedValue) is: " + cat.protectedValue); // accessible within package
        
        // Access modifier: <default>
        System.out.println("<default> (canYouAccessThisDefaultScopeAttr) is:" 
                + cat.canYouAccessThisDefaultScopeAttr); // accessible within the package
        
        // Access modifier: public
        System.out.println("public (isAnimal) is:" + cat.isAnimal); // accessible inside and outside the package
        
        System.out.println();
        
        // Cat object accessing its attributes within itself
        System.out.println("Cat object accessing its attribute within itself...");
        cat.showAllAttributes();
        System.out.println();
        
        // Polymorphism
        Animal polymorphAnimal = new Animal();
        polymorphAnimal.speak();
        polymorphAnimal = new Cat();
        polymorphAnimal.speak();
    }
    
}
