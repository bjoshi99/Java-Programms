//Assignment 1
package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Cart;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;


/**
 * A test class for Cart class with assertmethods.
 * @author Bhavesh
 * @version 19 January 2020
 */
public class CartTest {
    
    
    /**
     * A instance field form itemOrder.
     */
    private ItemOrder myO1;
    
    /**
     * A instance field form itemOrder.
     */
    private ItemOrder myO2;
    
    /**
     * A instance field of Item.
     */
    private Item myI1;
    
    /**
     * A instance field of cart class. 
     */
    private Cart myCartObj;
    
    /**
     * A instance field for total variable. 
     */
    private BigDecimal myTotal;
    
    /**
     * A setup method for creating obejcts of Item and ItemOrder class. 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        
        myCartObj = new Cart();
        myI1 = new Item("Java", BigDecimal.valueOf(20.00), 
                                 10, BigDecimal.valueOf(100.0));
        final Item i2 = new Item("Java Pen ", BigDecimal.valueOf(120.00), 
                                 4, BigDecimal.valueOf(400.0));
        myO1 = new ItemOrder(myI1, 12);
        myO2 = new ItemOrder(i2, 3);
        myTotal = BigDecimal.ZERO;
    }

    /**
     * A test method to check exception for negative value of quantity.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testforIAE() {
        new ItemOrder(new Item("Java doc", BigDecimal.TEN), -10);
    }
    
    /**
     * A test method to check the exception of null string.
     */
    @Test(expected = NullPointerException.class)
    public void testforNPE() {
        new ItemOrder(new Item(null, BigDecimal.TEN), 10);
    }
    /**
     * Adding all ItemOrder in myTest cart.
     */
    @Test
    public void testAdd() {
        
        myCartObj.add(myO1);
        myCartObj.add(myO2);
        myCartObj.add(new ItemOrder(myI1, 12));
        
        myTotal = myCartObj.calculateTotal();
        
        assertEquals("add method is not working", 2, myCartObj.getCartSize());
       // System.out.println(myTotal);
    }

    @Test
    public void testCalculateTotal() {
        //System.out.println(myTotal);
        assertEquals("Total", this.myTotal, myCartObj.calculateTotal());
    }

    /**
     * A test method to clear Cart. 
     */
    @Test
    public void testClear() {
        myCartObj.clear();
        assertEquals("Clear cart", 0, myCartObj.getCartSize());
    }

    @Test
    public void testToString() {
        final StringBuilder sbi = new StringBuilder(100);
        sbi.append("You cart has total item (not quantity) of ");
        sbi.append(myCartObj.getCartSize());
        sbi.append(" and total price of ");
        sbi.append(this.myTotal);    
        
        assertEquals("To string :", sbi.toString(), myCartObj.toString());
    }

}
