/*
 * TCSS 305 - Road Rage.
 */
package model;

import java.util.Map;

/**
 * A Truck class with Two interface and two helper methods.
 * @author Bhavesh Joshi
 * @version Autumn 2020 
 */
public class Truck extends AbstractVehicle implements Vehicle {
 
    /**
     * Instance field of Direction. Enum type.
     */
    private final Terrain myTerrainForTruck;


    /**
     * A public constructor for All Terrain vehicles.
     * @param theX the x coordinate of ATV on map
     * @param theY the y coordinate of ATV on map
     * @param theDir type of direction this atv gets to move on map.
     */
    
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theDir, 0, theX, theY);
        myTerrainForTruck = Terrain.STREET;
    }
    
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        boolean pass = false;
        
//        
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.CROSSWALK 
                        || theTerrain == Terrain.LIGHT) {
            if (theTerrain == Terrain.CROSSWALK 
                            && theLight == Light.RED) {
                pass = false;
            }  else {
                pass = true;
            }
        }
//        System.out.println("Terrain: " + theTerrain);
//        System.out.println("TheLight: " + theLight);
//        System.out.println("Can Pass: " + pass);
        return pass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {        
        Direction d = Direction.random();
           
        if (checkValidDir(theNeighbors)) {
            
            while (theNeighbors.get(d) != Terrain.STREET 
                            && theNeighbors.get(d) != Terrain.LIGHT
                            && theNeighbors.get(d) != Terrain.CROSSWALK
                            || d == getDirection().reverse()) {
                
                d = Direction.random();
            }
        } else {
            d = getDirection().reverse();
        }
           
        return d;
        
//        while (d == pass.reverse()) {
//            d = Direction.random();
//        }
//                   
//                    while (true) {
//                    
//                        System.out.println("Random in while : " + d);
//                        
//                        if (theNeighbors.get(d) == myTerrainForTruck 
//                                      || theNeighbors.get(d) == Terrain.CROSSWALK
//                                      || theNeighbors.get(d) == Terrain.LIGHT) {
//                            pass = d;
//                            break;
//                        }
//                        
//                        else if ((theNeighbors.get(d.left()) == myTerrainForTruck 
//                                        || theNeighbors.get(d.left()) == Terrain.CROSSWALK
//                                        || theNeighbors.get(d.left()) == Terrain.LIGHT)
//                                        && d != pass.reverse()) {
//                            pass = d.left();
//                            break;
//                        }
//                        
//                        else if ((theNeighbors.get(getDirection().right()) == 
//       myTerrainForTruck 
//                                        || theNeighbors.get(getDirection().right()) 
//        == Terrain.CROSSWALK
//                                        || theNeighbors.get(getDirection().right()) 
//        == Terrain.LIGHT)
//                                        && d != pass.reverse()) {
//                            pass = d.right();
//                            break;
//                         }
////                        
//                        
////                      System.out.println("Random direction "+d);
////                      System.out.println("Reverse direction "+
//        super.getDirection().reverse());
//
////                        if (d != super.getDirection().reverse()) {
////                          //d = Direction.random();
//
////                          else if (theNeighbors.get(getDirection().left()) 
//        == Terrain.STREET
////                                 || theNeighbors.get(getDirection().left()) 
//        == Terrain.CROSSWALK
////                                 || theNeighbors.get(getDirection().left()) 
//        == Terrain.LIGHT) {
////                             // System.out.println("Before Pass assigned to:" +pass);
////                              pass = d.left();
////                              //System.out.println("Pass assigned to L:" + pass);
////                              break;
////                          }
////                          else if (theNeighbors.get(getDirection().right()) 
        
//        == Terrain.STREET
////                                 || theNeighbors.get(getDirection().right()) 
//        == Terrain.CROSSWALK
////                                 || theNeighbors.get(getDirection().right()) 
//        == Terrain.LIGHT) {
////                              //System.out.println("Before Pass assigned to R:" +pass);
////                              pass = d.right();
////                             // System.out.println("Pass assigned to:" + pass);
////                              break;
////                          }
//                          else {
//                              pass = super.getDirection().reverse();
//                              //System.out.println("Pass assigned to:" + pass);
//                              break;
//         
//            
//               // System.out.println("Rendom direction before second if statement "+d);
//
//                
// //     }

    }
    
    /**
     * A helper method to check to whether direction is okay or not?
     * @param theNeighbors the map which has key of Direction and value of Terrain
     * @return boolean depends on whether the neighbors valid.
     */
    private boolean checkValidDir(final Map<Direction, Terrain> theNeighbors) {
        boolean pass = false;
        
        if (isValidTerrain(theNeighbors.get(getDirection()))
                        || isValidTerrain(theNeighbors.get(getDirection().left()))
                        || isValidTerrain(theNeighbors.get(getDirection().right()))) {
            pass = true;
        }
        
        return pass; 
    }
    
    /**
     * A helper method to check if the Terrain is valid or not.
     * @param theTerrain The enum type terrain.
     * @return boolean depends whether terrain is valid or not.
     */
    private boolean isValidTerrain(final Terrain theTerrain) {
        boolean result = false;
        if (theTerrain == myTerrainForTruck || theTerrain == Terrain.CROSSWALK
                        || theTerrain == Terrain.LIGHT) {
            result = true;
            
        }
        return result;
    }

}
//End of class Truck