import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class instructionsScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class instructionsScreen extends World
{
    Label titleLabel2 = new Label("How to Play?:", 70);
    Label atkLabel = new Label ("Aim with the Mouse, and Shoot with Left-Click", 50);
    Label moveLabel = new Label("To move, use arrow keys or w a s d", 55);
    Label startLabel2 = new Label("Press Enter to Start", 50);
    /**
     * Constructor for objects of class instructionsScreen.
     * 
     */
    public instructionsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        
        //sets background for instructions screen
        setBackground("instructions.jpeg");
        //adds labels for the screen
        addObject(atkLabel, getWidth()/2, (getHeight()/4)*2);
        addObject(titleLabel2,getWidth()/2, getHeight()/6);
        addObject(moveLabel, getWidth()/2, getHeight()/3);
        addObject(startLabel2, getWidth()/2, (getHeight()/3)*2);
    }
    public void act()
    {
        //Start game if space bar is pressed
        if ("enter".equals(Greenfoot.getKey())){
            gameMap gameWorld = new gameMap();
            //change worlds
            Greenfoot.setWorld(gameWorld);
        }
    }
}
