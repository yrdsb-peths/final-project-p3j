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
                            {300,             50},  //lvl3
                            {0,               80}}; //lvl4 (final)
    public int cur_lvl = 0; //current diffculty lvl
    public int wave_cnt = 0; //wave count
    public static GreenfootSound gameMusic = new GreenfootSound("Rip & Tear _ Doom OST.mp3");
    public gameMap(){
        super(900, 600, 1); //create world
        setBackground("map.png"); //sets background

        //adds player in center of map
        addObject(new Player(), getWidth()/2, getHeight()/2);
        
        //adds HUD
        addObject(new HUD(), 0, 0);
    }
    public void act(){
        gameMusic.setVolume(15);
        gameMusic.playLoop();
        
        //If theres any player in the map (aka player alive)
        if(getObjects(Player.class).size()>0){
            //If the current diffculty lvl is not the highest yet
            if(cur_lvl < diffculty_table.length - 1){
                //If the diffculty level satisfy the requirement for next lvl
                if(States.score >= diffculty_table[cur_lvl][0]){
                    cur_lvl++; //Increase diffculty level
                }
            }
            
            //spawn mob when theres no more mob, but exclude bosses
            if(getObjects(Enemy.class).size() - getObjects(Monster_Boss.class).size() <= 0){
                //Spawn the ammount of mob depending on the wave size
                mob_spawn(diffculty_table[cur_lvl][1]);
                wave_cnt++;
            }
        }else{
            /*if("g".equals(Greenfoot.getKey()))*/
            {
                gameMusic.stop();
                //Temporarely store the Name and Score for this run to
                //feed it back into the game over screen so it can show
                //the apporate message
                String name = Greenfoot.ask("Name");
                int score = States.score;
                //store the name and score, this will works because 
                //the reset button doesnt wipe static varible
                ScoreSave.add(name, score);
                //wipe the States because they are also stored
                //as static varible, and we do want to wipe those
                States.reset();
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
            if(wave_cnt % 5 == 0 & i == 0 & wave_cnt >= 10){
                //bose spawn for every 5 wave after once reach wave 10
                addObject(new Monster_Boss(),Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(600));
            }else{
                //Liklier to spawn a thicker monster as the wave count increases
                if(Greenfoot.getRandomNumber(50) < Math.min(wave_cnt + 1,10)){
                    addObject(new Monster_Thick(),Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(600));
                }else{
                    addObject(new Monster_Basic(),Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(600));
                }
            }
        }
    }
}