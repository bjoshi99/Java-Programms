//PA_2 - Spring 2020
package PriorityQueue_ArrayHeap;

import HuffmanClasses.HuffmanTreeNode;

/**
 * PQ class extends the heapArray class property.
 * @author Bhavesh Joshi
 * @version Spring 2020.
 * @param <T>
 */
public class PriorityQueue<T> extends ArrayHeap<HuffmanTreeNode<T>>{
    
    /**
     * The array of H_Tree_node
     */
    HuffmanTreeNode<T>[] Queue;
    
    /**
     * int value for priority.
     */
    int myPriority;
    
    /**
     * T element of the node.
     */
    T myElement;
    
    /**
     * the H_tree_node.
     */
    HuffmanTreeNode<T> node;
    
    /** size.*/
    int length = 0;
    
    /**
     * Constructor to initialize the size.
     * @param theLength
     */
    public PriorityQueue(final int theLength) {
        super(theLength);
    }
 
    /**
     * Method to add element in the PQ.
     * @param theObject
     */
    public void addElement(HuffmanTreeNode<T> theObject) {
        
        @SuppressWarnings("unchecked")
        HuffmanTreeNode<T> theObject2 = (HuffmanTreeNode<T>) theObject;
        node = theObject2;
        super.addelement(node);
        length++;

    }
    
    /**
     * removes the next priority value.
     * @return deleted node.
     */
    public HuffmanTreeNode<T> removeNext() {
        HuffmanTreeNode<T> deleted = super.removeElement();
        length--;
        return deleted;
    }
    
    /**
     * Size of the PQ>
     * @return
     */
    public int size() {
        return length;
    }
    
//    public void print() {
//        super.print();
//    }
////    
//    public PriorityQueue<T> getQ(){
////        Queue = (HuffmanTreeNode<T>[]) super.getQ();
//        return this;
//    }
}
