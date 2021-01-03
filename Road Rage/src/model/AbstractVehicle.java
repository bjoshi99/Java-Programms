/*
 * TCSS 305 - RoadRage
 */
package model;

import java.util.Map;
/**
 * The abstract Vehicle (Parent) class for all subclasses.
 * @author Bhavesh Joshi
 * @version Autumn 2020
 */
public abstract class AbstractVehicle implements Vehicle {
    
    /**
     * Private Instance field from parent class x coordinate. 
     */
    private int myX;
    
    /**
     * Private Instance field from parent class y coordinate. 
     */
    private int myY;
    
    /**
     * Private Instance field from parent class x coordinate. 
     */
    private final int myDefaultX;
    
    /**
     * Private Instance field from parent class y coordinate. 
     */
    private final int myDefaultY;
    
    /**
     * Private Instance field from parent class to move in such direction. 
     */
    private final Direction myDirection;
    
    /**
     * Private Instance field from parent class Current direction. 
     */
    private Direction myCurrentDirection;
    
    /**
     * Time for death time.
     */
    private final int myVehicleDeathTime;
    
    /**
     * Vehicle live status.
     */
    private boolean myStatus;

    /**
     * A counting variable for poke.
     */
    private int myCount;
     

    /**
     * A private constructor with initializing its sub-classes instance fields.
     * @param theID unique id for each sub-classes of abstractVehicle.
     * @param theDir direction type parameters.
     * @param theX x coordinates of myVehicle
     * @param theY y coordinates of myVehicle
     */
    protected AbstractVehicle(final Direction theDir, final int theID, 
                              final int theX, final int theY) {
        myX = theX;
        myY = theY;
        myDefaultX = theX;
        myDefaultY = theY;
        myVehicleDeathTime = theID;
        myDirection = theDir;
        myCurrentDirection = theDir;
        myStatus = true;
        myCount = 0; 
    }
    
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
       
        boolean pass = true;
        if (theLight == Light.RED) {
            pass = false;
        }
        
        return pass;
    }

    @Override
    public abstract Direction chooseDirection(Map<Direction, Terrain> theNeighbors);

    @Override
    public void collide(final Vehicle theOther) {
        if ((this.isAlive() && theOther.isAlive())
                        && (this.getDeathTime() > theOther.getDeathTime())) {
            myStatus = false;
        }
    }

    @Override 
    public int getDeathTime()  {
        return myVehicleDeathTime;
    }

    @Override
    public String getImageFileName() {
        
        final String vehiclename = getClass().getSimpleName().toLowerCase();
        
        final StringBuilder vimage = new StringBuilder();
        if (isAlive()) {
            vimage.append(vehiclename);
            vimage.append(".gif");
        } else {
            vimage.append(vehiclename);
            vimage.append("_dead.gif");
        }
            
        return vimage.toString();
    }

    @Override
    public Direction getDirection() {
        return myCurrentDirection;
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public boolean isAlive() {
        return myStatus;
    }
    
    @Override
    public void poke() {
        if (!isAlive()) {
            myCount++;
            if (myCount == myVehicleDeathTime) {
                myStatus = true;
                myCount = 0;
            }
            
        }
    }

    @Override
    public void reset() {
        this.setX(myDefaultX);
        this.setY(myDefaultY);
        myCurrentDirection = myDirection;
        myStatus = true;
    }

    @Override
    public void setDirection(final Direction theDir) {
        myCurrentDirection = theDir;
    }

    @Override
    public void setX(final int theX) {
        myX = theX;
    }

    @Override
    public void setY(final int theY) {
        myY = theY;
    }

}
