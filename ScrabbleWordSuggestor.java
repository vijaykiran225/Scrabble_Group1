package Scrabble_Group1;

import java.util.List;
import java.util.logging.Logger;
public class ScrabbleWordSuggestor
{
	private ScrabbleWords coreDictionary;
	
	public ScrabbleWordSuggestor ()
	{   
		this.coreDictionary = ScrabbleWords.getInstance();
	}
	
	public void wordSuggestions(String rack)
	{
		WordSuggester wordSuggestor = new WordSuggester (rack);
		List<Word> wordSuggestions = wordSuggestor.getMaxScoreWords();
		printWordSuggestions(wordSuggestions);
	}
	
	public void wordSuggestions(String rack, String constraint)
	{
		WordSuggester wordSuggestor = new WordSuggester (rack);
		List<Word> wordSuggestions = wordSuggestor.getMaxScoreWords(rack, constraint);
		printWordSuggestions(wordSuggestions);
	}
	
	public void printWordSuggestions(List<Word> wordSuggestion)
	{
		for (Word word : wordSuggestion)
		{
			System.out.println(word);
		}
	}
	
	public static void main (String[] arg)
	{
		ScrabbleWordSuggestor scrabbleWordSuggester = new ScrabbleWordSuggestor();
    	scrabbleWordSuggester.wordSuggestions("dabge");
    	System.out.println("\n\n***");
		scrabbleWordSuggester.wordSuggestions("abelo","h*l");
		
	}
}
