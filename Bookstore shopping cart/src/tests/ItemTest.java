//Assignment 1
package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import model.Item; 
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for Item.
 * @author Bhavesh
 * @version 19 January 2020
 */

public class ItemTest {

    /**
     * Default name to assign. 
     */
    private static String Default_name = "Java";
    
    /**
     * A NumberFormat used in toString() to display prices.
     */
    private static final NumberFormat CURRENCY_FORMAT =
                    NumberFormat.getCurrencyInstance(Locale.US);
    
    /**
     * private instance field from Item class.
     */
    private Item myTestItem;
        
    /**
     * private instance field from Item class.
     */
    private Item myTestItem2;
    
    /**
     * A setup method to set values for Item1 and Item2 instance field.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        myTestItem2 = new Item("Java2", BigDecimal.valueOf(120.00));
        
        myTestItem = new Item("Java", BigDecimal.valueOf(20.00), 
                              10, BigDecimal.valueOf(100.0));
    }

    /**
     * A test method to test hashcode method.
     */
    @Test
    public void testHashCode() {
        //I did with this way to/.....
        //final Item item2 = (Item) myTestItem;
        //I wanted to see if i change something does it fail or not...but it did.
        
        //Same variables have same hashcode.
        
        final Item test2 = new Item("Java", BigDecimal.valueOf(20.00), 
                               10, BigDecimal.valueOf(100.0));
        assertEquals("Falied to show same hash code for two objects",
                     myTestItem.hashCode(), test2.hashCode());
    }

    /**
     * A test method to get NullPointerException when we pass null values. 
     */
    @Test(expected = NullPointerException.class)
    public void testItemStringBigDecimalIntBigDecimalNPE() {
        myTestItem = new Item(null, BigDecimal.valueOf(20.00), 
                              10, BigDecimal.valueOf(100.0));
    }
    
    /**
     * A test method to get IllegalArgumentException when we pass 
     * negative bigdecimal for price.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimalIAE() {
        myTestItem = new Item("Test Item", BigDecimal.valueOf(-1), 
                              10, BigDecimal.valueOf(100.0));
    }
    
    /**
     * A test method to get IllegalArgumentException when we pass 
     * negative int for bulkQuantity.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimalIAE2() {
        myTestItem = new Item("Test Item", BigDecimal.valueOf(20.00), 
                              -10, BigDecimal.valueOf(100.0));
    }
    
    /**
     * A test method to get IllegalArgumentException when we pass 
     * empty string for item.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimalIAE3() {
        myTestItem = new Item("", BigDecimal.valueOf(20.00), 
                              10, BigDecimal.valueOf(100.0));
    }
    /**
     * A test method to check getPrice method.
     */
    @Test
    public void testGetPrice() {
        assertEquals("Item Price for constructor 2", BigDecimal.valueOf(20.00),
                     myTestItem.getPrice());
        assertEquals("Item Price for constructor 1", BigDecimal.valueOf(120.00), 
                     myTestItem2.getPrice());
    }

    /**
     * A test method to check getBulkQuantity method.
     */
    @Test
    public void testGetBulkQuantity() {
     // assertEquals("Item name", "Java", myTestItem.getName());
        assertEquals("Bulk Quantity", 10, myTestItem.getBulkQuantity());
    }

    /**
     * A test method to check getBulkPrice method.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals("Bulk Price", BigDecimal.valueOf(100.00), myTestItem.getBulkPrice());
    }

    /**
     * A test method to check getBulkStatus method.
     */
    @Test
    public void testIsBulk() {
        assertEquals("Bulk Status", true, myTestItem.isBulk());    
    }

    /**
     * A test method for string.
     */
    @Test
    public void testToString() {
       
        final StringBuilder sbi = new StringBuilder();
        sbi.append(Default_name);
        sbi.append(", ");
        sbi.append(CURRENCY_FORMAT.format(myTestItem.getPrice()));
        if (myTestItem.isBulk()) {
            sbi.append(" (");
            sbi.append(myTestItem.getBulkQuantity());
            sbi.append(" for " + CURRENCY_FORMAT.format(myTestItem.getBulkPrice()) + ")");
        }
        assertEquals("TO String : ", sbi.toString(), myTestItem.toString());
    }

    /**
     * A test method to check .equals method of Item class.
     */
    @Test
    public void testEqualsObject() {
        assertEquals("Equals method", true, myTestItem.equals
                     (new Item("Java", BigDecimal.valueOf(20.00), 
                               10, BigDecimal.valueOf(100.0))));
    
    }

}
