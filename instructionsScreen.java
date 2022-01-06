import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class instructionsScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class instructionsScreen extends World
{
    Label titleLabel = new Label("To move, use arrow keys ", 75);
    Label startLabel = new Label("Press Enter to Start", 50);
    /**
     * Constructor for objects of class instructionsScreen.
     * 
     */
    public instructionsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
    }
}
