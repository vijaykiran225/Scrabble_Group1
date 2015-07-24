import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConstraintChecker {

	public static void main(){
		
		String rack = "xyddjke", constraint = " ***gb";
		Word obj = new Word();
		List<String> keyList = new ArrayList<String>();
		List<String> wordList = new ArrayList<String>();
		keyList = obj.getCombinationsOfWord(rack);
		CoreDictionary cd = new CoreDictionary();
		 
		wordList = getWordList(cd.map , keyList);
		
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
}
