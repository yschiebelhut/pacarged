import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Gegener here.
 * 
 * @author Yannik Schiebelhut 
 * @version 20180530
 */
public class Ghost extends Actor
{
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        eatPacman();
        movement();
    } 

    public void movement() {
        if(Greenfoot.getRandomNumber(100)<10) randomTurn();
        while(wallInFront()) randomTurn();
        move(1);
        walkThroughBounds();
    }
    
    public void movement2() {
        int num = Greenfoot.getRandomNumber(1);
        if((!wallAt("r")||!wallAt("l"))&&num==1) {}
    }
    
    public void movementTargeted() {
        Labyrinth1 home = (Labyrinth1) this.getWorld();
        Pacman player = (Pacman) home.getObjects(Pacman.class).get(0);
        int targetX = player.getX();
        int targetY = player.getY();
    }
    
    public boolean wallAt(String direction) {
        int obsDir = 0;
        if(direction == "f") obsDir = this.getRotation();
        if(direction == "l") obsDir = (this.getRotation()+360-90)%360;
        if(direction == "r") obsDir = (this.getRotation()+90)%360;

        if(obsDir==0) if(getOneObjectAtOffset(1,0,Wall.class)!=null) return true;
        if(obsDir==90) if(getOneObjectAtOffset(0,1,Wall.class)!=null) return true;
        if(obsDir==180) if(getOneObjectAtOffset(-1,0,Wall.class)!=null) return true;
        if(obsDir==270) if(getOneObjectAtOffset(0,-1,Wall.class)!=null) return true;        
        return false;
    }
    
    public boolean wallInFront() {
        if(getRotation()==0) if(getOneObjectAtOffset(1,0,Wall.class)!=null) return true;
        if(getRotation()==90) if(getOneObjectAtOffset(0,1,Wall.class)!=null) return true;
        if(getRotation()==180) if(getOneObjectAtOffset(-1,0,Wall.class)!=null) return true;
        if(getRotation()==270) if(getOneObjectAtOffset(0,-1,Wall.class)!=null) return true;
        return false;
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

    public void randomTurn() {
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

    public void eatPacman() {
        Labyrinth1 home = (Labyrinth1) getWorld();
        if(getOneIntersectingObject(Pacman.class)!=null) {
            Pacman player = (Pacman) getOneIntersectingObject(Pacman.class);
            player.lives--;
            home.removeObject(player);
            home.addObject(player,10,19);
            List<Ghost> enemies = new ArrayList<Ghost>(home.getObjects(Ghost.class));
            for(Ghost i : enemies) {
                i.setLocation(10,10);
            }
        }
    }
}
