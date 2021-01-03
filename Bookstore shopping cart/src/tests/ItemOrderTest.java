//Assignment 1
package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for Itemorder class.
 * @author Bhavesh Joshi
 * @version 19 January 2020
 */
public class ItemOrderTest {
    /**
     *Instance ItemOrder class object. 
     */
    private ItemOrder myObj;
    
    /**
     *Instance Item class object. 
     */
    private Item myB1;
    
    /**
     * A test setup method to initialize itemOrder and its objects.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        myB1 = new Item("Book", BigDecimal.valueOf(150.00), 5, 
                                 BigDecimal.valueOf(450.00));
        myObj = new ItemOrder(myB1, 10);
    }
    
    /**
     * A test method to check if item name is null. 
     */
    @Test(expected = NullPointerException.class)
    public void testNPE() {
        new ItemOrder(new Item(null, BigDecimal.TEN), 10);
    }

    /**
     * A test method to check if price is is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIAE() {
        new ItemOrder(new Item("Book", BigDecimal.valueOf(-10.00)), 10);
    }
    
    /**
     * A test method to check if quantity is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIAE2() {
        new ItemOrder(new Item("Book", BigDecimal.TEN), -10);
    }
    /**
     * A test method to check both getItem Method. 
     */ 
    @Test
    public void testItem() {
        final Item otherItem = (Item) myB1;
        assertEquals("Get Item", otherItem, myObj.getItem());
    }
    
    /**
     * The test string method to test if both string representation are same or not.
     */
    @Test
    public void testtoString() {
        final StringBuilder sbi = new StringBuilder(35);
        sbi.append("Your order: ");
        sbi.append(myObj.getItem());
        sbi.append(" Your Quantity ");
        sbi.append(myObj.getQuantity());
        
        assertEquals("ToString ", sbi.toString(), myObj.toString());
    }

    /**
     * A test method to check getQuantity method for item.
     */
    @Test
    public void testgetQuantity() {
        assertEquals("Get Quantity", 10, myObj.getQuantity());
    }
}
