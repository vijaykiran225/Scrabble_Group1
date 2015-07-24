import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConstraintChecker {

	public static void main(){

		ConstraintChecker cc = new ConstraintChecker();
		cc.wordWithConstraints("abcdef" , "g**b");

	}


	public List<String> wordWithConstraints(String rack, String constraint) {

		List<String> keyList = new ArrayList<String>();
		Word obj = new Word();
		keyList = obj.getValidKeys(getNewRack(rack, constraint));

		List<String> wordList = new ArrayList<String>();
		CoreDictionary cd = new CoreDictionary();
		wordList = getWordList(cd.map , keyList); //remove this comment

		return(getAllWords(wordList), constraint);


	}
	public String getNewRack(String rack, String constraint){

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
	public static List<String> getWordList(HashMap<String, List<String>> map, List<String> keyList){

		List<String> wordList = new ArrayList<String>();
		Iterator<Map.Entry<String, List<String>>> entries = map.entrySet().iterator();

		while (entries.hasNext()) {

		    Map.Entry<String, List<String>> entry = entries.next();
		    Iterator<String> itr = entry.getValue().iterator();

		    while(itr.hasNext()){
		    	String anagram = itr.next();
		    	wordList.add(anagram);
		    }

		}
		return wordList;
	}
	public static boolean wordMatches(String constraint, String word){
		return Pattern.matches(word, getRegEx(constraint));
	}

	public static ArrayList<String> getAllWords(ArrayList<String> wordList,String constraint){
		ArrayList<String> legalWords= new ArrayList<String>();
		for(String words : wordList){
			if(wordMatches(words,constraint)){
				legalWords.add(words);
			}
		}
		return legalWords;
	}

	public static String getRegEx(String constraint){
		String regEx = ".*";
		char[] charConstraint = constraint.toCharArray();
		for(char c : charConstraint){
			if(c!='*'){
				regEx =regEx +  c;
			}
			else{
				regEx=regEx+"[a-z]";
			}
		}

		regEx = regEx + ".*";
		return regEx;
	}

}
