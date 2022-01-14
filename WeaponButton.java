import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponButton extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int weaponUpgrade = 1;
    public WeaponButton(){
        setImage(new GreenfootImage("Weapon\nUpgrade", 25, Color.BLACK, new Color(200,200,200)));
    }
    public void act() 
    {
        if(weaponUpgrade > 3){
            weaponUpgrade=3;
        }else{
            if(Greenfoot.mousePressed(this) && Money.money >= 150){
                Money.money -= 150;
                weaponUpgrade++;
            }
        }
    }    
}
