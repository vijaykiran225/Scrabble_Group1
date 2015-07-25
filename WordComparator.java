package Scrabble_Group1;

import java.util.Comparator;

public class WordComparator implements Comparator<Word>{
	

		public int compare(Word arg0, Word arg1) {
			return Integer.compare(arg0.getScore(),arg1.getScore());
		}
	

}
