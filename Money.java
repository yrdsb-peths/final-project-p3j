import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author Vincent
 * @version 1.0
 */
public class Money extends Actor{
    public static int money = 0;
    private Color bg = new Color(0,0,0,20);
    public Money(){
        update();
    }
    public void act(){
        update();
    }
    public void update(){
        if(money < 150){
            setImage(new GreenfootImage("$"+money,40,Color.BLACK,bg)); 
        }else{
            setImage(new GreenfootImage("$"+money,40,Color.GREEN,bg)); 
        }
    }      
}
