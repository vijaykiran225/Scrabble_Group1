package Scrabble_Group1;

public class  Score{

	private static int ScrabbleScores[]={1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private static final int valueofA=97;
	
	public static int getScores(String word)
	{
		int total=0;
		for(int i=0;i<word.length();i++)
		{
			int c=((int)word.charAt(i)) % valueofA;
			if(c >=0 && c<26){
			total+=ScrabbleScores[c];
			}
			
		}

	    return total;
	}
	
}
