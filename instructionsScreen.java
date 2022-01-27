import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class instructionsScreen here.
 * 
 * @author (your name) 
 * @version 1.0
 */
public class instructionsScreen extends World{
    /**
     * Constructor for objects of class instructionsScreen.
     * 
     */
    public instructionsScreen(){    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        
        //background for instructions screen
        GreenfootImage img = new GreenfootImage("instructions.jpeg");
        
        //Dark semi-transparent box
        img.setColor(new Color(0,0,0,100));
        img.fillRect(40,40,820,520);
        
        setBackground(img);
        
        //adds labels for the screen
        addObject(new Label("How to Play?:", 70),                            getWidth()/2, getHeight()/6);
        addObject(new Label("To move, use arrow keys or WASD", 55),          getWidth()/2, getHeight()/3);
        addObject(new Label("Aim with the Mouse, and Shoot with Space", 50), getWidth()/2, getHeight()/2);
        addObject(new Label("Press Enter to Start", 50),                     getWidth()/2, getHeight()/3*2);
    }
    public void act(){
        //Start game if enter is pressed
        if ("enter".equals(Greenfoot.getKey())){
            //change world
            Greenfoot.setWorld(new gameMap());
        }
    }
}
