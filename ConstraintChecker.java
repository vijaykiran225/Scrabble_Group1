import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;
 

public class ConstraintChecker {

	public static List<Words> wordWithConstraints(String rack, String constraint) {
		
		List<String> keyList = new ArrayList<String>();
		CoreDictionary cd = new CoreDictionary("C:/Users/test/Desktop/sowpods.txt");
		Scrabble sc = new Scrabble(getNewRack(rack,constraint), cd.getDictionary());
		
		keyList = sc.getValidKeys();
		System.out.println(keyList);
		
		List<Words> wordList = new ArrayList<Words>();
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
	public static List<Words> getWordList(Map<String, List<Words>> map, List<String> keyList){
		
		    List<Words> wordList = new ArrayList<Words>();
		    Iterator<String> itr = keyList.iterator();
		    
		    while(itr.hasNext()){
		    	
		    	List<Words> anagram = map.get(itr.next());
		    	Iterator<Words> itr2 = anagram.iterator();
		    	
		    	while(itr2.hasNext()){
		    		wordList.add((itr2.next()));
		    	}
		    }
		
		return wordList;		
	}
	
	public static boolean wordMatches(String constraint, String word){
		return Pattern.matches(getRegEx(constraint), word);
	}

	public static ArrayList<Words> getAllWords(List<Words> wordList, String constraint){
		
		ArrayList<Words> legalWords = new ArrayList<Words>();
		ArrayList<Words> finalList = new ArrayList<Words>();
		for(Words word : wordList){
			if(wordMatches(constraint , word.getWord())){
				legalWords.add(word);
			}
		}
		
		System.out.println(legalWords);
		Collections.sort(legalWords);
		ListIterator<Words> li = legalWords.listIterator(legalWords.size());	
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
