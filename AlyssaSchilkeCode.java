//Alyssa Schilke
//Project 4
//5/3/17
public class AlyssaSchilkeCode {
	private char letter;
	private String code;
	/**Default Constructor
	 */
	public AlyssaSchilkeCode(){
		letter = ' ';
		code = "";
	}
	/**Specific Constructor
	 * @param letter
	 * @param code
	 */
	public AlyssaSchilkeCode(char letter, String code){
		this.letter = letter;
		setCode(code);
	}
	/**code mutator
	 * @param code
	 */
	public void setCode(String code){
		// add restrictions (make sure 1 and 0's)
		this.code = code;
	}
	/**letter accessor
	 * @return letter
	 */
	public char getLetter(){
		return letter;
	}
	/**code accessor
	 * @return code
	 */
	public String getCode(){
		return code;
	}
	/**overrides toString for Code objects
	 */
	public String toString(){
		return letter+ ":"+ code +", ";
	}
}