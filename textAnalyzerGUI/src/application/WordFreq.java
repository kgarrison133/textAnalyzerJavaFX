package application;

public class WordFreq {
	private int ranking;
	private String word;
	private int frequency;
	public WordFreq(int ranking, String word, int frequency) {
		super();
		this.ranking = ranking;
		this.word = word;
		this.frequency = frequency;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
	
	
}
