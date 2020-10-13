//PA _2 Spring 2020
package HuffmanClasses;

/**
 * A huffman node class with node, priority values.
 * @author Bhavesh Joshi
 * @version Spring 2020
 */
public class HuffmanTreeNode<T> {
    
    /**
     * Node of the element.    
     */
    private HuffmanTreeNode myNode;
    
    /**
     * left and right nodes of the element.    
     */
    private HuffmanTreeNode myLeft, myRight;
    
    /**
     * Value of myNode.
     */
    private char myElement;
    
    /**
     * A Priority value of myNode.
     */
    private int myPriorityValue;
    
    /**
     * Constructor to initialize the values of element, priority.
     * @param theChar element of the node.
     * @param theP priority of the node. 
     */
    public HuffmanTreeNode(final char theChar, final int theP) {
        myElement = theChar;
        myPriorityValue = theP;
        
    }
    
    /**
     * Constructor only for the root of combine nodes in PQ.
     * @param theF
     */
    public HuffmanTreeNode(final int theF) {
        myPriorityValue = theF;
    }
    
    /**
     * setter method for tree node.
     * @param theNode to set.
     */
    public void setLeftNode(final HuffmanTreeNode theNode) {
        myLeft = theNode;
    }
    
    /**
     * setter method for right tree node.
     * @param theNode to set.
     */
    public void setRightNode(final HuffmanTreeNode theNode) {
        myRight = theNode;
    }
    
    /**
     * Method to get tree node.
     * @return HuffmanTreeNode 
     */
    public HuffmanTreeNode getLeftNode() {
        return myLeft;
    }

    /**
     * Method to get tree node.
     * @return HuffmanTreeNode 
     */
    public HuffmanTreeNode getRightNode() {
        return myRight;
    }
    
    /**
     * Method to set element of the node to theElement.
     * @param theElement char to set element.
     */
    public void setElement(final char theElement) {
        myNode.myElement = theElement;
        //myElement = theElement;
    }
    
    /**
     * Method to return element of the node.
     * @return char element of Tree Node.
     */
    public char getElement() {
        return myElement;
        //return myElement
    }
    
    /**
     * Method to set priority value to theP.
     * @param theP int to set value.
     */
    public void setPriority(final int theP) {
        myNode.myPriorityValue = theP;
        //myPriorityValue = theP;
    }
    
    /**
     * Method to get return value of Tree Node. 
     * @return int priority value.
     */
    public int getPriorityValue() {
        return myPriorityValue;
        //return myPriorityValue;
    }
    
    /**
     * Method to compare given node with current node.
     * @param theO object to compare with.
     * @return the 1 if the current node has higher priority than
     * the given node and -1 otherwise.
     */
    public int compareTo(final HuffmanTreeNode theO) {
        int result = -1;
//        System.out.println("theO : " + theO.myPriorityValue);
//
//        System.out.println("Node : " + myPriorityValue);

        if(myPriorityValue > theO.myPriorityValue) {
            result = 1;
        }
        return result;
    }
}
