//Alyssa Schilke
//Project 4
//5/3/17
import java.util.ArrayList;
import java.util.Scanner;
public class AlyssaSchilkeClientEncoding {
	public static void main (String [] args){
		//Ask user for word
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter word: ");
		String word = scan.nextLine();
		scan.close();
		//encode
		//build ArrayList of Frequencies
		ArrayList<AlyssaSchilkeFrequency> freqList = new ArrayList<AlyssaSchilkeFrequency>();
		for(char letter: word.toCharArray()){
			if (!(AlyssaSchilkeBinaryTree.isDuplicate(freqList,letter))){
				freqList.add(new AlyssaSchilkeFrequency(letter, 1));
			}
			else{
				for(AlyssaSchilkeFrequency freq: freqList){
					if(freq.getLetter() == letter)
						freq.addOneToFrequency();
				}
			}
		}
		// test: output sorted and unsorted list of Data/Frequency objects
		System.out.print("UnSorted Frequency List: ");
		for(AlyssaSchilkeFrequency freq: freqList){
			System.out.print(freq +" ");
		}
		AlyssaSchilkeBinaryTree.sortFreq(freqList);
		System.out.println("");
		System.out.print("Sorted   Frequency List: ");
		for(AlyssaSchilkeFrequency freq: freqList){
			System.out.print(freq +" ");
		}
		//Forest Of Binary Trees
		ArrayList<AlyssaSchilkeBinaryTree> forest = new ArrayList<AlyssaSchilkeBinaryTree>(freqList.size());
		for(AlyssaSchilkeFrequency freq : freqList){//copy frequency list into BinaryTree objects into forest
			forest.add(new AlyssaSchilkeBinaryTree(freq));
		}
		//build tree
		AlyssaSchilkeBinaryTree tree = AlyssaSchilkeBinaryTree.build(forest);
		//Testing: traverse the tree with each traversal method
		System.out.println("\nTraversal and Build Tree tests ");
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
		
		//build the ArrayList of codes
		ArrayList<AlyssaSchilkeCode> codeList = tree.buildCodes();
		//Testing: output ArrayList of codes
		System.out.print("List of Codes: ");
		for (AlyssaSchilkeCode code: codeList){
			System.out.print(code);
		}
		System.out.println();
		
		// build encoded string
		System.out.println("Encoded Word: "+tree.codeOutput(word));
	}
}