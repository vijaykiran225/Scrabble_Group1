package Scrabble_team_1;

/**
 * Created by test on 7/24/2015.
 */
import java.util.*;

public class Scrabble {

    private int max_score;
    private String max_score_words;
    private String rack;
    private HashMap<String, Words> dictionary;

    public Scrabble(String rack, HashMap<String, Words> dictionary){
        max_score = 0;
        max_score_words = "";
        this.rack = rack;
        this.dictionary = dictionary;
    }

    private ArrayList<Words> getCombinationsOfWord(String word) {
        word = sortCharactersInWord(word);
        ArrayList<Words> combinationsOfWord = new ArrayList<Words>();
        for (int k = 0; k < word.length(); k++) {
            for (int i = k + 1; i < word.length(); i++) {
                String str1 = word.substring(k, i);
                String str2 = word.substring(i, word.length());
                for (int j = 0; j < str2.length(); j++) {
                    String combinationWord = str1 + str2.charAt(j);
                    if (!combinationsOfWord.contains(combinationWord)) {
                        combinationsOfWord.add(getWord(combinationWord));
                    }
                }
            }
        }
        return combinationsOfWord;
    }



    private Words getWord(String word){
        Words w = new Words(word, getScore(word));

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

    private long getPrimeProduct(String word){
        int prime_numbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        long product = 1;
        for (int i = 0; i < word.length(); i++)
            product *= prime_numbers[(int)word.charAt(i) - 97];

        return product;
    }

    private String sort_word_byScore(String word){
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

    private String sortCharactersInWord(String word) {
        char[] alphabets = word.toCharArray();
        Arrays.sort(alphabets);
        return new String(alphabets);
    }


    private boolean ifKeyExists(String word, HashMap<String, Words> dictionary){

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


    private ArrayList<String> generate_valid_keys(ArrayList<Words> keys, HashMap<String, Words> dictionary)
    {
        ArrayList<String> valid_keys = new ArrayList<String>();
        for(Words key: keys)
            if(ifKeyExists(key.getWord(), dictionary))
                valid_keys.add(key.getWord());

        return valid_keys;
    }

    private ArrayList<Words> generate_valid_words(ArrayList<Words> keys, HashMap<String, Words> dictionary)
    {
        ArrayList<Words> valid_keys = new ArrayList<Words>();
        for(Words key: keys)
            if(ifKeyExists(key.getWord(), dictionary))
                valid_keys.add(key);

        return valid_keys;
    }

    public ArrayList<String> getValidKeys()
    {
        return generate_valid_keys(getCombinationsOfWord(rack), dictionary);
    }

    public ArrayList<Words> getValidWords()
    {
        return generate_valid_words(getCombinationsOfWord(rack), dictionary);
    }

    public ArrayList<Words> getMaxScoreWords(ArrayList<String> validRackCombinations,
                                             Map<String, List<Words>> dictionary) {
        ArrayList<Words> maxScoreWords = new ArrayList<Words>();
        for (String validRackWord : validRackCombinations) {
            maxScoreWords.addAll(dictionary.get(validRackWord));
        }
        Collections.sort(maxScoreWords);
        ArrayList<Words> wordSuggestions = new ArrayList<Words>();
        for (int i = 0; i <= 10 && i < maxScoreWords.size(); i++) {
            wordSuggestions.add(maxScoreWords.get(i));
        }
        return wordSuggestions;
    }
}
