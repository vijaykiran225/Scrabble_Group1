package Scrabble_Group1;

import java.util.Comparator;

public class WordComparator implements Comparator<Words>{
	

		public int compare(Words arg0, Words arg1) {
			return Integer.compare(arg0.getScore(),arg1.getScore());
		}
	

}
