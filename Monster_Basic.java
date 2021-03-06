import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Monster_Basic here.
 * 
 * @author (your name) 
 * @version 1/14 0.4
 */
public class Monster_Basic extends Enemy{
    //health of this enemy
    private int health = 3;
    //score worth of this enemy
    private int score = 1;
    //cash worth of this enemy
    private int reward = 5;
    //movement speed of this enemy
    private double spd = 1;
    //cooldown between attack of this enemy (seconds)
    private double fire_CD = 1;
    //damage towards player
    private double player_dmg = 1;
    
    //current cooldown level for attacks, starts with 1 to avoid spawn kill
    private double cur_CD = 1;
    
    //current health of the enemy
    private int cur_health = health;
    
    //who the player is
    private Player player;
    //who my healthbar is
    private HealthBar healthbar;
    //what my world is
    private World world;
    //what my image is
    private GreenfootImage img;
    
    int animateImage = 0;
    //lower the animate speed for faster animation
    int animateSpeed = 50;
    int count;
    
    public void addedToWorld(World w){
        world = w;//a World is pass down from this function addedToWorld
        healthbar = new HealthBar(this);//create a healthbar that follows me
        world.addObject(healthbar,0,0);//add this healthbar into the world, it will fix its location itself
    }
    //create a new timer object that will tracking our firing interval
    private SimpleTimer fire_timer = new SimpleTimer();
    public void act(){
        List players = world.getObjects(Player.class);//gets all the player in world, cause you cant get one it seems
        if(players.size()>0){//if we have atleast 1 player
            player = (Player)players.get(0);//gets the first player in da list
            if(isTouching(Player.class)){//if we are touching ANY player
                //is the cooldown ready
                if(cur_CD <= 0){
                    cur_CD = fire_CD;//reset cooldown
                    player.hurt(player_dmg);//damage player
                }
            }
            turnTowards(player.getX(), player.getY());//turnTowards player for sake os simplicity
            move(spd);//walk toward player
        }
        double dt = (double)fire_timer.millisElapsed()/1000;//delta time
        cur_CD = Math.max(cur_CD-dt,0);//math the current cooldown and limit it to be no less then 0
        fire_timer.mark();//mark the timer for a new cooldown call
        if(hitByProjectile()){
            //get one of the projectile that we get hit by
            Projectile p = (Projectile)getOneIntersectingObject(Projectile.class);
            //decrease health based on projectile damage
            cur_health -= p.getDMG();
            //set our healthbar level
            healthbar.setHealth((double)cur_health/health);
            //delete this projectile
            world.removeObject(p);
        }
        //if we have no more health
        if(cur_health<=0){
            States.score+=score;//increase scroe
            States.money+=reward;//increase money
            remove();//remove ourself
        }
        animate();
    }
    /**
     * Remove this entity along with its associated healthbar
     */
    public void remove(){
        world.removeObject(healthbar);//remove the healthbar first
        world.removeObject(this);//then remove us
    }
    
    public void animate(){
        if(count % animateSpeed == 0){
            if(animateImage > 16){
                animateImage = 0;
            }
            setImage("skeleton-move_" + animateImage + ".png");
            animateImage++;
            getImage().scale(50,50);
        }
    }
}
