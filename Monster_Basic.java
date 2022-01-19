import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    double spd = 1;
    
    Player player;
    HealthBar healthbar;
    World world;
    private GreenfootImage img;
    public Monster_Basic(){
        update();
    }
    public void addedToWorld(World w){
        //a World is pass down from this function addedToWorld
        healthbar = new HealthBar(this);
        world = w;
        world.addObject(healthbar, 0, 0);
    }
    private SimpleTimer fire_timer = new SimpleTimer();
    private double fire_CD = 1;
    private double cur_CD = 0;
    public void act(){
        //hunt player
        List players = world.getObjects(Player.class);
        if(players.size()>0){
            player = (Player)players.get(0);
            if(isTouching(Player.class)){
                if(cur_CD <= 0){
                    cur_CD = fire_CD;
                    player.hurt(1);
                }
            }
            turnTowards(player.getX(), player.getY());
            update();
            move(spd);
        }
        cur_CD -= (double)fire_timer.millisElapsed()/1000;
        fire_timer.mark();
        if(hitByProjectile()){
            Projectile p = (Projectile)getOneIntersectingObject(Projectile.class);
            health -= p.getDMG();
            healthbar.setHealth((double)health/3);
            world.removeObject(p);
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
    private void update(){
        img = new GreenfootImage("monster_placeholder.png");
        img.rotate(-getRotation());
        setImage(img);
    }      
}
