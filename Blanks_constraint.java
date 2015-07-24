package Scrabble_team_1;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by test on 7/24/2015.
 */
class Blanks_constraint {
    public String rack = "**c**p**";
    public scoreOfAlphabets = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    ArrayList<Word> word_list = new ArrayList<Word>();

    public static void main(String[] args){
        System.out.println(sort_word("azby"));
    }
    
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
        
        int total = 0;
        for (int i = 0; i < word.length(); i++)
        {  	
        	if(word.charAt(i)!='*')
        	{
        		total += scoreOfAlphabets[word.charAt(i)-'a'];
        	}
        }

        return total;
    }

	
	public String sortCharactersInWord(String word) {
		char[] alphabets = word.toCharArray();
		Arrays.sort(alphabets);
		return new String(alphabets);
	}
	
		
	public boolean ifKeyExists(String word, HashMap<String,list<words>> dictionary){
		
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
	
	
	public ArrayList<String> getValidkeys(ArrayList<String> keys, HashMap<String,list<words>> dictionary)
	{
		ArrayList<String> validkeys = null;
		
		for(String key: keys)
		{
			if(ifKeyExists(key,dictionary))
			{
				validkeys.add(key);
			}
		}
		
		return validkeys;
	}

    //not working yet to fix.
    public String sort_word(String word){
        Character word_arr[] = ArrayUtils.toObject(word.toCharArray());
        Arrays.sort(word_arr, new Score_Comparator());
        for (Character c: word_arr)
            System.out.println(c);
        return new String(ArrayUtils.toPrimitive(word_arr));
    }

    static class Score_Comparator implements Comparator<Character> {

    public static String sort_word(String word){

        TreeMap<Integer, String> temp_map = new TreeMap<Integer, String>();
        for (int i = 0; i < word.length(); i++){
            int char_index = (int)word.charAt(i) - 'a';
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

}
