package HashTableClasses;
//TCSS - 342

import java.io.FileWriter;
import java.io.IOException;

/**
 * Hash Table class.
 * @author Bhavesh
 * @version Spring 2020.
 */
public class HashTableClass {
    
    double Load_Factor;
    private int myTableSize;
    private Anagram[] myHashTable;
    private int element;
    private int NoOfCollision;
    
    /**
     * 
     * @param theSize size of the table.
     */
    public HashTableClass(final int theSize) {
        
//        FindTheSize(theSize);
        
        //This is found by try and error. 
        //It has least collision. 
        myTableSize = 199967;
        myHashTable = new Anagram[myTableSize];
    }
    
    /**
     * For size.
     * @return the number of element present in the table.
     */
    public int size() {
        return element;
    }
    
    /**
     * Checks if the table is empty or not.
     * @return
     */
    public boolean isEmpty() {
        return (element == 0);
    }
    
    /**
     * Insert element in table.
     * @param theKey sorted key.
     * @param theValue the original value.
     */
    public void put(final String theKey, final String theValue) {
               
        int p =1;
        boolean flag = false;
        Anagram theAnagramNode = new Anagram(theKey, theValue);
        
        int New_Key = hashingFunction(theAnagramNode.myKey);
        
        //Java's hash function:
//        int New_Key = hashMethodOfJavas(theKey);
        
        int original = New_Key;
        
//        System.out.println("Hash Key : " + New_Key);
//        System.out.println("value " + theValue);

        do {
            
            if(myHashTable[New_Key] == null) {
                
                myHashTable[New_Key] = theAnagramNode;
                flag = true;
                break;
            }
            

            else if(myHashTable[New_Key].myKey.equals(theAnagramNode.myKey)) {
                
                theAnagramNode.next = myHashTable[New_Key];
                myHashTable[New_Key] = theAnagramNode;
                
//                myHashTable[New_Key].next = temp;
                
//                Anagram start = theAnagramNode;
//                while(start.next != null) {
//                    System.out.print(start.myValue + " ");
//                    start = start.next;
//                }
//                System.out.println(start.myValue);
                
                flag = true;

                break;
            }
            else if(!(myHashTable[New_Key].myKey.equals(theAnagramNode.myKey))) {
                
                New_Key = (original + (p*p)) % myTableSize;
                                              
                if(p == 1) {
                    NoOfCollision++;
                }
                p++;
                
            }
            
        } while(!flag);
        
        element++;
        Load_Factor = (double) element/myTableSize;
    }
    
    /**
     * Finds the value.
     * @param thekey the string
     */
    public String[] getValue(final String thekey) {
                
        int position = hashingFunction(thekey);
        
        //Java's hash function
//        int position = hashMethodOfJavas(thekey);
                
        int original = position;
        
        int i = 0;
        boolean flag = false;
        int p = 1;
        
        while(true) {
            
//          FileWriter writer = new FileWriter("output111.txt");
            
//        if((i == myTableSize && !flag) || position >= myTableSize) {
          if(!flag && position >= myTableSize) {
              
              return null;
//              writer.write(thekey + " 0");
//              break;
          }
          
//          System.out.println("pos " + position);
          Anagram start = myHashTable[position];    
          
          if(start != null && start.myKey.equals(thekey)) {

              flag = true;
              String value[] = new String[start.count()];
              value[i] = start.myValue;
              
//              writer.write(thekey + " " + start.count() + " " + start.myValue);
              
              while(start.next != null) {
                  
                  i++;
                  start = start.next;
                  value[i] = start.myValue;
//                  writer.write(" " + start.myValue);
              }
              
              return value;
//              break;
          }
          else {
              position = original + (p*p);
              p++;
              i++;
          }
         
        }      
       

    }
    
    /**
     * Prints the whole table with anagram in the outPut file.
     */
    public void print() {
        
        try {
            FileWriter writer = new FileWriter("outPut_With_Anagram_Of_Dictionary_words.txt");
            
            System.out.println("Number of collisions (by my hashing method): " + NoOfCollision);
            System.out.println("Number of collisions (by Java's hashing method): " + 1600);

//            System.out.println("LF : " + Load_Factor);

//            writer.write("Table size : " + myTableSize + "\n");
            writer.write("Number of collisions (by my hashing method) : " + NoOfCollision + "\n");
            writer.write("Number of words (after excluding string with punctuation): " + element + "\n");

            System.out.println("Number of words placed (after excluding string with punctuation): " + element + "\n");

            for(int i = 0; i < myTableSize; i++) {
                
                if(myHashTable[i] == null) {
                    continue;
                }

                Anagram start = myHashTable[i];
                writer.write(start.myValue +" " + (start.count() - 1) + " ");

                while(start.next != null) {
                    start = start.next;
                    writer.write(start.myValue + " ");
                }
                writer.write("\n");
            }
            
            writer.close();
            
        } catch(IOException theE) {
            System.out.println("File is already there.");
            theE.printStackTrace();
        }
        
    }
    
    /**
     * A method which implements java's hashCode method.
     * @param theK string to find hashcode.
     * @return hashcode of the string;
     */
    public int hashMethodOfJavas(final String theK) {
        
        return (Math.abs(theK.hashCode()) % myTableSize);
    }
    
    /**
     * A hash function to find the hash key of the string.
     * Implements Quadratic probing for collision.
     * 
     * This is better because it has less number of collision than 
     * Java's api hashCode() method. 
     * By that method I got 1600 collisions.
     * By my own method I got 1494 collisions. 
     * 
     * @param theK String to find the hashcode.
     * @return the int hash code of that string.
     */
    private int hashingFunction(final String theK) {
                
        int length = theK.length();
        int sum = 0;
                
        for(int i = 0; i < length; i++) {
            
            sum = (sum << 5) | (sum >>> 27);
            sum = sum + (int) theK.charAt(i);
        }
        
        sum = sum * length + theK.charAt(length/2) - theK.charAt(length - 1);
                
        if(sum < 0) {
            sum = sum + myTableSize;
        }
                  
        sum = Math.abs(sum) % myTableSize;

        return sum;

    }
    
    /**
     * Determine the size for our hash table. 
     * @param theS
     */
    public void FindTheSize(final int theS) {
        
        int s = theS+1;
        
        //We start with odd number. 
        if((theS+1) % 2 == 0) {
            s = theS + 1 + 1;
        }

        //Finds the nearest prime number
        for (int i = s; i < s*s; i=i+2) {
            if(isPrime(i)) {
                myTableSize = i;
                break;
            }
        }
        
    }
    
    /**
     * Checks whether the given number is prime or not. 
     * @param theN
     * @return
     */
    private boolean isPrime(final int theN) {
        boolean flag = true;
        
        for(int i = 2; i < theN; i++) {
            if(theN % i == 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }

}
