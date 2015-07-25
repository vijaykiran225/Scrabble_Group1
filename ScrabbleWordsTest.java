package Scrabble_Group1;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ScrabbleWordsTest {
		ScrabbleWords d;
		@Before
		public void setUp() {
			d = ScrabbleWords.getInstance();
		}
		
        @Test
        public void testGetWords(){
        
        	char[] rack = {'h','l','e','l','s'};
        
        	String testString = new String(rack);
        	System.out.println(testString);
        	List<String> words = d.getWords(testString);
        //	if(words!=null)
        	assertEquals(1,words.size());
        }
}
