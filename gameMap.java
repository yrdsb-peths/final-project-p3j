import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameMap extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    
    
    int score = 0;
    public Player mainPlayer = new Player();
    
    public Player getPlayer()
    {
        return mainPlayer;
    }
    
    
    public gameMap()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        mainPlayer = new Player();
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
    }
}
