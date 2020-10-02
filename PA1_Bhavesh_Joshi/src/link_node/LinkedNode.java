//TCSS 342 B - PA 1

package link_node;

/**
 * Node class for linked List.
 * @author Bhavesh Joshi
 *
 * @param <Integer> type of class
 */
public class LinkedNode<Integer> {
    
    /**
     * Instace field int data type.
     */
    public int data;
//    LinkedNode head;
    
    /**
     * Next node of current.
     */
    public LinkedNode<Integer> next;
//    LinkedNode tail;
    
    /**
     * A constructor to initialize empty list.
     */
    public LinkedNode() {
        next = null;
    }
    
    /**
     * A constructor to store data. 
     * @param theT int number
     */
    public LinkedNode(int theT) {
        this.data = theT;
        next = null;
//        setNext(this);
    }
    
    /**
     * A method to get next node.
     * @return next LinkedNode 
     */
    public LinkedNode<Integer> getNext() {
        return next;
    }
    
    /**
     * Set next node based on passing parameter.
     * @param theNode to be saved. 
     */
    public void setNext(LinkedNode<Integer> theNode) {
        next = theNode;
//        if (head == null) {
//            head = theNode;
//            tail = theNode;
//        }
//        else {
//            LinkedNode n = head;
//            while (n.next != null) {
//                n = n.next;
//            }
//            n.next = theNode;
//            tail = theNode;
//        }
        
    }
    
    /**
     * Method to return element.
     * @return int element.
     */
    public int getElement() {
        return data;
    }
    
    /**
     * A void method to set element based on passed element. 
     * @param theElement int type.
     */
    public void setElement(final int theElement) {
        data = theElement;
//        LinkedNode nn = new LinkedNode();
//        nn.data = theElement;
////        nn.next = null;
////        this.data = theElement;
//        setNext(nn);
    }
    
    //END of LinkedNode class. 
}
