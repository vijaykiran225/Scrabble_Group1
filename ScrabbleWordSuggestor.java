

import java.util.List;
import java.util.logging.Logger;
public class ScrabbleWordSuggestor
{
	private CoreDictionary coreDictionary;
	
	public ScrabbleWordSuggestor ()
	{   
		this.coreDictionary = CoreDictionary.getCoreDictionaryObject();
	}
	
	public void wordSuggestions(String rack)
	{
		WordSuggester wordSuggestor = new WordSuggester (rack,coreDictionary.getDictionary());
		List<Words> wordSuggestions = wordSuggestor.getMaxScoreWords();
		printWordSuggestions(wordSuggestions);
	}
	
	public void wordSuggestions(String rack, String constraint)
	{
		WordSuggester wordSuggestor = new WordSuggester (rack,coreDictionary.getDictionary());
		List<Words> wordSuggestions = wordSuggestor.getMaxScoreWords(rack, constraint,this.coreDictionary);
		printWordSuggestions(wordSuggestions);
	}
	
	public void printWordSuggestions(List<Words> wordSuggestion)
	{
		for (Words word : wordSuggestion)
		{
			System.out.println(word);
		}
	}
	
	public static void main (String[] arg)
	{
		ScrabbleWordSuggestor scrabbleWordSuggester = new ScrabbleWordSuggestor();
    	scrabbleWordSuggester.wordSuggestions("dabge");
    	System.out.println("\n\n");
		scrabbleWordSuggester.wordSuggestions("abelo","h*l");
		
	}
}