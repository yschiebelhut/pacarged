import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // for managing contact with other objects
import java.util.ArrayList; // for managing contact with other objects

/**
 * Ghosts is the oponent class of pacman.
 * Ghosts wander around the maze and if they get contact with pacman, they usually eat him up and this costs a life.
 * 
 * @author Yannik Schiebelhut 
 * @version 20180530
 */
public class Ghost extends Actor {
    public void act() {
        // call methods necessary for the ghosts behavior
        eatPacman();
        movement();
    } 

    /**
     * This method is used to move the ghost in the labyrinth.
     * While there isn't a wall in front, the ghost just walks and with a probability of 0,1 it
     * performs a random turn.
     * If the ghosts finds itself in front of a wall, it also makes a random turn.
     * The ghost is able to walk through the free spaces on the sides of the labyrinth.
     */
    public void movement() {
        // let's the ghosts perform a random turn if the generated number is smaller than 10
        if(Greenfoot.getRandomNumber(100)<10) randomTurn();
        // ghosts can't walk through walls
        while(wallInFront()) randomTurn();
        // makes the ghost walk around
        move(1);
        // enables the ghost to pass the sides of the map
        walkThroughBounds();
    }
    
    /**
     * A try to improve the first movement method...
     * 
     * TODO
     */
    public void movement2() {
        int num = Greenfoot.getRandomNumber(1);
        if((!wallAt("r")||!wallAt("l"))&&num==1) {}
    }
    
    /**
     * This method should make the ghost walk into the direction of pacman.
     * 
     * TODO
     */
    public void movementTargeted() {
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        Pacman player = (Pacman) home.getObjects(Pacman.class).get(0);
        int targetX = player.getX();
        int targetY = player.getY();
    }
    
    
    /**
     * Checks if there is a wall next to the ghost in the given direction.
     * @param direction tells the method whether to look left, in front or right of the ghost for a wall
     * @return boolean
     */
    public boolean wallAt(String direction) {
        // initialize variable for displaying the direction to observe
        int obsDir = 0;
        // set the variable to right value
        if(direction == "f") obsDir = this.getRotation();
        if(direction == "l") obsDir = (this.getRotation()+360-90)%360; // prevent values less than 360
        if(direction == "r") obsDir = (this.getRotation()+90)%360; // prevent values grater than 360

        // basically the same as in method wall in front but not with the current orientation but with the observing Orientation
        if(obsDir==0) if(getOneObjectAtOffset(1,0,Wall.class)!=null) return true;
        if(obsDir==90) if(getOneObjectAtOffset(0,1,Wall.class)!=null) return true;
        if(obsDir==180) if(getOneObjectAtOffset(-1,0,Wall.class)!=null) return true;
        if(obsDir==270) if(getOneObjectAtOffset(0,-1,Wall.class)!=null) return true;        
        return false;
    }
    
    /**
     * Checks whether there is a wall in front of the ghost or not.
     * In front means one field ahead of the current position, along the current orrientation.
     * @return boolean
     */
    public boolean wallInFront() {
        // go through all possible cases of orientation
        if(getRotation()==0) if(getOneObjectAtOffset(1,0,Wall.class)!=null) return true;
        if(getRotation()==90) if(getOneObjectAtOffset(0,1,Wall.class)!=null) return true;
        if(getRotation()==180) if(getOneObjectAtOffset(-1,0,Wall.class)!=null) return true;
        if(getRotation()==270) if(getOneObjectAtOffset(0,-1,Wall.class)!=null) return true;
        return false;
    }

    /**
     * This method enables the ghost to pass the sides of the labyrinth.
     */
    public void walkThroughBounds() {
        // get basic information
        Labyrinth1 home = (Labyrinth1) getWorld();
        int posX = getX();
        int posY = getY();
        
        // left
        if(posX==0) setLocation(home.getWidth()-1,posY);
        // right
        if(posX==home.getWidth()-1) setLocation(0,posY);
        // top
        if(posY==0) setLocation(posX,home.getHeight()-1);
        //bottom
        if(posY==home.getHeight()-1) setLocation(posX,0);
    }

    /**
     * Makes the ghost turn randomly by 90, 180 or 270 degree.
     */
    public void randomTurn() {
        // #TheCodeIsTheComment
            switch(Greenfoot.getRandomNumber(3)) {
            case 0:
                turn(90);
                break;
            case 1:
                turn(180);
                break;
            case 2:
                turn(270);    
        }
    }

    /**
     * If the ghost get's contact with pacman, it reduces the lifes by one and resets the position of
     * pacman and the ghosts.
     */
    public void eatPacman() {
        // get basic information
        Labyrinth1 home = (Labyrinth1) getWorld();
        
        // search for pacman in reach
        if(getOneIntersectingObject(Pacman.class)!=null) {
            Pacman player = (Pacman) getOneIntersectingObject(Pacman.class);
            
            // reduce lives variable of pacman
            player.lives--;
            
            // respawn pacman
            home.removeObject(player);
            home.addObject(player,10,19);
            
            // set the position of all ghosts into the origin of the ghosts
            List<Ghost> enemies = new ArrayList<Ghost>(home.getObjects(Ghost.class));
            for(Ghost i : enemies) {
                i.setLocation(10,10);
            }
        }
    }
}