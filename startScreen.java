import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startScreen extends World
{
    Label titleLabel = new Label("Monster Shooter", 100);
    Label startLabel = new Label("Press Enter to Start", 50);
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public startScreen()
    {    
        super(900, 600, 1);
        setBackground("startImage.jpeg");
        Greenfoot.start();
        
        //adds labels for the startscreen
        addObject(titleLabel, getWidth()/2, getHeight()/3);
        addObject(startLabel, getWidth()/2, (getHeight()/3)*2);
    }
    public void act()
    {
        //Start game if space bar is pressed
        if ("enter".equals(Greenfoot.getKey())){
            instructionsScreen gameWorld = new instructionsScreen();
            //change worlds
            Greenfoot.setWorld(gameWorld);
        }
    }
}
