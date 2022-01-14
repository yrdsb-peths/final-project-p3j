import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version 0.4
 */
public class gameMap extends World{
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public Player player;
    Score scoreCounter = new Score();
    WeaponButton weaponButton = new WeaponButton();
    Money cash = new Money();
    public gameMap(){    
        super(900, 600, 1); 
        player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
        addObject(scoreCounter, 100, 30);
        addObject(cash, 800, 30);
        addObject(weaponButton, 800, 100);
    }
    public Player getPlayer(){
        return player;
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("e")){
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