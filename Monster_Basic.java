import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster_Basic here.
 * 
 * @author (your name) 
 * @version 1/14 0.4
 */
public class Monster_Basic extends Enemy{
    int health = 3;
    
    int score = 1;
    
    int reward = 5;
    
    HealthBar healthbar;
    World world;
    public Monster_Basic(){
        setImage("monster_placeholder.png");
    }
    public void addedToWorld(World w){
        //a World is pass down from this function addedToWorld
        healthbar = new HealthBar(this);
        world = w;
        world.addObject(healthbar, 0, 0);
    }
    public void act(){
        if(hitByProjectile()){
            health--;
            healthbar.setHealth((double)health/3);
            getWorld().removeObject(getOneIntersectingObject(Projectile.class));
        }
        if(health<=0){
            Score.score+=score;
            Money.money+=reward;
            remove();
        }
    }
    public void remove(){
        world.removeObject(healthbar);
        world.removeObject(this);
    }
}
