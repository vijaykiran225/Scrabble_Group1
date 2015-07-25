package Scrabble_Group1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;
 

public class ConstraintChecker {

	public static List<Word> wordWithConstraints(String rack, String constraint,ScrabbleWords cd) {
		
		List<String> keyList = new ArrayList<String>();
	//	CoreDictionary cd = new CoreDictionary("C:/Users/test/Desktop/sowpods.txt");
	//	CoreDictionary cd = CoreDictionary.getCoreDictionaryObject();
		WordSuggester sc = new WordSuggester(getNewRack(rack,constraint), cd.getDictionary());
		
		keyList = sc.getValidKeys();
	//System.out.println(keyList);
		
		List<Word> wordList = new ArrayList<Word>();
		wordList = getWordList(cd.getDictionary(), keyList); 
		
		return getAllWords(wordList, constraint);
		
	}
	public static String getNewRack(String rack, String constraint){
		
		int index = 0;
		int len = constraint.length();
		while( index < len){
			char ch = constraint.charAt(index);
			if('a' <= ch && ch <= 'z') {
				rack += ch;
			}
			index++;
		}
		return rack;
		
	}
	public static List<Word> getWordList(Map<String, List<Word>> map, List<String> keyList){
		
		    List<Word> wordList = new ArrayList<Word>();
		    Iterator<String> itr = keyList.iterator();
		    
		    while(itr.hasNext()){
		    	
		    	List<Word> anagram = map.get(itr.next());
		    	Iterator<Word> itr2 = anagram.iterator();
		    	
		    	while(itr2.hasNext()){
		    		wordList.add((itr2.next()));
		    	}
		    }
		
		return wordList;		
	}
	
	public static boolean wordMatches(String constraint, String word){
		return Pattern.matches(getRegEx(constraint), word);
	}

	public static ArrayList<Word> getAllWords(List<Word> wordList, String constraint){
		
		ArrayList<Word> legalWords = new ArrayList<Word>();
		ArrayList<Word> finalList = new ArrayList<Word>();
		for(Word word : wordList){
			if(wordMatches(constraint , word.getWord())){
				legalWords.add(word);
			}
		}
    		
		
	//	System.out.println(legalWords);
		Collections.sort(legalWords,new WordComparator());
		
		ListIterator<Word> li = legalWords.listIterator(legalWords.size());	
		while(li.hasPrevious() && finalList.size() < 5) {
			  finalList.add(li.previous());
			}

		return finalList;
		
		
	}

	public static String getRegEx(String constraint){
		
		String regEx = ".*";
		char[] charConstraint = constraint.toCharArray();
		for(char c : charConstraint) {
			if(c!='*'){
				regEx =regEx +  c;
			}
			else {
				regEx=regEx+"[a-z]";
			}
		}
		regEx = regEx + ".*";
		return regEx;
	}
	
}
