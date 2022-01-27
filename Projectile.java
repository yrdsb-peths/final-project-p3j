import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile.
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
    /**
     * Normal projectile constructer
     */
    public Projectile(){
        update();
        dmg = 1;
    }
    /**
     * Projectile constructer with specified damage
     */
    public Projectile(int d){
        update();
        dmg = d;
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
    /**
     * get this Projectiles damage
     */
    public int getDMG(){
        return dmg;
    }
    /**
     * update the projectile sprits
     */
    private void update(){
        img = new GreenfootImage(10, 2);
        img.setColor(Color.YELLOW);
        img.fillRect(0,0,10,2);
        setImage(img);
    }      
}
