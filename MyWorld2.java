import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu1 here:
 * I Don't know this too.
 * 
 * @author Benedikt Rölle 
 * @version IDon'tKnow ~Yannik
 */
public class MyWorld2 extends World
{

    /**
     * Constructor for objects of class MyWorld2.
     * 
     */
    public MyWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Homescreen  homescreen = new Homescreen(); //Erstellt Button
        addObject(homescreen,300,200);
    }
}
