import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version 1/14 0.5
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
        //if (Greenfoot.isKeyDown("e")){
            mob_spawn(0);
        //}
    }
    public void mob_spawn(int scoreCounter){
        //why the hell am i doing this garbage, this can be done in a goddanm
        //for loop, yet we going reursive for it, bruh
        int i;
        Monster_Basic mob = new Monster_Basic();
        for(i = 0; i < scoreCounter; i++)
        {
            addObject(mob, Greenfoot.getRandomNumber(900), Greenfoot.getRandomNumber(600));
        }
    }
}