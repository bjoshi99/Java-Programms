package coding_decoding;

import HuffmanClasses.HuffmanTreeNode;

/**
 * Class to decode the encode string.
 * @author Bhavesh Joshi.
 *
 */
public class Decoder {
    
    //Root node.
    private HuffmanTreeNode<?> myNode;

    //Encoded string.
    private String myEncodedString;
    
    //String builder for decode string
    private StringBuilder myDecodedString = new StringBuilder();
    
    /**
     * Constructor with root node and encoded string.
     * @param theCode
     * @param theT
     */
    public Decoder(final String theCode, 
            final HuffmanTreeNode<?> theT) {
        myNode = theT;
        myEncodedString = theCode;
        Decode();
    }
    
    /**
     * Method to decode the string.
     */
    private void Decode() {
        
        int length = myEncodedString.length();
        HuffmanTreeNode<?> node = myNode;
        
        for(int i = 0; i <= length; i++) {
            
            if(isLeaf(node)) {
                myDecodedString.append(node.getElement());
                node = myNode;
                
                if(i==length) {
                    break;
                }
                
                i--;
            }
                       
            else if(myEncodedString.charAt(i) == '1') {
                node = node.getRightNode();
            }
            else if(myEncodedString.charAt(i) == '0') {
                node = node.getLeftNode();
            }
            
        }
        
//        System.out.println("Printing decoded string :");
//        System.out.println(myDecodedString.toString());
        
    }
      
    /**
     * checks if the node is leaf or not.
     * @param theN
     * @return
     */
    private boolean isLeaf(final HuffmanTreeNode<?> theN) {
        if(theN.getLeftNode() == null && theN.getRightNode() == null) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns the decoded string.
     * @return
     */
    public String getDecodedMsg() {
        return myDecodedString.toString();
    }
    
}
