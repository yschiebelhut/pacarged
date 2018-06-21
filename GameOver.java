import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World {
    protected int score;
    protected int ghosts;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int pScore, int pGhosts) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage background = new GreenfootImage("",0,Color.BLACK,Color.BLACK);
        setBackground(background);
        score = pScore;
        ghosts = pGhosts;
        prepare();
    }
   
    public void act() {
        if(Greenfoot.isKeyDown("escape")) {
            Greenfoot.stop();
            System.exit(0);
        }
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new Labyrinth1());
    }
    
    public void prepare() {
        this.showText("GameOver", 300, 100);
        this.showText(String.format("You scored %d points", this.score), 300, 150);
        this.showText(String.format("You ate %d ghosts", this.ghosts), 300, 180);
        this.showText("Press Enter to Retry", 300, 320);
        this.showText("Press Escape to close the Game", 300, 350);
    }
}
