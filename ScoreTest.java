package Scrabble_Group1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testGetScores() {
		Score s=new Score();
		assertEquals(s.getScrabbleScore(""),0);
		assertEquals(s.getScrabbleScore("hello"),8);
	}

}
