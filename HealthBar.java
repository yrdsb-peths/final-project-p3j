import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version 1/11 0.3
 */
public class HealthBar extends Actor
{
    private double health;
    private double last_health;
    private Actor entity;
    //HealthBar Visuals
    public HealthBar(Actor e){
        entity = e;
        health = 1;
    }
    /**
     * Act is called whenever the 'Act' button gets pressed.
     * or every tick whenever the 'Run' button gets pressed.
     */
    public void act(){
        update_bar();
    }
    public void setHealth(double n){
        health = n;
    }
    private void update_bar(){
        if(last_health!=health){
            last_health = health;
            
            GreenfootImage h_bar = new GreenfootImage(52, 12);
            h_bar.fillRect(0,0,52,12);
            Color health_color = new Color((int)Math.round(255.0*(1.0-health)),(int)Math.round(255.0*(health)),0);
            h_bar.setColor(health_color);
            h_bar.fillRect(1,1,(int)Math.round(health*50.0),10);
    
            setImage(h_bar);
        }
        //clip prevention
        int x = entity.getX();
        int y = entity.getY()-35;
        if(y<=0){
            y = entity.getY()+entity.getImage().getHeight()-10;
        }
        setLocation(x, y);
    }

    //Method for losing Health
    /*
    public void loseHealth(){
        World world = getWorld();
        gameMap myWorld = (gameMap)world;
        if(myWorld.getPlayer().hitByMonster_Basic()){
            health--;
        }
        if(health<=0){
        getWorld().showText("You Lose! \n You Survived For " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
        }
    }
    */
}
