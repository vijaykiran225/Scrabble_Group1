//package scrabble.Scrabble_Group1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoreDictionaryTest {

	ScrabbleWords d;
	@Before
	public void setUp() {
		d = new ScrabbleWords("testdoc.txt");
	}
	

	@Test
	public void testSortWord() {
		String testString = "harsha";
        String testString2 = "ha**sh";
		assertEquals("aahhrs",d.sortWord(testString));	
		System.out.println(d.sortWord(testString2));
		assertEquals("**ahhs",d.sortWord(testString2));
 
	}

	@Test
	public void testAddToHash() {
		String testString = "tel";
		ScrabbleWords l = new ScrabbleWords("testdoc2.txt");
		l.addToHash(testString);
		assertEquals(l.getDictionary().size(),7);
		
	}

}
