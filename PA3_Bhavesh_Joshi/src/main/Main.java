/*  
    Result of output.txt
    My hash function is better because it has less number of collision than 
    Java's api hashCode() method. 
    By Java's hashCode() method I got 1600 collisions.
    By my own method I got 1494 collisions. 
    
    As java's HashCode method has O(log2n) and my method has less collision than 
    its, so mine is better than log2n.
*/

package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import HashTableClasses.HashTableClass;

/**
 * Main class to read file for strings.
 * @author Bhavesh Joshi
 * @version Spring 2020.
 */
public class Main {

    //By doing try and error. I found the sweet spot with least collisions.
    //199967 is the prime and nearest to 200,000.
   private static HashTableClass obj = new HashTableClass(199967);
    
    public static void main(String[] args) {

        String Dictionary = "words";
//        String Dictionary = "Sample1";
        
        String input_File = "input";
//        String input_File = "Sample1";

                
        try {
            Scanner sc = new Scanner(new File(Dictionary));

            while(sc.hasNext()) {
                
                String value = sc.next();
                
//                Pattern p = Pattern.compile("[@_!#$%^&*()<>?/\\|}{~:]");
//                Matcher m = p.matcher(value);
//                
//                boolean b = m.find();
                                
                if(value.contains(".") || value.contains(",") || value.contains(";")
                        || value.contains("'") || value.contains("!")) {
                    continue;
                }
                
                char[] arr = value.toLowerCase().toCharArray();
                
                Arrays.sort(arr);
                String key = new String(arr);
                
//                System.out.println("Key " + key + " Value " + value);
                
                obj.put(key, value);
            }
            
            sc.close();  
            
            System.out.println("Check file 'outPut_With_Anagram_Of_Dictionary_words.txt' for output." + "\n"
                                + "And 'output_of_inputtxt_file.txt' for output of your input.txt file" + "\n");
            obj.print();
            
            readingInputFile(input_File);
            
//            String ff = obj.getValue(new String("golf".toLowerCase().toCharArray()));
//            System.out.println(ff);
            
        } catch(IOException theE) {
            
            System.out.println("File is not found.");
            theE.printStackTrace();
        }

    }
    
    public static void readingInputFile(String theFile) {
        
        try {
            Scanner sc2 = new Scanner(new File(theFile));
            FileWriter writer = new FileWriter("output_of_inputtxt_file.txt");

            while(sc2.hasNext()) {
                
                String str = sc2.next();
                char[] cc = str.toLowerCase().toCharArray();
                Arrays.sort(cc);
                String ss = new String(cc);
                
                String[] anag = obj.getValue(ss);
                
                if(anag == null) {
                    
                    writer.write(str + " 0" + "\n");
                    
                } else {
                    
                    writer.write(str + " " + anag.length);
                    
                    for(int i = 0; i < anag.length; i++) {
                        
                        writer.write(" " + anag[i]);
                    }
                    
                    writer.write("\n");
                }
                
            }
            writer.close();
            sc2.close();

        } catch(IOException theE) {
            System.out.println("File not found.");
//            theE.printStackTrace();
        }
    }
    
//    private static int SizeOfFile(String TheFile) {
//        
//        try {
//            Scanner sc = new Scanner(new File(TheFile));
//            int size = 0;
//            
//            while(sc.hasNext()) {
//                String vv = sc.next();
//                size++;
//            }
//            
//            sc.close();
//            
//            return size;
//            
//        } catch(IOException theE) {
//            System.out.println("File is not found.");
//            theE.printStackTrace();
//        }
//        return 0;
//    }
    
}
