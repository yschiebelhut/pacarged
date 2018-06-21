import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu1 here:
 * I Don't know this too.
 * 
 * @author Benedikt Rölle 
 * @version IDon'tKnow ~Yannik
 */
public class Logo extends Block
{
    /**
     * Act - do whatever the Logo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int zaehlerer = 1;
    protected int zaehlererer = 1;
    public void act() 
    {
        Actor a = getOneIntersectingObject(Wall.class);
        if(zaehlererer == 1){
            this.getWorld().showText("pacarged", this.getX(), this.getY()-3);
            zaehlererer = 2;}
        if (a != null ){
            if (zaehlerer == 1){
                setRotation(180);
                zaehlerer = 2;
                move(1);
            }
            else if(zaehlerer == 2){
                setRotation(0);
                zaehlerer = 1;
                move(1);
            }

        }
        else
            move(1);
         // Add your action code here.
    }  
}
