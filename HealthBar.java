import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author Vincent Hsieh
 * @version 1.0
 */
public class HealthBar extends Actor{
    //who does the health bar needs to follow
    private Actor entity;
    //Display Health stored in double
    private double health;
    //avoid spaming image update when health didnt even change
    private double last_health;
    public HealthBar(Actor e){
        //store the entity that we needs to follow
        entity = e;
        //initialize the health to 1
        health = 1;
    }
    public void act(){
        update_bar();
    }
    /**
     * Set the health for the healthbar
     */
    public void setHealth(double n){
        health = n;
    }
    /**
     * update healthbar image and location
     */
    private void update_bar(){
        //if theres changes to the display health
        if(last_health!=health){
            //remember new value
            last_health = health;
            
            //new image
            GreenfootImage h_bar = new GreenfootImage(52, 12);
            //fill image with black
            h_bar.fillRect(0,0,52,12);
            //figure out the color for the health bar
            Color health_color = new Color((int)Math.round(255.0*(1.0-health)),(int)Math.round(255.0*(health)),0);
            //set brush color to what we just calculated
            h_bar.setColor(health_color);
            //draw colored bar with the correct length
            h_bar.fillRect(1,1,(int)Math.round(health*50.0),10);
            //image is ready, now set our actor to this
            setImage(h_bar);
        }
        int x = entity.getX();
        int y = entity.getY()-35;
        //prevent health bar from capped at the top and clipping into the entity
        if(y<=0){
            //then we just move it below the entity
            y = entity.getY()+entity.getImage().getHeight()-10;
        }
        //update location
        setLocation(x, y);
    }
}
