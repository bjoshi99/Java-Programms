//TCSS 342B - PA 1

package sorting;

import link_node.LinkedNode;

/**
 * Bubble sort class to bubble sort algorithm. 
 * @author Bhavesh Joshi
 * @version Spring 2020
 */
public class Bubble_Sort {

    /** Head node for list to sort. */
    private LinkedNode<Integer> myHead;
    
    /** private int for count.*/
    private int myCount = 0;
    
    /**
     * Empty Constructor. 
     */
    public Bubble_Sort() {
    }
    
    /**
     * A method to sort list for bubble sort. 
     * @param theFirst the head node of the list.
     * @return returns the head node of the updated list. 
     */
    public LinkedNode<Integer> sort(final LinkedNode<Integer> theFirst) {
        
        myHead = theFirst;

        int count = 0;
        LinkedNode<Integer> start = myHead;
        
        //Counting the size of the list. 
        while(start.next != null) {
            start = start.next;
            count++;
        }
                
        //Flag to see if the list is sorted or not. 
        boolean sorted = false;
        
        int counter = 0;
        int comp = 0;
        
        int pass = 0;
        
        //Outer for loop. 
        for (int i = 0; i < count && !sorted ; i++) {
           
           LinkedNode<Integer> current = myHead;
           LinkedNode<Integer> trail = myHead;
                      
           sorted = true;

           pass++;
           int j = 0;
                     
           //Inner for loop. 
           while(current.next != null && j < count - i ) {

               j++;
               comp++;

               if(current.data > current.next.data) {
                   
                       counter++;
                       LinkedNode<Integer> temp = current.next;
                       current.next = current.next.next;
                       temp.next = current;
                       
                       if(current == myHead) {
                           myHead = temp;
                           trail = temp;
                       } else {
                           trail.next = temp;
                           current = temp;
                       }
                       sorted = false;
               }
               
               trail = current;
               current = current.next;
                           
           }
           
        }
       
       //Printing the number of exchanges and comparisons. 
       System.out.println("exc " + counter);
       System.out.println("comp " + comp);

       System.out.println("pass "+pass);
       
       return myHead;
    }
    
    /**
     * The print method to display all elements in list.  
     */
    public void print() {
        LinkedNode<Integer> n = myHead;

        while(n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println(n.data);

    }
    
    //END of the Bubble sort class. 
  
}

    //ANOTHER WAY TO USE BUBBLE SORT FOR LINKED LIST.

//public void sort() {
//    
//    if (myCount > 1) {
//        boolean sorted;
//
//        do {
//            LinkedNode<Integer> current = myHead;
//            LinkedNode<Integer> previous = null;
//            LinkedNode<Integer> next = myHead.next;
//            sorted = false;
//
//            while ( next != null ) {
//                if (current.data > next.data) {
//                    /*
//                    // This is just a literal translation
//                    // of bubble sort in an array
//                    Node temp = currentNode;
//                    currentNode = next;
//                    next = temp;*/
//                    sorted = true;
//
//                    if ( previous != null ) {
//                        LinkedNode<Integer> temp = next.next;
//
//                        previous.next = next;
//                        next.next = current;
//                        current.next = temp;
//                    } else {
//                        LinkedNode<Integer> temp = next.next;
//
//                        myHead = next;
//                        next.next = current;
//                        current.next = temp;
//                    }
//
//                    previous = next;
//                    next = current.next;
//                } else { 
//                    previous = current;
//                    current = next;
//                    next = next.next;
//                }
//            } 
//        } while( sorted );
//    }
//    }
//
//}
