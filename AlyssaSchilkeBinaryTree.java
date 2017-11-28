//Alyssa Schilke
//Project 4
//5/3/17
import java.util.ArrayList;
public class AlyssaSchilkeBinaryTree {
	private AlyssaSchilkeNode root;
	private int frequency;
	private ArrayList<AlyssaSchilkeCode> codes;
	
	public AlyssaSchilkeBinaryTree(AlyssaSchilkeFrequency frequency){
		root = new AlyssaSchilkeNode(frequency);
		this.frequency = root.getFrequency().getFreq();
		codes = new ArrayList<AlyssaSchilkeCode>();
	}
	/** frequency of tree accessor
	 * @return frequency of root
	 */
	public int getFrequency(){
		return frequency;
	}
	/**assigns tree to left node
	 * @param bt
	 */
	public void attachLeft( AlyssaSchilkeBinaryTree bt ){
		root.setLeft(  bt.root );
	}
	/**assigns tree to right node
	 * @param bt
	 */
	public void attachRight( AlyssaSchilkeBinaryTree bt ){
		root.setRight( bt.root );
	}
	/**sorts an array of BinaryTrees based on frequency (in ascending order)
	 * @param treeList
	 * @return sorted treeList
	 */
	public static ArrayList<AlyssaSchilkeBinaryTree> sort(ArrayList<AlyssaSchilkeBinaryTree> treeList){
		//copy to Arraylist
		AlyssaSchilkeBinaryTree[] treeArray = new AlyssaSchilkeBinaryTree[treeList.size()];
		treeArray =  treeList.toArray(treeArray);
		//sort ArrayList
		int j;
		AlyssaSchilkeBinaryTree temp;
		for ( int i = 1; i < treeArray.length; i++ ){
		   j = i;
		   temp = treeArray[i];
		   while ( j != 0 && treeArray[j - 1].root.getFrequency().compareTo(temp.root.getFrequency()) > 0 ){
		   	treeArray[j] = treeArray[j - 1];
		     j--;
		   }
		   treeArray[j] = temp;
		}
		//empty and reload ArrayList
		treeList.clear();
		for(AlyssaSchilkeBinaryTree tree: treeArray){
			treeList.add(tree);
		}
		return treeList;
	}
	/**combines two Binary Trees into one
	 * @param otherTree
	 * @return bigTree
	 */
	public static AlyssaSchilkeBinaryTree combine(AlyssaSchilkeBinaryTree tree1, AlyssaSchilkeBinaryTree tree2, AlyssaSchilkeFrequency newLetter){
		AlyssaSchilkeBinaryTree bigTree = new AlyssaSchilkeBinaryTree( newLetter );
		bigTree.attachLeft( tree1 );
		bigTree.attachRight( tree2 );
		return bigTree;
	}
	/**accept a forest of Binary Trees as its parameter and build a Binary Tree from it.
	 * @param forest
	 * @return tree
	 */
	public static AlyssaSchilkeBinaryTree build(ArrayList<AlyssaSchilkeBinaryTree> forest){
		while(forest.size()>1){
			AlyssaSchilkeBinaryTree tree1 = forest.remove(0);
			AlyssaSchilkeBinaryTree tree2 = forest.remove(0);
			int totalFreq = tree1.root.getFrequency().getFreq()+ tree2.root.getFrequency().getFreq();
			forest.add(AlyssaSchilkeBinaryTree.combine(tree1, tree2, new AlyssaSchilkeFrequency('?',totalFreq)));//add to end of forest
			AlyssaSchilkeBinaryTree.sort(forest);// sort forest to put added tree into correct spot
		}
		return forest.get(0);//list should only contain one entry , the finished tree
	}
	/**outputs the tree in preorder (first appearance)
	 */
	public void preOrder(){
		System.out.print("PreOrder: ");
		preOrder(root);
		System.out.println("");
	}
	/**private recursive method for preorder
	 * @param nd
	 */
	private void preOrder(AlyssaSchilkeNode nd){
		if (nd!= null){
			System.out.print(nd.getFrequency() + ", ");
			preOrder(nd.getLeft());
			preOrder(nd.getRight());
		}
	}
	/**outputs the tree in order (second appearance)
	 */
	public void inOrder(){
		System.out.print("In Order: ");
		inOrder(root);
		System.out.println("");
	}
	/**private recursive method for in order
	 * @param nd
	 */
	private void inOrder(AlyssaSchilkeNode nd){
		if(nd != null){
			inOrder(nd.getLeft());
			System.out.print(nd.getFrequency()+ ", ");
			inOrder(nd.getRight());
		}
	}
	/**outputs the tree in post order (third appearance)
	 */
	public void postOrder(){
		System.out.print("PostOrder: ");
		postOrder(root);
		System.out.println("");
	}
	/**private recursive method for post order
	 * @param nd
	 */
	private void postOrder(AlyssaSchilkeNode nd){
		if(nd != null){
			postOrder(nd.getLeft());
			postOrder(nd.getRight());
			System.out.print(nd.getFrequency()+ ", ");
		}
	}
	/** builds Code list
	 * @return ArrayList of Code objects (codes)
	 */
	public ArrayList<AlyssaSchilkeCode> buildCodes(){
		String codeStr = "";
		return buildCodes(root,codeStr);
	}
	/**
	 * private recursive method for buildCodes
	 * @param nd
	 * @param codeStr
	 * @return codes ArrayList
	 */
	private ArrayList<AlyssaSchilkeCode> buildCodes(AlyssaSchilkeNode nd, String codeStr){
		if(nd!= null){
			if (nd.getLeft()==null && nd.getRight()==null){
				codes.add(new AlyssaSchilkeCode(nd.getFrequency().getLetter(),codeStr));
			}
			else{
				buildCodes(nd.getLeft(),codeStr+"0");
				buildCodes(nd.getRight(),codeStr+"1");
			}
		}
		return codes;
	}
	/**
	 * loops through word from user and looks up code from ArrayList
	 * @param word
	 * @return encode string of word (CodeStr)
	 */
	public String codeOutput(String word){
		String codeStr = "";
		for (char letter: word.toCharArray()){
			for (AlyssaSchilkeCode code: codes){
			if(letter == code.getLetter())
				codeStr+=code.getCode();
			}
		}
		return codeStr;
	}
	//helper methods
	/**@param freqList
	 * @param letter
	 * @return true if letter already in list
	 */
	public static boolean isDuplicate(ArrayList<AlyssaSchilkeFrequency> freqList, char letter){ 
		for(AlyssaSchilkeFrequency freq : freqList){
			if(letter == freq.getLetter())
				return true;
		}
		return false;
	}
	/**Sorts ArrayList of Frequency Objects 
	 * @param freqList
	 * @return
	 */
	public static ArrayList<AlyssaSchilkeFrequency> sortFreq(ArrayList<AlyssaSchilkeFrequency> freqList){
		AlyssaSchilkeFrequency[] freqArray = new AlyssaSchilkeFrequency[freqList.size()];
		freqArray =  freqList.toArray(freqArray);
		int j;
		AlyssaSchilkeFrequency temp;
		for ( int i = 1; i < freqArray.length; i++ ){
		   j = i;
		   temp = freqArray[i];
		   while ( j != 0 && freqArray[j - 1].compareTo(temp) > 0 ){
		   	freqArray[j] = freqArray[j - 1];
		     j--;
		   }
		   freqArray[j] = temp;
		}
		freqList.clear();
		for(AlyssaSchilkeFrequency freq: freqArray){
			freqList.add(freq);
		}
		return freqList;
	}
}