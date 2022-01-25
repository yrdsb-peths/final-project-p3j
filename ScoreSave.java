import java.util.*;
/**
 * Saves the Score and Names during one session
 * 
 * @author Vincent Hsieh
 * @version 1.0
 */
public class ScoreSave{
    //a private static list of names
    private static ArrayList<String> names = new ArrayList();
    //a private static list of scores
    private static ArrayList<Integer> scores = new ArrayList();
    /**
     * the ammount of records we have
     */
    public static int length = 0;
    /**
     * Add a record into the ScoreSave with the name and score
     */
    public static void add(String name, int score){
        //try find the name in the list of names we have
        int res = namesLinSearch(name);
        if(res != -1){
            //find it, now set the score that is related to this name, if it is bigger
            int saved_score = scores.get(res);
            if(saved_score < score){
                scores.set(res,score);
            }
        }else{
            //add the name into the ordered list of names
            names.add(name);
            //add the score into the ordered list of scores
            scores.add(score);
            //increase the length by 1
            length++;
        }
    }
    /**
     * Get the record name at this index
     */
    public static String getName(int n){
        return names.get(n);
    }
    /**
     * Get the record score at this index
     */
    public static int getScore(int n){
        return scores.get(n);
    }
    /**
     * triggers a sort to the ScoreSave
     */
    public static void sort(){
        scoresQuicksort(0, scores.size() - 1);
    }
    private static void scoresQuicksort(int l, int h){
        if (h <= l) return;
        int j = scoresPartition(l, h);
        scoresQuicksort(l, j-1); 
        scoresQuicksort(j+1, h);
    }
    private static int scoresPartition(int l, int h){
        int i = l; 
        int j = h + 1;
        while(true){
            while(scores.get(++i)>scores.get(l))if (i == h)break; 
            while(scores.get(--j)<scores.get(l))if (j == l)break;
            if (i >= j)break;
            Util.swap(scores, i, j);
            Util.swap(names, i, j);
        } 
        Util.swap(scores, l, j);  // Swap partitioning element
        Util.swap(names, l, j);  // Swap partitioning element
        return j;  // Return index of item now know to be in place
    }
    private static int namesLinSearch(String target){
        for(int i = 0; i < names.size(); i++){
            if(((String)names.get(i)).equals(target)){
                return i;
            }
        }
        return -1;
    }
}
