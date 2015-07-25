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

	public int getScore(String word) {
		int alphabetsValue[] = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		int totalScore = 0;
		for (int i = 0; i < word.length(); i++) {

			totalScore += alphabetsValue[word.charAt(i) - 'a'];
		}

		return totalScore;
	}

	private String sort_word_byScore(String word) {
		int score_val[] = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		TreeMap<Integer, String> temp_map = new TreeMap<Integer, String>();
		for (int i = 0; i < word.length(); i++) {
			int char_index = (int) word.charAt(i) - 'a';
			if (!temp_map.containsKey(score_val[char_index])) {
				String vect = "";
				temp_map.put(score_val[char_index], vect);
			}
			String val = temp_map.get(score_val[char_index]);
			val += word.charAt(i);
			temp_map.put(score_val[char_index], val);
		}

		String temp_word = "";
		for (Map.Entry<Integer, String> entry : temp_map.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
			temp_word += entry.getValue();
		}

		return temp_word;
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

	public List<Word> getMaxScoreWords(String rack, String constraint) {
		return getTopTenWordSuggestions(ConstraintChecker.wordWithConstraints(rack, constraint));
	}
}
