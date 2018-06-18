import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AMyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public AMyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(21, 21, 35); 
        
        StartScreen startScreen = new StartScreen(); // erstellt einen Button
        addObject(startScreen,10,10);
        Greenfoot.start();
        
    }
}
   