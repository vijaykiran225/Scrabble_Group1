package Scrabble_Group1;

import java.util.*;

public class WordSuggester {

	private int max_score;
	private String max_score_words;
	private String rack;
	private final int NUMBER_OF_WORDS = 10;

	public WordSuggester(String rack) {
		max_score = 0;
		max_score_words = "";
		this.rack = rack;
	}

	public WordSuggester() {
		max_score = 0;
		max_score_words = "";
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

	private boolean ifKeyExists(String word, Map<String, List<Word>> dictionary) {

		if (word.contains("*")) {
			return dictionary.containsKey(word);
		} else {
			return dictionary.containsKey(sortCharactersInWord(word));
		}

	}

	private List<String> generate_valid_keys(List<String> keys) {
		List<String> valid_keys = new ArrayList<String>();
		for (String key : keys) {
			if (ScrabbleWords.getInstance().isValidKey(key))
				valid_keys.add(key);
		}

		return valid_keys;
	}

	public List<String> getValidKeys() {
		return generate_valid_keys(getCombinationsOfWord(rack));
	}

	public List<Word> MaxScoreWords(List<String> validRackCombinations) {
		ArrayList<String> maxScoreWords = new ArrayList<String>();
		for (String validRackWord : validRackCombinations) {
			maxScoreWords.addAll(ScrabbleWords.getWords(validRackWord));
		}
		return getTopTenWordSuggestions(maxScoreWords);
	}

	private List<Word> getTopTenWordSuggestions(List<String> words) {
		ArrayList<Word> wordList = new ArrayList<Word>();
		for (String word : words) {
			int score = Score.getScores(word);
			wordList.add(new Word(word, score));
		}
		Collections.sort(wordList);
		ArrayList<Word> wordSuggestions = new ArrayList<Word>();
		for (int i = 0; i <= NUMBER_OF_WORDS && i < wordList.size(); i++) {
			wordSuggestions.add(wordList.get(i));
		}
		return wordSuggestions;
	}

	public List<Word> getMaxScoreWords() {
		return MaxScoreWords(generate_valid_keys(getCombinationsOfWord(rack)));
	}

	public List<Word> getMaxScoreWords(String rack, String constraint, ScrabbleWords coreDictionary) {
		return getTopTenWordSuggestions(ConstraintChecker.wordWithConstraints(rack, constraint));
	}
}
