package s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MaxScoreWordsSuggester {
	
	public ArrayList<Words> getMaxScoreWords(ArrayList<String> validRackCombinations,
			Map<String, List<Words>> dictionary) {
		ArrayList<Words> maxScoreWords = new ArrayList<Words>();
		for (String validRackWord : validRackCombinations) {
			maxScoreWords.addAll(dictionary.get(validRackWord));
		}
		Collections.sort(maxScoreWords);
		ArrayList<Words> wordSuggestions = new ArrayList<Words>();
		for (int i = 0; i <= 10 && i < maxScoreWords.size(); i++) {
			wordSuggestions.add(maxScoreWords.get(i));
		}
		return wordSuggestions;
	}
	
}
