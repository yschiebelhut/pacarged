import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author Yannik Schiebelhut 
 * @version (a version number or a date)
 */
public class Pacman extends Actor {
    protected int speed = 1;
    protected int counter = 0;
    protected int lives = 3;
     
    protected String up = "w";
    protected String down = "s";
    protected String left = "a";
    protected String right = "d";
    protected String escape = "l";
   
    public void act() {
        movement();
	eatFood();
	walkThroughBounds();
    } 
    
    public void movement() {
        if(Greenfoot.isKeyDown(up)||Greenfoot.isKeyDown("up")) {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown(down)||Greenfoot.isKeyDown("down")){
            setRotation(90);
        }
        if(Greenfoot.isKeyDown(left)||Greenfoot.isKeyDown("left")){
            setRotation(180);
        }
        if(Greenfoot.isKeyDown(right)||Greenfoot.isKeyDown("right")){
            setRotation(0);
        }
        if (Greenfoot.isKeyDown(escape)){
            Greenfoot.setWorld(new MyWorld2());
        }
        if(!wallInFront()) move(speed);
    }

    public void walkThroughBounds() {
        Labyrinth1 home = (Labyrinth1) getWorld();
        int posX = getX();
        int posY = getY();
        if(posX==0) setLocation(home.getWidth()-1,posY);
        if(posX==home.getWidth()-1) setLocation(0,posY);
        if(posY==0) setLocation(posX,home.getHeight()-1);
        if(posY==home.getHeight()-1) setLocation(posX,0);
    }

    public boolean wallInFront() {
        switch(getRotation()) {
            case 0:   if(getOneObjectAtOffset(1,0,Wall.class)!=null) 
                            return true;
                      break;
            case 90:  if(getOneObjectAtOffset(0,1,Wall.class)!=null) 
                            return true;
                      break;    
            case 180: if(getOneObjectAtOffset(-1,0,Wall.class)!=null) 
                            return true;
                      break;    
            case 270: if(getOneObjectAtOffset(0,-1,Wall.class)!=null) 
                            return true;
                      break;    
        }
        return false;
    }
    
    public boolean wallAt(String pDirection) {
        int currentDirection = getRotation();
        int observingDirection = 0;
        if(pDirection == "left") 
            observingDirection = (currentDirection-90)%360;
        if(pDirection == "front")
            observingDirection = currentDirection;
        if(pDirection == "right")
            observingDirection = (currentDirection+90)%360;
        switch(observingDirection) {
            case 0:   if(getOneObjectAtOffset(1,0,Wall.class)!=null) 
                            return true;
                      break;
            case 90:  if(getOneObjectAtOffset(0,1,Wall.class)!=null) 
                            return true;
                      break;    
            case 180: if(getOneObjectAtOffset(-1,0,Wall.class)!=null) 
                            return true;
                      break;    
            case 270: if(getOneObjectAtOffset(0,-1,Wall.class)!=null) 
                            return true;
                      break;    
        }
        return false;
    }

    public void setSpeed(int pSpeed){
        speed = pSpeed;
    }

    public void eatFood() {
        Labyrinth1 home = (Labyrinth1) getWorld();
        Food aktFressen = (Food)getOneIntersectingObject(Food.class);
        if(aktFressen!=null) {
            home.removeObject(aktFressen);
            this.counter++;
        }
    }
}
