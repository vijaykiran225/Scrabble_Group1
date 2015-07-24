import java.util.ArrayList;

class SubsetGenerator
 {
	private String word;
	public SubsetGenerator(String aWord)
	{
		word = aWord;
	}

	public ArrayList<String> getSubsets() {
		ArrayList<String> Subsets = new ArrayList<String>();

		if (word.length() == 0) {
			Subsets.add(word);
			return Subsets;
		}
		
		for (int j = word.length()-1; j >= 0; j--) {
			for (int i = j; i < word.length(); i++) {
				String shorterWord =  word.substring(0, j) ;
				SubsetGenerator shorterPermutationGenerator = new SubsetGenerator(shorterWord);
				ArrayList<String> shorterWordPermutations = shorterPermutationGenerator.getSubsets();
				for (String s : shorterWordPermutations) {
					Subsets.add(s + word.charAt(i));
				}
			}
		}
		return Subsets;
	}
	
	public static void main(String[] args)
	{
            SubsetGenerator generator = new SubsetGenerator("abc");
            ArrayList<String> Subsets = generator.getSubsets();
            for (String s : Subsets)
            {
                System.out.println(s);
            }      
    }
			
	
	
 }