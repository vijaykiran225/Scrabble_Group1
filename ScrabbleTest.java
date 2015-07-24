

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class ScrabbleTest {

	@Test
	public void testGetCombinationsOfWord() {
		String rack = "ab*";
		Scrabble scrabble = new Scrabble();
		ArrayList<String> actual = scrabble.getCombinationsOfWord(rack);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("*a");
		expected.add("*ab");
		expected.add("*b");
		expected.add("ab");
		assertEquals(expected, actual,"incorrect combinations of rack");
	}

}
