
/**
 * @author Jared Henry
 * 
 * BinarySearchTree Class provides methods to be used in adding, removing, and checking elements in a binary search tree
 * The BinarySearchTree Class references Nodes, their data, and left children and right children nodes of the tree
 * 
 * version 11/16/2022
 */


public class BinarySearchTree {

	public Node root;
	public Node current;
	
	/**
	 * @param root
	 * @param current
	 */
	public BinarySearchTree(Node root, Node current) {
		this.root = root;
		this.current = current;
	}


/**
 * @constructor creates a new binarysearchtree object
 */
	
	public BinarySearchTree() { // constructor; no nodes yet in tree
		
		root = null;
	}//end constructor
	
	/**
	 * 	@insertIt inserts Country objects into the binary search tree with considerations of Country Name of lesser value to the left child and 
	 * greater country names as the right child
	 * 
	 */
	public void insertIt(Country id) {
		Node newNode = new Node();           // make new node
		newNode.iData = id;                  // insert data
		
		if(root==null)                       // no node in root
		root = newNode;
		else // root occupied
		{
		Node current = root;               // start at root
		Node parent;
		while(true) {                      // (exits internally)
		parent = current;
		if(id.getName().compareTo(current.iData.getName()) < 0)    {     // go left?
		current = current.leftChild;
		if(current == null) {         // if end of the line, insert on left
		parent.leftChild = newNode;
		return;
		}
		} // end if go left
		else {                           // or go right?
		current = current.rightChild;
		if(current == null) {          // if end of the line, insert on right
		parent.rightChild = newNode;
		return;
		}
		} // end else go right
		} // end while
		} // end else not root
		} // end insert()
	
	
//--------------------------------------------------------------------------------------------------------------
	/**
	 * 	inOrder traverses through the binary search tree left children nodes, root, and right children nodes
	 */
public void inOrder(Node localRoot) {
	
	if(localRoot == null) {
		return;
	}//end base case
	
		preOrder(localRoot.leftChild);
		System.out.println(localRoot.iData + " ");
		preOrder(localRoot.rightChild);
		
	
}//end inOrder traversal print method

//--------------------------------------------------------------------------------------------------------------
/**
 * 	@inorder recursively prints out the binary search tree starting with left children nodes, root, and right children nodes
 */
public void inOrder() {
		
		inOrder(root);
	}//end InOrder Traversal
	
//--------------------------------------------------------------------------------------------------------------
	/**
	 * 	@preorder traverses tree starting at root, left children, then right children
	 * Node localRoot is the variable passed in to traverse through the tree
	 */
	
	public void preOrder(Node localRoot) {
		if(localRoot == null) {
			return;
		}//end base case
			System.out.println(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			
		
	}//end preorder traversal print method
	
//--------------------------------------------------------------------------------------------------------------	
	/**
	 * 	@preorder prints out tree starting with root, left tree, then right tree by passing in a root Node
	 */
	public void preOrder() {

		preOrder(root);
	
	}//end preOrder Traversal
	
//--------------------------------------------------------------------------------------------------------------		
	/**
	 * 	@postorder traverses through the tree starting with left children, right children, root
	 */
	
	public void postOrder(Node localRoot) {
		if(localRoot == null) {
			return;
		}//end base case
			
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			System.out.println(localRoot.iData + " ");
		
	}//end post order traversal print method
	
//--------------------------------------------------------------------------------------------------------------
	/**
	 * 	@postOrder prints out the binary search tree recursively starting with left children nodes, right children nodes, and root
	 */
	public void postOrder() {

		postOrder(root);
	
	}//end preOrder Traversal
	
	
//--------------------------------------------------------------------------------------------------------------
	/**
	 * 	@boolean delete returns true when a node is deleted.
	 * This method takes in a String from a user in Project 4 class, compares it with values of the binary search tree
	 * once matching value is found, the node is deleted and a successor node is set in place to become the new local root of the tree/subtree levels
	 */
public boolean delete(String key) // delete node with given key 
{ // (assumes non-empty list) 
Node current = root; 
Node parent = root; 
boolean isLeftChild = true; 

while(current.iData.getName().compareTo(key) != 0) // search for node 
{ 
parent = current; 
if(current.iData.getName().compareTo(key) > 0) // go left? 

{ 
isLeftChild = true; 
current = current.leftChild; 
} 

else // or go right? 
{ 
isLeftChild = false; 
current = current.rightChild; 
} 

if(current == null) // end of the line, 
return false; // didn’t find it 
} // end while 
// found node to delete 

// if no children, simply delete it 
if(current.leftChild==null && 

current.rightChild==null) 
{ 
if(current == root) // if root, 

root = null; // tree is empty 

 


else if(isLeftChild) 
parent.leftChild = null; // disconnect 
else // from parent 
parent.rightChild = null; 
} 

// if no right child, replace with left subtree 
else if(current.rightChild==null) 
if(current == root) 
root = current.leftChild; 
else if(isLeftChild) 
parent.leftChild = current.leftChild; 
else 
parent.rightChild = current.leftChild; 

// if no left child, replace with right subtree 
else if(current.leftChild==null) 
if(current == root) 
root = current.rightChild; 
else if(isLeftChild) 
parent.leftChild = current.rightChild; 
else 
parent.rightChild = current.rightChild; 

else // two children, so replace with inorder successor 
{ 
// get successor of node to delete (current) 
Node successor = getSuccessor(current); 

// connect parent of current to successor instead 
if(current == root) 
root = successor; 
else if(isLeftChild) 
parent.leftChild = successor; 
else 
parent.rightChild = successor; 

// connect successor to current’s left child 
successor.leftChild = current.leftChild; 
} // end else two children 

// (successor cannot have a left child) 

return true; // success 
} // end delete()
//--------------------------------------------------------------------------------------------------------------
/**
 * 	@getSuccessor method takes in the Node deleted by Delete method, finds its place in the Binary Search tree and replaces it with a new 
 * Node value so that the tree remains connected and balanced
 * It returns a successor Node which is used in the Delete method
 */
private Node getSuccessor(Node delNode) 

{ 
Node successorParent = delNode; 
Node successor = delNode; 
Node current = delNode.rightChild; // go to right child 
while(current != null) // until no more 

{ // left children, 
successorParent = successor; 
successor = current; 
current = current.leftChild; // go to left child 
} 

// if successor not 

if(successor != delNode.rightChild) // right child, 
{ // make connections 
successorParent.leftChild = successor.rightChild; 
successor.rightChild = delNode.rightChild; 
} 

return successor; 
} 
	
//--------------------------------------------------------------------------------------------------------------
/**
 * 	@find method takes in a key from a user input in Project 4 class, compares the values with values of the Binary Search Tree to find the Country
 * 
 */
public Node find(String key) // find node with given key 
{ // (assumes non-empty tree) 
Node current = root; // start at root 
while(current.iData.getName().compareTo(key) != 0) // while no match, 

{ 
if(key.compareTo(current.iData.getName()) < 0) { // go left? 
current = current.leftChild; 
}//end if statement
else { // or go right? 
current = current.rightChild; 
}//end else
if(current == null) { // if no child, 
return null; // didn’t find it 
}//end if null statement
} 
return current; // found it 
} // end find() 

//--------------------------------------------------------------------------------------------------------------
/**
 * 	@foundPrint method takes in a key input from the user for the Find method
 * As the method traverses through the tree, a path to the designated node is printed showing a happy path to our requested Country in the tree
 */
public void foundPrint(String key) {
	
	


 // find node with given key 
 // (assumes non-empty tree) 
Node current = root; // start at root 
while(current.iData.getName().compareTo(key) != 0) // while no match, 
{ 
if(current == root)
	System.out.print(root.iData.getName() + "--> ");
if(key.compareTo(current.iData.getName()) < 0) { // go left? 
current = current.leftChild; 
if(current.iData.getName().compareTo(key) != 0) {
System.out.print(current.iData.getName() + "--> ");

}//end if statement
//else {
//	System.out.printf(current.iData.getName());
//}//end print if statement

}//end if statement
else { // or go right? 
current = current.rightChild; 
if(current.iData.getName().compareTo(key) != 0) {
System.out.print(current.iData.getName() + "--> ");

}//end if statement
//else {
//	System.out.printf(current.iData.getName());
//}//end if print statement

}//end else
if(current == null) { // if no child, 
System.out.print("Null"); // didn’t find it 
}//end if null statement
} 
 // found it 
} // end find() 

//--------------------------------------------------------------------------------------------------------------
/**
 * @lowestValue - still under construction :(
 */
public void lowestValue() {
	
	Node finderLeft = root;
	
	if(finderLeft == null) {
		
	System.out.println("Tree is empty");
	}//end if null
	
	else {
		while(finderLeft.leftChild != null ) {
			
			
			finderLeft = finderLeft.leftChild;
			
			
		
		}//end while loop
	}
	
	finderLeft.displayNode();
	
}//end lowest value search



}//end BinarySearchTree Class
