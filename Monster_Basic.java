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
    public Monster_Basic(World w){
        setImage("monster_placeholder.png");
        healthbar = new HealthBar(this);
        //getWorld is invalid untill the construction of the world is OVER
        //pass down a world class to get around it
        w.addObject(healthbar, 0, 0);
    }
    //Score scoreCount;  this does not work like that
    /**
     * Act is called whenever the 'Act' button gets pressed.
     * or every tick whenever the 'Run' button gets pressed.
     */
    public void act(){
        // Add your action code here.
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
    public boolean hitByProjectile(){
        if(getOneIntersectingObject(Projectile.class) != null){
            return true;
        }
        return false;
    }
}
