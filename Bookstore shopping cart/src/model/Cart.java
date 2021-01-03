//Assignment 1
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;
//import java.util.Iterator;

/**
 * Assignment 1 - Bookstore
 * A Cart class to calculate total for user. 
 * @author Bhavesh Joshi
 * @version 19 January 2020
 */
public class Cart {
        
    /**
     * A private instance field of BigDecimal.
     */
    private final List<ItemOrder> myCart;
        
     /**
      * Private bigdecimal for total price for my cart.
      */
    private BigDecimal myTotal;
    
    /**
     * Private boolean instanec field.
     */
    private boolean myMembership;
     
    //Constructor
    /**
     * A constructor that creates an empty shopping cart.
     */
    public Cart() {
        myCart = new ArrayList<ItemOrder>();
        
    }
    
    /** 
     * A void method to add into myCart.
     * @param theOrder to add it into myCart list
     */
    public void add(final ItemOrder theOrder) {
        
        final ItemOrder themyOrder = (ItemOrder) theOrder;
        
        for (int i = 0; i < myCart.size(); i++) {
            
            if ((this.myCart.get(i).getItem()).equals(themyOrder.getItem())) {
                
                myCart.remove(i);
                    
                //myCart.set(i, myOrder);
                    //System.out.println(myCart.toString());
                    //temp = i;
                    //break;
                    
            } 
        }
            
        myCart.add(themyOrder);
    }

    /**
     * A void method to set the store membership for order.
     * @param theMembership Boolean which sets the store membership for order
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * A method to calculate total price for items in cart.
     * @return BigDecima which is calculate total of cart item. 
     */
    public BigDecimal calculateTotal() {
              
        myTotal = BigDecimal.ZERO;
                
        for (int i = 0; i < myCart.size(); i++) {
            
            if (myCart.get(i).getQuantity() < 0) {
                throw new IllegalArgumentException("Item Quantity is less than 0");
            }
            
            final Item requireItem = myCart.get(i).getItem();
            final int quantity = myCart.get(i).getQuantity();
            
            if (requireItem.isBulk() && myMembership) {
               
                //System.out.println("1 " + myTotal);
                
                final int quantityModule = quantity % requireItem.getBulkQuantity();
                final int quantityDivision = quantity / requireItem.getBulkQuantity();
                
                //Calculating Price for Bulk Quantity. 
                final BigDecimal bulkPrice = requireItem.getBulkPrice().multiply
                                (BigDecimal.valueOf(quantityDivision));
                
                //Calculating Price for single quantity.
                final BigDecimal notBulkPrice = (requireItem.getPrice()).
                                multiply(BigDecimal.valueOf(quantityModule));
                
                //Adding both single and bulk_quantit price
                final BigDecimal itemTotalPrice = bulkPrice.add(notBulkPrice);
                
                myTotal = myTotal.add(itemTotalPrice);
                
            } else {
                
                myTotal = myTotal.add((requireItem.getPrice()).
                                      multiply(BigDecimal.valueOf(quantity)));
            }
            
        }
        
        //Rounding total value for cart into 2 decimal. 
        myTotal = myTotal.setScale(2, RoundingMode.HALF_EVEN);
        
        return myTotal;
        
        //If item is available in Bulk Quantity and if user quantity is 
        //more than and equal to our bulk Quantity.
        //If user input is divisible with bulk Quantity.
        /*if (quantityModule == 0) {
            
            myTotal = myTotal.add(requireItem.getBulkPrice().multiply
                                  (BigDecimal.valueOf(quantityDivision)));
            System.out.println("2 " + myTotal);
        
        } else {
            
          //This else block is for If user input is not divisible by bulk quantity.
            myTotal = myTotal.add((requireItem.getPrice().
                                  multiply(BigDecimal.valueOf(quantityModule))).
                                  add(requireItem.getBulkPrice().
                                      multiply(BigDecimal.valueOf(quantityDivision))));
            System.out.println("3 " + myTotal);
        }
    } else {
        
      //If item is not available in bulk or user doesn't want in bulk.
        
        myTotal = myTotal.add((requireItem.getPrice()).
                              multiply(BigDecimal.valueOf(myOrder.getQuantity())));
        System.out.println("Quantity " + myOrder.getQuantity());
        System.out.println("4 " + myTotal);
        System.out.println("Cart size " + myCart.size());
        System.out.println(myCart.toString());
    }*/
    }
    
    /**
     * A void method to remove all items from myCart.
     */
    public void clear() {
        myCart.clear();
        myTotal = BigDecimal.ZERO;
    }
    
    /**
     * A method to return myCart size. 
     * @return int cart size 
     */
    public int getCartSize() {
        return myCart.size();
    }

    /**
     * Return String representation of total price and total item. 
     */
    @Override
    public String toString() {
        final StringBuilder sbi = new StringBuilder(100);
        sbi.append("You cart has total item (not quantity) of ");
        sbi.append(getCartSize());
        sbi.append(" and total price of ");
        sbi.append(myTotal);
        
        return sbi.toString();
    }

}
