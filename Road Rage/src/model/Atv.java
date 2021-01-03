/*
 * TCSS 305 -Road Rage
 */
package model;

import java.util.Map;

/**
 * A ATV class with two methods canPass and ChooseDirection.
 * @author Bhavesh
 * @version Atumn 2020
 */
public class Atv extends AbstractVehicle implements Vehicle {
    
    /**
     * ATV should revive in 25 moves. 
     */
    private static final int MY_ATV_DEATH_TIME = 25;
    
    /**
     * Instance field of Direction. Enum type.
     */
    private final Terrain myTerrainForAtv;

    
    /**
     * A public constructor for All Terrain vehicles.
     * @param theX the x coordinate of ATV on map
     * @param theY the y coordinate of ATV on map
     * @param theDir type of direction this atv gets to move on map.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theDir, MY_ATV_DEATH_TIME, theX, theY);
        myTerrainForAtv = Terrain.WALL;
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {

        boolean possibility = true;
        //Needs attention here in if statement. 
        //Checks if the passed terrain is wall or not
        if (theTerrain.equals(myTerrainForAtv)) {
            possibility = false;
        }
        return possibility;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
       
        //Direction pass = super.getDirection();

        Direction rendomdir = Direction.random();
        
        
        while (theNeighbors.get(rendomdir) == myTerrainForAtv 
                        || rendomdir == getDirection().reverse()) {
            
            rendomdir = Direction.random();

        }
        return rendomdir;

        //System.out.println("random direction " + rendomdir);
        //System.out.println("this direction " + this.getDirection());
       // System.out.println("reverse direction " + myReverseDirection);
        //System.out.println("**********");
        
//        if (rendomdir == super.getDirection().reverse()) {
//            rendomdir = Direction.random();
//            continue;
//        }
        
     // This first comparison is not right for sure. So make sure it is good.
//        if (rendomdir != myReverseDirection
//                        && (theNeighbors.get(rendomdir) != myTerrainForAtv 
//                            || theNeighbors.get(getDirection().right())
//        != myTerrainForAtv
//                            || theNeighbors.get(getDirection().left()) 
//        != myTerrainForAtv)) { 
//            pass = rendomdir;
////            System.out.println("Current direction" + myCurrentDirection);
////            System.out.println("----------------------");
//          break;
//         }
        /*// Checks if the passed object is instance of Map or not.
        if (theNeighbors instanceof Map) {
            
            //Creating a map objects from Map<>
            final Map<Direction, Terrain> map = (Map<Direction, Terrain>) theNeighbors;
            
            //Iterating through all keys of the Map (which is Direction key)
            for (Map.Entry<Direction, Terrain> entry : map.entrySet()) {
                
                //If the value of key is not wall then 
                //it gives the first random direction for atv to move. 
                if (entry.getValue() != myTerrainForAtv) {
                    myDirection = Direction.random();
                    break;
                }
            }
        }*/
        
    }

}
