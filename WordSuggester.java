import java.util.*;

public class WordSuggester {

    private int max_score;
    private String max_score_words;
    private String rack;
    private Map<String, List<Words>> dictionary;

    public Scrabble(String rack, Map<String, List<Words> > dictionary){
        max_score = 0;
        max_score_words = "";
        this.rack = rack;
        this.dictionary = dictionary;
    }

    public Scrabble(){
        max_score = 0;
        max_score_words = "";
    }

    private List<String> getCombinationsOfWord(String word) {
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

    private boolean ifKeyExists(String word, Map<String, List<Words> > dictionary){

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

    private List<String> generate_valid_keys(List<String> keys, Map<String, List<Words> > dictionary)
    {
        List<String> valid_keys = new ArrayList<String>();
        for(String key: keys) {
            System.out.println(key);
            if (ifKeyExists(key, dictionary))
                valid_keys.add(key);
        }

        return valid_keys;
    }

    private List<Words> generate_valid_words(List<Words> keys, Map<String, List<Words>> dictionary)
    {
        List<Words> valid_keys = new ArrayList<Words>();
        for(Words key: keys) {
            System.out.println(key.getWord());
            if (ifKeyExists(key.getWord(), dictionary))
                valid_keys.add(key);
        }

        return valid_keys;
    }

    public List<String> getValidKeys()
    {
        return generate_valid_keys(getCombinationsOfWord(rack), dictionary);
    }

    public List<Words> MaxScoreWords(List<String> validRackCombinations,
                                          Map<String, List<Words>> dictionary){
        ArrayList<Words> maxScoreWords = new ArrayList<Words>();
        for (String validRackWord : validRackCombinations) {
            maxScoreWords.addAll(dictionary.get(validRackWord));
        }
        Collections.sort(maxScoreWords);
        ArrayList<Scrabble_team_1.Words> wordSuggestions = new ArrayList<Scrabble_team_1.Words>();
        for (int i = 0; i <= 10 && i < maxScoreWords.size(); i++) {
            wordSuggestions.add(maxScoreWords.get(i));
        }
        return wordSuggestions;
    }

    public List<Words> getMaxScoreWords() {
       return MaxScoreWords(generate_valid_keys(getCombinationsOfWord(rack), dictionary), dictionary);
    }
}
