import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Where the money, score, upgrades, etc are saved during each level
 * 
 * @author Vincent
 * @version 1/24
 */
public class States extends Actor{
    public static int weaponUpgrade;
    public static int money;
    public static int score;
    
    public States(){
        weaponUpgrade = 0;
        money = 0;
        score = 0;
    }
    public void act(){
        // Add your action code here.
    }
    public static void reset(){
        weaponUpgrade = 0;
        money = 0;
        score = 0;
    }
}
