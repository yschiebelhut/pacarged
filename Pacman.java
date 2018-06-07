import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pacman is the main actor.
 * The player controls him and tries to survive as long as possible while collecting many points.
 * 
 * @author Yannik Schiebelhut 
 * @version (at least not from today XD)
 */
public class Pacman extends Actor {
    protected int speed = 1; // step distance, used for powerups
    protected int counter = 0; // collected points are stored in here
    protected int lives = 3; // well, hope you can explain this to yourself

    // sets which keys can be used to control pacman
    protected String up = "w";
    protected String down = "s";
    protected String left = "a";
    protected String right = "d";
    protected String escape = "l";

    /**
     * Make pacman walk and do all the other things he needs to do...
     */
    public void act() {
        movement();
        eatFood();
        walkThroughBounds();
        checkEnd();
    }

    /**
     * If no wall is in front, pacman just walks and turns around according to the keybindings set above.
     */
    public void movement() {
        int currentDirection = this.getRotation();
        if(Greenfoot.isKeyDown(up)||Greenfoot.isKeyDown("up")) {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown(down)||Greenfoot.isKeyDown("down")) {
            setRotation(90);
        }
        if(Greenfoot.isKeyDown(left)||Greenfoot.isKeyDown("left")) {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown(right)||Greenfoot.isKeyDown("right")) {
            setRotation(0);
        }
        if (Greenfoot.isKeyDown(escape)) {
            Greenfoot.setWorld(new MyWorld2());
        }
        if(wallInFront()) setRotation(currentDirection);
        if(!wallInFront()) move(speed);
    }

    /**
     * Enable pacman to walk through the open sides of the maze.
     */
    public void walkThroughBounds() {
        // get some basic information
        Labyrinth1 home = (Labyrinth1) getWorld();
        int posX = getX();
        int posY = getY();
        
        // for comments on this see Ghost.class
        if(posX==0) setLocation(home.getWidth()-1,posY);
        if(posX==home.getWidth()-1) setLocation(0,posY);
        if(posY==0) setLocation(posX,home.getHeight()-1);
        if(posY==home.getHeight()-1) setLocation(posX,0);
    }

    /**
     * Checks if there is a wall in front of pacman.
     * @return boolean
     */
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

    /**
     * Checks whether there is a wall in the given direction (out of the sight of pacman) or not.
     * @param pDirection Direction to be observed
     * @return boolean
     */
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

    /**
     * Checks whether there is a wall at the given position of not.
     */
    public boolean wallAtPosition(int posX, int posY) {
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        if(home.getObjectsAt(posX, posY, Wall.class)!=null) return true;
        return false;
    }
    
    /**
     * Checks whether the Game is over due to missing lives or not.
     */
    public void checkEnd() {
        if(this.lives<=0) Greenfoot.setWorld(new GameOver());
    }
    
    /**
     * setter for the step distance of pacman
     * @param pSpeed new step distance
     */
    public void setSpeed(int pSpeed){
        speed = pSpeed;
    }

    /**
     * Enables pacman to eat the points allover the maze and gives him points for doing this...
     */
    public void eatFood() {
        // get basic information
        Labyrinth1 home = (Labyrinth1) getWorld();
        
        // check for food on the current field
        Food aktFressen = (Food)getOneIntersectingObject(Food.class);
        
        // if there is food deal with it
        if(aktFressen!=null) {
            home.removeObject(aktFressen);
            this.counter++;
        }
    }
}
