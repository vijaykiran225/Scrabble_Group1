import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Scrabble {

	public static void main(String[] args) {
		String word = "ab**";
		System.out.println(getCombinationsOfWord(word));
	}

	public static ArrayList<String> getCombinationsOfWord(String word) {
		word = sortCharactersInWord(word);
		ArrayList<String> combinationsOfWord = new ArrayList<String>();
		for (int k = 0; k < word.length(); k++) {
			for (int i = k + 1; i < word.length(); i++) {
				String str1 = word.substring(k, i);
				String str2 = word.substring(i, word.length());
				for (int j = 0; j < str2.length(); j++) {
					String combinationWord = str1 + str2.charAt(j);
					if (!combinationsOfWord.contains(combinationWord)) {
						combinationsOfWord.add(combinationWord);
					}
				}
			}
		}
		return combinationsOfWord;
	}

}
