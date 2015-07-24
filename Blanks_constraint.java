package Scrabble_team_1;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by test on 7/24/2015.
 */
public class Blanks_constraint {
    public String rack = "**c**p**";
    ArrayList<Word> word_list = new ArrayList<Word>();


    public void generateAllScrabbleWords(){

    }

    public void ifExists(String word, HashMap map){
        Word w = new Word();
        w.length = word.length();
        w.score = getScore(word);
        w.val = word;
        w.prime_product = getPrimeProduct(word);
        w.key = sort_word(word);
    }

    public int getScore(String word){
        int val[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        int total = 0;
        for(int i = 0;i < word.length();i++)
        {
            int c = ((int)word.charAt(i)) % 97;
            total += val[c];
        }

        return total;
    }

    public long getPrimeProduct(String word){
        int prime_numbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        long product = 1;
        for (int i = 0; i < word.length(); i++)
            product *= prime_numbers[(int)word.charAt(i) - 97];

        return product;
    }

    //not working yet to fix.
    public static String sort_word(String word){
        Character word_arr[] = ArrayUtils.toObject(word.toCharArray());
        Arrays.sort(word_arr, new Score_Comparator());
        for (Character c: word_arr)
            System.out.println(c);
        return new String(ArrayUtils.toPrimitive(word_arr));
    }

    static class Score_Comparator implements Comparator<Character> {
        int score_val[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        public int compare(Character o1, Character o2) {
            if (score_val[(int)o1 % 97] > score_val[(int)o2 % 97]){
                System.out.println(o1 + ">" + o2);
                return o1 - o2;
            }
            return o2 - o1;
        }

    }
}
