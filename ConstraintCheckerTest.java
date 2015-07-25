package Scrabble_Group1;

import org.junit.Before;

public class ConstraintCheckerTest {

		ConstraintChecker c ;
		
		@Before
		public void setUp() {	
			c= new ConstraintChecker();
		}
		
		/*@Test
		public void testGetAllWords(){
			List<String> testStrings = new ArrayList<String>();
			testStrings.add("hello");
			testStrings.add("sgdjd");
			testStrings.add("dhjds");
			testStrings.add("herlo");
			testStrings.add("heilo");
			testStrings.add("jkdhwkj");
			
			List<String> finalOutput = new ArrayList<String>();
			finalOutput.add("hello");
			finalOutput.add("herlo");
			finalOutput.add("heilo");
			
			assertEquals(c.getAllWords(testStrings,"h**lo"),finalOutput);
			
		}
		
		@Test
		public void testRegEx(){
			String testConstraint = "h**lo";
			String output = ".*h[a-z][a-z]lo.*";
			assertEquals(output, c.getRegEx(testConstraint));
		}
		
		@Test
		public void testWordMatches(){
			String testConstraint = "h**lo";
			String word1 = "gdgjgdjk";
			String word2 = "dhjwdfhellodbjkwebd";
			assertEquals(true,c.wordMatches(testConstraint, word2));
			assertEquals(false,c.wordMatches(testConstraint, word1));
			
		}

        @Test
		public void testGetNewRack(){
			String testRack = "rack";
			String testConstraint = "h**lo";
			String output = "rackhlo";
			assertEquals(output,c.getNewRack(testRack, testConstraint));
		}*/

}
