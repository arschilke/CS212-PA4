//Alyssa Schilke
//Project 4
//5/3/17
public class AlyssaSchilkeNode {
	private AlyssaSchilkeFrequency letter;
	private AlyssaSchilkeNode right, left;
	
	public AlyssaSchilkeNode( AlyssaSchilkeFrequency newLetter ){
		setFrequency( newLetter );
		right = null;
		left = null;
	}
	public AlyssaSchilkeFrequency getFrequency( ){
		return letter;
	}
	public AlyssaSchilkeNode getRight( ){	
		return right;
	}
	public AlyssaSchilkeNode getLeft( ){	
		return left;
	}
	public void setFrequency( AlyssaSchilkeFrequency newLetter ){
		letter = newLetter;
	}
	public void setRight( AlyssaSchilkeNode nd ){
		right = nd;
	}
	public void setLeft( AlyssaSchilkeNode pd ){
		left = pd;
	}
}