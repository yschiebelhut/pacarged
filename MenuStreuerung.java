import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuStreuerung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuStreuerung extends Actor
{
    /**
     * Act - do whatever the MenuStreuerung wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected String up = "w";         // Kontroll Keys 
    protected String down = "s";
    protected String left = "a";
    protected String right = "d";
    protected String enter = "enter";
    protected String space = "space";

    public void act() 
    {
        
        mover(); //Bewegen
        select();// dann auswählen
    }

    public void mover(){// bewegung der Menusteuerung
        if(Greenfoot.isKeyDown(up)||Greenfoot.isKeyDown("up")) {// entweder durch wasd
            setRotation(270);
            move(1);
        }
        if(Greenfoot.isKeyDown(down)||Greenfoot.isKeyDown("down")){ // oder Keys
            setRotation(90);
            move(1);
        }
        if(Greenfoot.isKeyDown(left)||Greenfoot.isKeyDown("left")){
            setRotation(180);
            move(1);
        }
        if(Greenfoot.isKeyDown(right)||Greenfoot.isKeyDown("right")){
            setRotation(0);
            move(1);
        }

    }

    public void select(){
        Actor a = getOneIntersectingObject(StartLevel1.class); 
        Actor b = getOneIntersectingObject(ExitBlock.class);

        if (a !=null){
            if (Greenfoot.isKeyDown(enter)||Greenfoot.isKeyDown(space)){ // Level1 Starten
                Greenfoot.setWorld(new MyWorld2());}
        }
        if (b !=null){
            if (Greenfoot.isKeyDown(enter)||Greenfoot.isKeyDown(space)){ // Stop
                Greenfoot.stop();
                System.exit(0);
            }
        }

    }
}
