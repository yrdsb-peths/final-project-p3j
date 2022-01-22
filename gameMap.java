import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version 1/14 0.5
 */
public class gameMap extends World{
    //a predefined diffculty table
    //           reqirement_for_next_level wave_size
    int[][]diffculty_table={{20,              10},  //lvl0 (default)
                            {60,              20},  //lvl1
                            {150,             30},  //lvl2
                            {0,               50}}; //lvl3 (final)
    public int cur_lvl = 0; //current diffculty lvl
    public gameMap(){
        super(900, 600, 1); //create world
        setBackground("map.png"); //sets background

        //adds player in center of map
        addObject(new Player(), getWidth()/2, getHeight()/2);
        //adds Score Counter in top left of map
        addObject(new Score(), 100, 30);
        //adds Money Display in top right of map
        addObject(new Money(), 800, 30);
        //adds Weapon upgrade Button in top right of map
        addObject(new WeaponButton(), 800, 100);
    }
    public void act(){
        //If theres any player in the map
        if(getObjects(Player.class).size()>0){
            //If the current diffculty lvl is not the highest yet
            if(cur_lvl < diffculty_table.length - 1){
                //If the diffculty level satisfy the requirement for next lvl
                if(Score.score >= diffculty_table[cur_lvl][0]){
                    cur_lvl++; //Increase diffculty level
                }
            }
            //spawn mob when theres no more mob
            if(getObjects(Enemy.class).size()<=0){
                //Spawn the ammount of mob depending on the wave size
                mob_spawn(diffculty_table[cur_lvl][1]);
            }
        }else{
            /*if("g".equals(Greenfoot.getKey()))*/
            {
                //Temporarely store the Name and Score for this run to
                //feed it back into the game over screen so it can show
                //the apporate message
                String name = Greenfoot.ask("Name");
                int score = Score.score;
                //store the name and score for the current run
                //this will works because the reset button doesnt wipe
                //static varible, as long as the game didnt error
                ScoreSave.add(name, score);
                //wipe the money and score because they are also stored
                //as static varible, and we do want to wipe those
                Score.score=0;
                Money.money=0;
                //Go to game over screen
                Greenfoot.setWorld(new gameOver(name, score));
            }
        }
    }
    /**
     * Spawn n mobs at random location of the world
     */
    public void mob_spawn(int n){
        for(int i = 0; i < n; i++){
            addObject(new Monster_Basic(),Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(600));
        }
    }
}