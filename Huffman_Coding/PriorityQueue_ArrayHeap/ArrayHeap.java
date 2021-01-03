package PriorityQueue_ArrayHeap;

import java.util.EmptyStackException;

import HuffmanClasses.HuffmanTree;
import HuffmanClasses.HuffmanTreeNode;

/**
 * Array heap class to heapify and remove min of PQ.
 * @author Bhavesh Joshi
 * @version Spring 2020
 * @param <T>
 */
public class ArrayHeap<T> {

//    private HuffmanTreeNode<T>[] tree;
    /**
     * Array generic type for tree.
     */
    private T[] tree;
    
    /**
     * counter variable.
     */
    private int count = 0;
    
    /**
     * The size of the array.
     */
    private int mySize;
    
    /**
     * front of the array.
     */
    private int front = 0;
    
    /**
     * Empty constructor.
     */
    public ArrayHeap() {
        
    }
    
    /**
     * Constructor to initialize the size.
     * @param theSize size for tree
     */
    public ArrayHeap(final int theSize){
//        tree = (HuffmanTreeNode[]) new Object[theSize];
        tree = (T[]) new Object[theSize];
        mySize = theSize;
//        System.out.println("size " + mySize);
    }
    
    /**
     * to check if the tree is full or not.
     * @return true if full, false otherwise.
     */
    private boolean isFull() {
//        System.out.println("count "+count + " size " + mySize);
        if(count == mySize) {
            return true;
        }
        return false;
    }
    
    /**
     * To print the tree.
     */
    public void print() {
        for (int i = front; i < count && tree[i] != null; i++) {
            HuffmanTreeNode<T> temp = (HuffmanTreeNode<T>) tree[i];
            System.out.println("char " + temp.getElement());
            System.out.println(" freq " + temp.getPriorityValue());
        }
    }
    
    /**
     * Get the Q/Array heap.
     * @return T[]
     */
    public T[] getQ() {
        return tree.clone();
    }
    
    /**
     * Add element to tree.
     * @param theElement T
     */
    public void addelement(final T theElement) {
        try {
            if(isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                
                tree[count] =  theElement;
                count++;
                if(count > 1) {
//                    heapAdd();
                    heapifyAdd();
                }                
            }

        } catch(final IndexOutOfBoundsException theE) {
            System.out.println("Tree is full. Can add!!");
        }
    }
        
    /**
     * heapify and rearrange the treee to follow min heap property.
     */
    private void heapifyAdd() {
        
        int next = count - 1;
        
        //Generic would be T
        HuffmanTreeNode<T> check = (HuffmanTreeNode<T>) tree[next];

        while(next != 0 && ((HuffmanTreeNode<T>)tree[(next - 1)/2]).compareTo(check) > 0) {
            tree[next] = tree[(next - 1)/2];
            next = (next - 1)/2;
        }
        tree[next] = (T) check;
    }
    
    /**
     * Removes the element from the tree and rearrange the nodes.
     * @return deleted element T
     */
    public T removeElement() {
        T min = null;
        try {
            if (count == 0) {
                throw new EmptyStackException();
            }
            min = tree[0];
            tree[0] = tree[count - 1];
            count--;
            heapifyRemov(0);
            
        } catch(final Exception theE) {
//            System.out.println("Empty Array: can not delete.");
        }
//        HuffmanTreeNode<T> mnn = (HuffmanTreeNode<T>) min;
        return min;
    }
    
    /**
     * Method to swap the first with second.
     * @param first
     * @param second
     */
    private void swap(final int first, final int second) {
        T temp = tree[first];
        tree[first] = tree[second];
        tree[second] = (T) temp;
    }
    
    /**
     * The heapify of remove.
     * @param i starting with 0 and rearrange till it reaches the leaf.
     */
    private void heapifyRemov(final int i) {
        
        int smallest = i;
        int parent = smallest;
        int left = 2*parent + 1, right = 2*parent + 2;
        
        HuffmanTreeNode<T> leftElement = (HuffmanTreeNode<T>) tree[left];
        HuffmanTreeNode<T> rightElement = (HuffmanTreeNode<T>) tree[right];
        HuffmanTreeNode<T> small = (HuffmanTreeNode<T>) tree[smallest];
               
        
//        Huffman type casting,
        if(small.compareTo(leftElement) > 0 && small.compareTo(rightElement) > 0
                && leftElement.compareTo(rightElement) > 0 && left < count && right < count) {
            swap(smallest, right);
            smallest = right;
            small = (HuffmanTreeNode<T>) tree[smallest];         
        }
        
        else if (left < count && small.compareTo(leftElement) > 0) {
            
//                System.out.println("Left "+leftElement.getPriorityValue()
//                +" small " + small.getPriorityValue());
                swap(smallest, left);
                smallest = left;
                small = (HuffmanTreeNode<T>) tree[smallest];
        } 
        
        else if (right < count && small.compareTo(rightElement) > 0) {
            
//              System.out.println("Right "+rightElement.getPriorityValue()
//                                  +" small " + small.getPriorityValue());
              swap(smallest, right);
              smallest = right;
              small = (HuffmanTreeNode<T>) tree[smallest];
          }
            
//        Generic type
//        if (left < count && A[left].compareTo(tree[smallest]) > 0) {
//            smallest = left;
//        } 
//        else if (right < count && A[right].compareTo(tree[smallest]) > 0) {
//            smallest = right;
//        }
        
        if(smallest != i) {
            heapifyRemov(smallest);
        } 
        
    }
    
//  private void heapAdd() {
//  int next = count-1;
//  int checker = next-1;
//  HuffmanTreeNode<T> check = (HuffmanTreeNode<T>) tree[next];
//  boolean flag = false;
//  
//  while(!flag && checker >= front) {
////      System.out.println("In while");
////      print();
//      flag = true;
////      System.out.println("check priority "+check.getPriorityValue()
////                          +" check char "+check.getElement());
////      System.out.println("checker priority "+((HuffmanTreeNode<T>) tree[checker]).getPriorityValue()
////                          +" checker char "+((HuffmanTreeNode<T>) tree[checker]).getElement());
//
//      if( (((HuffmanTreeNode<T>) tree[checker])).compareTo(check) > 0){
//          flag = false;
////          System.out.println("In check");
//          swap(checker, next);
//          next = checker;
//          checker--;
//      }
//  }
//}

//private void printjj() {
//  for (int i = 0; i < count; i++) {
//      System.out.print(" " + ((HuffmanTreeNode<T>) tree[i]).getPriorityValue());
//  }
//  System.out.println();
//}
//
    
//    private void heapifyRemove() {
//        T temp = tree[0];
//        int parent = 0;
//        int left = 1, right = 2;
//        
//        while (parent < count) {
//            if (tree[left] == null && tree[right] == null) {
//                parent = count;
//            }
//            else if(tree[left].compareTo(temp) < 0 && tree[right] == null) {
//                swap(parent, left);
//                parent = left;
//                left = 2*parent + 1;
//            }
//            else if(tree[left].compareTo(temp) < 0 && tree[right].compareTo(tree[left]) > 0) {
//                swap(parent, left);
//                parent = left;
//                left = 2*parent + 1;
//            }
//        }
//    }
    
}
