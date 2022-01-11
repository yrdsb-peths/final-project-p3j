import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster_Basic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster_Basic extends Enemy
{
    int health = 3;
    public Monster_Basic(){
        setImage("monster_placeholder.png"); // The initial sprite of the character
    }
    Score scoreCount;
    /**
     * Act - do whatever the Monster_Basic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        hitByProjectile();
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0)
        {
            scoreCount.score++;
            
            getWorld().removeObject(this);
        
        }
    }
}
