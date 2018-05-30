import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Homescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Homescreen extends MenuStreuerung
{
    /**
     * Act - do whatever the Homescreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private String enter = "enter";
   private String space = "space";
    public void act() 
    {
       if (Greenfoot.isKeyDown(enter)||Greenfoot.isKeyDown(space)){
        Greenfoot.setWorld(new Labyrinth1());}
        this.getWorld().showText("Press Space to start", this.getX(), this.getY());// Startet Spiel wenn bereit
    }    
}
