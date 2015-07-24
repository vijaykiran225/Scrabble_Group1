package scrabble;

public class Words {
	private String word;
	private int score;

	public Words(String word, int score) {
		this.word = word;
		this.score = score;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
