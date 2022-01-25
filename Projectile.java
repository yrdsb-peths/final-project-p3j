import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version 1/14 0.15
 */
public class Projectile extends SmoothMover{
    //projectile sprite
    private GreenfootImage img;
    //world we are at
    private World world;
    
    //damage of this particular projectile
    private int dmg;
    
    public Projectile(){
        update();
        dmg = 1;
    }
    public Projectile(int d){
        update();
        dmg = d;
    }
    public int getDMG(){
        return dmg;
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
    private void update(){
        img = new GreenfootImage(10, 2);
        img.setColor(Color.YELLOW);
        img.fillRect(0,0,10,2);
        setImage(img);
    }      
}
