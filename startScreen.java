import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version 1.0
 */
public class startScreen extends World{
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public startScreen(){    
        super(900, 600, 1);
        setBackground("startImage.jpeg");
        Greenfoot.start();
        
        //adds labels for the startscreen
        addObject(new Label("Monster Shooter", 100),        getWidth()/2, getHeight()/3);
        addObject(new Label("Press Enter to Start", 50),    getWidth()/2, getHeight()/3*2);
    }
    public void act(){
        //Start game if space bar is pressed
        if("enter".equals(Greenfoot.getKey())){
            //change world
            Greenfoot.setWorld(new instructionsScreen());
        }
    }
}
