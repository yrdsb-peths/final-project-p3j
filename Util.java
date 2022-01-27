import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Util{
    // swap the ith object and jth object inside of the arr
    public static void swap(List arr, int i, int j){
        Object t = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,t);
    }
}
   


