package Main;

import HuffmanClasses.HuffmanFrequencyTable;

/**
 * Tester class with main method to call frequency table to pass the input string.
 * @author Bhavesh Joshi.
 * @version Spring 2020.
 */
public class Tester {

    public static void main(String[] args) {
           
        new HuffmanFrequencyTable("Eerie eyes seen near lake.");
//        new HuffmanFrequencyTable("abc abc abc");
        
        System.out.println();
        new HuffmanFrequencyTable("eeyjjjj");
        
        System.out.println();
        new HuffmanFrequencyTable("Hello this is the huffan tree codig which will compress the number of bits in your"
                + " given string. This is the implementation of PQ, array heap.");
//        System.out.println();
//        new HuffmanFrequencyTable("yyufuufufu");
        

    }

}
