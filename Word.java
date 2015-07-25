package Scrabble_Group1;

public class Word implements Comparable<Word> {
    private String word;
    private int score;
    private int length;

    public Word(String word, int score) {
        this.word = word;
        this.length = word.length();
        this.score = score;
    }

    /**
     * @return String stored in the word
     */
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return Score of the word currently generated using Scrabble values of alphabets
     * @see <a href="http://www.wordfind.com/scrabble-letter-values/">Scrabble Letter Values</a>
     */
    public int getScore() {
        return score;
    }

    /**
     * Used to compare to words
     * @param comparedWord Word to be compared with
     * @return 1 if the comparedWord has an equivalent score, else 0
     */
    public int compareTo(Word comparedWord) {
        return Integer.compare(comparedWord.getScore(), this.getScore());
    }

    /**
     * @return String containing the word along with it's score
     */
	public String toString()
	{
		return "Word : " + getWord() + " --- "  +" Score : " + getScore();
	}

}
