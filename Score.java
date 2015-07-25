package Scrabble_Group1;

/**
 * <b>Internal</b> class containing word scoring methods
 */
public class Score{

	private static int ScrabbleScores[]={1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private static final int valueOfA =97;

	/**
	 * @param word
	 * @return the score of the word as per the scrabble value of each alphabet
	 * @see <a href="http://www.wordfind.com/scrabble-letter-values/">Scrabble Letter Values</a>
	 */
	public static int getScrabbleScore(String word)
	{
		int total=0;
		for(int i=0;i<word.length();i++)
		{
			int c=((int)word.charAt(i)) % valueOfA;
			if(c >=0 && c<26){
			total+=ScrabbleScores[c];
			}
			
		}

	    return total;
	}
	
}
