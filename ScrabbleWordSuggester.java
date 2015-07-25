package Scrabble_Group1;

import java.util.List;

/**
 * <b>Main Wrapper</b> class containing all the APIs
 */
public class ScrabbleWordSuggester
{

    public ScrabbleWordSuggester()
	{
        ScrabbleWords coreDictionary = ScrabbleWords.getInstance();
	}

    /**
     * @param rack given by the user
     */
	public void wordSuggestions(String rack)
	{
		WordSuggester wordSuggester = new WordSuggester (rack);
		List<Word> wordSuggestions = wordSuggester.getMaxScoreWords();
		printWordSuggestions(wordSuggestions);
	}

    /**
     * @param rack set of alphabets the user has
     * @param constraint existing on scrabble board
     */
	public void wordSuggestions(String rack, String constraint)
	{
		WordSuggester wordSuggester = new WordSuggester (rack);
		List<Word> wordSuggestions = wordSuggester.getMaxScoreWords(rack, constraint);
		printWordSuggestions(wordSuggestions);
	}

    /**
     * @param wordSuggestion list of suggested words based on the rack
     * Prints the words
     */
	public void printWordSuggestions(List<Word> wordSuggestion)
	{
		for (Word word : wordSuggestion)
		{
			System.out.println(word);
		}
	}
	
	public static void main (String[] arg)
	{
		ScrabbleWordSuggester scrabbleWordSuggester = new ScrabbleWordSuggester();
    	scrabbleWordSuggester.wordSuggestions("dabge");
    	System.out.println("\n\n***");
		scrabbleWordSuggester.wordSuggestions("abelo","h*l");
		
	}
}
