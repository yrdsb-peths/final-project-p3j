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
        //sets background for instructions screen
        GreenfootImage img = new GreenfootImage("startImage.jpeg");
        
        //semi-transparent box
        img.setColor(new Color(0,0,0,100));
        img.fillRect(100,120,700,360);
        
        setBackground(img); 
        
        Greenfoot.start();    
        //adds labels for the startscreen
        addObject(new Label("Monster Shooter", 100),        getWidth()/2, getHeight()/3);
        addObject(new Label("Press Enter to Start", 50),    getWidth()/2, getHeight()/3*2);

        States.reset();
    }
    public void act(){
        //Start game if space bar is pressed
        if("enter".equals(Greenfoot.getKey())){
            //change world
            Greenfoot.setWorld(new instructionsScreen());
        }
    }
}
