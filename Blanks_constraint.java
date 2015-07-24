package Scrabble_team_1;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by test on 7/24/2015.
 */
class Blanks_constraint {
    public String rack = "**c**p**";
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
        int val[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        int total = 0;
        for (int i = 0; i < word.length(); i++)
        {
            total += val[word.charAt(i)-'a'];
        }

        return total;
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
	
	
	public ArrayList<String> getValidkeys(ArrayList<String> keys, HashMap<String,String> dictionary)
	{
		ArrayList<String> validkeys = null;
		
		for(String key: keys)
		{
			if(ifExists(key,dictionary))
			{
				validkeys.add(key);
			}
		}
		
		return validkeys;
	}

<<<<<<< HEAD
    //not working yet to fix.
    public String sort_word(String word){
        Character word_arr[] = ArrayUtils.toObject(word.toCharArray());
        Arrays.sort(word_arr, new Score_Comparator());
        for (Character c: word_arr)
            System.out.println(c);
        return new String(ArrayUtils.toPrimitive(word_arr));
    }

    static class Score_Comparator implements Comparator<Character> {
=======
    public static String sort_word(String word){
>>>>>>> 42492ea64b732004c45d425f670800e5968d232d
        int score_val[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        TreeMap<Integer, String> temp_map = new TreeMap<Integer, String>();
        for (int i = 0; i < word.length(); i++){
            int char_index = (int)word.charAt(i) % 'a';
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
//    //not working yet to fix.
//    public static String sort_word(String word){
//        Character word_arr[] = ArrayUtils.toObject(word.toCharArray());
//        Arrays.sort(word_arr, new Score_Comparator());
//        for (Character c: word_arr)
//            System.out.println(c);
//        return new String(ArrayUtils.toPrimitive(word_arr));
//    }
//
//    static class Score_Comparator implements Comparator<Character> {
//        int score_val[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
//        public int compare(Character o1, Character o2) {
//            if (score_val[(int)o1 % 97] > score_val[(int)o2 % 97]){
//                System.out.println(o1 + ">" + o2);
//                return o1;
//            }
//            return o2;
//        }
//
//    }



}
