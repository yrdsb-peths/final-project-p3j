import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    //HealthBar Visuals
    public HealthBar()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        
    }
    public void act() 
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        gameMap myWorld = (gameMap)world;
        setLocation(myWorld.getPlayer().getX() - 1, myWorld.getPlayer().getY()-35);
        //loseHealth();
    } 
    //Method for losing Health
    // public void loseHealth()
    // {
        // World world = getWorld();
        // gameMap myWorld = (gameMap)world;
        // if(myWorld.getPlayer().hitByMonster_Basic())
        // {
            // health--;
        // }
        // if(health<=0)
        // {
        // getWorld().showText("You Lose! \n You Survived For " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
        // Greenfoot.stop();
        // }
    // }
}
