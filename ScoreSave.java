import java.util.*;
/**
 * Saves the Score and Names during one session
 * 
 * @author Vincent Hsieh
 * @version 1.0
 */
public class ScoreSave{
    //a private static list of names
    private static ArrayList names = new ArrayList();
    //a private static list of scores
    private static ArrayList scores = new ArrayList();
    /**
     * the ammount of records we have
     */
    public static int length = 0;
    /**
     * Add a record into the ScoreSave with the name and score
     */
    public static void add(String name, int score){
        //add the name into the ordered list of names
        names.add(name);
        //add the score into the ordered list of scores
        scores.add(score);
        //increase the length by 1
        length++;
    }
    /**
     * Get the record name at this index
     */
    public static String getName(int n){
        return (String)names.get(n);
    }
    /**
     * Get the record score at this index
     */
    public static int getScore(int n){
        return (int)scores.get(n);
    }
    /**
     * triggers a sort to the ScoreSave
     */
    public static void sort(){
        quicksort(scores, 0, scores.size() - 1);
    }
    private static void quicksort(ArrayList nums, int l, int h){
        if (h <= l) return;
        int j = partition(scores, l, h);
        quicksort(scores, l, j-1); 
        quicksort(scores, j+1, h);
    }
    private static int partition(ArrayList nums, int l, int h){
        int i = l; 
        int j = h + 1;
        while(true){
            while((int)scores.get(++i)>(int)scores.get(l))if (i == h)break; 
            while((int)scores.get(--j)<(int)scores.get(l))if (j == l)break;
            if (i >= j)break;
            Util.swap(scores, i, j);
            Util.swap(names, i, j);
        } 
        Util.swap(scores, l, j);  // Swap partitioning element
        Util.swap(names, l, j);  // Swap partitioning element
        return j;  // Return index of item now know to be in place
    }
}
