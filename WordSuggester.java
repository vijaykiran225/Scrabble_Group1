package Scrabble_Group1;

import java.util.*;

/**
 * <b>Sub Wrapper</b> class to get all valid keys and maximum scoring words from a rack
 */
public class WordSuggester {
    private String rack;
	private final int NUMBER_OF_WORDS = 10;

	public WordSuggester(String rack) {
		this.rack = rack;
	}

	private List<String> getCombinationsOfWord(String word) {
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

	private String sortCharactersInWord(String word) {
		char[] alphabets = word.toCharArray();
		Arrays.sort(alphabets);
		return new String(alphabets);
	}

    /**
     * @return list of valid keys
     */
	public List<String> getValidKeys() {
        List<String> valid_keys = new ArrayList<String>();
        for(String key : getCombinationsOfWord(rack)){
            if (ScrabbleWords.getInstance().isValidKey(key))
                valid_keys.add(key);
        }

        return valid_keys;
	}

    /**
     * Generates maximum scoring words generated using the rack
     * @return list of maximum scoring words
     */
	public List<Word> getMaxScoreWords() {
        ArrayList<String> maxScoreWords = new ArrayList<String>();
        for (String validRackWord : getValidKeys()) {
            maxScoreWords.addAll(ScrabbleWords.getWords(validRackWord));
        }
        return getTopTenWordSuggestions(maxScoreWords);
	}

    /**
     * Generates maximum scoring words using the rack satisfying the constraint on board
     * @param rack set of alphabets provided by user
     * @param constraint restrictions specified on board
     * @return list of maximum scoring words
     */
	public List<Word> getMaxScoreWords(String rack, String constraint) {
		return getTopTenWordSuggestions(ConstraintChecker.wordWithConstraints(rack, constraint));
	}

    private List<Word> getTopTenWordSuggestions(List<String> words) {
        ArrayList<Word> wordList = new ArrayList<Word>();
        for (String word : words) {
            int score = Score.getScrabbleScore(word);
            wordList.add(new Word(word, score));
        }
        Collections.sort(wordList);
        ArrayList<Word> wordSuggestions = new ArrayList<Word>();
        for (int i = 0; i <= NUMBER_OF_WORDS && i < wordList.size(); i++) {
            wordSuggestions.add(wordList.get(i));
        }
        return wordSuggestions;
    }
}
