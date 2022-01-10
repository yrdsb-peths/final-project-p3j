import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameMap extends World{
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public gameMap(){    
        super(900, 600, 1); 
        Player player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
        
    }
    public void act(){
        if (Greenfoot.isKeyDown("e")){
            //change worlds
            recursive_mod_spawn(Integer.parseInt(Greenfoot.ask("how many")));
        }
    }
    public void recursive_mod_spawn(int times){
        //why the hell am i doing this garbage, this can be done in a goddanm
        //for loop, yet we going reursive for it, bruh
        if(times<=0) return;
        Monster_Basic mob = new Monster_Basic();
        addObject(mob, Greenfoot.getRandomNumber(900), Greenfoot.getRandomNumber(600));
        
        recursive_mod_spawn(times-1);
    }
}