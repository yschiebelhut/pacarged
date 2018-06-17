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
        Greenfoot.start();
        MenuStreuerung menuStreuerung = new MenuStreuerung(); // Erstellt das Menu
        addObject(menuStreuerung,10,9);
        StartLevel1 startLevel1 = new StartLevel1();
        addObject(startLevel1,10,13);
        
        ExitBlock exit = new ExitBlock();
        addObject(exit,10,17);
        Logo logo = new Logo();
        addObject(logo,10,5);
        Wall[] walls = new Wall[20];
        for(int i=0; i<walls.length; i++) {
            walls[i] = new Wall();
            int posX = i;
            int posY = 7;
            addObject(walls[i], posX, posY);
        }
           for(int i=0; i<walls.length; i++) {
            walls[i] = new Wall();
            int posX = i;
            int posY = 0;
            addObject(walls[i], posX, posY);
        }
           for(int i=0; i<walls.length; i++) {
            walls[i] = new Wall();
            int posX = 0;
            int posY = i;
            addObject(walls[i], posX, posY);
        }
           for(int i=0; i<walls.length; i++) {
            walls[i] = new Wall();
            int posX = 20;
            int posY = i;
            addObject(walls[i], posX, posY);
        }
           for(int i=0; i<walls.length; i++) {
            walls[i] = new Wall();
            int posX = i;
            int posY = 20;
            addObject(walls[i], posX, posY);
        }
        
    }
}
