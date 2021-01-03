package HashTableClasses;

/**
 * Anagram node class.
 * @author Bhavesh Joshi.
 *
 */
public class Anagram {
    
    /** Sorted key of value string. */
    String myKey;
    
    /** Value of node. */
    String myValue;
    
    /** Next node.*/
    Anagram next;
    
    /**
     * Constructor.
     * @param theKey sorted key.
     * @param theValue value of the key.
     */
    public Anagram(final String theKey, final String theValue) {
        
        myKey = theKey;
        myValue = theValue;
    }
    
    /**
     * Gives the number of node associated with current node.
     * @return int count.
     */
    public int count() {
        int nodes = 1;
        Anagram temp = this;
        while(temp.next != null) {
            nodes++;
            temp = temp.next;
        }
//        nodes++;
        return nodes;
    }

}
