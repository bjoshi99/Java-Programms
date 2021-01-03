//Assignment 1
package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 *  Assignment 1 - BookStore
 * A item class to define all variable for items in bookstore.
 * @author Bhavesh Joshi
 * @version 19 January 2020
 */
public final class Item {
    
    /**
     * A NumberFormat used in toString() to display prices.
     */
    private static final NumberFormat CURRENCY_FORMAT =
                    NumberFormat.getCurrencyInstance(Locale.US);
     
    /**
     * a instance field for item name.
     */
    private final String myItem;
    
    /**
     * A instance field for price.
     */
    private final BigDecimal myPrice;
    
    /**
     * A instance field for BulkQuantity. 
     */
    private final int myBulkQuantity;
    
    /**
     * A instance field for myBulk price.
     */
    private final BigDecimal myBulkPrice;
    
    /**
     * A instance field for item, if it is available in bulk in or not.
     */
    private final boolean myBulkStatus;
    
    /**
     * A constructor of Item class with two parameters. 
     * @param theName The name of particular Item.
     * @param thePrice The original price of item. 
     */ 
    public Item(final String theName, final BigDecimal thePrice) {
        if (Objects.requireNonNull(theName).length() == 0
                        || Objects.requireNonNull(thePrice).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        this.myItem = theName;
        this.myPrice = thePrice;
        this.myBulkStatus = false;
        this.myBulkQuantity = 0;
        this.myBulkPrice = BigDecimal.ZERO;
    }
 
    /**
     * A constructor of Item class with four parameters.
     * @param theName The name of particular item. 
     * @param thePrice The original price of item.
     * @param theBulkQuantity The available bulk quantity of Item.
     * @param theBulkPrice Available bulk price of the Item.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        if (Objects.requireNonNull(theName).length() == 0
                        || Objects.requireNonNull(theBulkQuantity) <= 0
                        || Objects.requireNonNull(theBulkPrice).compareTo(BigDecimal.ZERO) < 0
                        || Objects.requireNonNull(thePrice).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        this.myItem = theName;
        this.myPrice = thePrice;
        this.myBulkQuantity = theBulkQuantity;
        this.myBulkPrice = theBulkPrice;
        this.myBulkStatus = true;
    }

    /**
     * A method which returns price. 
     * @return BigDecimal of Item price.
     */
    public BigDecimal getPrice() {
        return this.myPrice;
    }

    /**
     * With no parameter.
     * @return int of Bulk Quantity. 
     */
    public int getBulkQuantity() {
        return this.myBulkQuantity;
    }

    /**
     * A public method with no parameter. 
     * @return BigDecimal for Bulk Price.
     */
    public BigDecimal getBulkPrice() {
        return this.myBulkPrice;
    }

    /**
     * Returns true if item is available in bulk, otherwise false.
     * @return Boolean true if item is available in bulk, otherwise false
     */
    public boolean isBulk() {
        return myBulkStatus;
    }

    /**
     * @return String representation of Item detail. 
     */
    @Override
    public String toString() {
        /*final String sentence = this.myItem + ", $" + this.myPrice;
        if (this.myBulkStatus) {
            return (sentence + " (" + this.myBulkQuantity 
                + " for $" + this.myBulkPrice + " )").toString();
        }
        return sentence;*/
        final StringBuilder sbi = new StringBuilder();
        sbi.append(this.myItem);
        sbi.append(", ");
        sbi.append(CURRENCY_FORMAT.format(this.myPrice));
        if (this.myBulkStatus) {
            sbi.append(" (");
            sbi.append(this.myBulkQuantity);
            sbi.append(" for " + CURRENCY_FORMAT.format(this.myBulkPrice) + ")");
        }
        return sbi.toString();
    }
 
    @Override
    public boolean equals(final Object theOther) {
        boolean status = false;
        if (theOther != null && getClass().equals(theOther.getClass())) {
            final Item otherItem = (Item) theOther;
            if ((myItem.equals(otherItem.myItem)) 
                            && (myPrice.equals(otherItem.getPrice())) 
                            && (myBulkPrice.equals(otherItem.getBulkPrice()))
                            && (myBulkQuantity == otherItem.getBulkQuantity())) {
                status = true;
            }
        }
        return status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.myItem, this.myPrice, this.myBulkPrice, this.myBulkQuantity);
    }

}
