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
        // Pacman player = (Pacman) getOneIntersectingObject(Pacman.class);
        // if(player != null) {
        if(getOneIntersectingObject(Pacman.class)!=null) {
            i = LIMIT;
            effect();
            setLocation(20,20);
            // home.removeObject(this);        
        }
        if(i>0) {
            // Greenfoot.ask("Foo2");
            // home.showText(String.format("Pill duration: %d", this.i), 14, 0);
            i--;
        }
        else undoEffect();
    }   

    @Override
    public void effect() {
        Pacman.canEatGhosts = true;
        Ghost.canEatPacman = false;
        this.effectPresent = true;
    }

    public void undoEffect() {
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        if(effectPresent) {
            Pacman.canEatGhosts = false;
            Ghost.canEatPacman = true;
            effectPresent = false;
            home.removeObject(this);
        }
    }
}
