import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Where the money, score, upgrades, etc are saved during each level
 * 
 * @author Vincent
 * @version 1/24
 */
public class States extends Actor{
    /**
     * Player's current weapon upgrade level
     */
    public static int weaponUpgrade;
    /**
     * Player's current money
     */
    public static int money;
    /**
     * Player's current score
     */
    public static int score;
    
    /**
     * table of weapon Upgrade Price for each level
     */
    public static int[]weaponUpgradePrice={100,250,750,2000,5000};
    
    /**
     * trigger a reset when its constructed
     */
    public States(){
        reset();
    }
    public void act(){
    }
    /**
     * Wipe the money, score, upgrades
     */
    public static void reset(){
        weaponUpgrade = 0;
        money = 0;
        score = 0;
    }
    /**
     * trigger a weapon upgrade
     */
    public static void TriggerWeaponUpgrade(){
        money -= weaponUpgradePrice[weaponUpgrade];
        weaponUpgrade++;
        Greenfoot.playSound("FX299.mp3");
    }
}
