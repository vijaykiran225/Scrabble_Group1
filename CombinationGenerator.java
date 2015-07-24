import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class CombinationGenerator
 {
	private String word;
	public CombinationGenerator(String aWord)
	{
		word = aWord;
	}

	private HashSet<String> getSubsets() {
		HashSet<String> Subsets = new HashSet<String>();

		if (word.length() == 0) {
			Subsets.add(word);
			return Subsets;
		}
		
		for (int j = word.length()-1; j >= 0; j--) {
			for (int i = j; i < word.length(); i++) {
				String shorterWord =  word.substring(0, j) ;
				CombinationGenerator shorterPermutationGenerator = new CombinationGenerator(shorterWord);
				HashSet<String> shorterWordPermutations = shorterPermutationGenerator.getSubsets();
				for (String s : shorterWordPermutations) {
					Subsets.add(s + word.charAt(i));
				}
			}
		}
		return Subsets;
	}
	
	public List<String> getWordCombination()
	{
        HashSet<String> Subsets = getSubsets();
		List<String> wordCombination = new ArrayList<String> ();
		for (String s : Subsets)
        {
                while (s.length() != word.length())
				{
					s += "*";
				}
				
				wordCombination.add(s);
        }
			
		return wordCombination;
	}
	

	 public static void main(String[] args) {
            // TODO Auto-generated method stub
            CombinationGenerator generator = new CombinationGenerator("abc");
            generator.getWordCombination();
                   
            }
 }