//package Scrabble_team_1;

/**
 * Created by test on 7/24/2015.
 */
import java.util.*;

public class Scrabble {

    private int max_score;
    private String max_score_words;
    private String rack;
    private HashMap<String, ArrayList<Words>> dictionary;
	private scoreOfAlphabets = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

    public Scrabble(String rack, HashMap<String, ArrayList<Words> > dictionary){
        max_score = 0;
        max_score_words = "";
        this.rack = rack;
        this.dictionary = dictionary;
    }

    public ArrayList<Words> getCombinationsOfWord(String word) {
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



    public Words getWord(String word){
        Words w = new Words(word, getScore(word));
        return w;
    }

    public int getScore(String word) {
        
        int total = 0;
        for(int i = 0;i < word.length();i++)
        {
            if(word.charAt(i)!='*')
			{
				total += scoreOfAlphabets[word.charAt(i)-'a'];
			}
            
        }

        return total;
    }



    public String sort_word_byScore(String word){
        
        TreeMap<Integer, String> temp_map = new TreeMap<Integer, String>();
        for (int i = 0; i < word.length(); i++){
            int char_index = (int)word.charAt(i) % 'a';
            if (!temp_map.containsKey(scoreOfAlphabets[char_index])){
                String vect = "";
                temp_map.put(scoreOfAlphabets[char_index], vect);
            }
            String val = temp_map.get(scoreOfAlphabets[char_index]);
            val += word.charAt(i);
            temp_map.put(scoreOfAlphabets[char_index], val);
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


    private boolean ifKeyExists(String word, HashMap<String, ArrayList<Words> > dictionary){

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


    public ArrayList<String> generate_valid_keys(ArrayList<Words> keys, HashMap<String, ArrayList<Words> > dictionary)
    {
        ArrayList<String> valid_keys = new ArrayList<String>();
        for(Words key: keys)
            if(ifKeyExists(key.getWord(), dictionary))
                valid_keys.add(key.getWord());

        return valid_keys;
    }

    public ArrayList<Words> generate_valid_words(ArrayList<Words> keys, HashMap<String, ArrayList<Words>> dictionary)
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
