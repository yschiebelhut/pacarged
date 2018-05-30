import greenfoot.*;
import java.awt.Color;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu1 extends World

{

    /**
     * Constructor for objects of class Menu1.
     * 
     */
    public Menu1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20, 20, 35); 
        MenuStreuerung menuStreuerung = new MenuStreuerung(); // Erstellt das Menu
        addObject(menuStreuerung,10,9);
        StartLevel1 startLevel1 = new StartLevel1();
        addObject(startLevel1,10,12);
        
        ExitBlock exit = new ExitBlock();
        addObject(exit,10,18);
        
    }
}
