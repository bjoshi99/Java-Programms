//Assignment 1
package model;

/**
 * Assignment 1 - BookStore
 * A itemOrder class to take an order of each item in class.
 * @author Bhavesh Joshi
 * @version 19 January 2020
 */
public final class ItemOrder {
    
    /**
     * Instance field from the Item class.
     */
    private final Item myOtherItem;
    
    /**
     * Private int for my quantity. 
     */
    private final int myQuantity;

    /**
     * A constructor of ItemOrder class with two parameters.
     * @param theItem passing an Item object and its all property.
     * @param theQuantity The amount of quantity user wants to purchase. 
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        
        if (theQuantity < 0) {
            throw new IllegalArgumentException();
        }
        this.myOtherItem = (Item) theItem;
        this.myQuantity = theQuantity;
    }
  
    /**
     * Returns an Item class reference. 
     * @return Item reference
     */
    public Item getItem() {
        return myOtherItem;
    }
    
    /** 
     * Returns the number of quantity for Item.
     * @return int of User input quantity. 
     */
    public int getQuantity() {
        return this.myQuantity;
    }
 
    /**
     * Return String representation of total Item and its quantity. 
     */ 
    @Override
    public String toString() {
        final StringBuilder sbi = new StringBuilder(35);
        sbi.append("Your order: ");
        sbi.append(this.getItem());
        sbi.append(" Your Quantity ");
        sbi.append(this.getQuantity());
        return sbi.toString();
        
    }

}
