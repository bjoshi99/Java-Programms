//TCSS 342 B - PA 2

package List;

/**
 * Node class for linked List.
 * @author Bhavesh Joshi
 * @version Spring 2020.
 * @param <T> type of class
 */
public class LinkedNode<T> {
    
    /**
     * Instace field int data type.
     */
    public T data;
//    LinkedNode head;
    
    /**
     * Next node of current.
     */
    public LinkedNode<T> next;
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
    public LinkedNode(T theT) {
        this.data = theT;
        next = null;
//        setNext(this);
    }
    
    /**
     * A method to get next node.
     * @return next LinkedNode 
     */
    public LinkedNode<T> getNext() {
        return next;
    }
    
    /**
     * Set next node based on passing parameter.
     * @param theNode to be saved. 
     */
    public void setNext(LinkedNode<T> theNode) {
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
    public T getElement() {
        return data;
    }
    
    /**
     * A void method to set element based on passed element. 
     * @param theElement int type.
     */
    public void setElement(final T theElement) {
        data = theElement;
//        LinkedNode nn = new LinkedNode();
//        nn.data = theElement;
////        nn.next = null;
////        this.data = theElement;
//        setNext(nn);
    }
    
    //END of LinkedNode class. 
}
