/*
 * TCSS 305 - Road Rage.
 */
package model;

import java.util.Map;

/**
 * A Taxi class with has two implemented methods from interface.
 * @author Bhavesh Joshi
 * @version Atumn 2020.
 */
public class Taxi extends AbstractVehicle implements Vehicle {
    
    /**
     * A constant for taxi death time.
     * TAxi should revive in 15 moves. 
     */
    private static final int MY_TAXI_DEATH_TIME = 15;
    
    /**
     * A countable variable.
     */
    private int myCount;
    
    /**
     * A construct with 3 parameters.
     * @param theX for X coordinates.
     * @param theY for Y coordinates.
     * @param theDir The Initial direction.
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theDir, MY_TAXI_DEATH_TIME, theX, theY);
        myCount = 0;
    }
    
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        boolean pass = false;
        final int value = 3;
//      
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.CROSSWALK 
                      || theTerrain == Terrain.LIGHT) {
                     
            if (theTerrain == Terrain.LIGHT
                              && (theLight == Light.RED)) {
                pass = false;
            } else if (theTerrain == Terrain.CROSSWALK 
                          && theLight == Light.RED) {
                myCount++;
                if (myCount == value || theLight == Light.GREEN) {
                    pass = true;
                    myCount = 0;
                } else {
                    pass = false;
                }
                
            } else { 
                pass = true;
            }
        }
        return pass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        Direction pass = super.getDirection();
        //System.out.println("My Direction:" + super.getDirection());

        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                                    || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                                    || theNeighbors.get(getDirection()) == Terrain.LIGHT) {

            pass = getDirection();
                    //System.out.println("Pass assigned to Normal:" + pass);

        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                       || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                       || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {

            pass = getDirection().left();
                   // System.out.println("Pass assigned to L:" + pass);

        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                       || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                       || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {

            pass = getDirection().right();
                    //System.out.println("Pass assigned to:" + pass);
            
        } else {
            pass = getDirection().reverse();
                   // System.out.println("Pass assigned to:" + pass);
        }  
        return pass;
    }
        
//      if (theNeighbors.get(super.getDirection()) != Terrain.STREET 
//                      && theNeighbors.get(super.getDirection()) != Terrain.CROSSWALK
//                      && theNeighbors.get(super.getDirection()) != Terrain.LIGHT) {
//          
////          for (Terrain t : Terrain.values()) {
////              System.out.println(t);
//          Direction d = Direction.random();
//
//          while (true) {
////              System.out.println("Random direction "+d);
////              System.out.println("Reverse direction "+super.getDirection().reverse());
////                  
//              if (d == super.getDirection().reverse()) {
//                  d = Direction.random();
//                  continue;
//              }
              //System.out.println("Rendom direction before second if statement "+d);
   
}

//End of the class Taxi.