import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class  Blanks_constraint
{


	
	public boolean ifKeyExists(String word, HashMap<String,String> dictionary){
		
		boolean wordexists = false;
		if(word.contains("*"))
		{
			return dictionary.containsKey(word);
		}
		else
		{
			return dictionary.containsKey(sortCharactersInWord(word));
		}
		
	}
	
	
	public ArrayList<String> getValidkeys(ArrayList<String> keys, HashMap<String,String> dictionary)
	{
		ArrayList<String> validkeys = null;
		
		for(String key: keys)
		{
			if(ifExists(key,dictionary))
			{
				validkeys.add(key);
			}
		}
		
		return validkeys;
	}

	public ArrayList<String> getCombinationsOfWord(String word) {
		word = sortCharactersInWord(word);
		ArrayList<String> combinationsOfWord = new ArrayList<String>();
		for (int k = 0; k < word.length(); k++) {
			for (int i = k + 1; i < word.length(); i++) {
				String str1 = word.substring(k, i);
				String str2 = word.substring(i, word.length());
				System.out.println(str1 + "," + str2);
				for (int j = 0; j < str2.length(); j++) {
					String combinationWord = str1 + str2.charAt(j);
					combinationsOfWord.add(combinationWord);
				}
			}
		}
		return combinationsOfWord;
	}

	public String sortCharactersInWord(String word) {
		char[] alphabets = word.toCharArray();
		Arrays.sort(alphabets);
		return new String(alphabets);
	}
	
}
public class codeforgit {

}
