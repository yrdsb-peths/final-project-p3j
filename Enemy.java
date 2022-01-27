import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version 1/11 0.15
 */
public class Enemy extends SmoothMover{
    //if Enemy is hit by a projectile
    public boolean hitByProjectile(){
        if(getOneIntersectingObject(Projectile.class)!=null){
            return true;
        }
        return false;
    }
}
