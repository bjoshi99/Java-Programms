//TCSS 342 B -PA 1

package link_node;

import java.io.IOException;
import sorting.Shell_Sort;

/**
 * Linked list class to add node in list.
 * @author Bhavesh Joshi
 * @version Spring 2020
 */
public class LinkedList {
    
    /** Private node for head of list */
    private LinkedNode<Integer> head;
    
    /** Private int variable for total number of size. */
    private int count;
    
    /** Constructor with no parameter.*/
    public LinkedList() {
        head = null;
        count = 0;
    }

    /** Method to search the key element in list.
     *  returns -1 is theKey is not in list.
     * 
     * @param theKey int key to search in list.
     */
    public int seach(int theKey) {
        
        LinkedNode<Integer> current = head;
        int index = 1;
        
        while (current != null) {
            if(current.data == theKey) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    /**
     * Method to add at front.
     * Which is head. 
     * @param theElement int element to add. 
     */
    public void addAtFront(final int theElement) {
        if(head == null) {
            head = new LinkedNode<Integer>(theElement);
            count++;
        }
        else {
            LinkedNode<Integer> temp = new LinkedNode<Integer>(theElement);
            temp.next = head.next;
            temp.next = head;
            head = temp;
            count++;
        }
    }
        
    /**
     * Method to add at the end of the list.
     * @param theElement the int element to add at end.
     * @throws Exception Runtime.
     */
    public void addAtEnd(final int theElement) throws Exception {

//        head.setNext(new LinkedNode<Integer>(theElement));
        if(head == null) {
            addAtFront(theElement);
        } else {
            addAtIndex(count, theElement);
        }
        
    }
    
    /**
     * Method to insert element at particular index. 
     * @param theIndex int location for element to insert.
     * @param theElement int element to be inserted.
     * @throws IOException Throws io exception if location is larger than size.
     */
    public void addAtIndex(final int theIndex, 
            final int theElement) throws IOException {
        
        //Checking for overflow.
        //if it is null then we can not add to purticular index. 
        if(head == null) {
            throw new IOException("LinkedList is null, you can not add");
        }
        
        //Checking for array index out of bound.
        if(theIndex > count) {
            throw new ArrayIndexOutOfBoundsException("Your index is larger then LinkedList size");
        }
        
        //If both above fails then it will be added to destination index.
        LinkedNode<Integer> node = head;
        for(int i = 0; i < theIndex - 1; i++) { //Iteration till index-1 location.
            node = node.next;
        }
        LinkedNode<Integer> temp = new LinkedNode<Integer>(theElement);
        temp.next = node.next;
        node.next = temp;
        
        count++;
    }
    
    /**
     * Method to delete from the front.
     * @return the linkedNode that deleted.
     * @throws Exception if the list is null. 
     */
    public LinkedNode<Integer> deleteAtFront() throws Exception{
        
      //Checking for overflow.
        //if it is null then we can not delete. 
        if(head == null) {
            throw new IOException("LinkedList is null, you can not add");
        }
        
        LinkedNode<Integer> deleted = new LinkedNode<Integer>();
        deleted = head;
        head = head.next;
        count--;
        
        return deleted;
    }
    
    /**
     * Method which calls the shell sort to class for sorting. 
     * To implement shell sort algorithm.
     */
    public void sort() {
        Shell_Sort sh = new Shell_Sort(head);
        head = sh.shellSort(head);
    }

    /**
     * Prints all the element fromt the list. 
     */
    public void print() {
        
//          int size = 0;
          LinkedNode<Integer> n = head;
          System.out.println("In list class");
          int i=0;
          while(n.next != null) {
              i++;
              System.out.print(n.data + " ");
              if(i%100 == 0) {
                  System.out.println("\n");
              }
              n = n.next;
          }
          System.out.println(n.data);
          i++;
          System.out.println("total size of list "+i);
    }
    
   
   //End of the Linked list class.  
}


//public void bbbubub() {
//    Bubble_Sort bb = new Bubble_Sort();
//  head = bb.sort(head);
//  System.out.println("head data + "+ head.data);
//}

            //Second way to sort element for bubble sort.

//public void sorting() {
//    
//    if (count > 1) {
//        
//        boolean sorted = false;
//        System.out.println("count " + count);
//        for (int i = 0; i < count && !sorted; i++) {
//            
//            System.out.println("count " + count);
//            System.out.println("sorted + "+sorted);
//
////            if (!sorted) {
//                
//                sorted = true;
//                LinkedNode<Integer> current = head;
//                LinkedNode<Integer> next = current.next;
//                int countttt = 0;
//                
//                for (int j = 1; j < count-i; i++) {
//                    System.out.println("Head " + head.data);
//
//                    if (next != null && current != null && current.data > next.data) {
//                        System.out.println("Next data " + next.data);
//                        countttt++;
//                        LinkedNode<Integer> temp = current;
//                        current = next;
//                        next = temp;
//                        if (countttt == 1) {
//                            head = current;
//                            System.out.println("1;;; + "+head.data);
//                        }
//
//                        current = next.next;
//                        next = current;
////                        current = next;
////                        next = next.next;
////                        current = current.next;
//                        sorted = false;
//                        
//                    } else {
//                        
//                        current.setNext(next.next);
//                        next = current;
////                        current = next;
//                        
////                        LinkedNode<Integer> temp = next.next;
////                        current = next;
////                        next = temp;
//                        
//                    }
//                }
////            }
//        }
//        
//    }
//    
//}
