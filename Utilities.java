import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilities  
{
    // instance variables - replace the example below with your own
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void shuffle(int[] arr)
    {
        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            int r = Greenfoot.getRandomNumber(n - i) + i;
            Utilities.swap(arr, i, r);
        }
    }
    public static void setup(int[] arr)
    {
        int n = arr.length;
        for(int i = 1; i <= n; i++)
        {
            arr[i - 1] = i;
        }
    }    
    }
   


