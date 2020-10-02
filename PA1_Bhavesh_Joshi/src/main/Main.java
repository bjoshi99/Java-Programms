//TCSS 342B - PA 1

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The main class with main, readValues and display values method..
 * @author Bhavesh Joshi
 * @version Spring 2020
 */
public class Main {
    
    private static link_node.LinkedList list = new link_node.LinkedList();

    /**
     * The main method 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
            
        long startTime = System.currentTimeMillis();
        
        readValue("inorder100.txt");
              
        list.sort();
        
        displayList();        
        
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: "+totalTime+" millisecond");
    }
    
    /**
     * Static method to read value of file and store into linkedlist.
     * @param theFile take string file name as an input.
     * @throws Exception throws exception if file can not be found. 
     */
    private static void readValue(final String theFile) throws FileNotFoundException {
        
        Scanner fileread = new Scanner(
                new File(theFile));
        
        while(fileread.hasNextInt()) {
            try {
                list.addAtEnd(fileread.nextInt());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        fileread.close();
    }
    
    /**
     * Static method to display the values from linked list.
     */
    private static void displayList() {
        list.print();
    }
    
    //END of main class. 
}
