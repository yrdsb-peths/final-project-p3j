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
        
        //background for instructions screen
        GreenfootImage img = new GreenfootImage("startImage.jpeg");
        
        //semi-transparent box
        img.setColor(new Color(0,0,0,100));
        img.fillRect(100,120,700,360);
        
        setBackground(img); 
        
        //starts the game
        Greenfoot.start();
        
        //adds labels for the startscreen
        addObject(new Label("Monster Shooter", 100),        getWidth()/2, getHeight()/3);
        addObject(new Label("Press Enter to Start", 50),    getWidth()/2, getHeight()/3*2);

        //reset the states so we can have a clean game
        States.reset();
    }
    public void act(){
        //Start game if enter is pressed
        if("enter".equals(Greenfoot.getKey())){
            //change world
            Greenfoot.setWorld(new instructionsScreen());
        }
    }
}
