//TCSS 342 B -PA 1

package List;

import java.io.IOException;

/**
 * Linked list class to add node in list.
 * @author Bhavesh Joshi
 * @version Spring 2020
 */
public class Linkedlist {
    
    /** Private node for head of list */
    private LinkedNode<Character> head;
    
    /** Private int variable for total number of size. */
    private int count;
    
    /** Constructor with no parameter.*/
    public Linkedlist() {
        head = null;
        count = 0;
    }
    
    public int size() {
        return count;
    }

    /** Method to search the key element in list.
     *  returns -1 is theKey is not in list.
     * 
     * @param theKey int key to search in list.
     */
    public int seach(int theKey) {
        
        LinkedNode<Character> current = head;
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
    public void addAtFront(final char theElement) {
        if(head == null) {
            head = new LinkedNode<Character>(theElement);
            count++;
        }
        else {
            LinkedNode<Character> temp = new LinkedNode<Character>(theElement);
            temp.next = head.next;
            temp.next = head;
            head = temp;
            count++;
        }
    }
    
    public LinkedNode<Character> get(final int theIndex) {
        
        LinkedNode<Character> travel = head;
        
        for(int i = 1; i <= theIndex; i++) {
            travel = travel.next;
        }
        
        return travel;
    }
        
    /**
     * Method to add at the end of the list.
     * @param theElement the int element to add at end.
     * @throws Exception Runtime.
     */
    public void addAtEnd(final char theElement) {

//        head.setNext(new LinkedNode<Integer>(theElement));
        try {
            if(head == null) {
                addAtFront(theElement);
            } else {
                addAtIndex(count, theElement);
            }
        } catch(final Exception theE) {
            System.out.println("");
        }
  
        
    }
    
    /**
     * Method to insert element at particular index. 
     * @param theIndex int location for element to insert.
     * @param theElement int element to be inserted.
     * @throws IOException Throws io exception if location is larger than size.
     */
    public void addAtIndex(final int theIndex, 
            final char theElement) {
        try {
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
            LinkedNode<Character> node = head;
            for(int i = 0; i < theIndex - 1; i++) { //Iteration till index-1 location.
                node = node.next;
            }
            LinkedNode<Character> temp = new LinkedNode<Character>(theElement);
            temp.next = node.next;
            node.next = temp;
            
            count++;
        } catch(final Exception theE) {
            System.out.println("Index is larger than actual size of list.");
        }
    }
    
    /**
     * Method to delete from the front.
     * @return the linkedNode that deleted.
     * @throws Exception if the list is null. 
     */
    public LinkedNode<Character> deleteAtFront() throws Exception{
        
      //Checking for overflow.
        //if it is null then we can not delete. 
        if(head == null) {
            throw new IOException("LinkedList is null, you can not add");
        }
        
        LinkedNode<Character> deleted = new LinkedNode<Character>();
        deleted = head;
        head = head.next;
        count--;
        
        return deleted;
    }
    
    public void deleteAtIndex(final int theI, final char theChar) {
        try {
            int index = seach(theChar);
            LinkedNode<Character> trvel = head;
            if(theI == 0) {
                head = trvel.next;
                count--;
            } else {
                for(int i = 1; i < theI; i++) {
                    trvel = trvel.next;
                }
                trvel.next = trvel.next.next;
                count--;
            }
            
            
        } catch(final Exception theE) {
            System.out.println("List is already empty.");
        }
    }
    

    /**
     * Prints all the element fromt the list. 
     */
    public void print() {
        
//          int size = 0;
          LinkedNode<Character> n = head;
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
