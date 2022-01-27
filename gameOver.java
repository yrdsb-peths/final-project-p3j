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
        
        
        //sets background for instructions screen
        GreenfootImage img = new GreenfootImage("instructions.jpeg");
        //white background
        img.setColor(new Color(0,0,0,50));
        img.fillRect(0,0,900,600);
        //semi-transparent box
        img.setColor(new Color(0,0,0,150));
        img.fillRect(200,40,500,520);
        setBackground(img);

        //adds labels for the startscreen
        addObject(new Label(name+"!",40), getWidth()/2, getHeight()/8);
        addObject(new Label("You have scored:",30), getWidth()/2, getHeight()/8+35);
        addObject(new Label(score+" points!",40), getWidth()/2, getHeight()/8+65);
        
        //triggers the sorting for the Score save, because we just
        //added a new record before we come to this world
        ScoreSave.sort();
        

        //count from 0 to the ammount of records we have
        for(int i = 0; i < ScoreSave.length; i++){
            //assemble the score printout, and add it at its appropiate location
            addObject(new Label(ScoreSave.getName(i)+":  "+ScoreSave.getScore(i), 40), getWidth()/2, getHeight()/8+120+i*40);
        }
    }
}
