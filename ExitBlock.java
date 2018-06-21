import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu1 here:
 * I Don't know this too.
 * 
 * @author Benedikt Rölle 
 * @version IDon'tKnow ~Yannik
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
