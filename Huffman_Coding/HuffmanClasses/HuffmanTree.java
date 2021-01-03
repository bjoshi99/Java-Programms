package HuffmanClasses;

import java.util.HashMap;
import java.util.Map;
import coding_decoding.*;
import PriorityQueue_ArrayHeap.PriorityQueue;

/**
 * Class which creates Huffman tree and call the coder. 
 * @author Bhavesh Joshi
 *
 * @param <T>
 */
public class HuffmanTree<T> {
    
    /**
     * Root node of the sub-tree/tree.
     */
    private HuffmanTreeNode<T> myRoot;    
    
    /**
     * int combime priority value.
     */
    private int myCombinePriority;
    
    /**
     * Priority Queue.
     */
    private PriorityQueue<T> myQueue;
    
    /**
     * H_Tree_Node array.
     */
    private HuffmanTreeNode<T>[] ArrayTree;
    
    /**
     * Hash map to store H_Tree_Node, coded each String 
     */
    private Map<HuffmanTreeNode<?>, String> myMap = new HashMap<HuffmanTreeNode<?>, String>();
    
    /**
     * Encoder object.
     */
    private Encoder myEn;
    
    /**
     * String builder for code.
     */
    private StringBuffer sb = new StringBuffer();
    
    /**
     * left and right value of the tree.
     */
    private int left = 0, right = 0;
    
    /**
     * Constructor that gets the input string.
     * @param theS
     */
    public HuffmanTree(final String theS) {
        // TODO Auto-generated constructor stub
//        createTree();
         myEn = new Encoder(theS);
    }
    
    /**
     * Adds the Queue in to classs and calls the create method for the tree..
     * @param theQ
     */
    public void addQ(final PriorityQueue<T> theQ) {
        myQueue = theQ;
//        System.out.println("added the Q");

        removeAndcreate();
    }
     
    /**
     * Keep removes and add till the size of the Queue is less than 2.
     */
    private void removeAndcreate() {
        
        while(myQueue.size() >= 2) {
            
            if(myQueue.size() >= 2) {
                
                HuffmanTreeNode<T> left = myQueue.removeNext();
                HuffmanTreeNode<T> right = myQueue.removeNext();

//                System.out.println("pr : " + left.getPriorityValue());
                
                myCombinePriority = left.getPriorityValue() +
                                    right.getPriorityValue();
                
//                System.out.println("combine "+myCombinePriority);
                
                myRoot = new HuffmanTreeNode<T>(myCombinePriority);
                
                myRoot.setLeftNode(left);
                myRoot.setRightNode(right);
                       

            }

            
            myQueue.addElement(myRoot);
//            inOrderTraversal(myRoot);
            left = 0;
            right = 0;

        }
                
//        System.out.println("The root " + myRoot.getPriorityValue());
    
        traversalForCode(myRoot, "");
        
                
        myEn.addRootOfHTN(myQueue.removeElement());
        myEn.createCode(myMap);
       
    }
    
    /**
     * Return the size of whole coded string.
     * @return
     */
    public int getSizeOfEncodedMsg() {
        return myEn.getSizeOfCodedMsg();
    }
    
    /**
     * Return the string of whole encoded string.
     * @return
     */
    public String getEncodedMsg() {
        return myEn.getEncodedMsg();
    }
      
    /**
     * Returns the whole decode string.
     * @return
     */
    public String getDecodeMsg() {
        return myEn.getDecodedMsg();
    }
    
    /**
     * Returns the hash map with H_Tree_node and string each code.
     * @return
     */
    public Map<HuffmanTreeNode<?>, String> getMap(){
        return myMap;
    }
    
    /**
     * Post order traversal to create code for each node.
     * @param theNode
     * @param theCode
     */
    public void traversalForCode(HuffmanTreeNode<T> theNode, String theCode) {
        
        if(theNode.getLeftNode() != null && theNode.getRightNode() != null) {
            
            traversalForCode(theNode.getLeftNode(), theCode + "0");
            traversalForCode(theNode.getRightNode(), theCode + "1");
        } else {
//            System.out.println("char "+theNode.getElement()
//                    + " code " + theCode + " pr " + theNode.getPriorityValue());
            myMap.put(theNode, theCode);
            sb.append(theCode);
        }
        
    }

//    
//    private void inOrderTraversal(HuffmanTreeNode<T> theNode) {
//        
//        if(theNode == null) {
//            return;
//        }
//
//        System.out.println("Priority of check "+theNode.getPriorityValue());        
////        
//        sb.append("0");
//        System.out.println("Going left");
////        if(left == 0) {
////            System.out.println("Going left");
////            left++;
////        }
//        inOrderTraversal(theNode.getLeftNode());
//        
//        
//        sb.append("1");
//        System.out.println("Going right");
////        if(right == 0) {
////            System.out.println("Going right");
////            right++;
////        }
//        inOrderTraversal(theNode.getRightNode());
//        
//        if(theNode.getLeftNode() == null && theNode.getRightNode() == null) {
//            String Huffman = sb.toString();
//            System.out.println("The char "+theNode.getElement()+" freq "+theNode.getPriorityValue());
//            System.out.println(Huffman);
//            sb = new StringBuffer();
//            System.out.println("Leaf node: ");
////            System.out.println("Priority value of traversal node : " + theNode.getPriorityValue()
////            + " the charcter is : " + theNode.getElement());
//            return;
//        }
        
//    }
}
