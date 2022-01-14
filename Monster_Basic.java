import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster_Basic here.
 * 
 * @author (your name) 
 * @version 1/11 0.2
 */
public class Monster_Basic extends Enemy
{
    HealthBar healthbar;
    int health = 3;
    public Monster_Basic(){
        setImage("monster_placeholder.png");
    }
    public void addedToWorld(World w){
        //a World is pass down from this function addedToWorld
        healthbar = new HealthBar(this);
        w.addObject(healthbar, 0, 0);
    }
    /**
     * Act is called whenever the 'Act' button gets pressed.
     * or every tick whenever the 'Run' button gets pressed.
     */
    public void act(){
        if(hitByProjectile()){
            health--;
            healthbar.setHealth((double)health/3);
            getWorld().removeObject(getOneIntersectingObject(Projectile.class));
            if(health<=0){
                Score.score++;
                Money.money++;
                getWorld().removeObject(healthbar);
                getWorld().removeObject(this);
            }
        }
    }
}
