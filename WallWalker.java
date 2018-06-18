import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes walls theoretically disappear for pacman so he can walk straight through them.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallWalker extends PowerUP {
    /**
     * Wait for pacman to get in touch...
     */
    public void act() {
        int i = 0;
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        Pacman player = (Pacman) getOneIntersectingObject(Pacman.class);
        if(player!=null) {
            Pacman.walkThroughWalls = true;
            home.removeObject(this);
            i = 45;
        }
        i--;
    }   
}
