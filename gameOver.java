import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World{
    /**
     * Constructor for objects of class gameOver.
     */
    public gameOver(String name, int score){    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        
        //adds labels for the startscreen
        addObject(new Label(name+" scored: "+score,60), getWidth()/2, getHeight()/8);
        
        //triggers the sorting for the Score save, because we just
        //added a new record before we come to this world
        ScoreSave.sort();
        

        //count from 0 to the ammount of records we have
        for(int i = 0; i < ScoreSave.length; i++){
            //assemble the score printout, and add it at its appropiate location
            addObject(new Label(ScoreSave.getName(i)+":  "+ScoreSave.getScore(i), 40), getWidth()/2, getHeight()/8+100+i*40);
        }
    }
}
