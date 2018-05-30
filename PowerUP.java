import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the mother to all other PowerUPs, enpowering Pacman to do great things.
 * As it's an abstract class, it won't ever do anything itself.
 * 
 * @author 
 * @version 0.1
 */
public abstract class PowerUP extends Actor {

    protected Labyrinth1 home = (Labyrinth1) this.getWorld();
    protected Pacman player = (Pacman) home.getObjects(Pacman.class).get(0);
    
    public void effect() {}
}
