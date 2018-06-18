import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pill extends PowerUP {    
    protected int LIMIT = 45;
    protected int i = 0;
    protected boolean effectPresent = false;
    /**
     * Wait for pacman to get in touch...
     */
    public void act() {
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        Pacman player = (Pacman) getOneIntersectingObject(Pacman.class);
        if(player != null) {
            i = LIMIT;
            effect();
            home.removeObject(this);        
        }
        if(i>0) {
            home.showText(String.format("Pill duration: %d", this.i), 14, 0);
        }
        if(i<0 && effectPresent) undoEffect();
        i--;
    }   

    @Override
    public void effect() {
        Pacman.canEatGhosts = true;
        Ghost.canEatPacman = false;
        effectPresent = true;
    }

    public void undoEffect() {
        Pacman.canEatGhosts = false;
        Ghost.canEatPacman = true;
        effectPresent = false;
    }
}
