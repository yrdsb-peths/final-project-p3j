import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version 1/11 0.15
 */
public class Money extends Actor{
    public static int money = 0;
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
