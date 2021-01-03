package HuffmanClasses;

import List.Linkedlist;
import PriorityQueue_ArrayHeap.PriorityQueue;
import coding_decoding.Decoder;
import coding_decoding.Encoder;

import java.util.Map;

public class HuffmanFrequencyTable {
    
    /**
     * The string that needs to split for frequency table.
     */
    private String myString;
    
    /**
     * Huffman Tree to create encode and decode.
     */
    private HuffmanTree<HuffmanTreeNode<?>> HT;
    
    /**
     * Character array which stores the character as per appear in input.
     */
    private char[] arr;
    
    /**
     * String builder to check occurance of character.
     */
    private StringBuilder sb = new StringBuilder();
    
    //Object of encoded class.
    private Encoder myEn;

    /**
     * Constructor takes the input string all calls Huffman tree node.
     * @param theString
     */
    public HuffmanFrequencyTable(final String theString) {
                
            try {
                theString.split("");
            } catch(final NullPointerException theE) {
                System.out.println("String is empty.");
                System.exit(0);
            } catch(final NumberFormatException theEE) {
                System.out.println("Number format exception.");
                System.exit(0);
            }
    
        myString = theString;
        
        System.out.println("Input string is : " + myString);
        
//        myEn = new Encoder(myString);

        convertingInto();

    }
    
    private void convertingInto() {
        
        int freq = 0;
        
        arr = myString.toCharArray();
        
        Linkedlist ll = new Linkedlist();
        
        
        for(char c: arr) {
            ll.addAtEnd(c);
        }

        
        PriorityQueue<HuffmanTreeNode<?>> PrQueue = new PriorityQueue<HuffmanTreeNode<?>>(myString.length());
        
        for(int i = 0; !(ll.size()==0);) {
            freq = 0;
//            char charr = Arrtolist.get(i);
//            System.out.println("i "+i);           
//            System.out.println("value is list "+ll.get(i));
            
            char charr = ll.get(i).data;
            ll.deleteAtIndex(i, charr);
            freq++;

            for(int j = 0; !(ll.get(j) == null); j++) {

                 if(ll.get(j).data == charr) {

                     freq++;
                     ll.deleteAtIndex(j, charr);
                     j--;
                 }
             }
            
            PrQueue.addElement(new HuffmanTreeNode(charr, freq));
            
        }

        HT = new HuffmanTree<HuffmanTreeNode<?>>(myString);
        HT.addQ(PrQueue);
        
        prrrntt();
    }
    
    
    private void prrrntt() {
        
        System.out.println("--------------------------------------------------- ");
        System.out.println("Character \t" + "Frequency" + "\t Code");
        System.out.println("--------------------------------------------------- ");
              
        for(int c = 0; c < arr.length; c++) {
            
            for(Map.Entry<HuffmanTreeNode<?>, String> it : HT.getMap().entrySet()) {
                
                if (arr[c] == it.getKey().getElement() && (sb.toString().indexOf(arr[c]) == -1) ) {
                    
                    System.out.println("   " + it.getKey().getElement() + "\t \t    " 
                            + it.getKey().getPriorityValue() + "\t \t"
                            + it.getValue());
                    
                    sb.append(arr[c]);
                }
                
            }
        }
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("Encoded bit Stream: \n" + HT.getEncodedMsg());
        System.out.println();
        
        System.out.println("Total number of bits without Huffman coding (8-bits per character)");
        System.out.println(myString.length()*8);
        
        
        System.out.println("\nTotal number of bits after Huffman Coding: \n" + HT.getSizeOfEncodedMsg());
        
        System.out.println("\nCompression Ration: (Origianl_bit) / (Huffman_bit) : 1");
        System.out.println((double)(myString.length()*8) / (HT.getSizeOfEncodedMsg()) + " : 1");
        
        System.out.println("\nDecode String: "  + HT.getDecodeMsg());
    }
    
}
