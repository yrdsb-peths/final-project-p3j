import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version 1.0
 */
public class Score extends Actor{
    public static int score = 0;
    private Color bg = new Color(0,0,0,20);
    public Score(){
        update();
    }
    public void act(){
        update();
    }      
    public void update(){
        setImage(new GreenfootImage("Score: "+score,40,Color.BLACK,bg));
    }      
}
