//PA_2 
package coding_decoding;

import java.util.Map;
import HuffmanClasses.HuffmanTreeNode;

/**
 * A class to encode the tree.
 * @author Bhavesh Joshi
 * @version Spring 2020.
 */
public class Encoder {

    //Input string.
    private String myInputString;
    
    //String builder.
    private StringBuilder mySb;
    
    //Final root node of the tree.
    private HuffmanTreeNode<?> myRootOfTree;
    
    //Decoder object.
    private Decoder myDC;
    
    /**
     * Constructor with input string.
     * @param theInput
     */
    public Encoder(final String theInput) {
        
        myInputString = theInput;
        mySb = new StringBuilder();
    }
    
    /**
     * Adds final root to the class.
     * @param <T>
     * @param theT
     */
    public <T> void addRootOfHTN(final HuffmanTreeNode<?> theT) {
        myRootOfTree = theT;
    }
    
    /**
     * Create the code based on the provide hashMap (H_tree_Node, string_code)
     * @param theMap
     */
    public void createCode(final Map<HuffmanTreeNode<?>, String> theMap) {
        
//        System.out.println("the string  ::: " + myInputString);
        
        char[] Chararray = myInputString.toCharArray();
        
        for(char c: Chararray) {
            Encoding(theMap, c);
        }
        
//        System.out.println(mySb.toString());
//        System.out.println("size : "+mySb.toString().length());
        
        myDC = new Decoder(mySb.toString(), myRootOfTree);
    }
    
    /**
     * returns whole encoded string code,
     * @return
     */
    public String getEncodedMsg() {
        return mySb.toString();
    }
    
    /**
     * returns the size of the encoded string.
     * @return
     */
    public int getSizeOfCodedMsg() {
        return mySb.length();
    }
       
    /**
     * Returns the decode string.
     * @return
     */
    public String getDecodedMsg() {
        return myDC.getDecodedMsg();
    }
    
    /**
     * Encodes the string.
     * @param theMap
     * @param theC
     */
    private void Encoding(final Map<HuffmanTreeNode<?>, String> theMap, final char theC) {
        
        for (Map.Entry<HuffmanTreeNode<?>, String> it : theMap.entrySet()) {
            
            if(it.getKey().getElement() == theC) {
                mySb.append(it.getValue());
                break;
            }
            
        }
        
    }
    
}
