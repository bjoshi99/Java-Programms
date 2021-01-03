/*
 * TCSS 305 - Road Rage.
 */
package model;

import java.util.Map;

/**
 * A Bicycle class with two implemented methods from Vehicle interface.
 * Child class of AbstractVehicle
 * @author Bhavesh Joshi
 * @version Atumn 2020.
 */
public class Bicycle extends AbstractVehicle implements Vehicle {
    
    /**
     * A constant for Bicycle- death time.
     * Human should revive in 45 moves. 
     */
    private static final int MY_BICYCLE_DEATH_TIME = 35;
    
    /**
     * A construct with 3 parameters.
     * @param theX for X coordinates.
     * @param theY for Y coordinates.
     * @param theDir The Initial direction.
     */
    
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theDir, MY_BICYCLE_DEATH_TIME, theX, theY);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        boolean canPass = false;
        
        if (theTerrain == Terrain.TRAIL || theTerrain == Terrain.STREET
                        || theTerrain == Terrain.CROSSWALK || theTerrain == Terrain.LIGHT) {
            
            if ((theTerrain == Terrain.LIGHT || theTerrain == Terrain.CROSSWALK) 
                            && (theLight == Light.RED || theLight == Light.YELLOW)) {
                canPass = false;
            } else {
                canPass = true; 
            }
        }        
        return canPass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        
        Direction pass = getDirection();
//        System.out.println("My Direction "+super.getDirection()+", pass direction "+pass);
        
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            pass = getDirection();
//            System.out.println("Now pass from 1st if "+pass);
            
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            pass = getDirection().left();
//            System.out.println("2nd if pass "+pass);
            
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            pass = getDirection().right();
//            System.out.println("pass in 3rd if"+pass);
            
        } else if (theNeighbors.get(getDirection()) == Terrain.STREET 
                        || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            pass = getDirection();
            
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                                || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                                || theNeighbors.get(getDirection().left()) 
                                    == Terrain.CROSSWALK) {
            pass = getDirection().left();
 //                   System.out.println("7. Now pass set to: "+pass);
            
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                                || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                                || theNeighbors.get(getDirection().right()) 
                                    == Terrain.CROSSWALK) {
            pass = getDirection().right();
//                    System.out.println("8. Now pass set to: "+pass);
            
        } else {
            pass = getDirection().reverse();
 //                   System.out.println("9. Now pass set to: "+pass);
        }
        return pass;
//            }
 //       }
//        System.out.println("Abover retrun statement "+pass);
        
//      else {
//          
//          Direction random = Direction.random();
////          System.out.println("Random direction : "+random);
//          
//          while (true) {
//              //5
//              if (random == super.getDirection().reverse()) {
//                  random = Direction.random();
////                  System.out.println("in 5 : reverse :");
//                  continue;
//              } 
//          else if (theNeighbors.get(get) == Terrain.STREET 
//                              || theNeighbors.get(random) == Terrain.LIGHT
//                              || theNeighbors.get(random) == Terrain.CROSSWALK) {
//                  pass = random;
////                  System.out.println("6.Now pass set to: "+pass);
//                  break;
//              }
        
    }


}
//End of the class