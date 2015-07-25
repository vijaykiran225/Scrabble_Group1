package Scrabble_Group1;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSuggesterTest {

	@Test
	public void testGetScoreString() {
		//fail("Not yet implemented");
		WordSuggester testingObject = new WordSuggester();
		assertEquals(testingObject.getScore(""),0);
		assertEquals(testingObject.getScore("ab"),4);
	}

	@Test
	public void testGetScoreStringIntArray() {
		//fail("Not yet implemented");
		int alphabetsValue[] = {1,1,2,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
		WordSuggester testingObject = new WordSuggester();
		assertEquals(testingObject.getScore(""),0);
		assertEquals(testingObject.getScore("ab",alphabetsValue),2);
	}

}
