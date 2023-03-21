
/**
 * @author Jared Henry
 * 
 * Node class provides construction of each Link in both the DLL and DoubleEndedLinkedList Class
 * The Node class offers reference to the Data of each Country object in the form of dData
 * It provides reference to left and right child Country object in the tree through Node leftChild and access to the right child Node through
 * Node rightChild
 * 
 * the display Node method prints out country objects one by one on a new line
 * 
 * version 11/9/2022
 */


public class Node {

	Country iData;
	Country dData;
	Node leftChild;
	Node rightChild;
	
	/**
	 * @param iData
	 * @param dData
	 * @param leftChild
	 * @param rightChild
	 */

/**
 * @displayNode prints out iData(country object) to user
 */
	public void displayNode() {
		
		
		System.out.print(iData);
		
	}//end display Node method
	
}//end Node Class
