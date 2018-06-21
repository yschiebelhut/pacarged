import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu1 here:
 * I Don't know this too.
 * 
 * @author Benedikt Rölle 
 * @version IDon'tKnow ~Yannik
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
