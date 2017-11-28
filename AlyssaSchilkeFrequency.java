//Alyssa Schilke
//Project 4
//5/3/17
public class AlyssaSchilkeFrequency {
	private char letter;
	private int freq;
	/**Default Constructor
	 */
	public AlyssaSchilkeFrequency(){
		letter = ' ';
		freq = 0;
	}
	/**Specific Constructor
	 * @param letter
	 * @param freq
	 */
	public AlyssaSchilkeFrequency(char letter, int freq) {
		this.letter = letter;
		this.freq = freq;
	}
	/**freq mutator
	 * @param newFreq
	 */
	public void setFreq(int newFreq){
		freq = newFreq;
	}
	/**letter accessor
	 * @return letter
	 */
	public char getLetter(){
		return letter;
	}
	/**frequency accessor
	 * @return freq
	 */
	public int getFreq(){
		return freq;
	}
	/**adds one to frequency
	 * @return freq
	 */
	public int addOneToFrequency(){
		freq++;
		return freq;
	}
	/**overrides toString for frequency objects
	 */
	public String toString(){
		return letter + " : " + freq;
	}
	/**compares frequency objects bases on the frequency integers
	 * @param otherFreq
	 * @return the compareTo value of the frequency integers
	 */
	public int compareTo(AlyssaSchilkeFrequency otherFreq){
		Integer freq = this.freq;
		return freq.compareTo(otherFreq.getFreq());
	}
}