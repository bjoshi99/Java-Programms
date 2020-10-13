//TCSS 342B - TA1

package sorting;

import link_node.LinkedNode;

/**
 * Shell sort for shell sort algorithm. 
 * @author Bhavesh Joshi
 * @version Spring 2020.
 */
public class Shell_Sort {
    
    /** Head node of the list.*/
    LinkedNode<Integer> myFirst;
    
    /** int variable for size of the list. */
    private int mySize = 1;

    /**
     * Constructor to assign the head the list. 
     * @param theFirst the head of the list to be sorted. 
     */
    public Shell_Sort(LinkedNode<Integer> theFirst) {
        myFirst = theFirst;
    }
    
    /**
     * Method to short the list using algorithm. 
     * @param theFirst the head of the list to arrange. 
     * @return returns head of shellsorted list. 
     */
    public LinkedNode<Integer> shellSort(LinkedNode<Integer> theFirst){
        
        myFirst = theFirst;
        LinkedNode<Integer> curr = myFirst;
        int exchange = 0;
        int cmp = 0;
        int pass = 0;
        
        //finding the size.
        while(curr.next != null) {
            mySize++;
            curr = curr.next;
        }
        
        int gap = gapSize(mySize);
        System.out.println("gap "+gap);

        //execute the until gap > 1.
        while(gap > 1) {
         
            int i = 0;
            pass++;
            exchange = 0;
            cmp = 0;
                        
            //Second way with previous to be null
            LinkedNode<Integer> current = myFirst;
            LinkedNode<Integer> next = myFirst;
            LinkedNode<Integer> nPre = null;
            LinkedNode<Integer> cPre = null;
            
          //Iterating till the gapth element.
            //condition that i had it before.
            //&& i + gap <= mySize
            while(i <= gap - 1 ) {
                nPre = next;
                next = next.next;
                i++;                   
            }
            
            LinkedNode<Integer> gapNode = next;
            LinkedNode<Integer> gapPreNode = nPre;
            
            
            int distance = 0;
            
            //If first one than next.next.next != null
            while(next != null) {
                
                cmp++;
                //if first then next.data < cPre.data
                if(next.data < current.data) {
                                        
                    //Second way
                    if(cPre == null) {
                        
                        LinkedNode<Integer> temp = next.next;
                        
                        myFirst = next;
                        next.next = current.next;
                        current.next = temp;
                        nPre.next = current;
                        
                        cPre = myFirst;
                        
                        LinkedNode<Integer> tp = next;
                        next = current;
                        current = tp;
                    }
                    
                    
                    else {

                        LinkedNode<Integer> temp = next.next;
                        cPre.next = next;
                        next.next = current.next;
                        nPre.next = current;
                        current.next = temp;
                        
                        LinkedNode<Integer> tp = next;
                        next = current;
                        current = tp;
                    }
                    
                    exchange++;                
                    
                }
                
                if(distance == gap) {
                    gapNode = current;
                    gapPreNode = cPre;

                }
                
                if (distance == 0) {
                    cPre = current;
                } else {
                    cPre = cPre.next;

                }
                if(next.next == null) {
                    next = null;
                } else {
                    next = next.next;
                    nPre = nPre.next;
                    current = current.next;
                }
                
                distance++;
                                
               if (next == null) {

                    if(gapNode.data < myFirst.data) {
                        
                        System.out.println("In gap condition");
                        
                        LinkedNode<Integer> temp = gapNode.next;
                        gapNode.next = myFirst.next;

                        gapPreNode.next = myFirst;
                        myFirst.next = temp;

                        myFirst = gapNode;                        
                        
                    }
                }
                          
            System.out.println("Exchange: "+exchange+
                                " for gap "+gap+" and "+
                                "Comparison: "+cmp+" pass "+pass);
            
            pass = 0;
            
            //Changing the gap size. 
            gap = gapSize(gap);
       System.out.println("Going in bubble");
       
       //Going for bubble sort cause gap = 1.
        myFirst = new Bubble_Sort().sort(myFirst);
        
        return myFirst;
    }
    
    /**
     * Method to assign gap size. 
     * @param theIndex gap needs to be less then theIndex value.  
     * @return the updated gap size.
     */
    private int gapSize(final int theIndex) {
        
        int index = 1;

        int gp = 0;
        while((int) ((Math.pow(3, index) - 1)/2) < theIndex) {            
            gp = (int) ((Math.pow(3, index) - 1)/2);   

            index++;
        }
        return gp;
    }
    
    /**
     * Method to print all element from the list. 
     */
    public void print() {
        LinkedNode<Integer> n = myFirst;
        while(n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println(n.data);

    }
    
    //END of the Shell sort class. 

}
