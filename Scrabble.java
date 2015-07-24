package Scrabble_team_1;

/**
 * Created by test on 7/24/2015.
 */
import java.util.*;

public class Scrabble {

    private ArrayList<Word> valid_keys;
    private int max_score;
    private String max_score_words;

    public Scrabble(){
        valid_keys = new ArrayList<Word>();
        max_score = 0;
        max_score_words = "";
    }

    public ArrayList<String> getCombinationsOfWord(String word) {
        word = sortCharactersInWord(word);
        ArrayList<String> combinationsOfWord = new ArrayList<String>();
        for (int k = 0; k < word.length(); k++) {
            for (int i = k + 1; i < word.length(); i++) {
                String str1 = word.substring(k, i);
                String str2 = word.substring(i, word.length());
                for (int j = 0; j < str2.length(); j++) {
                    String combinationWord = str1 + str2.charAt(j);
                    if (!combinationsOfWord.contains(combinationWord)) {
                        combinationsOfWord.add(combinationWord);
                    }
                }
            }
        }
        return combinationsOfWord;
    }



    public Word getWord(String word){
        Word w = new Word();
        w.length = word.length();
        w.score = getScore(word);
        w.val = word;
        w.prime_product = getPrimeProduct(word);
        w.key = sortCharactersInWord(word);

        return w;
    }

    public int getScore(String word) {
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

    public String sort_word_byScore(String word){
        int score_val[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        TreeMap<Integer, String> temp_map = new TreeMap<Integer, String>();
        for (int i = 0; i < word.length(); i++){
            int char_index = (int)word.charAt(i) % 97;
            if (!temp_map.containsKey(score_val[char_index])){
                String vect = "";
                temp_map.put(score_val[char_index], vect);
            }
            String val = temp_map.get(score_val[char_index]);
            val += word.charAt(i);
            temp_map.put(score_val[char_index], val);
        }

        String temp_word  = "";
        for(Map.Entry<Integer, String> entry : temp_map.entrySet()) {
            System.out.println(entry.getKey() +"->" + entry.getValue());
            temp_word += entry.getValue();
        }

        return temp_word;
    }

    public String sortCharactersInWord(String word) {
        char[] alphabets = word.toCharArray();
        Arrays.sort(alphabets);
        return new String(alphabets);
    }


    public boolean ifKeyExists(String word, HashMap<String,String> dictionary){

        boolean wordexists = false;
        if(word.contains("*"))
        {
            return dictionary.containsKey(word);
        }
        else
        {
            return dictionary.containsKey(sortCharactersInWord(word));
        }

    }


    public void generate_valid_keys(ArrayList<Word> keys, HashMap<String,String> dictionary)
    {
        for(Word key: keys)
            if(ifKeyExists(key.val, dictionary))
                valid_keys.add(key);
    }

    public ArrayList<Word> getValidKeys()
    {
        return valid_keys;
    }
}
