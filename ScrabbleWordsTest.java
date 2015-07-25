package Scrabble_Group1;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScrabbleWordsTest {

	    @Before
		public void setUp() {
		ScrabbleWords d = ScrabbleWords.getInstance();
		}
		
        @Test
        public void testGetWords(){
        
        	char[] rack = {'h','l','e','l','s'};
        
        	String testString = new String(rack);
        	System.out.println(testString);
        	List<String> words = ScrabbleWords.getWords(testString);
			assert words != null;
			assertEquals(1, words.size());
        }
}
