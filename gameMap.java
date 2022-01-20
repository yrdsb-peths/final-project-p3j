import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version 1/14 0.5
 */
public class gameMap extends World{
    //           reqirement_for_next_level wave_size
    int[][]diffculty_table={{20,              10},  //lvl0 (default)
                            {60,              20},  //lvl1
                            {150,             30},  //lvl2
                            {0,               50}}; //lvl3 (final)
    int cur_lvl = 0;
    
    Player player;
    Score scoreCounter;
    WeaponButton weaponButton;
    Money cash;
    public gameMap(){   
        super(900, 600, 1); 
        player = new Player();
        scoreCounter = new Score();
        cash = new Money();
        weaponButton = new WeaponButton();
        
        addObject(player, getWidth()/2, getHeight()/2);
        addObject(scoreCounter, 100, 30);
        addObject(cash, 800, 30);
        addObject(weaponButton, 800, 100);
    }
    public void act(){
        if(getObjects(Player.class).size()>0){
            if(cur_lvl < diffculty_table.length - 1){
                if(Score.score >= diffculty_table[cur_lvl][0]){
                    cur_lvl++;
                }
            }
            //spawn mob when theres no more mob
            if(getObjects(Enemy.class).size()<=0){
                mob_spawn(diffculty_table[cur_lvl][1]);
            }
        }
        {
            //Start game if space bar is pressed
            if ("g".equals(Greenfoot.getKey())){
                gameOver gameWorld = new gameOver();
                //change worlds
                Greenfoot.setWorld(gameWorld);
            }
        }
    }
    
    public void mob_spawn(int n){
        for(int i = 0; i < n; i++){
            Monster_Basic mob = new Monster_Basic();
            addObject(mob, Greenfoot.getRandomNumber(900), Greenfoot.getRandomNumber(600));
        }
    }
}