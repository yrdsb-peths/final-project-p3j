import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version 1/14 0.15
 */
public class Projectile extends Actor{
    GreenfootImage img;
    World world;
    public Projectile(){
        update();
    }
    public void addedToWorld(World w){
        //a World is pass down from this function addedToWorld
        world = w;
    }
    public void act(){
        move(10);
        if(isAtEdge()){
            world.removeObject(this);
        }
    }    
    public void update(){
        img = new GreenfootImage(10, 2);
        img.setColor(Color.RED);
        img.fillRect(0,0,10,2);
        setImage(img);
    }      
}
