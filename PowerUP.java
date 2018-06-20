import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the mother to all other PowerUPs, enpowering Pacman to do great things.
 * As it's an abstract class, it won't ever do anything itself.
 * 
 * @author 
 * @version 0.1
 */
public abstract class PowerUP extends Actor {
    // methods to be implemented in the subclasses:
    public void act() {}
    public void effect() {}
    public void undoEffect() {}
}
