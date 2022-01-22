import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Util{
    // instance variables - replace the example below with your own
    public static void swap(ArrayList arr, int i, int j){
        Object t = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,t);
    }
    /*
    public static void shuffle(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int r = Greenfoot.getRandomNumber(n - i) + i;
            swap(arr, i, r);
        }
    }
    public static void setup(int[] arr){
        int n = arr.length;
        for(int i = 1; i <= n; i++){
            arr[i - 1] = i;
        }
    }
    */
}
   


