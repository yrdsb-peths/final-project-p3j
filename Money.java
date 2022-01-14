import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version 1/11 0.12
 */
public class Money extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int money;
    private Color transparent = new Color(0,0,0,0);
    
    public Money(){
        update();
    }
    public void act(){
        update();
    }
    
    public void update(){
        setImage(new GreenfootImage("$"+money,40,Color.BLACK,transparent));  
    }      
}
