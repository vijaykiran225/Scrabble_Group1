package Scrabble_Group1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScrabbleWords {

    private static ScrabbleWords dict = null;
	private static Map<String, List<String>> dictionary;

	/**
	 * Checks if an object of ScrabbleWord already exists and creates a new object of not
	 * @return Singleton Instance of this class
	 * @see ScrabbleWords
	 */
	public static ScrabbleWords getInstance(){
		if(dict == null){
			final String dir = System.getProperty("user.dir") + "\\src\\Scrabble_Group1";
			dict = new ScrabbleWords( dir + "\\testCoreDictionary.txt");
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

	/**
	 * Hashes the input key to get list of all valid words
	 * @param key word used as index
	 * @return list of all scrabble words possible to make using the key
	 */
	public static List<String> getWords(String key) {
		String sortedKey = sortWord(key);
		if(dictionary.containsKey(sortedKey))
		{	
			return dictionary.get(sortedKey);
		}
			return null;
		
	}

	/**
	 * Checks if the key is valid or not
	 * @param key
	 * @return true if the key exists
	 */
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
		KeyCombinationGenerator wordCombinations = new KeyCombinationGenerator(word);
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
