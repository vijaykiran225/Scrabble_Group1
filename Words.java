
public class Words implements Comparable<Words> {
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

	@Override
	public int compareTo(Words o) {
		return Integer.compare(this.getScore(), o.getScore());
	}
}
