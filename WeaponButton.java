import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version 1/14 0.1
 */
public class WeaponButton extends Actor{
    public static int weaponUpgrade = 1;
    public WeaponButton(){
        setImage(new GreenfootImage("Weapon\nUpgrade", 25, Color.BLACK, new Color(200,200,200)));
    }
    public void act(){
        if(weaponUpgrade < 3){
            if(Greenfoot.mousePressed(this) && Money.money >= 150){
                Money.money -= 150;
                weaponUpgrade++;
            }
        }else{
            //weaponUpgrade=3;
        }
    }    
}
