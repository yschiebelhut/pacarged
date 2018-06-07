import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo extends Block
{
    /**
     * Act - do whatever the Logo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = getOneIntersectingObject(Wall.class);
        move(1);
        if (a != null ){
            setRotation(180);
            move(2);}
        //   this.getWorld().showText("pacarged", this.getX(), this.getY()-3); // Add your action code here.
    }  
}
