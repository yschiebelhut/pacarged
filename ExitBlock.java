import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitBlock extends Block
{
    /**
     * Act - do whatever the Block3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.getWorld().showText("Exit", this.getX()+3, this.getY());// Add your action code here.
    }    
}
