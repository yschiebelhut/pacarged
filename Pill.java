import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enables pacman to eat the Ghosts.
 * 
 * @author Yannik Schiebelhut
 * @version 20180620_final-(hopefully)
 */
public class Pill extends PowerUP {    
    protected int LIMIT = 45; // number of steps pacman can take before the effect is over
    protected int i = 0; // just a simple counter variable
    protected boolean effectPresent = false; // used to avoid conflicts with other PowerUPs
    /**
     * Wait for pacman to get in touch...
     */
    public void act() {
        // get some basic information
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        
        // activated if pacman steps on the pill
        if(getOneIntersectingObject(Pacman.class)!=null) {
            i = LIMIT; // set the counter
            effect(); // apply the effect
            setLocation(20,20); // show pill in bottom bar
            // NEVER remove Objects that should still do something!!!
        }
        if(i>0) i--; // reduce counter, if it can be reduced
        else undoEffect(); // if counter already equals zero, remove the effect
    }

    /**
     * Enable pacman to eat the ghosts and forbit the ghosts to eat pacman.
     */
    @Override
    public void effect() {
        Pacman.canEatGhosts = true; // enable ALL pacmans to eat the ghosts
        Ghost.canEatPacman = false; // disable ALL ghosts to eat pacmans
        this.effectPresent = true; // flip activation bit
    }

    /**
     * Redo what "effect()" does.
     */
    public void undoEffect() {
        // get some basic information
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        
        // only changes variables if effect is present
        if(effectPresent) {
            Pacman.canEatGhosts = false; // disable ALL pacmans to eat the ghosts
            Ghost.canEatPacman = true; // reenable ALL ghosts to eat pacman
            effectPresent = false; // flip activation bit
            home.removeObject(this); // remove the pill, it's job is now done
        }
    }
}
