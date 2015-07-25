package Scrabble_Group1;

public class Words implements Comparable<Words> {
    private String word;
    private int score;
    private int length;
    private String key;

    public Words(String word, int score) {
        this.word = word;
        this.length = word.length();
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

    public int getLength(){
        return length;
    }


    public int compareTo(Words o) {
        return Integer.compare(o.getScore(),this.getScore());
    }
	
	public String toString()
	{
		return "Word : " + getWord() + " --- "  +" Score : " + getScore();
	}
}
