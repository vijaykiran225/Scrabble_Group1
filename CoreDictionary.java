//package scrabble.Scrabble_Group1.Scrabble_Group1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CoreDictionary {


	private Map<String, List<Words>> dictionary = new HashMap<String, List<Words>>();

	public Map<String, List<Words>> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, List<Words>> dictionary) {
		this.dictionary = dictionary;
	}
	
	public CoreDictionary(String path){
		populateDictionary(path);
	}
	
	public void populateDictionary(String path) {
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

	public String sortWord(String originalString) {
		char[] chars = originalString.toCharArray();
		Arrays.sort(chars);
		String sortedString = new String(chars);
		return sortedString;
	}

	public void addToHash(String word) {
		CombinationGenerator wordCombinations = new CombinationGenerator(word);
		Score s = new Score();
		List<String> wordList = wordCombinations.getWordCombination();
        
		for (String line : wordList) {     	
		 	String sortedWord = sortWord(line);
			int score = s.getScores(line);	          
			
			if (dictionary.containsKey(sortedWord)) {
				dictionary.get(sortedWord).add(new Words(line,score));
			} else {				
				dictionary.put(sortedWord, new ArrayList<Words>());
			    dictionary.get(sortedWord).add(new Words(line,score));
			}
		}
	}
}
