package s;

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
		expected.add("*b");
		expected.add("*ab");
		expected.add("ab");
		assertEquals("incorrect combinations of rack", expected, actual);
		rack = "d*c*";
		actual = scrabble.getCombinationsOfWord(rack);
		expected = new ArrayList<String>();
		expected.add("**");
		expected.add("*c");
		expected.add("*d");
		expected.add("**c");
		expected.add("**d");
		expected.add("**cd");
		expected.add("*cd");
		expected.add("cd");
		assertEquals("incorrect combinations of rack", expected, actual);
	}

}
