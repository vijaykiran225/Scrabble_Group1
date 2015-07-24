import java.util.*;
import CoreDictionary.java;
class scoreSortedList {

  public static void main(String[] aArgs){

  }
  public String sortWord(String originalString) {
		char[] chars = originalString.toCharArray();
		Arrays.sort(chars);
		String sortedString = new String(chars);
		return sortedString;
	}

  private static List<String> sortList(List<String> legalWordList){

     CoreDictionary coreDictionary = new CoreDictionary();
     Map<String,List<Words>> dictionary = new HashMap<String,List<Words>>();
     for (String s : legalWordList){
            legalWordList.remove(s);
            s = s + dictionary.get(sortWord(s)).getScore();
            legalWordList.add(s);

     }
    Collections.sort(legalWordList, String.CASE_INSENSITIVE_ORDER);
  }
}
