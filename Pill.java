import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pill extends PowerUP {    
    /**
     * Wait for pacman to get in touch...
     */
    public void act() {
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        Pacman player = (Pacman) getOneIntersectingObject(Pacman.class);
        if(player != null) effect();
        home.removeObject(this);        
    }   
    
    @Override
    public void effect() {
        player.eatGhosts = true;
        Greenfoot.delay(30);
        player.eatGhosts = false;
    }
}
