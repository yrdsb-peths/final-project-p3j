import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version 1/11 0.12
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // this needs to be static
    public static int score;
    private Color transparent = new Color(0,0,0,0);
    public static int money;
    public Score(){
        update();
    }
    public void act(){
        update();
    }      
    public void update(){
        setImage(new GreenfootImage("Score: "+score,40,Color.BLACK,transparent));
    }      
}
