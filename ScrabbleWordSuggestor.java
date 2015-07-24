import ConstraintChecker;
import WordSuggester;
import CoreDictionary;

public class ScrabbleWordSuggestor
{
	private String rack;
	private CoreDictionary coreDictionary;
	
	public ScrabbleWordSuggestor ()
	{
		coreDictionary = new CoreDictionary();
	}
	
	public List<Words> wordSuggestions(String rack)
	{
		WordSuggestor wordSuggestor = new WordSuggestor (rack, coreDictionary.getDictionary());
		List<Words> wordSuggestions = wordSuggestor.getMaxWords ();
		printWordSuggestions(wordSuggestions);
	}
	
	public void wordSuggestionsForConstraint(String rack, String constraint)
	{
		List<Words> wordSuggestions = ConstraintChecker.wordWithConstraints(rack, constraint);
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
		ScrabbleWordSuggestor scrabbleWordSugggestor = new ScrabbleWordSuggestor();
		
	}
}