package Scrabble_Group1;

//package Scrabble_Group3;

//package scrabble.Scrabble_Group1.Scrabble_Group1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScrabbleWords {

    private static ScrabbleWords dict = null;
	private static Map<String, List<String>> dictionary;
		
	
	public static ScrabbleWords getInstance(){
		if(dict == null){
			dict = new ScrabbleWords("finaltest.txt");
		}
		return dict;
	}
	
	private Map<String, List<String>> getDictionary() {
		return dictionary;
	}

    
	private ScrabbleWords(String path){
		dictionary = new HashMap<String, List<String>>();
		populateDictionary(path);
		
	}

	public static List<String> getWords(String key) {
		String sortedKey = sortWord(key);
		if(dictionary.containsKey(sortedKey))
		{	
			return dictionary.get(sortedKey);
		}
			return null;
		
	}
	
	public boolean isValidKey(String key) {
		return dictionary.containsKey(key);
	}
	private void populateDictionary(String path) {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(path));
			while ((sCurrentLine = br.readLine()) != null) {
				this.addToHash(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static String sortWord(String originalString) {
		char[] chars = originalString.toCharArray();
		Arrays.sort(chars);
		String sortedString = new String(chars);
		return sortedString;
	}

	private void addToHash(String word) {
		KeyCombinationGenerater wordCombinations = new KeyCombinationGenerater(word);
		List<String> wordList = wordCombinations.getKeyCombination();
		for (String line : wordList) {     	
		 	String sortedWord = sortWord(line);
			if (dictionary.containsKey(sortedWord)) {
				dictionary.get(sortedWord).add(word);
			} else {				
				dictionary.put(sortedWord, new ArrayList<String>());
			    dictionary.get(sortedWord).add(word);
			}
		}
	}
	

}
