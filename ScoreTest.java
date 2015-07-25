package Scrabble_Group1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

	@Test
	public void testGetScores() {
		assertEquals(Score.getScrabbleScore(""),0);
		assertEquals(Score.getScrabbleScore("hello"),8);
	}

}
