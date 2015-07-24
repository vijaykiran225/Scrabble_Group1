import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConstraintChecker {

	public static void main(){
		
		ConstraintChecker cc = new ConstraintChecker();
		cc.wordWithConstraints("abcdef" , "***gb");
		
	}
	public List<String> wordWithConstraints(String rack, String constraint) {
		
		List<String> keyList = new ArrayList<String>();
		Word obj = new Word();
		keyList = obj.getValidKeys(getNewRack(rack, constraint));
		
		List<String> wordList = new ArrayList<String>();
		CoreDictionary cd = new CoreDictionary();
		wordList = getWordList(cd.map , keyList); //remove this comment
		
		return wordList;
		
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
}
