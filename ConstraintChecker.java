package Scrabble_Group1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static Scrabble_Group1.ScrabbleWords.getWords;

/**
 * <b>Internal</b> Class for retrieving list of words generated from rack satisfying the constraints
 */
class ConstraintChecker {

	/**
	 * finds all words possible using the rack satisfying the board constraint
	 * @param rack list of letter present with the user
	 * @param constraint Restriction because of existing letters on board
	 * @return list of possible Scrabble words
	 */
	public static List<String> wordWithConstraints(String rack, String constraint) {

		WordSuggester ws = new WordSuggester(getNewRack(rack,constraint));
		List<String> keyList = ws.getValidKeys();
		List<String> wordList = getWordList(keyList);
		
		return getAllWords(wordList, constraint);
		
	}

	private static String getNewRack(String rack, String constraint){

		int index = 0;
		while( index < constraint.length()){
			char ch = constraint.charAt(index);
			if('a' <= ch && ch <= 'z') {
				rack += ch;
			}
			index++;
		}
		return rack;

	}

	private static List<String> getWordList(List<String> keyList){

		    List<String> wordList = new ArrayList<String>();

		for (String aKeyList : keyList) {
			wordList.addAll(getWords(aKeyList));
		}

		return wordList;		
	}

	private static List<String> getAllWords(List<String> wordList, String constraint){
		
		List<String> legalWords = new ArrayList<String>();
			for(String word : wordList){
				if(wordMatches(constraint , word)){
				legalWords.add(word);
			}
		}
    		
		return legalWords;
		
	}

	private static boolean wordMatches(String constraint, String word){
		return Pattern.matches(getRegEx(constraint), word);
	}

	private static String getRegEx(String constraint){

		String regEx = ".*";
		char[] charConstraint = constraint.toCharArray();
		for(char c : charConstraint) {
			if(c!='*'){
				regEx =regEx +  c;
			}
			else {
				regEx=regEx + "[a-z]";
			}
		}
		regEx = regEx + ".*";
		return regEx;
	}
	
}
